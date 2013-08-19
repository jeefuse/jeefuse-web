/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.param.model.GsysParameter;

/**
 * GsysParameter 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysParameterValueGet implements PropertyValueGet<GsysParameter>{

	/**
	 * GsysParameter 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysParameter model, String propertyName) throws DataNoExistException {
		if (null == model)
			return null;
		GsysParameterField gsysParameterField = GsysParameterField.valueOfFieldName(propertyName);
		if (null == gsysParameterField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysParameterField) {
		case name://1 参数名
			return model.getName();
		case value://2 参数值
			return model.getValue();
		case descript://3 用途说明
			return model.getDescript();	
		}
		return null;
	}
	
}
