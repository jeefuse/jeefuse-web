/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.GsysOperatelog;

/**
 * GsysUser Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_user")
public class GsysUser implements IdEntity<String>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysUser() {
	}


	/**
	 * ------------------------------------------------------------------------
	 * id
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Id
	@GeneratedValue(generator = "hibernate-uuid")
	@GenericGenerator(strategy = "uuid", name = "hibernate-uuid")
	@Column(name = "id", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	public String getId() {
		return id;
	}
	
	/** @generated */
	public void setId(final String id) {
		this.id = id;
	}
	
	private String id = null;

	/**
	 * ------------------------------------------------------------------------
	 * username
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "username", length = 20, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@Length(min = 0, max = 20)
	@NotNull
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
	@Column(name = "create_time", length = 19, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
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
	@Transient
	public String getCreateTimeToStr() {
		return DateUtil.formatDateTimeSecond(createTime);
	}

	/** @generated */
	private Date createTime = null;

	/**
	 * ------------------------------------------------------------------------
	 * email
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "email", length = 50, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 50)
	@Email
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
	@Column(name = "enabled", length = 3, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@Length(min = 0, max = 3)
	@NotNull
	public String getEnabled() {
		return enabled;
	}

	/** @generated */
	public void setEnabled(final String enabled) {
		this.enabled = enabled;
	}

	/** @generated */
	private String enabled = null;

	/**
	 * ------------------------------------------------------------------------
	 * activated
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "activated", length = 3, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@Length(min = 0, max = 3)
	@NotNull
	public String getActivated() {
		return activated;
	}

	/** @generated */
	public void setActivated(final String activated) {
		this.activated = activated;
	}

	/** @generated */
	private String activated = null;

	/**
	 * ------------------------------------------------------------------------
	 * level
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "level", length = 1, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 1)
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
	@Column(name = "login_name", length = 26, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 26)
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
	 * password
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "password", length = 36, unique = false, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
	@NotNull
	@Length(min = 0, max = 36)
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
	@Column(name = "remark", length = 255, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 255)
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
	@Column(name = "sex", length = 1, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 1)
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
	 * 电话
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "mobile", length = 20, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 20)
	public String getMobile() {
		return mobile;
	}

	/** @generated */
	public void setMobile(final String mobile) {
		this.mobile = mobile;
	}

	/** @generated */
	private String mobile = null;

	/**
	 * ------------------------------------------------------------------------
	 * telephone
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "telephone", length = 60, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 60)
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
	@Column(name = "update_time", length = 19, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
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
	@Transient
	public String getUpdateTimeToStr() {
		return DateUtil.formatDateTimeSecond(updateTime);
	}

	/** @generated */
	private Date updateTime = null;

	/**
	 * ------------------------------------------------------------------------
	 * lastLoginTime
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "last_login_time", length = 19, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
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
	@Transient
	public String getLastLoginTimeToStr() {
		return DateUtil.formatDateTimeSecond(lastLoginTime);
	}

	/** @generated */
	private Date lastLoginTime = null;

	/**
	 * ------------------------------------------------------------------------
	 * 头像
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "portrait_photo", length = 120, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 120)
	public String getPortraitPhoto() {
		return portraitPhoto;
	}

	/** @generated */
	public void setPortraitPhoto(final String portraitPhoto) {
		this.portraitPhoto = portraitPhoto;
	}

	/** @generated */
	private String portraitPhoto = null;


	/**
	 * ------------------------------------------------------------------------
	 * 头像保存实际地址
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "portrait_photo_save_path", length = 120, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 120)
	public String getPortraitPhotoSavePath() {
		return portraitPhotoSavePath;
	}

	/** @generated */
	public void setPortraitPhotoSavePath(final String portraitPhotoSavePath) {
		this.portraitPhotoSavePath = portraitPhotoSavePath;
	}

	/** @generated */
	private String portraitPhotoSavePath = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysOperatelogs
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysUser", cascade = CascadeType.REMOVE)
	public List<GsysOperatelog> getGsysOperatelogs() {
		if (this.gsysOperatelogs == null) {
			this.gsysOperatelogs = new ArrayList<GsysOperatelog>();
		}
		return gsysOperatelogs;
	}

	/** @generated */
	public void setGsysOperatelogs(final List<GsysOperatelog> gsysOperatelogs) {
		this.gsysOperatelogs = gsysOperatelogs;
	}

	/** @generated */
	private List<GsysOperatelog> gsysOperatelogs = null;

	/**
	 * ------------------------------------------------------------------------
	 * gsysOperatelogs
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysUser", cascade = CascadeType.REMOVE)
	public List<GsysLoginlog> getGsysLoginlogs() {
		if (this.gsysLoginlogs == null) {
			this.gsysLoginlogs = new ArrayList<GsysLoginlog>();
		}
		return gsysLoginlogs;
	}

	/** @generated */
	public void setGsysLoginlogs(final List<GsysLoginlog> gsysLoginlogs) {
		this.gsysLoginlogs = gsysLoginlogs;
	}

	/** @generated */
	private List<GsysLoginlog> gsysLoginlogs = null;


	/**
	 * ------------------------------------------------------------------------
	 * gsysRelUserRoles
	 * ------------------------------------------------------------------------
	 * 
	 * @generated
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gsysUser", cascade = CascadeType.REMOVE)
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
	// Utils
	// ------------------------------------------------------------------------


	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("username",username).append("createTime",createTime).append("email",email)
				.append("level",level).append("updateTime",updateTime).append("loginName",loginName)
				.append("password",password).append("remark",remark).append("sex",sex).append("mobile",mobile)
				.append("telephone",telephone).append("enabled",enabled).append("activated",activated).append("lastLoginTime",lastLoginTime)
				.toString();
	}
	
	/** @generated */
	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + (id == null? super.hashCode() : id.hashCode());
		return result;
	}

	/** @generated */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof GsysUser))
			return false;
		final GsysUser other = (GsysUser) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}	
}
