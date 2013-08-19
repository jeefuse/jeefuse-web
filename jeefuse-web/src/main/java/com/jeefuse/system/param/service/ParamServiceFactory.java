/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.service;

import com.jeefuse.base.service.SpringContextUtils;

/**
 * param 服务工厂.
 *
 * @author yonclv
 * @generated
 */
public class ParamServiceFactory{

	/**
	 * 获取GsysParameter CRUD 服务.
	 * 
	 * @generated
	 */
	static public GsysParameterService getGsysParameterService() {
		return (GsysParameterService) SpringContextUtils.getBean("gsysParameterServiceImpl");
	}

	
}
