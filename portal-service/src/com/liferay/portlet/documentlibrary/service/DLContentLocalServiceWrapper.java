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

package com.liferay.portlet.documentlibrary.service;

/**
 * <p>
 * This class is a wrapper for {@link DLContentLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DLContentLocalService
 * @generated
 */
public class DLContentLocalServiceWrapper implements DLContentLocalService {
	public DLContentLocalServiceWrapper(
		DLContentLocalService dlContentLocalService) {
		_dlContentLocalService = dlContentLocalService;
	}

	/**
	* Adds the d l content to the database. Also notifies the appropriate model listeners.
	*
	* @param dlContent the d l content
	* @return the d l content that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.documentlibrary.model.DLContent addDLContent(
		com.liferay.portlet.documentlibrary.model.DLContent dlContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.addDLContent(dlContent);
	}

	/**
	* Creates a new d l content with the primary key. Does not add the d l content to the database.
	*
	* @param contentId the primary key for the new d l content
	* @return the new d l content
	*/
	public com.liferay.portlet.documentlibrary.model.DLContent createDLContent(
		long contentId) {
		return _dlContentLocalService.createDLContent(contentId);
	}

	/**
	* Deletes the d l content with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param contentId the primary key of the d l content
	* @throws PortalException if a d l content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDLContent(long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dlContentLocalService.deleteDLContent(contentId);
	}

	/**
	* Deletes the d l content from the database. Also notifies the appropriate model listeners.
	*
	* @param dlContent the d l content
	* @throws SystemException if a system exception occurred
	*/
	public void deleteDLContent(
		com.liferay.portlet.documentlibrary.model.DLContent dlContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dlContentLocalService.deleteDLContent(dlContent);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the d l content with the primary key.
	*
	* @param contentId the primary key of the d l content
	* @return the d l content
	* @throws PortalException if a d l content with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.documentlibrary.model.DLContent getDLContent(
		long contentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.getDLContent(contentId);
	}

	/**
	* Returns a range of all the d l contents.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of d l contents
	* @param end the upper bound of the range of d l contents (not inclusive)
	* @return the range of d l contents
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.documentlibrary.model.DLContent> getDLContents(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.getDLContents(start, end);
	}

	/**
	* Returns the number of d l contents.
	*
	* @return the number of d l contents
	* @throws SystemException if a system exception occurred
	*/
	public int getDLContentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.getDLContentsCount();
	}

	/**
	* Updates the d l content in the database. Also notifies the appropriate model listeners.
	*
	* @param dlContent the d l content
	* @return the d l content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.documentlibrary.model.DLContent updateDLContent(
		com.liferay.portlet.documentlibrary.model.DLContent dlContent)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.updateDLContent(dlContent);
	}

	/**
	* Updates the d l content in the database. Also notifies the appropriate model listeners.
	*
	* @param dlContent the d l content
	* @param merge whether to merge the d l content with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the d l content that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.documentlibrary.model.DLContent updateDLContent(
		com.liferay.portlet.documentlibrary.model.DLContent dlContent,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.updateDLContent(dlContent, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _dlContentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_dlContentLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.portlet.documentlibrary.model.DLContent addContent(
		long companyId, java.lang.String portletId, long groupId,
		long repositoryId, java.lang.String path, java.lang.String version,
		byte[] bytes)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.addContent(companyId, portletId, groupId,
			repositoryId, path, version, bytes);
	}

	public com.liferay.portlet.documentlibrary.model.DLContent addContent(
		long companyId, java.lang.String portletId, long groupId,
		long repositoryId, java.lang.String path, java.lang.String version,
		java.io.InputStream inputStream, long size)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.addContent(companyId, portletId, groupId,
			repositoryId, path, version, inputStream, size);
	}

	public void deleteContent(long companyId, java.lang.String portletId,
		long repositoryId, java.lang.String path, java.lang.String version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_dlContentLocalService.deleteContent(companyId, portletId,
			repositoryId, path, version);
	}

	public void deleteContents(long companyId, java.lang.String portletId,
		long repositoryId, java.lang.String path)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dlContentLocalService.deleteContents(companyId, portletId,
			repositoryId, path);
	}

	public com.liferay.portlet.documentlibrary.model.DLContent getContent(
		long companyId, java.lang.String portletId, long repositoryId,
		java.lang.String path, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portlet.documentlibrary.NoSuchContentException {
		return _dlContentLocalService.getContent(companyId, portletId,
			repositoryId, path, version);
	}

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLContent> getContentReferences(
		long companyId, long repositoryId, java.lang.String path)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.getContentReferences(companyId,
			repositoryId, path);
	}

	public java.util.List<com.liferay.portlet.documentlibrary.model.DLContent> getContents(
		long companyId, java.lang.String portletId, long repositoryId,
		java.lang.String path)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.getContents(companyId, portletId,
			repositoryId, path);
	}

	public boolean hasContent(long companyId, java.lang.String portletId,
		long repositoryId, java.lang.String path, java.lang.String version)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dlContentLocalService.hasContent(companyId, portletId,
			repositoryId, path, version);
	}

	public void updateDLContent(long companyId, long oldRepositoryId,
		long newRepositoryId, java.lang.String oldPath, java.lang.String newPath)
		throws com.liferay.portal.kernel.exception.SystemException {
		_dlContentLocalService.updateDLContent(companyId, oldRepositoryId,
			newRepositoryId, oldPath, newPath);
	}

	public DLContentLocalService getWrappedDLContentLocalService() {
		return _dlContentLocalService;
	}

	public void setWrappedDLContentLocalService(
		DLContentLocalService dlContentLocalService) {
		_dlContentLocalService = dlContentLocalService;
	}

	private DLContentLocalService _dlContentLocalService;
}