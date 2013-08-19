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
import com.jeefuse.system.security.model.GsysRelUserRole;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.GsysUser;

/**
 * GsysRelUserRole Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysRelUserRoleRTO implements GenericRTO<GsysRelUserRole>, Serializable{
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
	 * gsysUser
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public GsysUser getGsysUser() {
		return gsysUser;
	}

	/** @generated */
	public void setGsysUser(final GsysUser gsysUser) {
		this.gsysUser = gsysUser;
	}
	
	/** @generated */
	private GsysUser gsysUser = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysRelUserRole getModifiedModel(GsysRelUserRole oldModel) {
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysRelUserRole getNewModel() {
		GsysRelUserRole newGsysRelUserRole=new GsysRelUserRole();
		//newGsysRelUserRole.setId(this.getId());//id auto generated
		newGsysRelUserRole.setGsysRole(this.getGsysRole());//1 gsysRole
		newGsysRelUserRole.setGsysUser(this.getGsysUser());//2 gsysUser
		return newGsysRelUserRole;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysRelUserRole model) {
		this.setId(model.getId());//id
		this.setGsysRole(model.getGsysRole());//1 gsysRole
		this.setGsysUser(model.getGsysUser());//2 gsysUser
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("gsysRole",gsysRole).append("gsysUser",gsysUser)
				.toString();
	}


}
