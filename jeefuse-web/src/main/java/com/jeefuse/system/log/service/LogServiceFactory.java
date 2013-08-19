/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.service;

import com.jeefuse.base.service.SpringContextUtils;

/**
 * log服务工厂.
 *
 * @author yonclv
 * @generated
 */
public abstract class LogServiceFactory{

	/**
	 * 获取登入日志 CRUD 服务.
	 * 
	 * @generated
	 */
	public final static GsysLoginlogService getGsysLoginlogService() {
		return (GsysLoginlogService) SpringContextUtils.getBean("gsysLoginlogServiceImpl");
	}

	/**
	 * 获取操作日志 CRUD 服务.
	 * 
	 * @generated
	 */
	public final static GsysOperatelogService getGsysOperatelogService() {
		return (GsysOperatelogService) SpringContextUtils.getBean("gsysOperatelogServiceImpl");
	}

	
}
