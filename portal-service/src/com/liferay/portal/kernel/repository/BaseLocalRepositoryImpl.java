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

package com.liferay.portal.kernel.repository;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import java.io.InputStream;

import java.util.List;

/**
 * This class is designed for third party repository implementations. Since the
 * paradigm of remote and local services exists only within Liferay, the
 * assumption is that all permission checking will be delegated to the specific
 * repository.
 *
 * There are also many calls within this class that pass in a user ID as a
 * parameter. These methods should only be called for administration of Liferay
 * repositories and are hence not supported in all third party repositories.
 * This includes moving between document library hooks and LAR import/export.
 * Calling these methods will throw an
 * <code>UnsupportedOperationException</code>.
 *
 * @author Alexander Chow
 */
public class BaseLocalRepositoryImpl implements LocalRepository {

	public BaseLocalRepositoryImpl(Repository repository) {
		_repository = repository;
	}

	public FileEntry addFileEntry(
			long userId, long folderId, String title, String description,
			String changeLog, InputStream is, long size,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	public Folder addFolder(
			long userId, long parentFolderId, String title,
			String description, ServiceContext serviceContext)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	public void deleteAll() throws PortalException, SystemException {
		_repository.deleteAll();
	}

	public void deleteFileEntry(long fileEntryId)
		throws PortalException, SystemException {

		_repository.deleteFileEntry(fileEntryId);
	}

	public void deleteFolder(long folderId)
		throws PortalException, SystemException {

		_repository.deleteFolder(folderId);
	}

	public List<FileEntry> getFileEntries(
			long folderId, int start, int end, OrderByComparator obc)
		throws SystemException {

		return _repository.getFileEntries(folderId, start, end, obc);
	}

	public List<Object> getFileEntriesAndFileShortcuts(
			List<Long> folderIds, int status, int start, int end)
		throws SystemException {

		return _repository.getFileEntriesAndFileShortcuts(
			folderIds, status, start, end);
	}

	public int getFileEntriesAndFileShortcutsCount(
			List<Long> folderIds, int status)
		throws SystemException {

		return _repository.getFileEntriesAndFileShortcutsCount(
			folderIds, status);
	}

	public int getFileEntriesCount(long folderId) throws SystemException {
		return _repository.getFileEntriesCount(folderId);
	}

	public FileEntry getFileEntry(long fileEntryId)
		throws PortalException, SystemException {

		return _repository.getFileEntry(fileEntryId);
	}

	public FileEntry getFileEntry(long folderId, String title)
			throws PortalException, SystemException {

		return _repository.getFileEntry(folderId, title);
	}

	public FileEntry getFileEntryByUuid(String uuid)
		throws PortalException, SystemException {

		return _repository.getFileEntryByUuid(uuid);
	}

	public FileVersion getFileVersion(long fileVersionId)
		throws PortalException, SystemException {

		return _repository.getFileVersion(fileVersionId);
	}

	public Folder getFolder(long folderId)
		throws PortalException, SystemException {

		return _repository.getFolder(folderId);
	}

	public Folder getFolder(long parentFolderId, String title)
		throws PortalException, SystemException {

		return _repository.getFolder(parentFolderId, title);
	}

	public List<Folder> getFolders(long parentFolderId, int start, int end)
		throws SystemException {

		return _repository.getFolders(parentFolderId, start, end);
	}

	public List<Object> getFoldersAndFileEntriesAndFileShortcuts(
			List<Long> folderIds, int status, int start, int end)
		throws SystemException {

		return _repository.getFoldersAndFileEntriesAndFileShortcuts(
			folderIds, status, start, end);
	}

	public int getFoldersAndFileEntriesAndFileShortcutsCount(
			List<Long> folderIds, int status)
		throws SystemException {

		return _repository.getFoldersAndFileEntriesAndFileShortcutsCount(
			folderIds, status);
	}

	public int getFoldersCount(long parentFolderId) throws SystemException {
		return _repository.getFoldersCount(parentFolderId);
	}

	public int getFoldersFileEntriesCount(List<Long> folderIds, int status)
		throws SystemException {

		return _repository.getFoldersFileEntriesCount(folderIds, status);
	}

	public long getRepositoryId() {
		return _repository.getRepositoryId();
	}

	public FileEntry moveFileEntry(
			long userId, long fileEntryId, long newFolderId,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	public void updateAsset(
			long userId, FileEntry fileEntry, FileVersion fileVersion,
			long[] assetCategoryIds, String[] assetTagNames)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	public FileEntry updateFileEntry(
			long userId, long fileEntryId, String sourceFileName, String title,
			String description, String changeLog, boolean majorVersion,
			InputStream is, long size, ServiceContext serviceContext)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	public Folder updateFolder(
			long folderId, long parentFolderId, String title,
			String description, ServiceContext serviceContext)
		throws PortalException, SystemException {

		throw new UnsupportedOperationException();
	}

	private Repository _repository;

}