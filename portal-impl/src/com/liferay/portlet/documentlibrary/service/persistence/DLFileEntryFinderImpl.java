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

package com.liferay.portlet.documentlibrary.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Iterator;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class DLFileEntryFinderImpl
	extends BasePersistenceImpl<DLFileEntry> implements DLFileEntryFinder {

	public static String COUNT_BY_EXTRA_SETTINGS =
		DLFileEntryFinder.class.getName() + ".countByExtraSettings";

	public static String COUNT_BY_G_F_S =
		DLFileEntryFinder.class.getName() + ".countByG_F_S";

	public static String FIND_BY_EXTRA_SETTINGS =
		DLFileEntryFinder.class.getName() + ".findByExtraSettings";

	public static String FIND_BY_NO_ASSETS =
		DLFileEntryFinder.class.getName() + ".findByNoAssets";

	public static String FIND_BY_ORPHANED_FILE_ENTRIES =
		DLFileEntryFinder.class.getName() + ".findByOrphanedFileEntries";

	public int countByExtraSettings() throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_EXTRA_SETTINGS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countByG_F_S(long groupId, List<Long> folderIds, int status)
		throws SystemException {

		return doCountByG_F_S(groupId, folderIds, status, false);
	}

	public int filterCountByG_F_S(
			long groupId, List<Long> folderIds, int status)
		throws SystemException {

		return doCountByG_F_S(groupId, folderIds, status, true);
	}

	public List<DLFileEntry> findByExtraSettings(int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_EXTRA_SETTINGS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("DLFileEntry", DLFileEntryImpl.class);

			return (List<DLFileEntry>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<DLFileEntry> findByNoAssets() throws SystemException {
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NO_ASSETS);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("DLFileEntry", DLFileEntryImpl.class);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<DLFileEntry> findByOrphanedFileEntries()
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_ORPHANED_FILE_ENTRIES);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("DLFileEntry", DLFileEntryImpl.class);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected int doCountByG_F_S(
			long groupId, List<Long> folderIds, int status,
			boolean inlineSQLHelper)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_G_F_S);

			if (inlineSQLHelper) {
				sql = InlineSQLHelperUtil.replacePermissionCheck(
					sql, DLFileEntry.class.getName(), "DLFileEntry.fileEntryId",
					groupId);
			}

			sql = StringUtil.replace(
				sql, "[$FOLDER_ID$]", getFolderIds(folderIds));

			if (status == WorkflowConstants.STATUS_ANY) {
				sql = StringUtil.replace(
					sql, "(DLFileVersion.status = ?) AND", "");
			}

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);

			if (status != WorkflowConstants.STATUS_ANY) {
				qPos.add(status);
			}

			for (int i = 0; i < folderIds.size(); i++) {
				Long folderId = folderIds.get(i);

				qPos.add(folderId);
			}

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected String getFolderIds(List<Long> folderIds) {
		if (folderIds.isEmpty()) {
			return StringPool.BLANK;
		}

		StringBundler sb = new StringBundler(folderIds.size() * 2 - 1);

		for (int i = 0; i < folderIds.size(); i++) {
			sb.append("DLFileEntry.folderId = ? ");

			if ((i + 1) != folderIds.size()) {
				sb.append("OR ");
			}
		}

		return sb.toString();
	}

}