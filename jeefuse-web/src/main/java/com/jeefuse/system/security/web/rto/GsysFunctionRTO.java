/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.rto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.commons.lang.xwork.StringUtils;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * GsysFunction Entity RTO(Request transfer object).
 * 
 * @author yonclv
 * @generated
 */
public class GsysFunctionRTO implements GenericRTO<GsysFunction>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/**
	 * ------------------------------------------------------------------------
	 * ID ----------------------------------------------------------------------
	 * --
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/** @generated */
	public void setId(final String id) {
		this.id = id;
	}

	/** @generated */
	private String id = null;

	/**
	 * ------------------------------------------------------------------------
	 * 权限标志
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
	 * 权限标志
	 * ------------------------------------------------------------------------
	 * 
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
	 * 描述 ----------------------------------------------------------------------
	 * --
	 * 
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
	 * 权限类型
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/** @generated */
	public void setType(final String type) {
		this.type = type;
	}

	/** @generated */
	private String type = null;

	/**
	 * ------------------------------------------------------------------------
	 * url
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/** @generated */
	public void setUrl(final String url) {
		this.url = url;
	}

	/** @generated */
	private String url = null;

	/**
	 * ------------------------------------------------------------------------
	 * 上级ID
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public String getParentId() {
		return parentId;
	}

	/** @generated */
	public void setParentId(final String parentId) {
		this.parentId = parentId;
	}

	/** @generated */
	private String parentId = null;

	/**
	 * ------------------------------------------------------------------------
	 * validStatus
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public String getValidStatus() {
		return validStatus;
	}

	/** @generated */
	public void setValidStatus(final String validStatus) {
		this.validStatus = validStatus;
	}

	/** @generated */
	private String validStatus = null;

	/**
	 * ------------------------------------------------------------------------
	 * 排序 ----------------------------------------------------------------------
	 * --
	 * 
	 * @generated
	 */
	public Long getSortNum() {
		return sortNum;
	}

	/** @generated */
	public void setSortNum(final Long sortNum) {
		this.sortNum = sortNum;
	}

	/** @generated */
	private Long sortNum = null;

	/**
	 * ------------------------------------------------------------------------
	 * layerCode
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public String getLayerCode() {
		return layerCode;
	}

	/** @generated */
	public void setLayerCode(final String layerCode) {
		this.layerCode = layerCode;
	}

	/** @generated */
	private String layerCode = null;

	// ------------------------------------------------------------------------
	// RTO <==> model convert
	// ------------------------------------------------------------------------

	/**
	 * 从请求中构造要更新的实体对象.
	 * 
	 * @generated
	 */
	public GsysFunction getModifiedModel(GsysFunction oldModel) {	
		oldModel.setValue(this.value);//1 权限标志
		oldModel.setName(this.name);//2 权限名称
		oldModel.setDescript(this.descript);//3 描述
		oldModel.setType(this.type);//4 权限类型
		oldModel.setUrl(this.url);//5 url
		// oldModel.setParentId(this.parentId);//6 上级ID
		oldModel.setValidStatus(this.validStatus);//7 是否有效
		oldModel.setSortNum(this.sortNum);//8 排序
		//oldModel.setLayerCode(this.layerCode);//9 层次编码	
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * 
	 * @generated
	 */
	public GsysFunction getNewModel() {
		GsysFunction newGsysFunction=new GsysFunction();	
		newGsysFunction.setValue(this.value);//1 权限标志
		newGsysFunction.setName(this.name);//2 权限名称
		newGsysFunction.setDescript(this.descript);//3 描述
		newGsysFunction.setType(this.type);//4 权限类型
		newGsysFunction.setUrl(this.url);//5 url
		if (StringUtils.isNotBlank(this.parentId)) {
			newGsysFunction.setParentId(this.parentId);//6 上级ID
		} else {
			//			newGsysFunction.setParentId(null);//6 上级ID
		}
		newGsysFunction.setValidStatus(this.validStatus);//7 是否有效
		newGsysFunction.setSortNum(this.sortNum);//8 排序
		//newGsysFunction.setLayerCode(this.layerCode);//9 层次编码
		return newGsysFunction;
	}

	/**
	 * 用实体对象填充数据.
	 * 
	 * @generated
	 */
	public void setModel(GsysFunction model) {
		this.setId(model.getId());//id 1
		this.setValue(model.getValue());//2 权限标志
		this.setName(model.getName());//3 权限名称
		this.setDescript(model.getDescript());//4 描述
		this.setType(model.getType());//5 权限类型
		this.setUrl(model.getUrl());//6 url
		this.setParentId(model.getParentId());//7 上级ID
		this.setValidStatus(model.getValidStatus());//8 是否有效
		this.setSortNum(model.getSortNum());//9 排序
		this.setLayerCode(model.getLayerCode());//10 层次编码
	}

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("value",value).append("name",name).append("descript",descript)
				.append("type",type).append("url",url)/*.append("parentId",getParentId())*/.append("validStatus",validStatus)
				.append("sortNum",sortNum).append("layerCode",layerCode)
				.toString();
	}

}
