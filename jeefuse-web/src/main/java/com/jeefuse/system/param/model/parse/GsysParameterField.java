/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.model.parse;

import com.jeefuse.base.model.parse.ColumnField;
import com.jeefuse.system.param.model.GsysParameter;

/**
 * GsysParameter Entity Field constants.
 *
 * @author yonclv
 * @generated
 */
public enum GsysParameterField implements ColumnField<GsysParameter>{
	/**
	 * name.
	 * @generated
	 */
	name("name", "name",10,false),//1 name
	/**
	 * value.
	 * @generated
	 */
	value("value", "value",50,true),//2 value
	/**
	 * descript.
	 * @generated
	 */
	descript("descript", "descript",150,true);//3 descript

	/** @generated */
	private String fieldName;
	/** @generated */
	private String fieldLabel;
	/** @generated */
	private int length;
	/** @generated */
	private boolean nullable;
	
	/** @generated */
	private GsysParameterField(String fieldName, String fieldLabel, int length, boolean nullable) {
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
		GsysParameterField gsysParameterField = valueOfFieldName(paramfieldName);
		if (gsysParameterField != null)
			return gsysParameterField.getFieldName();
		return null;
	}

	/**
	 * 根据fieldName查找对象,若没有找到则返回null.
	 * 
	 * @param fieldName
	 * @generated
	 */
	static public GsysParameterField valueOfFieldName(String fieldName) {
		if (null == fieldName)
			return null;
		GsysParameterField[] gsysParameterFields = values();
		for (GsysParameterField gsysParameterField : gsysParameterFields) {
			if (gsysParameterField.getFieldName().equals(fieldName))
				return gsysParameterField;
		}
		return null;
	}

	/**
	 * 根据fieldLabel查找对象,若没有找到则返回null.
	 * 
	 * @param fieldComment
	 * @generated
	 */
	static public GsysParameterField valueOfFieldLabel(String fieldLabel) {
		if (null == fieldLabel)
			return null;
		GsysParameterField[] gsysParameterFields = values();
		for (GsysParameterField gsysParameterField : gsysParameterFields) {
			if (gsysParameterField.getFieldLabel().equals(fieldLabel))
				return gsysParameterField;
		}
		return null;
	}
}
