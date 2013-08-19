/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRole 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysRoleValueGet implements PropertyValueGet<GsysRole>{

	/**
	 * GsysRole 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysRole model, String propertyName) throws DataNoExistException {
	
		GsysRoleField gsysRoleField = GsysRoleField.valueOfFieldName(propertyName);
		if (null == gsysRoleField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysRoleField) {
		case id:
			return model.getId();////1 id
		case name:
			return model.getName();////2 name
		case displayName:
			return model.getDisplayName();////3 displayName
		case descript:
			return model.getDescript();////4 descript	
		}
		return null;
	}
	
}
