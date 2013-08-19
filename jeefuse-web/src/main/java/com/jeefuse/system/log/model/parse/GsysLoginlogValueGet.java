/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.security.model.GsysUser;

/**
 * 登入日志 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysLoginlogValueGet implements PropertyValueGet<GsysLoginlog>{

	/**
	 * 登入日志 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysLoginlog model, String propertyName) throws DataNoExistException {
		if (null == model)
			return null;
		GsysLoginlogField gsysLoginlogField = GsysLoginlogField.valueOfFieldName(propertyName);
		if (null == gsysLoginlogField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysLoginlogField) {
		case id://1 id
			return model.getId();
		case loginIp://2 登录IP
			return model.getLoginIp();
		case createdate://3 登录时间
			return model.getCreatedate();
		case message://4 信息
			return model.getMessage();
		case userId://5 登入用户
			GsysUser gsysUser=model.getGsysUser();
			return null == gsysUser ? null : gsysUser.getId();
		}
		return null;
	}
	
}
