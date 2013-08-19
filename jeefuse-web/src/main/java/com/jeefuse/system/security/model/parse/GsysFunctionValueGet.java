/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * GsysFunction 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysFunctionValueGet implements PropertyValueGet<GsysFunction>{

	/**
	 * GsysFunction 属性值获取.该方法用于根据属性名直接获取对象的属性值,避免使用反射引起的性能开销.
	 * @generated
	 */
	public Object getValue(GsysFunction model, String propertyName) throws DataNoExistException {
		if (null == model)
			return null;
		GsysFunctionField gsysFunctionField = GsysFunctionField.valueOfFieldName(propertyName);
		if (null == gsysFunctionField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysFunctionField) {
		case id://1 ID
			return model.getId();
		case value://2 权限标志
			return model.getValue();
		case name://3 权限名称
			return model.getName();
		case descript://4 描述
			return model.getDescript();
		case type://5 权限类型
			return model.getType();
		case url://6 url
			return model.getUrl();
		case parentId://7 上级ID
			return model.getParentId();
		case validStatus://8 是否有效
			return model.getValidStatus();
		case sortNum://9 排序
			return model.getSortNum();
		case layerCode://10 层次编码
			return model.getLayerCode();	
		}
		return null;
	}
	
}
