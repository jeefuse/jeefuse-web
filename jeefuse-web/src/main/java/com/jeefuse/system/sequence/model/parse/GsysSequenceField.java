/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.sequence.model.GsysSequence;

/**
 * 序例 Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysSequenceField implements ColumnField<GsysSequence>{
	/**
	 * 序列名.
	 * @generated
	 */
	name("name", "序列名",20,false),//1 
	/**
	 * 序号.
	 * @generated
	 */
	nextId("nextId", "序号",19,false)//2 
	;

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;
	/** @generated */
	private int length;
	/** @generated */
	private boolean nullable;
	
	/** @generated */
	private GsysSequenceField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
	
	/** @generated */
	public String getFieldLabelByName(String paramfieldName) {
		GsysSequenceField gsysSequenceField = valueOfFieldName(paramfieldName);
		if (gsysSequenceField != null)
			return gsysSequenceField.getFieldName();
		return null;
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

	/**
	 * 根据fieldName查找对象,若没有找到则返回null.
	 * 
	 * @param fieldName
	 * @generated
	 */
	static public GsysSequenceField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysSequenceField[] gsysSequenceFields = values();
		for (GsysSequenceField gsysSequenceField : gsysSequenceFields) {
			if (gsysSequenceField.getFieldName().equals(fieldName))
				return gsysSequenceField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysSequenceField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysSequenceField[] gsysSequenceFields = values();
		for (GsysSequenceField gsysSequenceField : gsysSequenceFields) {
			if (gsysSequenceField.getFieldLabel().equals(fieldLabel))
				return gsysSequenceField;
		}
		return null;
	}
}
