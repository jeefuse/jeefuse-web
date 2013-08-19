/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.rto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.security.model.GsysRelRoleResource;
import com.jeefuse.system.security.model.GsysResource;

/**
 * GsysResource Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceRTO implements GenericRTO<GsysResource>, Serializable{
	/** @generated */
	private static final long serialVersionUID = 1L;
	/**
	 * ------------------------------------------------------------------------
	 * id
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
	 * type
	 * ------------------------------------------------------------------------
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
	 * gsysRelRoleResources
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public List<GsysRelRoleResource> getGsysRelRoleResources() {
		if (this.gsysRelRoleResources == null) {
			this.gsysRelRoleResources = new ArrayList<GsysRelRoleResource>();
		}
		return gsysRelRoleResources;
	}

	/** @generated */
	public void setGsysRelRoleResources(final List<GsysRelRoleResource> gsysRelRoleResources) {
		this.gsysRelRoleResources = gsysRelRoleResources;
	}
	
	/** @generated */
	private List<GsysRelRoleResource> gsysRelRoleResources = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysResource getModifiedModel(GsysResource oldModel) {
		oldModel.setName(this.getName());//1 name
		oldModel.setDescript(this.getDescript());//2 descript
		oldModel.setValue(this.getValue());//3 value
		oldModel.setType(this.getType());//4 type
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysResource getNewModel() {
		GsysResource newGsysResource=new GsysResource();
		//newGsysResource.setId(this.getId());//id auto generated
		newGsysResource.setName(this.getName());//1 name
		newGsysResource.setDescript(this.getDescript());//2 descript
		newGsysResource.setValue(this.getValue());//3 value
		newGsysResource.setType(this.getType());//4 type
		newGsysResource.setGsysRelRoleResources(this.getGsysRelRoleResources());//5 gsysRelRoleResources
		return newGsysResource;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysResource model) {
		this.setId(model.getId());//id
		this.setName(model.getName());//1 name
		this.setDescript(model.getDescript());//2 descript
		this.setValue(model.getValue());//3 value
		this.setType(model.getType());//4 type
		this.setGsysRelRoleResources(model.getGsysRelRoleResources());//5 gsysRelRoleResources
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("name",name).append("descript",descript).append("value",value)
				.append("type",type).append("gsysRelRoleResources",gsysRelRoleResources)
				.toString();
	}


}
