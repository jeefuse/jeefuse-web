/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.service;

import com.jeefuse.base.service.SpringContextUtils;
import com.jeefuse.system.sequence.service.impl.GsysSequenceServiceImpl;

/**
 * 服务工厂.
 *
 * @author yonclv
 * @generated
 */
public abstract class SequenceServiceFactory{

	/**
	 * 获取序例 CRUD 服务.
	 * 
	 * @generated
	 */
	public final static GsysSequenceService getGsysSequenceService() {
		return (GsysSequenceService) SpringContextUtils.getBean(GsysSequenceServiceImpl.SERVICE_ID);
	}

	
}
