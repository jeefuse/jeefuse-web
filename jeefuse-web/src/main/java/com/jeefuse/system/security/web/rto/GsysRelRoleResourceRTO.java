/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.rto;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.security.model.GsysRelRoleResource;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRelRoleResource Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysRelRoleResourceRTO implements GenericRTO<GsysRelRoleResource>, Serializable{
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
	 * gsysRole
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public GsysRole getGsysRole() {
		return gsysRole;
	}

	/** @generated */
	public void setGsysRole(final GsysRole gsysRole) {
		this.gsysRole = gsysRole;
	}
	
	/** @generated */
	private GsysRole gsysRole = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysResource
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public GsysResource getGsysResource() {
		return gsysResource;
	}

	/** @generated */
	public void setGsysResource(final GsysResource gsysResource) {
		this.gsysResource = gsysResource;
	}
	
	/** @generated */
	private GsysResource gsysResource = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysRelRoleResource getModifiedModel(GsysRelRoleResource oldModel) {
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysRelRoleResource getNewModel() {
		GsysRelRoleResource newGsysRelRoleResource=new GsysRelRoleResource();
		//newGsysRelRoleResource.setId(this.getId());//id auto generated
		newGsysRelRoleResource.setGsysRole(this.getGsysRole());//1 gsysRole
		newGsysRelRoleResource.setGsysResource(this.getGsysResource());//2 gsysResource
		return newGsysRelRoleResource;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysRelRoleResource model) {
		this.setId(model.getId());//id
		this.setGsysRole(model.getGsysRole());//1 gsysRole
		this.setGsysResource(model.getGsysResource());//2 gsysResource
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("gsysRole",gsysRole).append("gsysResource",gsysResource)
				.toString();
	}


}
