/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model.validate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
/**
 * GsysCodevalue  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueValidate {

	private static ClassValidator<GsysCodevalue> classValidator = new ClassValidator<GsysCodevalue>(GsysCodevalue.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysCodevalue gsysCodevalue) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysCodevalue);
		return invalidValues;
	}

	/**
	 * 验证User对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysCodevalue gsysCodevalue) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysCodevalue);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysCodevalueField gsysCodevalueField = GsysCodevalueField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysCodevalueField) {
					errors.add(gsysCodevalueField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					errors.add(invalidValue.getMessage());
				}
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 验证User对象属性,返回约束违反集合.
	 * 
	 */
	static public InvalidValue[] validateProperty(GsysCodevalue gsysCodevalue, GsysCodevalueField gsysCodevalueField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysCodevalue, gsysCodevalueField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证User对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysCodevalue gsysCodevalue, GsysCodevalueField gsysCodevalueField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysCodevalue, gsysCodevalueField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysCodevalueField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
}
