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

package com.liferay.portal.upgrade.v4_3_0.util;

import java.sql.Types;

/**
 * @author	  Brian Wing Shun Chan
 * @generated
 */
public class AddressTable {

	public static String TABLE_NAME = "Address";

	public static Object[][] TABLE_COLUMNS = {
		{"addressId", Types.BIGINT},
		{"companyId", Types.BIGINT},
		{"userId", Types.BIGINT},
		{"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT},
		{"classPK", Types.BIGINT},
		{"street1", Types.VARCHAR},
		{"street2", Types.VARCHAR},
		{"street3", Types.VARCHAR},
		{"city", Types.VARCHAR},
		{"zip", Types.VARCHAR},
		{"regionId", Types.BIGINT},
		{"countryId", Types.BIGINT},
		{"typeId", Types.INTEGER},
		{"mailing", Types.BOOLEAN},
		{"primary_", Types.BOOLEAN}
	};

	public static String TABLE_SQL_CREATE = "create table Address (addressId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,street1 VARCHAR(75) null,street2 VARCHAR(75) null,street3 VARCHAR(75) null,city VARCHAR(75) null,zip VARCHAR(75) null,regionId LONG,countryId LONG,typeId INTEGER,mailing BOOLEAN,primary_ BOOLEAN)";

	public static String TABLE_SQL_DROP = "drop table Address";

	public static final String[] TABLE_SQL_ADD_INDEXES = {
		"create index IX_93D5AD4E on Address (companyId)",
		"create index IX_ABD7DAC0 on Address (companyId, classNameId)",
		"create index IX_71CB1123 on Address (companyId, classNameId, classPK)",
		"create index IX_923BD178 on Address (companyId, classNameId, classPK, mailing)",
		"create index IX_9226DBB4 on Address (companyId, classNameId, classPK, primary_)",
		"create index IX_5BC8B0D4 on Address (userId)"
	};

}