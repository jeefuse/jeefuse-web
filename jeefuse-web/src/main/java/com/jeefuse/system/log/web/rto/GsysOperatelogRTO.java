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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.security.model.GsysUser;

/**
 * 操作日志 Entity RTO(Request transfer object).
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogRTO implements GenericRTO<GsysOperatelog>, Serializable{
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
	 * 创建时间
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
	 * convert to date string for 创建时间
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
	 * search 创建时间 for 创建时间
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
	 * search field two for 创建时间
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
	 * 操作用户
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
		

	/**
	 * ------------------------------------------------------------------------
	 * 类型
	 * ------------------------------------------------------------------------
	 * @generated
	 */
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
	public GsysUser getGsysUser() {
		if (this.gsysUser == null) {
			this.gsysUser = new GsysUser();        
		}
		return gsysUser;
	}

	/** @generated */
	public void setGsysUser(final GsysUser gsysUser) {
		this.gsysUser = gsysUser;
	}

	/** @generated */
	private GsysUser gsysUser = new GsysUser();
	// ------------------------------------------------------------------------
	// RTO <==> model convert 
	// ------------------------------------------------------------------------
	
	/**
	 * 从请求中构造要更新的实体对象.
	 * @generated
	 */
	public GsysOperatelog getModifiedModel(GsysOperatelog oldModel) {	
		oldModel.setLoginIp(this.loginIp);//1 登录IP
		//oldModel.setCreatedate(new Date());//2 创建时间
		oldModel.setMessage(this.message);//3 信息
		oldModel.setUserId(this.userId);//4 操作用户
		oldModel.setKind(this.kind);//5 类型
		oldModel.setDetail(this.detail);//6 详细说明	
		//oldModel.setGsysUser(this.gsysUser);//7 rel m2o GsysUser
		return oldModel;
	}

	/**
	 *从请求中构造要保存的实体对象.
	 * @generated
	 */
	public GsysOperatelog getNewModel() {
		GsysOperatelog newGsysOperatelog=new GsysOperatelog();	
		newGsysOperatelog.setLoginIp(this.loginIp);//1 登录IP
		newGsysOperatelog.setCreatedate(new Date());//2 创建时间
		newGsysOperatelog.setMessage(this.message);//3 信息
		newGsysOperatelog.setUserId(this.userId);//4 操作用户
		newGsysOperatelog.setKind(this.kind);//5 类型
		newGsysOperatelog.setDetail(this.detail);//6 详细说明
		//newGsysOperatelog.setGsysUser(this.gsysUser);//7 rel m2o GsysUser
		return newGsysOperatelog;
	}

	/**
	 * 用实体对象填充数据.
	 * @generated
	 */
	public void setModel(GsysOperatelog model) {
		this.setId(model.getId());//id 1
		this.setLoginIp(model.getLoginIp());//2 登录IP
		this.setCreatedate(model.getCreatedate());//3 创建时间
		this.setMessage(model.getMessage());//4 信息
		this.setUserId(model.getUserId());//5 操作用户
		this.setKind(model.getKind());//6 类型
		this.setDetail(model.getDetail());//7 详细说明
		// this.setGsysUser(model.getGsysUser());//8 gsysUser
	}
	
	// ------------------------------------------------------------------------
	// Utils
	// ------------------------------------------------------------------------

	/** @generated */
	@Override
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId()).append("loginIp",loginIp).append("createdate",createdate).append("message",message)
				.append("userId",userId).append("kind",kind).append("detail",detail)//.append("gsysUser",gsysUser)
				
				.toString();
	}


}
