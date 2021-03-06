/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.documentlibrary.store;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.repository.cmis.CMISRepositoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PropsValues;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileException;
import com.liferay.portlet.documentlibrary.model.FileModel;
import com.liferay.portlet.documentlibrary.util.DLUtil;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.ObjectId;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BaseTypeId;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.UnfileObject;
import org.apache.chemistry.opencmis.commons.impl.dataobjects.ContentStreamImpl;

/**
 * @author Alexander Chow
 */
public class CMISStore extends BaseStore {

	public CMISStore() {
		_systemRootDir = getFolder(
			_session.getRootFolder(),
			PropsValues.DL_STORE_CMIS_SYSTEM_ROOT_DIR);

		if (_systemRootDir == null) {
			_systemRootDir = createFolder(
				_session.getRootFolder(),
				PropsValues.DL_STORE_CMIS_SYSTEM_ROOT_DIR);
		}
	}

	@Override
	public void addDirectory(
		long companyId, long repositoryId, String dirName) {

		Folder folder = getRepositoryFolder(companyId, repositoryId);

		String[] dirNames = StringUtil.split(dirName, StringPool.SLASH);

		for (String curDirName : dirNames) {
			Folder subFolder = getFolder(folder, curDirName);

			if (subFolder == null) {
				subFolder = createFolder(folder, curDirName);
			}

			folder = subFolder;
		}
	}

