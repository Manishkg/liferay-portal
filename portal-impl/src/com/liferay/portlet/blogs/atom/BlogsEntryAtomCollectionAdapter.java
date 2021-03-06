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

package com.liferay.portlet.blogs.atom;

import com.liferay.portal.atom.AtomPager;
import com.liferay.portal.atom.AtomUtil;
import com.liferay.portal.kernel.atom.AtomRequestContext;
import com.liferay.portal.kernel.atom.BaseAtomCollectionAdapter;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Image;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.ImageLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryServiceUtil;

import java.io.File;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Igor Spasic
 */
public class BlogsEntryAtomCollectionAdapter
	extends BaseAtomCollectionAdapter<BlogsEntry> {

	public String getCollectionName() {
		return _COLLECTION_NAME;
	}

	public List<String> getEntryAuthors(BlogsEntry blogsEntry) {
		List<String> authors = new ArrayList<String>();

		authors.add(blogsEntry.getUserName());

		return authors;
	}

	public String getEntryContent(BlogsEntry blogsEntry) {
		return blogsEntry.getContent();
	}

	public String getEntryId(BlogsEntry blogsEntry) {
		return String.valueOf(blogsEntry.getEntryId());
	}

	public String getEntryTitle(BlogsEntry blogsEntry) {
		return blogsEntry.getTitle();
	}

	public Date getEntryUpdated(BlogsEntry blogsEntry) {
		return blogsEntry.getModifiedDate();
	}

	public String getFeedTitle(AtomRequestContext atomRequestContext) {
		return AtomUtil.createFeedTitleFromPortletName(
			atomRequestContext, PortletKeys.BLOGS);
	}

	@Override
	protected void doDeleteEntry(
			String resourceName, AtomRequestContext atomRequestContext)
		throws Exception {

		long blogsEntryId = GetterUtil.getLong(resourceName);

		BlogsEntryServiceUtil.deleteEntry(blogsEntryId);
	}

	@Override
	protected BlogsEntry doGetEntry(
			String resourceName, AtomRequestContext atomRequestContext)
		throws Exception {

		long blogsEntryId = GetterUtil.getLong(resourceName);

		return BlogsEntryServiceUtil.getEntry(blogsEntryId);
	}

	@Override
	protected Iterable<BlogsEntry> doGetFeedEntries(
			AtomRequestContext atomRequestContext)
		throws Exception {

		long groupId = atomRequestContext.getLongParameter("groupId");
		int status = WorkflowConstants.STATUS_APPROVED;

		int max = atomRequestContext.getIntParameter(
			"max", SearchContainer.DEFAULT_DELTA);

		if (groupId > 0) {
			int page = atomRequestContext.getIntParameter("page");

			if (page == 0) {
				return BlogsEntryServiceUtil.getGroupEntries(
					groupId, status, max);
			}

			int blogsEntriesCount = BlogsEntryServiceUtil.getGroupEntriesCount(
				groupId, status);

			AtomPager atomPager = new AtomPager(page, blogsEntriesCount, max);

			AtomUtil.saveAtomPagerInRequest(atomRequestContext, atomPager);

			return BlogsEntryServiceUtil.getGroupEntries(
				groupId, status, atomPager.getStart(), atomPager.getEnd() + 1);
		}

		long organizationId = atomRequestContext.getLongParameter(
			"organizationId");

		if (organizationId > 0) {
			return BlogsEntryServiceUtil.getOrganizationEntries(
				organizationId, status, max);
		}

		long companyId = CompanyThreadLocal.getCompanyId();

		if (companyId > 0) {
			return BlogsEntryServiceUtil.getCompanyEntries(
				companyId, status, max);
		}

		return Collections.emptyList();
	}

	@Override
	protected BlogsEntry doPostEntry(
			String title, String summary, String content, Date date,
			AtomRequestContext atomRequestContext)
		throws Exception {

		long groupId = atomRequestContext.getLongParameter("groupId");

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		int displayDateMonth = cal.get(Calendar.MONTH);
		int displayDateDay = cal.get(Calendar.DAY_OF_MONTH);
		int displayDateYear = cal.get(Calendar.YEAR);
		int displayDateHour = cal.get(Calendar.HOUR_OF_DAY);
		int displayDateMinute = cal.get(Calendar.MINUTE);

		boolean allowPingbacks = true;
		boolean allowTrackbacks = true;
		String[] trackbacks = new String[0];

		ServiceContext serviceContext = new ServiceContext();

		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setScopeGroupId(groupId);

		return BlogsEntryServiceUtil.addEntry(
			title, summary, content, displayDateMonth, displayDateDay,
			displayDateYear, displayDateHour, displayDateMinute,
			allowPingbacks, allowTrackbacks, trackbacks, false, null, null,
			serviceContext);
	}

	@Override
	protected void doPutEntry(
			BlogsEntry blogsEntry, String title, String summary, String content,
			Date date, AtomRequestContext atomRequestContext)
		throws Exception {

		Calendar cal = Calendar.getInstance();

		cal.setTime(date);

		int displayDateMonth = cal.get(Calendar.MONTH);
		int displayDateDay = cal.get(Calendar.DAY_OF_MONTH);
		int displayDateYear = cal.get(Calendar.YEAR);
		int displayDateHour = cal.get(Calendar.HOUR_OF_DAY);
		int displayDateMinute = cal.get(Calendar.MINUTE);

		String[] trackbacks = StringUtil.split(blogsEntry.getTrackbacks());

		long smallImageId = blogsEntry.getSmallImageId();

		File smallImageFile = null;

		if (smallImageId != 0) {
			Image smallImage = ImageLocalServiceUtil.getImage(smallImageId);

			if (smallImage != null) {
				byte[] smallImageBytes = smallImage.getTextObj();

				smallImageFile = FileUtil.createTempFile(
					smallImageId + StringPool.PERIOD +
						blogsEntry.getSmallImageType());

				FileUtil.write(smallImageFile, smallImageBytes);
			}
		}

		ServiceContext serviceContext = new ServiceContext();

		BlogsEntryServiceUtil.updateEntry(
			blogsEntry.getEntryId(), title, summary, content, displayDateMonth,
			displayDateDay, displayDateYear, displayDateHour, displayDateMinute,
			blogsEntry.getAllowPingbacks(), blogsEntry.isAllowTrackbacks(),
			trackbacks, blogsEntry.isSmallImage(),
			blogsEntry.getSmallImageURL(), smallImageFile, serviceContext);

		if (smallImageFile != null) {
			smallImageFile.delete();
		}
	}

	private static final String _COLLECTION_NAME = "blogs";

}