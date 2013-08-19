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
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.parse.GsysCodeField;
/**
 * GsysCode  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodeValidate {

	private static ClassValidator<GsysCode> classValidator = new ClassValidator<GsysCode>(GsysCode.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysCode gsysCode) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysCode);
		return invalidValues;
	}

	/**
	 * 验证User对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysCode gsysCode) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysCode);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysCodeField gsysCodeField = GsysCodeField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysCodeField) {
					errors.add(gsysCodeField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	static public InvalidValue[] validateProperty(GsysCode gsysCode, GsysCodeField gsysCodeField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysCode, gsysCodeField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证User对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysCode gsysCode, GsysCodeField gsysCodeField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysCode, gsysCodeField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysCodeField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 获取验证失败信息.
	 */
	public static String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (null!=invalidValues&&invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysCodeField columnField = GsysCodeField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != columnField) {
					sb.append(columnField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					sb.append(invalidValue.getMessage());
				}
				sb.append(null == newLineChar ? "\n" : newLineChar);
			}
			return sb.toString();
		}
		return "";
	}

	/**
	 * 获取验证失败信息.设置换行符为<code><</code>br/>
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}

}
