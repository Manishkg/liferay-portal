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

package com.liferay.portlet.dynamicdatamapping.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.dynamicdatamapping.service.DDMContentLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLocalService;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryService;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMContentPersistence;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructureEntryLinkPersistence;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMStructureEntryPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the d d m structure entry link remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.dynamicdatamapping.service.impl.DDMStructureEntryLinkServiceImpl}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.dynamicdatamapping.service.impl.DDMStructureEntryLinkServiceImpl
 * @see com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkServiceUtil
 * @generated
 */
public abstract class DDMStructureEntryLinkServiceBaseImpl extends PrincipalBean
	implements DDMStructureEntryLinkService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkServiceUtil} to access the d d m structure entry link remote service.
	 */

	/**
	 * Gets the d d m content local service.
	 *
	 * @return the d d m content local service
	 */
	public DDMContentLocalService getDDMContentLocalService() {
		return ddmContentLocalService;
	}

	/**
	 * Sets the d d m content local service.
	 *
	 * @param ddmContentLocalService the d d m content local service
	 */
	public void setDDMContentLocalService(
		DDMContentLocalService ddmContentLocalService) {
		this.ddmContentLocalService = ddmContentLocalService;
	}

	/**
	 * Gets the d d m content persistence.
	 *
	 * @return the d d m content persistence
	 */
	public DDMContentPersistence getDDMContentPersistence() {
		return ddmContentPersistence;
	}

	/**
	 * Sets the d d m content persistence.
	 *
	 * @param ddmContentPersistence the d d m content persistence
	 */
	public void setDDMContentPersistence(
		DDMContentPersistence ddmContentPersistence) {
		this.ddmContentPersistence = ddmContentPersistence;
	}

	/**
	 * Gets the d d m structure entry local service.
	 *
	 * @return the d d m structure entry local service
	 */
	public DDMStructureEntryLocalService getDDMStructureEntryLocalService() {
		return ddmStructureEntryLocalService;
	}

	/**
	 * Sets the d d m structure entry local service.
	 *
	 * @param ddmStructureEntryLocalService the d d m structure entry local service
	 */
	public void setDDMStructureEntryLocalService(
		DDMStructureEntryLocalService ddmStructureEntryLocalService) {
		this.ddmStructureEntryLocalService = ddmStructureEntryLocalService;
	}

	/**
	 * Gets the d d m structure entry remote service.
	 *
	 * @return the d d m structure entry remote service
	 */
	public DDMStructureEntryService getDDMStructureEntryService() {
		return ddmStructureEntryService;
	}

	/**
	 * Sets the d d m structure entry remote service.
	 *
	 * @param ddmStructureEntryService the d d m structure entry remote service
	 */
	public void setDDMStructureEntryService(
		DDMStructureEntryService ddmStructureEntryService) {
		this.ddmStructureEntryService = ddmStructureEntryService;
	}

	/**
	 * Gets the d d m structure entry persistence.
	 *
	 * @return the d d m structure entry persistence
	 */
	public DDMStructureEntryPersistence getDDMStructureEntryPersistence() {
		return ddmStructureEntryPersistence;
	}

	/**
	 * Sets the d d m structure entry persistence.
	 *
	 * @param ddmStructureEntryPersistence the d d m structure entry persistence
	 */
	public void setDDMStructureEntryPersistence(
		DDMStructureEntryPersistence ddmStructureEntryPersistence) {
		this.ddmStructureEntryPersistence = ddmStructureEntryPersistence;
	}

	/**
	 * Gets the d d m structure entry link local service.
	 *
	 * @return the d d m structure entry link local service
	 */
	public DDMStructureEntryLinkLocalService getDDMStructureEntryLinkLocalService() {
		return ddmStructureEntryLinkLocalService;
	}

	/**
	 * Sets the d d m structure entry link local service.
	 *
	 * @param ddmStructureEntryLinkLocalService the d d m structure entry link local service
	 */
	public void setDDMStructureEntryLinkLocalService(
		DDMStructureEntryLinkLocalService ddmStructureEntryLinkLocalService) {
		this.ddmStructureEntryLinkLocalService = ddmStructureEntryLinkLocalService;
	}

	/**
	 * Gets the d d m structure entry link remote service.
	 *
	 * @return the d d m structure entry link remote service
	 */
	public DDMStructureEntryLinkService getDDMStructureEntryLinkService() {
		return ddmStructureEntryLinkService;
	}

	/**
	 * Sets the d d m structure entry link remote service.
	 *
	 * @param ddmStructureEntryLinkService the d d m structure entry link remote service
	 */
	public void setDDMStructureEntryLinkService(
		DDMStructureEntryLinkService ddmStructureEntryLinkService) {
		this.ddmStructureEntryLinkService = ddmStructureEntryLinkService;
	}

	/**
	 * Gets the d d m structure entry link persistence.
	 *
	 * @return the d d m structure entry link persistence
	 */
	public DDMStructureEntryLinkPersistence getDDMStructureEntryLinkPersistence() {
		return ddmStructureEntryLinkPersistence;
	}

	/**
	 * Sets the d d m structure entry link persistence.
	 *
	 * @param ddmStructureEntryLinkPersistence the d d m structure entry link persistence
	 */
	public void setDDMStructureEntryLinkPersistence(
		DDMStructureEntryLinkPersistence ddmStructureEntryLinkPersistence) {
		this.ddmStructureEntryLinkPersistence = ddmStructureEntryLinkPersistence;
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
			DataSource dataSource = ddmStructureEntryLinkPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DDMContentLocalService.class)
	protected DDMContentLocalService ddmContentLocalService;
	@BeanReference(type = DDMContentPersistence.class)
	protected DDMContentPersistence ddmContentPersistence;
	@BeanReference(type = DDMStructureEntryLocalService.class)
	protected DDMStructureEntryLocalService ddmStructureEntryLocalService;
	@BeanReference(type = DDMStructureEntryService.class)
	protected DDMStructureEntryService ddmStructureEntryService;
	@BeanReference(type = DDMStructureEntryPersistence.class)
	protected DDMStructureEntryPersistence ddmStructureEntryPersistence;
	@BeanReference(type = DDMStructureEntryLinkLocalService.class)
	protected DDMStructureEntryLinkLocalService ddmStructureEntryLinkLocalService;
	@BeanReference(type = DDMStructureEntryLinkService.class)
	protected DDMStructureEntryLinkService ddmStructureEntryLinkService;
	@BeanReference(type = DDMStructureEntryLinkPersistence.class)
	protected DDMStructureEntryLinkPersistence ddmStructureEntryLinkPersistence;
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