	@Override
	public void addFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, long fileEntryId, String properties,
			Date modifiedDate, ServiceContext serviceContext, InputStream is)
		throws PortalException {

		updateFile(
			companyId, portletId, groupId, repositoryId, fileName,
			DEFAULT_VERSION, null, fileEntryId, properties, modifiedDate,
			serviceContext, is);
	}

	@Override
	public void checkRoot(long companyId) {
	}

	@Override
	public void deleteDirectory(
		long companyId, String portletId, long repositoryId, String dirName) {

		Folder repositoryFolder = getRepositoryFolder(companyId, repositoryId);

		Folder directory = getFolder(repositoryFolder, dirName);

		if (directory != null) {
			directory.deleteTree(true, UnfileObject.DELETE, false);
		}
	}

	@Override
	public void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName)
		throws PortalException {

		Folder versioningFolder = getVersioningFolder(
			companyId, repositoryId, fileName, false);

		if (versioningFolder == null) {
			throw new NoSuchFileException();
		}

		versioningFolder.deleteTree(true, UnfileObject.DELETE, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			FileModel.class);

		FileModel fileModel = new FileModel();

		fileModel.setCompanyId(companyId);
		fileModel.setFileName(fileName);
		fileModel.setPortletId(portletId);
		fileModel.setRepositoryId(repositoryId);

		indexer.delete(fileModel);
	}

	@Override
	public void deleteFile(
			long companyId, String portletId, long repositoryId,
			String fileName, String versionNumber)
		throws PortalException {

		Document document = getVersionedDocument(
			companyId, repositoryId, fileName, versionNumber);

		document.delete(true);

		Indexer indexer = IndexerRegistryUtil.getIndexer(
			FileModel.class);

		FileModel fileModel = new FileModel();

		fileModel.setCompanyId(companyId);
		fileModel.setFileName(fileName);
		fileModel.setPortletId(portletId);
		fileModel.setRepositoryId(repositoryId);

		indexer.delete(fileModel);
	}

	@Override
	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws PortalException {

		if (Validator.isNull(versionNumber)) {
			versionNumber = getHeadVersionNumber(
				companyId, repositoryId, fileName);
		}

		Document document = getVersionedDocument(
			companyId, repositoryId, fileName, versionNumber);

		return document.getContentStream().getStream();
	}

	@Override
	public String[] getFileNames(
		long companyId, long repositoryId, String dirName) {

		Folder folder = getRepositoryFolder(companyId, repositoryId);

		String[] dirNames = StringUtil.split(dirName, StringPool.SLASH);

		for (String curDirName : dirNames) {
			Folder subFolder = getFolder(folder, curDirName);

			if (subFolder == null) {
				subFolder = createFolder(folder, curDirName);
			}

			folder = subFolder;
		}

		List<Folder> folders = getFolders(folder);

		String[] fileNames = new String[folders.size()];

		for (int i = 0; i < folders.size(); i++) {
			Folder curFolder = folders.get(i);

			String fileName = curFolder.getName();

			fileNames[i] = dirName.concat(StringPool.SLASH).concat(fileName);
		}

		return fileNames;
	}

	@Override
	public long getFileSize(
			long companyId, long repositoryId, String fileName)
		throws PortalException {

		String versionNumber = getHeadVersionNumber(
			companyId, repositoryId, fileName);

		Document document = getVersionedDocument(
			companyId, repositoryId, fileName, versionNumber);

		return document.getContentStreamLength();
	}

	public String getHeadVersionNumber(
			long companyId, long repositoryId, String dirName)
		throws NoSuchFileException {

		Folder versioningFolder = getVersioningFolder(
			companyId, repositoryId, dirName, false);

		if (versioningFolder == null) {
			throw new NoSuchFileException();
		}

		List<Folder> folders = getFolders(versioningFolder);

		String headVersionNumber = DEFAULT_VERSION;

		for (Folder folder : folders) {
			String versionNumber = folder.getName();

			if (DLUtil.compareVersions(versionNumber, headVersionNumber) > 0) {
				headVersionNumber = versionNumber;
			}
		}

		return headVersionNumber;
	}

	@Override
	public boolean hasFile(
		long companyId, long repositoryId, String fileName,
		String versionNumber) {

		Folder versioningFolder = getVersioningFolder(
			companyId, repositoryId, fileName, true);

		Document document = getDocument(versioningFolder, versionNumber);

		if (document == null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void move(String srcDir, String destDir) {
	}

	@Override
	public void reindex(String[] ids) throws SearchException {
		long companyId = GetterUtil.getLong(ids[0]);
		String portletId = ids[1];
		long groupId = GetterUtil.getLong(ids[2]);
		long repositoryId = GetterUtil.getLong(ids[3]);

		Collection<com.liferay.portal.kernel.search.Document> documents =
			new ArrayList<com.liferay.portal.kernel.search.Document>();

		try {
			Folder repositoryFolderEntry = getRepositoryFolder(
				companyId, repositoryId);

			List<Folder> folders = getFolders(repositoryFolderEntry);

			for (Folder folder : folders) {
				String fileName = folder.getName();

				Indexer indexer = IndexerRegistryUtil.getIndexer(
					FileModel.class);

				FileModel fileModel = new FileModel();

				fileModel.setCompanyId(companyId);
				fileModel.setFileName(fileName);
				fileModel.setGroupId(groupId);
				fileModel.setPortletId(portletId);
				fileModel.setRepositoryId(repositoryId);

				com.liferay.portal.kernel.search.Document document =
					indexer.getDocument(fileModel);

				if (document == null) {
					continue;
				}

				documents.add(document);
			}
		}
		catch (Exception e) {
			if (_log.isErrorEnabled()) {
				_log.error(e, e);
			}
		}

		SearchEngineUtil.updateDocuments(companyId, documents);
	}

	@Override
	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			long newRepositoryId, String fileName, long fileEntryId)
		throws PortalException {

		Folder oldVersioningFolderEntry = getVersioningFolder(
			companyId, repositoryId, fileName, true);
		Folder newVersioningFolderEntry = getVersioningFolder(
			companyId, newRepositoryId, fileName, true);

		List<Folder> folders = getFolders(oldVersioningFolderEntry);

		for (Folder folder : folders) {
			String curFileName = folder.getName();

			Document document = getDocument(
				oldVersioningFolderEntry, curFileName);

			InputStream is = document.getContentStream().getStream();

			createDocument(newVersioningFolderEntry, curFileName, is);
		}

		oldVersioningFolderEntry.deleteTree(true, UnfileObject.DELETE, false);

		Indexer indexer = IndexerRegistryUtil.getIndexer(FileModel.class);

		FileModel fileModel = new FileModel();

		fileModel.setCompanyId(companyId);
		fileModel.setFileName(fileName);
		fileModel.setPortletId(portletId);
		fileModel.setRepositoryId(repositoryId);

		indexer.delete(fileModel);

		fileModel.setGroupId(groupId);
		fileModel.setRepositoryId(newRepositoryId);

		indexer.reindex(fileModel);
	}

	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String newFileName, boolean reindex)
		throws PortalException {

		Folder oldVersioningFolderEntry = getVersioningFolder(
			companyId, repositoryId, fileName, true);
		Folder newVersioningFolderEntry = getVersioningFolder(
			companyId, repositoryId, newFileName, true);

		List<Folder> folders = getFolders(oldVersioningFolderEntry);

		for (Folder folder : folders) {
			String curFileName = folder.getName();

			Document document = getDocument(
				oldVersioningFolderEntry, curFileName);

			InputStream is = document.getContentStream().getStream();

			createDocument(newVersioningFolderEntry, curFileName, is);
		}

		oldVersioningFolderEntry.deleteTree(true, UnfileObject.DELETE, false);

		if (reindex) {
			Indexer indexer = IndexerRegistryUtil.getIndexer(FileModel.class);

			FileModel fileModel = new FileModel();

			fileModel.setCompanyId(companyId);
			fileModel.setFileName(fileName);
			fileModel.setPortletId(portletId);
			fileModel.setRepositoryId(repositoryId);

			indexer.delete(fileModel);

			fileModel.setFileName(newFileName);
			fileModel.setGroupId(groupId);

			indexer.reindex(fileModel);
		}
	}

	@Override
	public void updateFile(
			long companyId, String portletId, long groupId, long repositoryId,
			String fileName, String versionNumber, String sourceFileName,
			long fileEntryId, String properties, Date modifiedDate,
			ServiceContext serviceContext, InputStream is)
		throws PortalException {

		Folder versioningFolder = getVersioningFolder(
			companyId, repositoryId, fileName, true);

		String title = String.valueOf(versionNumber);

		Document document = getDocument(versioningFolder, title);

		if (document != null) {
			throw new DuplicateFileException();
		}

		createDocument(versioningFolder, title, is, serviceContext);

		Indexer indexer = IndexerRegistryUtil.getIndexer(FileModel.class);

		FileModel fileModel = new FileModel();

		fileModel.setAssetCategoryIds(serviceContext.getAssetCategoryIds());
		fileModel.setAssetTagNames(serviceContext.getAssetTagNames());
		fileModel.setCompanyId(companyId);
		fileModel.setFileEntryId(fileEntryId);
		fileModel.setFileName(fileName);
		fileModel.setGroupId(groupId);
		fileModel.setModifiedDate(modifiedDate);
		fileModel.setPortletId(portletId);
		fileModel.setProperties(properties);
		fileModel.setRepositoryId(repositoryId);

		indexer.reindex(fileModel);
	}

	protected Document createDocument(
		Folder versioningFolder, String title, InputStream is) {

		return createDocument(versioningFolder, title, is, null);
	}

	protected Document createDocument(
		Folder versioningFolder, String title, InputStream is,
		ServiceContext serviceContext) {

		Map<String, Object> documentProperties = new HashMap<String, Object>();

		documentProperties.put(PropertyIds.NAME, title);
		documentProperties.put(
			PropertyIds.OBJECT_TYPE_ID, BaseTypeId.CMIS_DOCUMENT.value());

		ContentStream contentStream = new ContentStreamImpl(
			null, null, ContentTypes.APPLICATION_OCTET_STREAM, is);

		return versioningFolder.createDocument(
			documentProperties, contentStream, null);
	}

	protected Folder createFolder(ObjectId parentFolderId, String name) {
		Map<String, Object> properties = new HashMap<String, Object>();

		properties.put(PropertyIds.NAME, name);
		properties.put(
			PropertyIds.OBJECT_TYPE_ID, BaseTypeId.CMIS_FOLDER.value());

		ObjectId objectId = _session.createFolder(properties, parentFolderId);

		return (Folder)_session.getObject(objectId);
	}

	protected Folder getCompanyFolder(long companyId) {
		String name = String.valueOf(companyId);

		Folder companyFolder = getFolder(_systemRootDir, name);

		if (companyFolder == null) {
			companyFolder = createFolder(_systemRootDir, name);
		}

		return companyFolder;
	}

	protected Document getDocument(Folder parentFolder, String name) {
		ItemIterable<CmisObject> cmisObjects = parentFolder.getChildren();

		Iterator<CmisObject> itr = cmisObjects.iterator();

		while (itr.hasNext()) {
			CmisObject cmisObject = itr.next();

			if (name.equals(cmisObject.getName()) &&
				cmisObject instanceof Document) {

				return (Document)cmisObject;
			}
		}

		return null;
	}

	protected Folder getFolder(Folder parentFolder, String name) {
		ItemIterable<CmisObject> cmisObjects = parentFolder.getChildren();

		Iterator<CmisObject> itr = cmisObjects.iterator();

		while (itr.hasNext()) {
			CmisObject cmisObject = itr.next();

			if (name.equals(cmisObject.getName()) &&
				cmisObject instanceof Folder) {

				return (Folder)cmisObject;
			}
		}

		return null;
	}

	protected List<Folder> getFolders(Folder folder) {
		List<Folder> folders = new ArrayList<Folder>();

		ItemIterable<CmisObject> cmisObjects = folder.getChildren();

		Iterator<CmisObject> itr = cmisObjects.iterator();

		while (itr.hasNext()) {
			CmisObject cmisObject = itr.next();

			if (cmisObject instanceof Folder) {
				folders.add((Folder)cmisObject);
			}
		}

		return folders;
	}

	protected Folder getRepositoryFolder(long companyId, long repositoryId) {
		Folder companyFolder = getCompanyFolder(companyId);

		String name = String.valueOf(repositoryId);

		Folder repositoryFolder = getFolder(companyFolder, name);

		if (repositoryFolder == null) {
			repositoryFolder = createFolder(companyFolder, name);
		}

		return repositoryFolder;
	}

	protected Document getVersionedDocument(
			long companyId, long repositoryId, String fileName,
			String versionNumber)
		throws NoSuchFileException {

		Folder versioningFolder = getVersioningFolder(
			companyId, repositoryId, fileName, false);

		if (versioningFolder == null) {
			throw new NoSuchFileException();
		}

		Document document = getDocument(versioningFolder, versionNumber);

		if (document == null) {
			throw new NoSuchFileException();
		}

		return document;
	}

	protected Folder getVersioningFolder(
		long companyId, long repositoryId, String fileName, boolean create) {

		Folder repositoryFolder = getRepositoryFolder(companyId, repositoryId);

		Folder versioningFolder = repositoryFolder;

		String[] dirNames = StringUtil.split(fileName, StringPool.SLASH);

		for (String dirName : dirNames) {
			Folder subFolder = getFolder(versioningFolder, dirName);

			if (create && (subFolder == null)) {
				subFolder = createFolder(versioningFolder, dirName);
			}

			versioningFolder = subFolder;
		}

		return versioningFolder;
	}

	private static Log _log = LogFactoryUtil.getLog(CMISStore.class);

	private static Session _session;
	private static Folder _systemRootDir;

	static {
		Map<String, String> parameters = new HashMap<String, String>();

		parameters.put(
			SessionParameter.ATOMPUB_URL,
			PropsValues.DL_STORE_CMIS_REPOSITORY_URL);
		parameters.put(
			SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameters.put(
			SessionParameter.COMPRESSION, Boolean.TRUE.toString());

		Locale locale = LocaleUtil.getDefault();

		parameters.put(
			SessionParameter.LOCALE_ISO3166_COUNTRY,
			locale.getCountry());
		parameters.put(
			SessionParameter.LOCALE_ISO639_LANGUAGE, locale.getLanguage());
		parameters.put(
			SessionParameter.PASSWORD,
			PropsValues.DL_STORE_CMIS_CREDENTIALS_PASSWORD);
		parameters.put(
			SessionParameter.USER,
			PropsValues.DL_STORE_CMIS_CREDENTIALS_USERNAME);

		SessionFactory sessionFactory = CMISRepositoryUtil.getSessionFactory();

		Repository repository =
			sessionFactory.getRepositories(parameters).get(0);

		_session = repository.createSession();

		_session.setDefaultContext(CMISRepositoryUtil.getOperationContext());
	}

}