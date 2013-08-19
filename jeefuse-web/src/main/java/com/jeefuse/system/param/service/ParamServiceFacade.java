/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.service;
import com.jeefuse.system.param.model.GsysParameter;

/**
 * null服务Facade.
 *
 * @author yonclv
 * @generated
 */
public class ParamServiceFacade{


	/*****************************************************************
	 * 系统参数 service
	 *****************************************************************/

	/**
	 * 按主键id获取GsysParameter对象.
	 * @generated
	 */
	static public GsysParameter getGsysParameter(String id){
		return ParamServiceFactory.getGsysParameterService().get(id);
	}	 
}
