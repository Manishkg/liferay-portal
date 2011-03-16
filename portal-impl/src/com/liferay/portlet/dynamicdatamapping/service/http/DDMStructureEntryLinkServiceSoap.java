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

package com.liferay.portlet.dynamicdatamapping.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkServiceUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLink}, that is translated to a
 * {@link com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <b>tunnel.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DDMStructureEntryLinkServiceHttp
 * @see       com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap
 * @see       com.liferay.portlet.dynamicdatamapping.service.DDMStructureEntryLinkServiceUtil
 * @generated
 */
public class DDMStructureEntryLinkServiceSoap {
	public static com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap addStructureEntryLink(
		java.lang.String structureId, java.lang.String className, long classPK,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLink returnValue =
				DDMStructureEntryLinkServiceUtil.addStructureEntryLink(structureId,
					className, classPK, serviceContext);

			return com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteStructureEntryLink(long groupId,
		java.lang.String structureId, long structureEntryLinkId)
		throws RemoteException {
		try {
			DDMStructureEntryLinkServiceUtil.deleteStructureEntryLink(groupId,
				structureId, structureEntryLinkId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap getStructureEntryLink(
		long groupId, java.lang.String structureId, java.lang.String className,
		long classPK) throws RemoteException {
		try {
			com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLink returnValue =
				DDMStructureEntryLinkServiceUtil.getStructureEntryLink(groupId,
					structureId, className, classPK);

			return com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap updateStructureEntryLink(
		long structureEntryLinkId, java.lang.String structureId, long groupId,
		java.lang.String className, long classPK) throws RemoteException {
		try {
			com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLink returnValue =
				DDMStructureEntryLinkServiceUtil.updateStructureEntryLink(structureEntryLinkId,
					structureId, groupId, className, classPK);

			return com.liferay.portlet.dynamicdatamapping.model.DDMStructureEntryLinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DDMStructureEntryLinkServiceSoap.class);
}