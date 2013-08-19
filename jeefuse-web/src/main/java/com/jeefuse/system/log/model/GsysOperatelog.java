/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.Length;

import com.jeefuse.base.model.IdEntity;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.system.security.model.GsysUser;

/**
 * 操作日志 Entity define.
 *
 * @author yonclv
 * @generated
 */
@Entity
@Table(name = "gsys_operatelog")
public class GsysOperatelog implements IdEntity<String>, Serializable {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/** @generated */
	public GsysOperatelog() {
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
	@Column(name = "ID", length = 32, unique = true, precision = 0, scale = 0, nullable = false, insertable = true, updatable = true)
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
	 * 登录IP
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "LOGIN_IP", length = 32, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 32)
	public String getLoginIp() {
		return loginIp;
	}

	/** @generated */
	public void setLoginIp(final String loginIp) {
		this.loginIp = loginIp;
	}

	/** @generated */
	private String loginIp = null;

	/**
	 * ------------------------------------------------------------------------
	 * 创建时间
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "CREATEDATE", length = 10, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	public Date getCreatedate() {
		return createdate;
	}

	/** @generated */
	public void setCreatedate(final Date createdate) {
		this.createdate = createdate;
	}	

	/**
	 * ------------------------------------------------------------------------
	 * convert to date string for 创建时间
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Transient
	public String getCreatedateToStr() {
		return DateUtil.formatDateTimeSecond(createdate);
	}

	/** @generated */
	private Date createdate = null;

	/**
	 * ------------------------------------------------------------------------
	 * 信息
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "MESSAGE", length = 255, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 255)
	public String getMessage() {
		return message;
	}

	/** @generated */
	public void setMessage(final String message) {
		this.message = message;
	}

	/** @generated */
	private String message = null;

	/**
	 * ------------------------------------------------------------------------
	 * 类型
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "KIND", length = 10, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 10)
	public String getKind() {
		return kind;
	}

	/** @generated */
	public void setKind(final String kind) {
		this.kind = kind;
	}

	/** @generated */
	private String kind = null;

	/**
	 * ------------------------------------------------------------------------
	 * 详细说明
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@Column(name = "DETAIL", length = 2147483647, unique = false, precision = 0, scale = 0, nullable = true, insertable = true, updatable = true)
	@Length(min = 0, max = 2147483647)
	public String getDetail() {
		return detail;
	}

	/** @generated */
	public void setDetail(final String detail) {
		this.detail = detail;
	}

	/** @generated */
	private String detail = null;	
	/**
	 * ------------------------------------------------------------------------
	 * gsysUser
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	@JoinColumn(name = "USER_ID", unique = false, nullable = false, insertable = true, updatable = true)
	@ManyToOne(fetch = FetchType.LAZY)
	public GsysUser getGsysUser() {
		return gsysUser;
	}

	/** @generated */
	public void setGsysUser(final GsysUser gsysUser) {
		this.gsysUser = gsysUser;
	}

	/** @generated */
	private GsysUser gsysUser = new GsysUser();

	@Transient
	public String getUserId() {
		if (null != gsysUser)
			return gsysUser.getId();
		return null;
	}

	/**
	 * @param userId
	 */
	@Transient
	public void setUserId(String userId) {
		if (null == gsysUser) {
			gsysUser = new GsysUser();
		}
		gsysUser.setId(userId);
	}

	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("loginIp",loginIp).append("createdate",createdate).append("message",message)
.append("kind", kind).append("detail", detail)// .append("gsysUser",gsysUser)
				
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
		if (!(obj instanceof GsysOperatelog))
			return false;
		final GsysOperatelog other = (GsysOperatelog) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}



}
