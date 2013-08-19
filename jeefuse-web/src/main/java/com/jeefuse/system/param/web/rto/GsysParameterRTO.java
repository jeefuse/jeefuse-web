/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.rto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.param.model.GsysParameter;

/**
 * GsysParameter Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysParameterRTO implements GenericRTO<GsysParameter>, Serializable{
	/** @generated */
	private static final long serialVersionUID = 1L;
	/**
	 * ------------------------------------------------------------------------
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getId() {
		return name;
	}
	
	/** @generated */
	public void setId(final String id) {
		this.name = id;
	}
	
		/**@generated */
	private String name = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * ------------------------------------------------------------------------
	 * value
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/** @generated */
	public void setValue(final String value) {
		this.value = value;
	}
	
	
	/** @generated */
	private String value = null;

	/**
	 * ------------------------------------------------------------------------
	 * descript
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getDescript() {
		return descript;
	}

	/** @generated */
	public void setDescript(final String descript) {
		this.descript = descript;
	}
	
	
	/** @generated */
	private String descript = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysParameter getModifiedModel(GsysParameter oldModel) {	
		oldModel.setId(this.name);//name 1
		oldModel.setValue(this.value);//2 参数值
		oldModel.setDescript(this.descript);//3 用途说明	
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysParameter getNewModel() {
		GsysParameter newGsysParameter=new GsysParameter();	
		newGsysParameter.setId(this.name);//id 1
		newGsysParameter.setValue(this.value);//2 参数值
		newGsysParameter.setDescript(this.descript);//3 用途说明
		return newGsysParameter;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysParameter model) {
		this.setId(model.getName());//id 1
		this.setValue(model.getValue());//2 参数值
		this.setDescript(model.getDescript());//3 用途说明
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("value",value).append("descript",descript)
				.toString();
	}



}
