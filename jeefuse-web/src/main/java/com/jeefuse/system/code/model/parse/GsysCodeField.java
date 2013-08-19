/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.code.model.GsysCode;

/**
 * GsysCode Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysCodeField implements ColumnField<GsysCode>{
	/**
	 * cid.
	 * @generated
	 */
	cid("cid", "cid",32,false),//1 cid
	/**
	 * name.
	 * @generated
	 */
	name("name", "name",100,true),//2 name
	/**
	 * ˵.
	 * @generated
	 */
	descript("descript", "˵",200,true),//3 ˵
	/**
	 * kind.
	 * @generated
	 */
	kind("kind", "kind",1,true);//4 kind

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;
	/** @generated */
	private int length;
	/** @generated */
	private boolean nullable;
	
	/** @generated */
	private GsysCodeField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
		GsysCodeField columField = valueOfFieldName(paramfieldName);
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
	static public GsysCodeField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysCodeField[] gsysCodeFields = values();
		for (GsysCodeField gsysCodeField : gsysCodeFields) {
			if (gsysCodeField.getFieldName().equals(fieldName))
				return gsysCodeField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysCodeField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysCodeField[] gsysCodeFields = values();
		for (GsysCodeField gsysCodeField : gsysCodeFields) {
			if (gsysCodeField.getFieldLabel().equals(fieldLabel))
				return gsysCodeField;
		}
		return null;
	}
}
