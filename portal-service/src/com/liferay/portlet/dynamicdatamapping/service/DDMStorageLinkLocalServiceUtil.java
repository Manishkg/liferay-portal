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

package com.liferay.portlet.dynamicdatamapping.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the d d m storage link local service. This utility wraps {@link com.liferay.portlet.dynamicdatamapping.service.impl.DDMStorageLinkLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMStorageLinkLocalService
 * @see com.liferay.portlet.dynamicdatamapping.service.base.DDMStorageLinkLocalServiceBaseImpl
 * @see com.liferay.portlet.dynamicdatamapping.service.impl.DDMStorageLinkLocalServiceImpl
 * @generated
 */
public class DDMStorageLinkLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.dynamicdatamapping.service.impl.DDMStorageLinkLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the d d m storage link to the database. Also notifies the appropriate model listeners.
	*
	* @param ddmStorageLink the d d m storage link to add
	* @return the d d m storage link that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink addDDMStorageLink(
		com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink ddmStorageLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDDMStorageLink(ddmStorageLink);
	}

	/**
	* Creates a new d d m storage link with the primary key. Does not add the d d m storage link to the database.
	*
	* @param storageLinkId the primary key for the new d d m storage link
	* @return the new d d m storage link
	*/
	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink createDDMStorageLink(
		long storageLinkId) {
		return getService().createDDMStorageLink(storageLinkId);
	}

	/**
	* Deletes the d d m storage link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param storageLinkId the primary key of the d d m storage link to delete
	* @throws PortalException if a d d m storage link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDDMStorageLink(long storageLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDDMStorageLink(storageLinkId);
	}

	/**
	* Deletes the d d m storage link from the database. Also notifies the appropriate model listeners.
	*
	* @param ddmStorageLink the d d m storage link to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteDDMStorageLink(
		com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink ddmStorageLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteDDMStorageLink(ddmStorageLink);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the d d m storage link with the primary key.
	*
	* @param storageLinkId the primary key of the d d m storage link to get
	* @return the d d m storage link
	* @throws PortalException if a d d m storage link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink getDDMStorageLink(
		long storageLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDDMStorageLink(storageLinkId);
	}

	/**
	* Gets a range of all the d d m storage links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of d d m storage links to return
	* @param end the upper bound of the range of d d m storage links to return (not inclusive)
	* @return the range of d d m storage links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink> getDDMStorageLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDDMStorageLinks(start, end);
	}

	/**
	* Gets the number of d d m storage links.
	*
	* @return the number of d d m storage links
	* @throws SystemException if a system exception occurred
	*/
	public static int getDDMStorageLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDDMStorageLinksCount();
	}

	/**
	* Updates the d d m storage link in the database. Also notifies the appropriate model listeners.
	*
	* @param ddmStorageLink the d d m storage link to update
	* @return the d d m storage link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink updateDDMStorageLink(
		com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink ddmStorageLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDDMStorageLink(ddmStorageLink);
	}

	/**
	* Updates the d d m storage link in the database. Also notifies the appropriate model listeners.
	*
	* @param ddmStorageLink the d d m storage link to update
	* @param merge whether to merge the d d m storage link with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the d d m storage link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink updateDDMStorageLink(
		com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink ddmStorageLink,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDDMStorageLink(ddmStorageLink, merge);
	}

	/**
	* Gets the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink addStorageLink(
		long classNameId, long classPK, java.lang.String type,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addStorageLink(classNameId, classPK, type, serviceContext);
	}

	public static void deleteStorageLink(
		com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink storageLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStorageLink(storageLink);
	}

	public static void deleteStorageLink(long storageLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStorageLink(storageLinkId);
	}

	public static void deleteStorageLink(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteStorageLink(classNameId, classPK);
	}

	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink getStorageLink(
		long storageLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStorageLink(storageLinkId);
	}

	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink getStorageLink(
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getStorageLink(classNameId, classPK);
	}

	public static com.liferay.portlet.dynamicdatamapping.model.DDMStorageLink updateStorageLink(
		long storageLinkId, long classNameId, long classPK,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStorageLink(storageLinkId, classNameId, classPK, type);
	}

	public static DDMStorageLinkLocalService getService() {
		if (_service == null) {
			_service = (DDMStorageLinkLocalService)PortalBeanLocatorUtil.locate(DDMStorageLinkLocalService.class.getName());

			ReferenceRegistry.registerReference(DDMStorageLinkLocalServiceUtil.class,
				"_service");
			MethodCache.remove(DDMStorageLinkLocalService.class);
		}

		return _service;
	}

	public void setService(DDMStorageLinkLocalService service) {
		MethodCache.remove(DDMStorageLinkLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(DDMStorageLinkLocalServiceUtil.class,
			"_service");
		MethodCache.remove(DDMStorageLinkLocalService.class);
	}

	private static DDMStorageLinkLocalService _service;
}