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

package com.liferay.portlet.documentlibrary.model;

/**
 * <p>
 * This class is a wrapper for {@link DLFileEntryMetadata}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       DLFileEntryMetadata
 * @generated
 */
public class DLFileEntryMetadataWrapper implements DLFileEntryMetadata {
	public DLFileEntryMetadataWrapper(DLFileEntryMetadata dlFileEntryMetadata) {
		_dlFileEntryMetadata = dlFileEntryMetadata;
	}

	public Class<?> getModelClass() {
		return DLFileEntryMetadata.class;
	}

	public String getModelClassName() {
		return DLFileEntryMetadata.class.getName();
	}

	/**
	* Returns the primary key of this d l file entry metadata.
	*
	* @return the primary key of this d l file entry metadata
	*/
	public long getPrimaryKey() {
		return _dlFileEntryMetadata.getPrimaryKey();
	}

	/**
	* Sets the primary key of this d l file entry metadata.
	*
	* @param primaryKey the primary key of this d l file entry metadata
	*/
	public void setPrimaryKey(long primaryKey) {
		_dlFileEntryMetadata.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this d l file entry metadata.
	*
	* @return the uuid of this d l file entry metadata
	*/
	public java.lang.String getUuid() {
		return _dlFileEntryMetadata.getUuid();
	}

	/**
	* Sets the uuid of this d l file entry metadata.
	*
	* @param uuid the uuid of this d l file entry metadata
	*/
	public void setUuid(java.lang.String uuid) {
		_dlFileEntryMetadata.setUuid(uuid);
	}

	/**
	* Returns the file entry metadata ID of this d l file entry metadata.
	*
	* @return the file entry metadata ID of this d l file entry metadata
	*/
	public long getFileEntryMetadataId() {
		return _dlFileEntryMetadata.getFileEntryMetadataId();
	}

	/**
	* Sets the file entry metadata ID of this d l file entry metadata.
	*
	* @param fileEntryMetadataId the file entry metadata ID of this d l file entry metadata
	*/
	public void setFileEntryMetadataId(long fileEntryMetadataId) {
		_dlFileEntryMetadata.setFileEntryMetadataId(fileEntryMetadataId);
	}

	/**
	* Returns the fully qualified class name of this d l file entry metadata.
	*
	* @return the fully qualified class name of this d l file entry metadata
	*/
	public java.lang.String getClassName() {
		return _dlFileEntryMetadata.getClassName();
	}

	/**
	* Returns the class name ID of this d l file entry metadata.
	*
	* @return the class name ID of this d l file entry metadata
	*/
	public long getClassNameId() {
		return _dlFileEntryMetadata.getClassNameId();
	}

	/**
	* Sets the class name ID of this d l file entry metadata.
	*
	* @param classNameId the class name ID of this d l file entry metadata
	*/
	public void setClassNameId(long classNameId) {
		_dlFileEntryMetadata.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this d l file entry metadata.
	*
	* @return the class p k of this d l file entry metadata
	*/
	public long getClassPK() {
		return _dlFileEntryMetadata.getClassPK();
	}

	/**
	* Sets the class p k of this d l file entry metadata.
	*
	* @param classPK the class p k of this d l file entry metadata
	*/
	public void setClassPK(long classPK) {
		_dlFileEntryMetadata.setClassPK(classPK);
	}

	/**
	* Returns the d d m structure ID of this d l file entry metadata.
	*
	* @return the d d m structure ID of this d l file entry metadata
	*/
	public long getDDMStructureId() {
		return _dlFileEntryMetadata.getDDMStructureId();
	}

	/**
	* Sets the d d m structure ID of this d l file entry metadata.
	*
	* @param DDMStructureId the d d m structure ID of this d l file entry metadata
	*/
	public void setDDMStructureId(long DDMStructureId) {
		_dlFileEntryMetadata.setDDMStructureId(DDMStructureId);
	}

	/**
	* Returns the file entry type ID of this d l file entry metadata.
	*
	* @return the file entry type ID of this d l file entry metadata
	*/
	public long getFileEntryTypeId() {
		return _dlFileEntryMetadata.getFileEntryTypeId();
	}

	/**
	* Sets the file entry type ID of this d l file entry metadata.
	*
	* @param fileEntryTypeId the file entry type ID of this d l file entry metadata
	*/
	public void setFileEntryTypeId(long fileEntryTypeId) {
		_dlFileEntryMetadata.setFileEntryTypeId(fileEntryTypeId);
	}

	/**
	* Returns the file entry ID of this d l file entry metadata.
	*
	* @return the file entry ID of this d l file entry metadata
	*/
	public long getFileEntryId() {
		return _dlFileEntryMetadata.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this d l file entry metadata.
	*
	* @param fileEntryId the file entry ID of this d l file entry metadata
	*/
	public void setFileEntryId(long fileEntryId) {
		_dlFileEntryMetadata.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the file version ID of this d l file entry metadata.
	*
	* @return the file version ID of this d l file entry metadata
	*/
	public long getFileVersionId() {
		return _dlFileEntryMetadata.getFileVersionId();
	}

	/**
	* Sets the file version ID of this d l file entry metadata.
	*
	* @param fileVersionId the file version ID of this d l file entry metadata
	*/
	public void setFileVersionId(long fileVersionId) {
		_dlFileEntryMetadata.setFileVersionId(fileVersionId);
	}

	public boolean isNew() {
		return _dlFileEntryMetadata.isNew();
	}

	public void setNew(boolean n) {
		_dlFileEntryMetadata.setNew(n);
	}

	public boolean isCachedModel() {
		return _dlFileEntryMetadata.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_dlFileEntryMetadata.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _dlFileEntryMetadata.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_dlFileEntryMetadata.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _dlFileEntryMetadata.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dlFileEntryMetadata.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dlFileEntryMetadata.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dlFileEntryMetadata.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DLFileEntryMetadataWrapper((DLFileEntryMetadata)_dlFileEntryMetadata.clone());
	}

	public int compareTo(
		com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata dlFileEntryMetadata) {
		return _dlFileEntryMetadata.compareTo(dlFileEntryMetadata);
	}

	@Override
	public int hashCode() {
		return _dlFileEntryMetadata.hashCode();
	}

	public com.liferay.portlet.documentlibrary.model.DLFileEntryMetadata toEscapedModel() {
		return new DLFileEntryMetadataWrapper(_dlFileEntryMetadata.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dlFileEntryMetadata.toString();
	}

	public java.lang.String toXmlString() {
		return _dlFileEntryMetadata.toXmlString();
	}

	public com.liferay.portlet.dynamicdatamapping.model.DDMStructure getDDMStructure()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileEntryMetadata.getDDMStructure();
	}

	public com.liferay.portlet.documentlibrary.model.DLFileEntryType getFileEntryType()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileEntryMetadata.getFileEntryType();
	}

	public com.liferay.portlet.documentlibrary.model.DLFileVersion getFileVersion()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _dlFileEntryMetadata.getFileVersion();
	}

	public DLFileEntryMetadata getWrappedDLFileEntryMetadata() {
		return _dlFileEntryMetadata;
	}

	public void resetOriginalValues() {
		_dlFileEntryMetadata.resetOriginalValues();
	}

	private DLFileEntryMetadata _dlFileEntryMetadata;
}