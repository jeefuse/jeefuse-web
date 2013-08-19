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
import com.jeefuse.system.security.model.GsysRelRoleFunction;
import com.jeefuse.system.security.model.GsysRelRoleResource;
import com.jeefuse.system.security.model.GsysRelUserRole;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRole Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysRoleRTO implements GenericRTO<GsysRole>, Serializable{
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
	 * displayName
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getDisplayName() {
		return displayName;
	}

	/** @generated */
	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}
	
	/** @generated */
	private String displayName = null;

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
	 * gsysRelRoleFunctions
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public List<GsysRelRoleFunction> getGsysRelRoleFunctions() {
		if (this.gsysRelRoleFunctions == null) {
			this.gsysRelRoleFunctions = new ArrayList<GsysRelRoleFunction>();
		}
		return gsysRelRoleFunctions;
	}

	/** @generated */
	public void setGsysRelRoleFunctions(final List<GsysRelRoleFunction> gsysRelRoleFunctions) {
		this.gsysRelRoleFunctions = gsysRelRoleFunctions;
	}
	
	/** @generated */
	private List<GsysRelRoleFunction> gsysRelRoleFunctions = null;

	/**
	 * 勾选的关联系统功能Ids.
	 */
	private String relGsysFunctionCheckIds;

	public String getRelGsysFunctionCheckIds() {
		return relGsysFunctionCheckIds;
	}

	public void setRelGsysFunctionCheckIds(String relGsysFunctionCheckIds) {
		this.relGsysFunctionCheckIds = relGsysFunctionCheckIds;
	}

	/**
	 * ------------------------------------------------------------------------
	 * gsysRelRoleResources
	 * ------------------------------------------------------------------------
	 * 
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


	/**
	 * 勾选的关联系统功能Ids.
	 */
	private String relGsysResourceCheckIds;

	/**
	 * @return the relGsysResourceCheckIds
	 */
	public String getRelGsysResourceCheckIds() {
		return relGsysResourceCheckIds;
	}

	/**
	 * @param relGsysResourceCheckIds
	 *            the relGsysResourceCheckIds to set
	 */
	public void setRelGsysResourceCheckIds(String relGsysResourceCheckIds) {
		this.relGsysResourceCheckIds = relGsysResourceCheckIds;
	}

	/**
	 * ------------------------------------------------------------------------
	 * gsysRelUserRoles
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	public List<GsysRelUserRole> getGsysRelUserRoles() {
		if (this.gsysRelUserRoles == null) {
			this.gsysRelUserRoles = new ArrayList<GsysRelUserRole>();
		}
		return gsysRelUserRoles;
	}

	/** @generated */
	public void setGsysRelUserRoles(final List<GsysRelUserRole> gsysRelUserRoles) {
		this.gsysRelUserRoles = gsysRelUserRoles;
	}
	
	/** @generated */
	private List<GsysRelUserRole> gsysRelUserRoles = null;


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------

	/*
	 * 从请求中构造要更新的实体对象.传入要更新的对象.
	 * 
	 * @generated
	 */
	public GsysRole getModifiedModel(GsysRole oldModel) {
		oldModel.setName(this.getName());//1 name
		oldModel.setDisplayName(this.getDisplayName());//2 displayName
		oldModel.setDescript(this.getDescript());//3 descript
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysRole getNewModel() {
		GsysRole newGsysRole=new GsysRole();
		//newGsysRole.setId(this.getId());//id auto generated
		newGsysRole.setName(this.getName());//1 name
		newGsysRole.setDisplayName(this.getDisplayName());//2 displayName
		newGsysRole.setDescript(this.getDescript());//3 descript
		newGsysRole.setGsysRelRoleFunctions(this.getGsysRelRoleFunctions());//4 gsysRelRoleFunctions
		newGsysRole.setGsysRelRoleResources(this.getGsysRelRoleResources());//5 gsysRelRoleResources
		newGsysRole.setGsysRelUserRoles(this.getGsysRelUserRoles());//6 gsysRelUserRoles
		return newGsysRole;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysRole model) {
		this.setId(model.getId());//id
		this.setName(model.getName());//1 name
		this.setDisplayName(model.getDisplayName());//2 displayName
		this.setDescript(model.getDescript());//3 descript
		this.setGsysRelRoleFunctions(model.getGsysRelRoleFunctions());//4 gsysRelRoleFunctions
		this.setGsysRelRoleResources(model.getGsysRelRoleResources());//5 gsysRelRoleResources
		this.setGsysRelUserRoles(model.getGsysRelUserRoles());//6 gsysRelUserRoles
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("name",name).append("displayName",displayName).append("descript",descript)
				.append("gsysRelRoleFunctions",gsysRelRoleFunctions).append("gsysRelRoleResources",gsysRelRoleResources).append("gsysRelUserRoles",gsysRelUserRoles)
				.toString();
	}


}
