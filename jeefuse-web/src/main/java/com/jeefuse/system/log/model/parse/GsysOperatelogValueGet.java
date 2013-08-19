/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.LogType;

/**
 * 操作日志 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogValueGet implements PropertyValueGet<GsysOperatelog>{

	/**
	 * 操作日志 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysOperatelog model, String propertyName) throws DataNoExistException {
		if (null == model)
			return null;
		GsysOperatelogField gsysOperatelogField = GsysOperatelogField.valueOfFieldName(propertyName);
		if (null == gsysOperatelogField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysOperatelogField) {
		case id://1 id
			return model.getId();
		case loginIp://2 登录IP
			return model.getLoginIp();
		case createdate://3 创建时间
			return model.getCreatedate();
		case message://4 信息
			return model.getMessage();
		case userId:// 5 操作用户
			return (null == model.getGsysUser() ? null : model.getGsysUser().getId());
		case kind://6 类型
			LogType logType = LogType.valueOfKey(model.getKind());
			if (null != logType)
				return logType.getLabel();
			else
				return model.getKind();
		case detail://7 详细说明
			return model.getDetail();			
		}
		return null;
	}
	
}
