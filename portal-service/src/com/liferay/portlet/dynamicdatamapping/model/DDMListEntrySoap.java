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

package com.liferay.portlet.dynamicdatamapping.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class DDMListEntrySoap implements Serializable {
	public static DDMListEntrySoap toSoapModel(DDMListEntry model) {
		DDMListEntrySoap soapModel = new DDMListEntrySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setListEntryId(model.getListEntryId());
		soapModel.setListId(model.getListId());
		soapModel.setClassPK(model.getClassPK());

		return soapModel;
	}

	public static DDMListEntrySoap[] toSoapModels(DDMListEntry[] models) {
		DDMListEntrySoap[] soapModels = new DDMListEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DDMListEntrySoap[][] toSoapModels(DDMListEntry[][] models) {
		DDMListEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DDMListEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DDMListEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DDMListEntrySoap[] toSoapModels(List<DDMListEntry> models) {
		List<DDMListEntrySoap> soapModels = new ArrayList<DDMListEntrySoap>(models.size());

		for (DDMListEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DDMListEntrySoap[soapModels.size()]);
	}

	public DDMListEntrySoap() {
	}

	public long getPrimaryKey() {
		return _listEntryId;
	}

	public void setPrimaryKey(long pk) {
		setListEntryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getListEntryId() {
		return _listEntryId;
	}

	public void setListEntryId(long listEntryId) {
		_listEntryId = listEntryId;
	}

	public long getListId() {
		return _listId;
	}

	public void setListId(long listId) {
		_listId = listId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	private String _uuid;
	private long _listEntryId;
	private long _listId;
	private long _classPK;
}