/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.security.model.GsysUser;

/**
 * GsysUser Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysUserField implements ColumnField<GsysUser>{
	/**
	 * ID.
	 * @generated
	 */
	id("id", "ID",32,false),//1 
	/**
	 * 用户名.
	 * @generated
	 */
	username("username", "用户名",20,false),//2 
	/**
	 * 创建时间.
	 * @generated
	 */
	createTime("createTime", "创建时间",19,true),//3 
	/**
	 * Email.
	 * @generated
	 */
	email("email", "Email", 50, true), //4 
	/**
	 * 级别.
	 * @generated
	 */
	level("level", "级别",1,true),//5 
	/**
	 * 更新时间.
	 * @generated
	 */
	updateTime("updateTime", "更新时间",19,true),//6 
	/**
	 * 登录名.
	 * @generated
	 */
	loginName("loginName", "登录名",20,false),/**
	 * 登录次数.
	 * @generated
	 */
	logincount("logincount", "登录次数",19,true), //7 
	/**
	 * 密码.
	 * @generated
	 */
	password("password", "密码",36,false),//9 
	/**
	 * 备注.
	 * @generated
	 */
	remark("remark", "备注",255,true),//10 
	/**
	 * 性别.
	 * @generated
	 */
	sex("sex", "性别",1,true),//11 
	/**
	 * 电话.
	 * @generated
	 */
	mobile("mobile", "电话",20,true),//12 
	/**
	 * telephone.
	 * @generated
	 */
	telephone("telephone", "telephone",60,true),//13 
	/**
	 * 有效性.
	 * @generated
	 */
	enabled("enabled", "有效性",1,true),//14 
	/**
	 * activated.
	 * @generated
	 */
	activated("activated", "activated",1,true),//15 
	/**
	 * 最后登录时间.
	 * @generated
	 */
	lastLoginTime("lastLoginTime", "最后登录时间",19,true)//16 
	, /**
	 * 头像.
	 * @generated
	 */
	portraitPhoto("portraitPhoto", "头像",120,true), /**
	 * 头像保存实际地址.
	 * @generated
	 */
	portraitPhotoSavePath("portraitPhotoSavePath", "头像保存实际地址", 120, true)
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
	private GsysUserField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
		GsysUserField gsysUserField = valueOfFieldName(paramfieldName);
		if (gsysUserField != null)
			return gsysUserField.getFieldName();
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
	static public GsysUserField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysUserField[] gsysUserFields = values();
		for (GsysUserField gsysUserField : gsysUserFields) {
			if (gsysUserField.getFieldName().equals(fieldName))
				return gsysUserField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysUserField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysUserField[] gsysUserFields = values();
		for (GsysUserField gsysUserField : gsysUserFields) {
			if (gsysUserField.getFieldLabel().equals(fieldLabel))
				return gsysUserField;
		}
		return null;
	}
}
