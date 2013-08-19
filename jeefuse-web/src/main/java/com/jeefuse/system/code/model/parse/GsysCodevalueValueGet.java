/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.code.model.GsysCodevalue;

/**
 * GsysCodevalue 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueValueGet implements PropertyValueGet<GsysCodevalue>{

	/**
	 * GsysCodevalue 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysCodevalue model, String propertyName) throws DataNoExistException {
	
		GsysCodevalueField gsysCodevalueField = GsysCodevalueField.valueOfFieldName(propertyName);
		if (null == gsysCodevalueField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysCodevalueField) {
		case id://1 ID
			return model.getId();
		case name://2 name
			return model.getName();
		case value://3 value
			return model.getValue();
		case descript://4 ˵
			return model.getDescript();	
		}
		return null;
	}
	
}
