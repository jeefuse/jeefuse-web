/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.service;

import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.GsysOperatelog;

/**
 * log服务Facade.
 *
 * @author yonclv
 * @generated
 */
public class LogServiceFacade{


	/*****************************************************************
	 * 登入日志 service
	 *****************************************************************/

	/**
	 * 按主键id获取GsysLoginlog对象.
	 * @generated
	 */
	static public GsysLoginlog getGsysLoginlog(String id){
		return LogServiceFactory.getGsysLoginlogService().get(id);
	}	 

	/*****************************************************************
	 * 操作日志 service
	 *****************************************************************/

	/**
	 * 按主键id获取GsysOperatelog对象.
	 * @generated
	 */
	static public GsysOperatelog getGsysOperatelog(String id){
		return LogServiceFactory.getGsysOperatelogService().get(id);
	}

}
