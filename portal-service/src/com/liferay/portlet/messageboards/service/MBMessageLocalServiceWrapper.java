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

package com.liferay.portlet.messageboards.service;

/**
 * <p>
 * This class is a wrapper for {@link MBMessageLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       MBMessageLocalService
 * @generated
 */
public class MBMessageLocalServiceWrapper implements MBMessageLocalService {
	public MBMessageLocalServiceWrapper(
		MBMessageLocalService mbMessageLocalService) {
		_mbMessageLocalService = mbMessageLocalService;
	}

	/**
	* Adds the message-boards message to the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessage the message-boards message
	* @return the message-boards message that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMessage addMBMessage(
		com.liferay.portlet.messageboards.model.MBMessage mbMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.addMBMessage(mbMessage);
	}

	/**
	* Creates a new message-boards message with the primary key. Does not add the message-boards message to the database.
	*
	* @param messageId the primary key for the new message-boards message
	* @return the new message-boards message
	*/
	public com.liferay.portlet.messageboards.model.MBMessage createMBMessage(
		long messageId) {
		return _mbMessageLocalService.createMBMessage(messageId);
	}

	/**
	* Deletes the message-boards message with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageId the primary key of the message-boards message
	* @throws PortalException if a message-boards message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMBMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.deleteMBMessage(messageId);
	}

	/**
	* Deletes the message-boards message from the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessage the message-boards message
	* @throws SystemException if a system exception occurred
	*/
	public void deleteMBMessage(
		com.liferay.portlet.messageboards.model.MBMessage mbMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.deleteMBMessage(mbMessage);
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
		return _mbMessageLocalService.dynamicQuery(dynamicQuery);
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
		return _mbMessageLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _mbMessageLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _mbMessageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the message-boards message with the primary key.
	*
	* @param messageId the primary key of the message-boards message
	* @return the message-boards message
	* @throws PortalException if a message-boards message with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMessage getMBMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMBMessage(messageId);
	}

