<%--
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
--%>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String name = ParamUtil.getString(request, "name");
String toolbarSet = ParamUtil.getString(request, "toolbarSet");
String initMethod =	ParamUtil.getString(request, "initMethod");
String onChangeMethod = ParamUtil.getString(request, "onChangeMethod");
String cssClasses = ParamUtil.getString(request, "cssClasses");
String editorImpl = ParamUtil.getString(request, "editorImpl");
%>

<liferay-ui:input-editor cssClass="<%= cssClasses %>" editorImpl="<%= editorImpl %>" initMethod="<%= initMethod %>" name="<%= name %>" onChangeMethod="<%= onChangeMethod %>" toolbarSet="<%= toolbarSet %>" />