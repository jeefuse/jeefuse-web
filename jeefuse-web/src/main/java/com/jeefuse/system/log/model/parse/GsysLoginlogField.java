/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.log.model.GsysLoginlog;

/**
 * 登入日志 Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysLoginlogField implements ColumnField<GsysLoginlog>{
	/**
	 * id.
	 * @generated
	 */
	id("id", "id",32,false),//1 
	/**
	 * 登录IP.
	 * @generated
	 */
	loginIp("loginIp", "登录IP",32,true),//2 
	/**
	 * 登录时间.
	 * @generated
	 */
	createdate("createdate", "登录时间",10,true),//3 
	/**
	 * 信息.
	 * @generated
	 */
	message("message", "信息",254,true),//4 
	/**
	 * 登入用户.
	 * @generated
	 */
	userId("userId", "登入用户",32,true)//5 
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
	private GsysLoginlogField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
		GsysLoginlogField gsysLoginlogField = valueOfFieldName(paramfieldName);
		if (gsysLoginlogField != null)
			return gsysLoginlogField.getFieldName();
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
	static public GsysLoginlogField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysLoginlogField[] gsysLoginlogFields = values();
		for (GsysLoginlogField gsysLoginlogField : gsysLoginlogFields) {
			if (gsysLoginlogField.getFieldName().equals(fieldName))
				return gsysLoginlogField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysLoginlogField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysLoginlogField[] gsysLoginlogFields = values();
		for (GsysLoginlogField gsysLoginlogField : gsysLoginlogFields) {
			if (gsysLoginlogField.getFieldLabel().equals(fieldLabel))
				return gsysLoginlogField;
		}
		return null;
	}
}
