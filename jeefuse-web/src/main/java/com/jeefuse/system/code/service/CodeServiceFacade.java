/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.service;

import java.util.List;

import org.springframework.util.Assert;

import com.jeefuse.system.code.cache.CodeCache;
import com.jeefuse.system.code.model.CodeDefineType;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;

/**
 * code 服务工厂.
 * 
 * @author yonclv
 * @generated
 */
public class CodeServiceFacade {

	/**
	 * 查询GsysCode关联的GsysCodevalue.只获取name、value字段.
	 * 
	 * @param codeDefineType
	 *            编码定义
	 * @return
	 */
	static public List<GsysCodevalue> findByGsysCodeForKeyLabel(CodeDefineType codeDefineType) {
		Assert.notNull(codeDefineType);
		GsysCode gsysCode = CodeCache.getInstance().get(codeDefineType.getName());
		if (null != gsysCode)
			return gsysCode.getGsysCodevalues();
		return null;
	}

}
