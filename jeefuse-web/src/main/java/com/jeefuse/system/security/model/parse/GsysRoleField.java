/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRole Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysRoleField implements ColumnField<GsysRole>{
	/** @generated */
	id("id", "id"),//1 id
	/** @generated */
	name("name", "name"),//2 name
	/** @generated */
	displayName("displayName", "displayName"),//3 displayName
	/** @generated */
	descript("descript", "descript");//4 descript

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;

	/** @generated */
	private GsysRoleField(String fieldName, String fieldLabel) {
		this.fieldName = fieldName;
		this.fieldLabel = fieldLabel;
	}
	
	/** @generated */
	public String getFieldName() {
		return fieldName;
	}

	/** @generated */
	public String getFieldLabel() {
		return fieldLabel;
	}
	

	/** @generated */
	public int getLength() {
		return 0;
	}

	/** @generated */
	public boolean isNullable() {
		return true;
	}

	/** @generated */
	public String getFieldLabelByName(String paramfieldName) {
		GsysRoleField columField = valueOfFieldName(paramfieldName);
		if (columField != null)
			return columField.getFieldName();
		return null;
	}

	/**
	 * 根据fieldName查找对象,若没有找到则返回null.
	 * 
	 * @param fieldName
	 * @generated
	 */
	static public GsysRoleField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysRoleField[] gsysRoleFields = values();
		for (GsysRoleField gsysRoleField : gsysRoleFields) {
			if (gsysRoleField.getFieldName().equals(fieldName))
				return gsysRoleField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysRoleField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysRoleField[] gsysRoleFields = values();
		for (GsysRoleField gsysRoleField : gsysRoleFields) {
			if (gsysRoleField.getFieldLabel().equals(fieldLabel))
				return gsysRoleField;
		}
		return null;
	}
}
