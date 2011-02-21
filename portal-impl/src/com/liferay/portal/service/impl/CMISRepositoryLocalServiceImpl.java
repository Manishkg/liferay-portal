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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.repository.cmis.CMISRepository;
import com.liferay.portal.service.base.CMISRepositoryLocalServiceBaseImpl;

import org.apache.chemistry.opencmis.client.api.Document;

/**
 * @author Alexander Chow
 */
public class CMISRepositoryLocalServiceImpl
	extends CMISRepositoryLocalServiceBaseImpl {

	public FileEntry toFileEntry(long repositoryId, Object object)
		throws PortalException, SystemException {

		CMISRepository cmisRepository =
			(CMISRepository)repositoryService.getRepositoryImpl(repositoryId);

		Document document = (Document)object;

		return cmisRepository.toFileEntry(document);
	}

	public FileVersion toFileVersion(long repositoryId, Object object)
		throws PortalException, SystemException {

		CMISRepository cmisRepository =
			(CMISRepository)repositoryService.getRepositoryImpl(repositoryId);

		Document version = (Document)object;

		return cmisRepository.toFileVersion(version);
	}

	public Folder toFolder(long repositoryId, Object object)
		throws PortalException, SystemException {

		CMISRepository cmisRepository =
			(CMISRepository)repositoryService.getRepositoryImpl(repositoryId);

		org.apache.chemistry.opencmis.client.api.Folder folder =
			(org.apache.chemistry.opencmis.client.api.Folder)object;

		return cmisRepository.toFolder(folder);
	}

}