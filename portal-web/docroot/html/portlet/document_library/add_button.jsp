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

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
Folder folder = (Folder)request.getAttribute("view.jsp-folder");

long folderId = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));

long repositoryId = GetterUtil.getLong((String)request.getAttribute("view.jsp-repositoryId"));

List<DLFileEntryType> fileEntryTypes = DLFileEntryTypeServiceUtil.getFileEntryTypes(scopeGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
%>

<liferay-ui:icon-menu align="left" icon="" direction="down" message="add" showExpanded="<%= false %>" showWhenSingleIcon="<%= false %>">
	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_FOLDER) %>">
		<portlet:renderURL var="addFolderURL">
			<portlet:param name="struts_action" value="/document_library/edit_folder" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="parentFolderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="folder" message='<%= (folder != null) ? "subfolder" : "folder" %>' url="<%= addFolderURL %>" />
	</c:if>

	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_SHORTCUT) %>">
		<portlet:renderURL var="editFileShortcutURL">
			<portlet:param name="struts_action" value="/document_library/edit_file_shortcut" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="add_instance" message="shortcut" url="<%= editFileShortcutURL %>" />
	</c:if>

	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_FOLDER) %>">
		<portlet:renderURL var="addRepositoryURL">
			<portlet:param name="struts_action" value="/document_library/edit_repository" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="add_drive" message="repository" url="<%= addRepositoryURL %>" />
	</c:if>

	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_DOCUMENT) %>">
		<portlet:renderURL var="editFileEntryURL">
			<portlet:param name="struts_action" value="/document_library/upload_multiple_file_entries" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon cssClass="aui-helper-hidden upload-multiple-documents" image="../document_library/add_multiple_documents" message="multiple-documents" url="<%= editFileEntryURL %>" />
	</c:if>

	<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderId, ActionKeys.ADD_DOCUMENT) %>">
		<portlet:renderURL var="editFileEntryURL">
			<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="backURL" value="<%= currentURL %>" />
			<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
			<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
		</portlet:renderURL>

		<liferay-ui:icon image='<%= (!fileEntryTypes.isEmpty() && ((folder == null) || folder.isSupportsMetadata())) ? "copy" : "../document_library/add_document" %>' message='<%= (!fileEntryTypes.isEmpty() && ((folder == null) || folder.isSupportsMetadata())) ? "basic-document" : "document" %>' url="<%= editFileEntryURL %>" />
	</c:if>

	<c:if test="<%= (folder == null) || folder.isSupportsMetadata() %>">

		<%
		for (DLFileEntryType fileEntryType : fileEntryTypes) {
		%>

			<portlet:renderURL var="addFileEntryTypeURL">
				<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
				<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD %>" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
				<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
				<portlet:param name="fileEntryTypeId" value="<%= String.valueOf(fileEntryType.getFileEntryTypeId()) %>" />
			</portlet:renderURL>

			<liferay-ui:icon image="copy" message="<%= fileEntryType.getName() %>" url="<%= addFileEntryTypeURL %>" />

		<%
		}
		%>

	</c:if>
</liferay-ui:icon-menu>

<aui:script use="aui-base,aui-swf">
	if (A.SWF.isFlashVersionAtLeast(9)) {
		var uploadMultipleDocumentsIcon = A.all('.upload-multiple-documents:hidden');

		uploadMultipleDocumentsIcon.show();
	}
</aui:script>