	/**
	* Returns the message-boards message with the UUID in the group.
	*
	* @param uuid the UUID of message-boards message
	* @param groupId the group id of the message-boards message
	* @return the message-boards message
	* @throws PortalException if a message-boards message with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMessage getMBMessageByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMBMessageByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the message-boards messages.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message-boards messages
	* @param end the upper bound of the range of message-boards messages (not inclusive)
	* @return the range of message-boards messages
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getMBMessages(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMBMessages(start, end);
	}

	/**
	* Returns the number of message-boards messages.
	*
	* @return the number of message-boards messages
	* @throws SystemException if a system exception occurred
	*/
	public int getMBMessagesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMBMessagesCount();
	}

	/**
	* Updates the message-boards message in the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessage the message-boards message
	* @return the message-boards message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMessage updateMBMessage(
		com.liferay.portlet.messageboards.model.MBMessage mbMessage)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.updateMBMessage(mbMessage);
	}

	/**
	* Updates the message-boards message in the database. Also notifies the appropriate model listeners.
	*
	* @param mbMessage the message-boards message
	* @param merge whether to merge the message-boards message with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the message-boards message that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.messageboards.model.MBMessage updateMBMessage(
		com.liferay.portlet.messageboards.model.MBMessage mbMessage,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.updateMBMessage(mbMessage, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _mbMessageLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_mbMessageLocalService.setBeanIdentifier(beanIdentifier);
	}

	public com.liferay.portlet.messageboards.model.MBMessage addDiscussionMessage(
		long userId, java.lang.String userName, long groupId,
		java.lang.String className, long classPK, int workflowAction)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.addDiscussionMessage(userId, userName,
			groupId, className, classPK, workflowAction);
	}

	public com.liferay.portlet.messageboards.model.MBMessage addDiscussionMessage(
		long userId, java.lang.String userName, long groupId,
		java.lang.String className, long classPK, long threadId,
		long parentMessageId, java.lang.String subject, java.lang.String body,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.addDiscussionMessage(userId, userName,
			groupId, className, classPK, threadId, parentMessageId, subject,
			body, serviceContext);
	}

	public com.liferay.portlet.messageboards.model.MBMessage addMessage(
		long userId, java.lang.String userName, long groupId, long categoryId,
		long threadId, long parentMessageId, java.lang.String subject,
		java.lang.String body, java.lang.String format,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, byte[]>> files,
		boolean anonymous, double priority, boolean allowPingbacks,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.addMessage(userId, userName, groupId,
			categoryId, threadId, parentMessageId, subject, body, format,
			files, anonymous, priority, allowPingbacks, serviceContext);
	}

	public com.liferay.portlet.messageboards.model.MBMessage addMessage(
		long userId, java.lang.String userName, long groupId, long categoryId,
		java.lang.String subject, java.lang.String body,
		java.lang.String format,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, byte[]>> files,
		boolean anonymous, double priority, boolean allowPingbacks,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.addMessage(userId, userName, groupId,
			categoryId, subject, body, format, files, anonymous, priority,
			allowPingbacks, serviceContext);
	}

	public void addMessageResources(long messageId,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.addMessageResources(messageId,
			addGroupPermissions, addGuestPermissions);
	}

	public void addMessageResources(long messageId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.addMessageResources(messageId, groupPermissions,
			guestPermissions);
	}

	public void addMessageResources(
		com.liferay.portlet.messageboards.model.MBMessage message,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.addMessageResources(message,
			addGroupPermissions, addGuestPermissions);
	}

	public void addMessageResources(
		com.liferay.portlet.messageboards.model.MBMessage message,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.addMessageResources(message, groupPermissions,
			guestPermissions);
	}

	public void deleteDiscussionMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.deleteDiscussionMessage(messageId);
	}

	public void deleteDiscussionMessages(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.deleteDiscussionMessages(className, classPK);
	}

	public void deleteMessage(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.deleteMessage(messageId);
	}

	public void deleteMessage(
		com.liferay.portlet.messageboards.model.MBMessage message)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.deleteMessage(message);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCategoryMessages(
		long groupId, long categoryId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getCategoryMessages(groupId, categoryId,
			status, start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCategoryMessages(
		long groupId, long categoryId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getCategoryMessages(groupId, categoryId,
			status, start, end, obc);
	}

	public int getCategoryMessagesCount(long groupId, long categoryId,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getCategoryMessagesCount(groupId,
			categoryId, status);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCompanyMessages(
		long companyId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getCompanyMessages(companyId, status,
			start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCompanyMessages(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getCompanyMessages(companyId, status,
			start, end, obc);
	}

	public int getCompanyMessagesCount(long companyId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getCompanyMessagesCount(companyId, status);
	}

	public com.liferay.portlet.messageboards.model.MBMessageDisplay getDiscussionMessageDisplay(
		long userId, long groupId, java.lang.String className, long classPK,
		int status)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getDiscussionMessageDisplay(userId,
			groupId, className, classPK, status);
	}

	public com.liferay.portlet.messageboards.model.MBMessageDisplay getDiscussionMessageDisplay(
		long userId, long groupId, java.lang.String className, long classPK,
		int status, java.lang.String threadView)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getDiscussionMessageDisplay(userId,
			groupId, className, classPK, status, threadView);
	}

	public int getDiscussionMessagesCount(long classNameId, long classPK,
		int status) throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getDiscussionMessagesCount(classNameId,
			classPK, status);
	}

	public int getDiscussionMessagesCount(java.lang.String className,
		long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getDiscussionMessagesCount(className,
			classPK, status);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> getDiscussions(
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getDiscussions(className);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getGroupMessages(groupId, status, start,
			end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getGroupMessages(groupId, status, start,
			end, obc);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
		long groupId, long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getGroupMessages(groupId, userId, status,
			start, end);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
		long groupId, long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getGroupMessages(groupId, userId, status,
			start, end, obc);
	}

	public int getGroupMessagesCount(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getGroupMessagesCount(groupId, status);
	}

	public int getGroupMessagesCount(long groupId, long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getGroupMessagesCount(groupId, userId,
			status);
	}

	public com.liferay.portlet.messageboards.model.MBMessage getMessage(
		long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMessage(messageId);
	}

	public com.liferay.portlet.messageboards.model.MBMessageDisplay getMessageDisplay(
		long messageId, int status, java.lang.String threadView,
		boolean includePrevAndNext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMessageDisplay(messageId, status,
			threadView, includePrevAndNext);
	}

	public com.liferay.portlet.messageboards.model.MBMessageDisplay getMessageDisplay(
		com.liferay.portlet.messageboards.model.MBMessage message, int status,
		java.lang.String threadView, boolean includePrevAndNext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMessageDisplay(message, status,
			threadView, includePrevAndNext);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getMessages(
		java.lang.String className, long classPK, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getMessages(className, classPK, status);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getNoAssetMessages()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getNoAssetMessages();
	}

	public int getPositionInThread(long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getPositionInThread(messageId);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadMessages(
		long threadId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getThreadMessages(threadId, status);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadMessages(
		long threadId, int status,
		java.util.Comparator<com.liferay.portlet.messageboards.model.MBMessage> comparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getThreadMessages(threadId, status,
			comparator);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadMessages(
		long threadId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getThreadMessages(threadId, status,
			start, end);
	}

	public int getThreadMessagesCount(long threadId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getThreadMessagesCount(threadId, status);
	}

	public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadRepliesMessages(
		long threadId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.getThreadRepliesMessages(threadId,
			status, start, end);
	}

	public void subscribeMessage(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.subscribeMessage(userId, messageId);
	}

	public void unsubscribeMessage(long userId, long messageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.unsubscribeMessage(userId, messageId);
	}

	public void updateAsset(long userId,
		com.liferay.portlet.messageboards.model.MBMessage message,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.updateAsset(userId, message, assetCategoryIds,
			assetTagNames, assetLinkEntryIds);
	}

	public com.liferay.portlet.messageboards.model.MBMessage updateDiscussionMessage(
		long userId, long messageId, java.lang.String className, long classPK,
		java.lang.String subject, java.lang.String body, int workflowAction)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.updateDiscussionMessage(userId,
			messageId, className, classPK, subject, body, workflowAction);
	}

	public com.liferay.portlet.messageboards.model.MBMessage updateMessage(
		long userId, long messageId, java.lang.String subject,
		java.lang.String body,
		java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<java.lang.String, byte[]>> files,
		java.util.List<java.lang.String> existingFiles, double priority,
		boolean allowPingbacks,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.updateMessage(userId, messageId, subject,
			body, files, existingFiles, priority, allowPingbacks, serviceContext);
	}

	public com.liferay.portlet.messageboards.model.MBMessage updateMessage(
		long messageId, java.lang.String body)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.updateMessage(messageId, body);
	}

	public com.liferay.portlet.messageboards.model.MBMessage updateStatus(
		long userId, long messageId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _mbMessageLocalService.updateStatus(userId, messageId, status,
			serviceContext);
	}

	public void updateUserName(long userId, java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		_mbMessageLocalService.updateUserName(userId, userName);
	}

	public MBMessageLocalService getWrappedMBMessageLocalService() {
		return _mbMessageLocalService;
	}

	public void setWrappedMBMessageLocalService(
		MBMessageLocalService mbMessageLocalService) {
		_mbMessageLocalService = mbMessageLocalService;
	}

	private MBMessageLocalService _mbMessageLocalService;
}