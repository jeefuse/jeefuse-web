/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.security.model.GsysResource;

/**
 * GsysResource Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysResourceField implements ColumnField<GsysResource>{
	/** @generated */
	id("id", "id"),//1 id
	/** @generated */
	name("name", "name"),//2 name
	/** @generated */
	descript("descript", "descript"),//3 descript
	/** @generated */
	value("value", "value"),//4 value
	/** @generated */
	type("type", "type");//5 type

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;

	/** @generated */
	private GsysResourceField(String fieldName, String fieldLabel) {
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
		GsysResourceField columField = valueOfFieldName(paramfieldName);
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
	static public GsysResourceField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysResourceField[] gsysResourceFields = values();
		for (GsysResourceField gsysResourceField : gsysResourceFields) {
			if (gsysResourceField.getFieldName().equals(fieldName))
				return gsysResourceField;
		}
		return null;
	}



	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysResourceField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysResourceField[] gsysResourceFields = values();
		for (GsysResourceField gsysResourceField : gsysResourceFields) {
			if (gsysResourceField.getFieldLabel().equals(fieldLabel))
				return gsysResourceField;
		}
		return null;
	}

}
