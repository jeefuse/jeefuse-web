/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.service;

import com.jeefuse.base.service.SpringContextUtils;

/**
 * code 服务工厂.
 *
 * @author yonclv
 * @generated
 */
public class CodeServiceFactory{

	/**
	 * 获取GsysCode CRUD 服务.
	 * 
	 * @generated
	 */
	public static final GsysCodeService getGsysCodeService() {
		return (GsysCodeService) SpringContextUtils.getBean("gsysCodeServiceImpl");
	}

	/**
	 * 获取GsysCodevalue CRUD 服务.
	 * 
	 * @generated
	 */
	public static final GsysCodevalueService getGsysCodevalueService() {
		return (GsysCodevalueService) SpringContextUtils.getBean("gsysCodevalueServiceImpl");
	}

	
}
