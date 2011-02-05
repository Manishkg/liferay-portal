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

package com.liferay.portlet.forms.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
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

import com.liferay.portlet.expando.service.ExpandoValueLocalService;
import com.liferay.portlet.expando.service.ExpandoValueService;
import com.liferay.portlet.expando.service.persistence.ExpandoValuePersistence;
import com.liferay.portlet.forms.service.FormStructureLinkLocalService;
import com.liferay.portlet.forms.service.FormStructureLinkService;
import com.liferay.portlet.forms.service.FormStructureLocalService;
import com.liferay.portlet.forms.service.FormStructureService;
import com.liferay.portlet.forms.service.persistence.FormStructureLinkPersistence;
import com.liferay.portlet.forms.service.persistence.FormStructurePersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the form structure link remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.forms.service.impl.FormStructureLinkServiceImpl}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.forms.service.impl.FormStructureLinkServiceImpl
 * @see com.liferay.portlet.forms.service.FormStructureLinkServiceUtil
 * @generated
 */
public abstract class FormStructureLinkServiceBaseImpl extends PrincipalBean
	implements FormStructureLinkService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.forms.service.FormStructureLinkServiceUtil} to access the form structure link remote service.
	 */

	/**
	 * Gets the form structure local service.
	 *
	 * @return the form structure local service
	 */
	public FormStructureLocalService getFormStructureLocalService() {
		return formStructureLocalService;
	}

	/**
	 * Sets the form structure local service.
	 *
	 * @param formStructureLocalService the form structure local service
	 */
	public void setFormStructureLocalService(
		FormStructureLocalService formStructureLocalService) {
		this.formStructureLocalService = formStructureLocalService;
	}

	/**
	 * Gets the form structure remote service.
	 *
	 * @return the form structure remote service
	 */
	public FormStructureService getFormStructureService() {
		return formStructureService;
	}

	/**
	 * Sets the form structure remote service.
	 *
	 * @param formStructureService the form structure remote service
	 */
	public void setFormStructureService(
		FormStructureService formStructureService) {
		this.formStructureService = formStructureService;
	}

	/**
	 * Gets the form structure persistence.
	 *
	 * @return the form structure persistence
	 */
	public FormStructurePersistence getFormStructurePersistence() {
		return formStructurePersistence;
	}

	/**
	 * Sets the form structure persistence.
	 *
	 * @param formStructurePersistence the form structure persistence
	 */
	public void setFormStructurePersistence(
		FormStructurePersistence formStructurePersistence) {
		this.formStructurePersistence = formStructurePersistence;
	}

	/**
	 * Gets the form structure link local service.
	 *
	 * @return the form structure link local service
	 */
	public FormStructureLinkLocalService getFormStructureLinkLocalService() {
		return formStructureLinkLocalService;
	}

	/**
	 * Sets the form structure link local service.
	 *
	 * @param formStructureLinkLocalService the form structure link local service
	 */
	public void setFormStructureLinkLocalService(
		FormStructureLinkLocalService formStructureLinkLocalService) {
		this.formStructureLinkLocalService = formStructureLinkLocalService;
	}

	/**
	 * Gets the form structure link remote service.
	 *
	 * @return the form structure link remote service
	 */
	public FormStructureLinkService getFormStructureLinkService() {
		return formStructureLinkService;
	}

	/**
	 * Sets the form structure link remote service.
	 *
	 * @param formStructureLinkService the form structure link remote service
	 */
	public void setFormStructureLinkService(
		FormStructureLinkService formStructureLinkService) {
		this.formStructureLinkService = formStructureLinkService;
	}

	/**
	 * Gets the form structure link persistence.
	 *
	 * @return the form structure link persistence
	 */
	public FormStructureLinkPersistence getFormStructureLinkPersistence() {
		return formStructureLinkPersistence;
	}

	/**
	 * Sets the form structure link persistence.
	 *
	 * @param formStructureLinkPersistence the form structure link persistence
	 */
	public void setFormStructureLinkPersistence(
		FormStructureLinkPersistence formStructureLinkPersistence) {
		this.formStructureLinkPersistence = formStructureLinkPersistence;
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
	 * Gets the expando value local service.
	 *
	 * @return the expando value local service
	 */
	public ExpandoValueLocalService getExpandoValueLocalService() {
		return expandoValueLocalService;
	}

	/**
	 * Sets the expando value local service.
	 *
	 * @param expandoValueLocalService the expando value local service
	 */
	public void setExpandoValueLocalService(
		ExpandoValueLocalService expandoValueLocalService) {
		this.expandoValueLocalService = expandoValueLocalService;
	}

	/**
	 * Gets the expando value remote service.
	 *
	 * @return the expando value remote service
	 */
	public ExpandoValueService getExpandoValueService() {
		return expandoValueService;
	}

	/**
	 * Sets the expando value remote service.
	 *
	 * @param expandoValueService the expando value remote service
	 */
	public void setExpandoValueService(ExpandoValueService expandoValueService) {
		this.expandoValueService = expandoValueService;
	}

	/**
	 * Gets the expando value persistence.
	 *
	 * @return the expando value persistence
	 */
	public ExpandoValuePersistence getExpandoValuePersistence() {
		return expandoValuePersistence;
	}

	/**
	 * Sets the expando value persistence.
	 *
	 * @param expandoValuePersistence the expando value persistence
	 */
	public void setExpandoValuePersistence(
		ExpandoValuePersistence expandoValuePersistence) {
		this.expandoValuePersistence = expandoValuePersistence;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = formStructureLinkPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = FormStructureLocalService.class)
	protected FormStructureLocalService formStructureLocalService;
	@BeanReference(type = FormStructureService.class)
	protected FormStructureService formStructureService;
	@BeanReference(type = FormStructurePersistence.class)
	protected FormStructurePersistence formStructurePersistence;
	@BeanReference(type = FormStructureLinkLocalService.class)
	protected FormStructureLinkLocalService formStructureLinkLocalService;
	@BeanReference(type = FormStructureLinkService.class)
	protected FormStructureLinkService formStructureLinkService;
	@BeanReference(type = FormStructureLinkPersistence.class)
	protected FormStructureLinkPersistence formStructureLinkPersistence;
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
	@BeanReference(type = ExpandoValueLocalService.class)
	protected ExpandoValueLocalService expandoValueLocalService;
	@BeanReference(type = ExpandoValueService.class)
	protected ExpandoValueService expandoValueService;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
}