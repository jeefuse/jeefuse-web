/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.enumeration.CodeOperateKind;

/**
 * GsysCode 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodeValueGet implements PropertyValueGet<GsysCode>{

	/**
	 * GsysCode 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysCode model, String propertyName) throws DataNoExistException {
	
		GsysCodeField gsysCodeField = GsysCodeField.valueOfFieldName(propertyName);
		if (null == gsysCodeField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysCodeField) {
		case cid://1 cid
			return model.getCid();
		case name://2 name
			return model.getName();
		case descript://3 ˵
			return model.getDescript();
		case kind://4 kind
			CodeOperateKind codeOperateKind = CodeOperateKind.valueOfKey(model.getKind());
			if (null != codeOperateKind) {
				return codeOperateKind.getLabel();
			} else {
				return model.getKind();
			}	
		}
		return null;
	}
	
}
