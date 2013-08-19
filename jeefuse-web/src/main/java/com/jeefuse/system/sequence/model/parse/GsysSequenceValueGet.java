/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.model.parse;


import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.model.parse.PropertyValueGet;
import com.jeefuse.system.sequence.model.GsysSequence;

/**
 * 序例 属性值获取.
 *
 * @author yonclv
 * @generated
 */
public class GsysSequenceValueGet implements PropertyValueGet<GsysSequence>{

	/**
	 * 序例 属性值获取.该方法用于根据属性名直接获取对象的属性值.
	 * @generated
	 */
	public Object getValue(GsysSequence model, String propertyName) throws DataNoExistException {
		if (null == model)
			return null;
		GsysSequenceField gsysSequenceField = GsysSequenceField.valueOfFieldName(propertyName);
		if (null == gsysSequenceField)
			throw new DataNoExistException("无效字段:" + propertyName);
		switch (gsysSequenceField) {
		case name://1 序列名
			return model.getName();
		case nextId://2 序号
			return model.getNextId();	
		}
		return null;
	}
	
}
