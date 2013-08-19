/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.service;

/**
 * 服务Facade.
 *
 * @author yonclv
 * @generated
 */
public class SequenceServiceFacade{


	/*****************************************************************
	 * 序例 service
	 *****************************************************************/

	/**
	 * 按主键sequenceName获取序列号.
	 * 
	 * @generated
	 */
	static public Long getGsysSequence(String sequenceName) {
		return SequenceServiceFactory.getGsysSequenceService().getNextId(sequenceName);
	}	 
}
