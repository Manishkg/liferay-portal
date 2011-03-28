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

package com.liferay.portlet.dynamicdatalist.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.dynamicdatalist.model.DDLEntry;
import com.liferay.portlet.dynamicdatalist.service.DDLEntryLocalService;
import com.liferay.portlet.dynamicdatalist.service.DDLEntryService;
import com.liferay.portlet.dynamicdatalist.service.persistence.DDLEntryPersistence;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the d d l entry local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.dynamicdatalist.service.impl.DDLEntryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.dynamicdatalist.service.impl.DDLEntryLocalServiceImpl
 * @see com.liferay.portlet.dynamicdatalist.service.DDLEntryLocalServiceUtil
 * @generated
 */
public abstract class DDLEntryLocalServiceBaseImpl
	implements DDLEntryLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.dynamicdatalist.service.DDLEntryLocalServiceUtil} to access the d d l entry local service.
	 */

	/**
	 * Adds the d d l entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntry the d d l entry to add
	 * @return the d d l entry that was added
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntry addDDLEntry(DDLEntry ddlEntry) throws SystemException {
		ddlEntry.setNew(true);

		return ddlEntryPersistence.update(ddlEntry, false);
	}

	/**
	 * Creates a new d d l entry with the primary key. Does not add the d d l entry to the database.
	 *
	 * @param entryId the primary key for the new d d l entry
	 * @return the new d d l entry
	 */
	public DDLEntry createDDLEntry(long entryId) {
		return ddlEntryPersistence.create(entryId);
	}

	/**
	 * Deletes the d d l entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the d d l entry to delete
	 * @throws PortalException if a d d l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDDLEntry(long entryId)
		throws PortalException, SystemException {
		ddlEntryPersistence.remove(entryId);
	}

	/**
	 * Deletes the d d l entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntry the d d l entry to delete
	 * @throws SystemException if a system exception occurred
	 */
	public void deleteDDLEntry(DDLEntry ddlEntry) throws SystemException {
		ddlEntryPersistence.remove(ddlEntry);
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return ddlEntryPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return ddlEntryPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return ddlEntryPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Counts the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query to search with
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return ddlEntryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Gets the d d l entry with the primary key.
	 *
	 * @param entryId the primary key of the d d l entry to get
	 * @return the d d l entry
	 * @throws PortalException if a d d l entry with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntry getDDLEntry(long entryId)
		throws PortalException, SystemException {
		return ddlEntryPersistence.findByPrimaryKey(entryId);
	}

	/**
	 * Gets the d d l entry with the UUID and group id.
	 *
	 * @param uuid the UUID of d d l entry to get
	 * @param groupId the group id of the d d l entry to get
	 * @return the d d l entry
	 * @throws PortalException if a d d l entry with the UUID and group id could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntry getDDLEntryByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return ddlEntryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Gets a range of all the d d l entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of d d l entries to return
	 * @param end the upper bound of the range of d d l entries to return (not inclusive)
	 * @return the range of d d l entries
	 * @throws SystemException if a system exception occurred
	 */
	public List<DDLEntry> getDDLEntries(int start, int end)
		throws SystemException {
		return ddlEntryPersistence.findAll(start, end);
	}

	/**
	 * Gets the number of d d l entries.
	 *
	 * @return the number of d d l entries
	 * @throws SystemException if a system exception occurred
	 */
	public int getDDLEntriesCount() throws SystemException {
		return ddlEntryPersistence.countAll();
	}

	/**
	 * Updates the d d l entry in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntry the d d l entry to update
	 * @return the d d l entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntry updateDDLEntry(DDLEntry ddlEntry) throws SystemException {
		ddlEntry.setNew(false);

		return ddlEntryPersistence.update(ddlEntry, true);
	}

	/**
	 * Updates the d d l entry in the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddlEntry the d d l entry to update
	 * @param merge whether to merge the d d l entry with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the d d l entry that was updated
	 * @throws SystemException if a system exception occurred
	 */
	public DDLEntry updateDDLEntry(DDLEntry ddlEntry, boolean merge)
		throws SystemException {
		ddlEntry.setNew(false);

		return ddlEntryPersistence.update(ddlEntry, merge);
	}

	/**
	 * Gets the d d l entry local service.
	 *
	 * @return the d d l entry local service
	 */
	public DDLEntryLocalService getDDLEntryLocalService() {
		return ddlEntryLocalService;
	}

	/**
	 * Sets the d d l entry local service.
	 *
	 * @param ddlEntryLocalService the d d l entry local service
	 */
	public void setDDLEntryLocalService(
		DDLEntryLocalService ddlEntryLocalService) {
		this.ddlEntryLocalService = ddlEntryLocalService;
	}

	/**
	 * Gets the d d l entry remote service.
	 *
	 * @return the d d l entry remote service
	 */
	public DDLEntryService getDDLEntryService() {
		return ddlEntryService;
	}

	/**
	 * Sets the d d l entry remote service.
	 *
	 * @param ddlEntryService the d d l entry remote service
	 */
	public void setDDLEntryService(DDLEntryService ddlEntryService) {
		this.ddlEntryService = ddlEntryService;
	}

	/**
	 * Gets the d d l entry persistence.
	 *
	 * @return the d d l entry persistence
	 */
	public DDLEntryPersistence getDDLEntryPersistence() {
		return ddlEntryPersistence;
	}

	/**
	 * Sets the d d l entry persistence.
	 *
	 * @param ddlEntryPersistence the d d l entry persistence
	 */
	public void setDDLEntryPersistence(DDLEntryPersistence ddlEntryPersistence) {
		this.ddlEntryPersistence = ddlEntryPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Gets the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ddlEntryPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DDLEntryLocalService.class)
	protected DDLEntryLocalService ddlEntryLocalService;
	@BeanReference(type = DDLEntryService.class)
	protected DDLEntryService ddlEntryService;
	@BeanReference(type = DDLEntryPersistence.class)
	protected DDLEntryPersistence ddlEntryPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
	private String _beanIdentifier;
}