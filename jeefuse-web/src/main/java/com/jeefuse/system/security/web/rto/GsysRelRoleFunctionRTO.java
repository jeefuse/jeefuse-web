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
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.GsysRelRoleFunction;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRelRoleFunction Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysRelRoleFunctionRTO implements GenericRTO<GsysRelRoleFunction>, Serializable{
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
	 * gsysFunction
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public GsysFunction getGsysFunction() {
		return gsysFunction;
	}

	/** @generated */
	public void setGsysFunction(final GsysFunction gsysFunction) {
		this.gsysFunction = gsysFunction;
	}
	
	/** @generated */
	private GsysFunction gsysFunction = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysRelRoleFunction getModifiedModel(GsysRelRoleFunction oldModel) {
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysRelRoleFunction getNewModel() {
		GsysRelRoleFunction newGsysRelRoleFunction=new GsysRelRoleFunction();
		//newGsysRelRoleFunction.setId(this.getId());//id auto generated
		newGsysRelRoleFunction.setGsysRole(this.getGsysRole());//1 gsysRole
		newGsysRelRoleFunction.setGsysFunction(this.getGsysFunction());//2 gsysFunction
		return newGsysRelRoleFunction;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysRelRoleFunction model) {
		this.setId(model.getId());//id
		this.setGsysRole(model.getGsysRole());//1 gsysRole
		this.setGsysFunction(model.getGsysFunction());//2 gsysFunction
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("gsysRole",gsysRole).append("gsysFunction",gsysFunction)
				.toString();
	}


}
