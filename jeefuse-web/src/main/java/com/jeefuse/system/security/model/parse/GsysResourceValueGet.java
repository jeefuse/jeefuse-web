/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.security.model.GsysResource;

/**
 * GsysResource 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceValueGet implements PropertyValueGet<GsysResource>{

	/**
	 * GsysResource 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysResource model, String propertyName) throws DataNoExistException {
	
		GsysResourceField gsysResourceField = GsysResourceField.valueOfFieldName(propertyName);
		if (null == gsysResourceField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysResourceField) {
		case id:
			return model.getId();////1 id
		case name:
			return model.getName();////2 name
		case descript:
			return model.getDescript();////3 descript
		case value:
			return model.getValue();////4 value
		case type:
			return model.getType();////5 type	
		}
		return null;
	}
	
}
