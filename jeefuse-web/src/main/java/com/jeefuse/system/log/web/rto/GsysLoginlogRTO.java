/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.rto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.jeefuse.base.web.rto.GenericRTO;
import com.jeefuse.system.log.model.GsysLoginlog;

/**
 * 登入日志 Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysLoginlogRTO implements GenericRTO<GsysLoginlog>, Serializable{
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
	
	/** @generated */
	private String id = null;	

	/**
	 * ------------------------------------------------------------------------
	 * 登录IP
	 * ------------------------------------------------------------------------
	 * @generated
	 */
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
	 * 登录时间
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public Date getCreatedate() {
		return createdate;
	}

	/** @generated */
	public void setCreatedate(final Date createdate) {
		this.createdate = createdate;
	}
	
	/** @generated */
	private Date createdate = null;	
	
	/**
	 * convert to date string for 登录时间
	 * @generated
	 */
	public String getCreatedateToStr() {
		return createdateToStr;
	}
	
	/** @generated */
	public void setCreatedateToStr(final String createdateToStr) {
		this.createdateToStr = createdateToStr;
	}
	
	/** @generated */
	private String createdateToStr;
	

	/**
	 * search 登录时间 for 登录时间
	 * @generated
	 */
	public String getCreatedateStart() {
		return createdateStart;
	}
	
	/** @generated */
	public void setCreatedateStart(final String createdateStart) {
		this.createdateStart = createdateStart;
	}
	
	/** @generated */
	private String createdateStart = null;	
	
	/**
	 * search field two for 登录时间
	 * @generated
	 */
	public String getCreatedateEnd() {
		return createdateEnd;
	}
	
	/** @generated */
	public void setCreatedateEnd(final String createdateEnd) {
		this.createdateEnd = createdateEnd;
	}
	
	/** @generated */
	private String createdateEnd = null;

	/**
	 * ------------------------------------------------------------------------
	 * 信息
	 * ------------------------------------------------------------------------
	 * @generated
	 */
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
	 * 登入用户
	 * ------------------------------------------------------------------------
	 * @generated
	 */
	public String getUserId() {
		return userId;
	}

	/** @generated */
	public void setUserId(final String userId) {
		this.userId = userId;
	}
	
	/** @generated */
	private String userId = null;
		


	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysLoginlog getModifiedModel(GsysLoginlog oldModel) {	
		oldModel.setLoginIp(this.loginIp);//1 登录IP
		//oldModel.setCreatedate(new Date());//2 登录时间
		oldModel.setMessage(this.message);//3 信息
		oldModel.setUserId(this.userId);//4 登入用户	
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysLoginlog getNewModel() {
		GsysLoginlog newGsysLoginlog=new GsysLoginlog();	
		newGsysLoginlog.setLoginIp(this.loginIp);//1 登录IP
		newGsysLoginlog.setCreatedate(new Date());//2 登录时间
		newGsysLoginlog.setMessage(this.message);//3 信息
		newGsysLoginlog.setUserId(this.userId);//4 登入用户
		return newGsysLoginlog;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysLoginlog model) {
		this.setId(model.getId());//id 1
		this.setLoginIp(model.getLoginIp());//2 登录IP
		this.setCreatedate(model.getCreatedate());//3 登录时间
		this.setMessage(model.getMessage());//4 信息
		this.setUserId(model.getUserId());//5 登入用户
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("loginIp",loginIp).append("createdate",createdate).append("message",message)
				.append("userId",userId)
				.toString();
	}


}
