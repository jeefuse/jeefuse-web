/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * GsysFunction Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysFunctionField implements ColumnField<GsysFunction>{
	/** @generated */
	id("id", "ID", 10, false), /**
	 * 权限标志.
	 * @generated
	 */
	value("value", "权限标志",100,false), // 1 ID
	/** @generated */
	name("name", "权限标志", 10, false), // 3 权限名称
	/** @generated */
	descript("descript", "描述", 10, false), // 4 描述
	/** @generated */
	type("type", "权限类型", 10, false), // 5 权限类型
	/** @generated */
	url("url", "url", 10, false), // 6 url
	/** @generated */
	parentId("parentId", "上级ID", 10, false), // 7 上级ID
	/** @generated */
	validStatus("validStatus", "是否有效", 10, false), // 8 validStatus
	/** @generated */
	sortNum("sortNum", "排序", 10, false), // 9 排序
	/** @generated */
	layerCode("layerCode", "层次编码", 10, false);// 10 layerCode

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;
	/** @generated */
	private int length;
	/** @generated */
	private boolean nullable;

	/**
	 * GsysFunction 字段属性.
	 * 
	 * @param fieldName
	 *            字段名
	 * @param fieldLabel
	 *            字段标签
	 * @param length
	 *            字断长度
	 * @param nullable
	 *            是否可为空
	 * @generated
	 */
	private GsysFunctionField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
		GsysFunctionField gsysFunctionField = valueOfFieldName(paramfieldName);
		if (gsysFunctionField != null)
			return gsysFunctionField.getFieldName();
		return null;
	}

	/**
	 * 根据fieldName查找对象,若没有找到则返回null.
	 * 
	 * @param fieldName
	 * @generated
	 */
	static public GsysFunctionField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysFunctionField[] gsysFunctionFields = values();
		for (GsysFunctionField gsysFunctionField : gsysFunctionFields) {
			if (gsysFunctionField.getFieldName().equals(fieldName))
				return gsysFunctionField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysFunctionField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysFunctionField[] gsysFunctionFields = values();
		for (GsysFunctionField gsysFunctionField : gsysFunctionFields) {
			if (gsysFunctionField.getFieldLabel().equals(fieldLabel))
				return gsysFunctionField;
		}
		return null;
	}

}
