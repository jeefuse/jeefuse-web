/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.rto;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;

/**
 * GsysCodevalue Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueRTO implements GenericRTO<GsysCodevalue>, Serializable{
	/** @generated */
	private static final long serialVersionUID = 1L;
	/**
	 * ------------------------------------------------------------------------
	 * ID
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getId() {
		return id;
	}
	
	/** @generated */
	public void setId(final String id) {
		this.id = id;
	}
	
		/**@generated */
	private String id = null;
	

	/**
	 * ------------------------------------------------------------------------
	 * name
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/** @generated */
	public void setName(final String name) {
		this.name = name;
	}
	
	/** @generated */
	private String name = null;	

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
	 * ˵
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

	/**
	 * ------------------------------------------------------------------------
	 * gsysCode
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public GsysCode getGsysCode() {
		if (null == gsysCode) {
			gsysCode = new GsysCode();
		}
		return gsysCode;
	}

	/** @generated */
	public void setGsysCode(final GsysCode gsysCode) {
		this.gsysCode = gsysCode;
	}
	
	/** @generated */
	private GsysCode gsysCode = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysCodevalue getModifiedModel(GsysCodevalue oldModel) {
		oldModel.setName(this.getName());//1 name
		oldModel.setValue(this.getValue());//2 value
		oldModel.setDescript(this.getDescript());//3 ˵
		if (StringUtils.isNotBlank(this.getGsysCode().getCid())) {
			oldModel.setGsysCode(this.getGsysCode());
		}
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysCodevalue getNewModel() {
		GsysCodevalue newGsysCodevalue=new GsysCodevalue();
		//newGsysCodevalue.setId(this.getId());//id auto generated
		newGsysCodevalue.setName(this.getName());//1 name
		newGsysCodevalue.setValue(this.getValue());//2 value
		newGsysCodevalue.setDescript(this.getDescript());//3 ˵
		if (StringUtils.isNotBlank(this.getGsysCode().getCid())) {
			newGsysCodevalue.setGsysCode(this.getGsysCode());// 4 gsysCode
		}
		return newGsysCodevalue;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysCodevalue model) {
		this.setId(model.getId());//id
		this.setName(model.getName());//1 name
		this.setValue(model.getValue());//2 value
		this.setDescript(model.getDescript());//3 ˵
		this.setGsysCode(model.getGsysCode());//4 gsysCode
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("name",name).append("value",value).append("descript",descript)
				//.append("gsysCode",gsysCode)
				.toString();
	}


}
