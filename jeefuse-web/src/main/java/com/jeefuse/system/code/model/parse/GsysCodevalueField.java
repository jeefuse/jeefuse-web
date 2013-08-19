/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.code.model.GsysCodevalue;

/**
 * GsysCodevalue Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysCodevalueField implements ColumnField<GsysCodevalue>{
	/**
	 * ID.
	 * @generated
	 */
	id("id", "ID",32,false),//1 ID
	/**
	 * name.
	 * @generated
	 */
	name("name", "name",20,true),//2 name
	/**
	 * value.
	 * @generated
	 */
	value("value", "value",50,true),//3 value
	/**
	 * ˵.
	 * @generated
	 */
	descript("descript", "˵",100,true);//4 ˵

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;
	/** @generated */
	private int length;
	/** @generated */
	private boolean nullable;
	
	/** @generated */
	private GsysCodevalueField(String fieldName, String fieldLabel, int length, boolean nullable) {
		this.fieldName = fieldName;
		this.fieldLabel = fieldLabel;
		this.length = length;
		this.nullable = nullable;
	}
	
	/** @generated */
	public String getFieldName() {
		return fieldName;
	}

	/** @generated */
	public String getFieldLabel() {
		return fieldLabel;
	}
	
	/**
	 * 字段长度.不限为零.
	 * 
	 * @generated
	 */
	public int getLength() {
		return length;
	}

	/** @generated */
	public boolean isNullable() {
		return nullable;
	}

	/** @generated */
	public String getFieldLabelByName(String paramfieldName) {
		GsysCodevalueField columField = valueOfFieldName(paramfieldName);
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
	static public GsysCodevalueField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysCodevalueField[] gsysCodevalueFields = values();
		for (GsysCodevalueField gsysCodevalueField : gsysCodevalueFields) {
			if (gsysCodevalueField.getFieldName().equals(fieldName))
				return gsysCodevalueField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysCodevalueField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysCodevalueField[] gsysCodevalueFields = values();
		for (GsysCodevalueField gsysCodevalueField : gsysCodevalueFields) {
			if (gsysCodevalueField.getFieldLabel().equals(fieldLabel))
				return gsysCodevalueField;
		}
		return null;
	}
}
