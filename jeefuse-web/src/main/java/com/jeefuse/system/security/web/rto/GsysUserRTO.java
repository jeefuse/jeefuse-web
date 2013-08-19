/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.rto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.security.model.ActivatedType;
import com.jeefuse.system.security.model.GsysRelUserRole;
import com.jeefuse.system.security.model.GsysUser;

/**
 * GsysUser Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysUserRTO implements GenericRTO<GsysUser>, Serializable{
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
	 * username
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getUsername() {
		return username;
	}

	/** @generated */
	public void setUsername(final String username) {
		this.username = username;
	}
	
	/** @generated */
	private String username = null;

	/**
	 * ------------------------------------------------------------------------
	 * createTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/** @generated */
	public void setCreateTime(final Date createTime) {
		this.createTime = createTime;
	}	
	/**
	 * ------------------------------------------------------------------------
	 * convert to date string for createTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getCreateTimeToStr() {
		return createTimeToStr;
	}
	
	/** @generated */
	public void setCreateTimeToStr(final String createTimeToStr) {
		this.createTimeToStr = createTimeToStr;
	}
	
	/** @generated */
	private String createTimeToStr;
	
	/** @generated */
	private Date createTime = null;

	/**
	 * ------------------------------------------------------------------------
	 * email
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/** @generated */
	public void setEmail(final String email) {
		this.email = email;
	}
	
	/** @generated */
	private String email = null;

	/**
	 * ------------------------------------------------------------------------
	 * enabled
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getEnabled() {
		return enabled;
	}

	/** @generated */
	public void setEnabled(final String enabled) {
		this.enabled = enabled;
	}
	
	/** @generated */
	private String enabled;

	/**
	 * ------------------------------------------------------------------------
	 * level
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getLevel() {
		return level;
	}

	/** @generated */
	public void setLevel(final String level) {
		this.level = level;
	}
	
	/** @generated */
	private String level = null;

	/**
	 * ------------------------------------------------------------------------
	 * loginName
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getLoginName() {
		return loginName;
	}

	/** @generated */
	public void setLoginName(final String loginName) {
		this.loginName = loginName;
	}
	
	/** @generated */
	private String loginName = null;

	/**
	 * ------------------------------------------------------------------------
	 * logincount
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public Long getLogincount() {
		return logincount;
	}

	/** @generated */
	public void setLogincount(final Long logincount) {
		this.logincount = logincount;
	}
	
	/** @generated */
	private Long logincount = null;

	/**
	 * ------------------------------------------------------------------------
	 * password
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getPassword() {
		return password;
	}

	/** @generated */
	public void setPassword(final String password) {
		this.password = password;
	}
	
	/** @generated */
	private String password = null;

	/**
	 * ------------------------------------------------------------------------
	 * remark
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getRemark() {
		return remark;
	}

	/** @generated */
	public void setRemark(final String remark) {
		this.remark = remark;
	}
	
	/** @generated */
	private String remark = null;

	/**
	 * ------------------------------------------------------------------------
	 * sex
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getSex() {
		return sex;
	}

	/** @generated */
	public void setSex(final String sex) {
		this.sex = sex;
	}
	
	/** @generated */
	private String sex = null;

	/**
	 * ------------------------------------------------------------------------
	 * telephone
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getTelephone() {
		return telephone;
	}

	/** @generated */
	public void setTelephone(final String telephone) {
		this.telephone = telephone;
	}
	
	/** @generated */
	private String telephone = null;

	/**
	 * ------------------------------------------------------------------------
	 * updateTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/** @generated */
	public void setUpdateTime(final Date updateTime) {
		this.updateTime = updateTime;
	}	
	/**
	 * ------------------------------------------------------------------------
	 * convert to date string for updateTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getUpdateTimeToStr() {
		return updateTimeToStr;
	}
	
	/** @generated */
	public void setUpdateTimeToStr(final String updateTimeToStr) {
		this.updateTimeToStr = updateTimeToStr;
	}
	
	/** @generated */
	private String updateTimeToStr;
	
	/** @generated */
	private Date updateTime = null;

	/**
	 * ------------------------------------------------------------------------
	 * lastLoginTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/** @generated */
	public void setLastLoginTime(final Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}	
	/**
	 * ------------------------------------------------------------------------
	 * convert to date string for lastLoginTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getLastLoginTimeToStr() {
		return lastLoginTimeToStr;
	}
	
	/** @generated */
	public void setLastLoginTimeToStr(final String lastLoginTimeToStr) {
		this.lastLoginTimeToStr = lastLoginTimeToStr;
	}
	
	/** @generated */
	private String lastLoginTimeToStr;
	
	/** @generated */
	private Date lastLoginTime = null;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(final String mobile) {
		this.mobile = mobile;
	}

	private String mobile = null;


	/**
	 * ------------------------------------------------------------------------
	 * gsysRelUserRoles
	 * ------------------------------------------------------------------------
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
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysUser getModifiedModel(GsysUser oldModel) {
		oldModel.setUsername(this.getUsername());//1 username
		oldModel.setEmail(this.getEmail());//3 email
		oldModel.setEnabled(this.getEnabled());//4 enabled
		oldModel.setLevel(this.getLevel());//5 level
		oldModel.setLoginName(this.getLoginName());//6 loginName
		// oldModel.setPassword(this.getPassword());//8 password
		oldModel.setRemark(this.getRemark());//9 remark
		oldModel.setSex(this.getSex());//10 sex
		oldModel.setTelephone(this.getTelephone());//11 telephone
		oldModel.setUpdateTime(new Date());//12 updateTime
		return oldModel;
	}

	public GsysUser getModifiedPersonalData(GsysUser oldModel) {
		oldModel.setUsername(this.getUsername());//1 username
		//		oldModel.setLoginName(this.getLoginName());//6 loginName
		//		oldModel.setEmail(this.getEmail());//3 email
		//		oldModel.setMobile(this.getMobile());
		oldModel.setRemark(this.getRemark());//9 remark
		oldModel.setSex(this.getSex());//10 sex
		oldModel.setTelephone(this.getTelephone());//11 telephone
		oldModel.setUpdateTime(new Date());//12 updateTime
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysUser getNewModel() {
		GsysUser newGsysUser=new GsysUser();
		//newGsysUser.setId(this.getId());//id auto generated
		newGsysUser.setUsername(this.getUsername());//1 username
		newGsysUser.setCreateTime(new Date());//2 createTime
		newGsysUser.setEmail(this.getEmail());//3 email
		newGsysUser.setEnabled(this.getEnabled());//4 enabled
		newGsysUser.setActivated(ActivatedType.VALID.getKey());
		newGsysUser.setLevel(this.getLevel());//5 level
		newGsysUser.setLoginName(this.getLoginName());//6 loginName
//		newGsysUser.setPassword(new Md5PasswordEncoder().encodePassword(this.getPassword()));//8 password
		newGsysUser.setPassword(this.getPassword());//8 password
		newGsysUser.setRemark(this.getRemark());//9 remark
		newGsysUser.setSex(this.getSex());//10 sex
		newGsysUser.setTelephone(this.getTelephone());//11 telephone
		newGsysUser.setUpdateTime(new Date());//12 updateTime
//		newGsysUser.setLastLoginTime(this.getLastLoginTime());//13 lastLoginTime
		newGsysUser.setGsysRelUserRoles(this.getGsysRelUserRoles());//14 gsysRelUserRoles
		return newGsysUser;
	}

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",id).append("username",username).append("createTime",createTime).append("email",email)
				.append("enabled",enabled).append("level",level).append("loginName",loginName).append("logincount",logincount)
				.append("password",password).append("remark",remark).append("sex",sex).append("telephone",telephone)
				.append("updateTime",updateTime).append("lastLoginTime",lastLoginTime).append("gsysRelUserRoles",gsysRelUserRoles)
				.toString();
	}


}
