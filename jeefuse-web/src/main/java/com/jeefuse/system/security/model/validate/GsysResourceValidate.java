/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.validate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;
/**
 * GsysResource  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceValidate {

	private static ClassValidator<GsysResource> classValidator = new ClassValidator<GsysResource>(GsysResource.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysResource gsysResource) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysResource);
		return invalidValues;
	}

	/**
	 * 验证User对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysResource gsysResource) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysResource);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysResourceField gsysResourceField = GsysResourceField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysResourceField) {
					errors.add(gsysResourceField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	static public InvalidValue[] validateProperty(GsysResource gsysResource, GsysResourceField gsysResourceField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysResource, gsysResourceField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证User对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysResource gsysResource, GsysResourceField gsysResourceField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysResource, gsysResourceField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysResourceField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
}
