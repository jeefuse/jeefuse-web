/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.log.model.GsysOperatelog;

/**
 * 操作日志 Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysOperatelogField implements ColumnField<GsysOperatelog>{
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
	 * 创建时间.
	 * @generated
	 */
	createdate("createdate", "创建时间",10,true),//3 
	/**
	 * 信息.
	 * @generated
	 */
	message("message", "信息",255,true),//4 
	/**
	 * 操作用户.
	 * @generated
	 */
	userId("userId", "操作用户",32,true),//5 
	/**
	 * 类型.
	 * @generated
	 */
	kind("kind", "类型",10,true),//6 
	/**
	 * 详细说明.
	 * @generated
	 */
	detail("detail", "详细说明",2147483647,true)//7 
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
	private GsysOperatelogField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
		GsysOperatelogField gsysOperatelogField = valueOfFieldName(paramfieldName);
		if (gsysOperatelogField != null)
			return gsysOperatelogField.getFieldName();
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
	static public GsysOperatelogField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysOperatelogField[] gsysOperatelogFields = values();
		for (GsysOperatelogField gsysOperatelogField : gsysOperatelogFields) {
			if (gsysOperatelogField.getFieldName().equals(fieldName))
				return gsysOperatelogField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysOperatelogField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysOperatelogField[] gsysOperatelogFields = values();
		for (GsysOperatelogField gsysOperatelogField : gsysOperatelogFields) {
			if (gsysOperatelogField.getFieldLabel().equals(fieldLabel))
				return gsysOperatelogField;
		}
		return null;
	}
}
