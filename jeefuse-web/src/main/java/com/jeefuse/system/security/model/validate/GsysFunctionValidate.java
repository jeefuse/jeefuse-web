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
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;
/**
 * GsysFunction  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysFunctionValidate {

	private static ClassValidator<GsysFunction> classValidator = new ClassValidator<GsysFunction>(GsysFunction.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysFunction gsysFunction) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysFunction);
		return invalidValues;
	}

	/**
	 * 验证User对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysFunction gsysFunction) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysFunction);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysFunctionField gsysFunctionField = GsysFunctionField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysFunctionField) {
					errors.add(gsysFunctionField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	static public InvalidValue[] validateProperty(GsysFunction gsysFunction, GsysFunctionField gsysFunctionField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysFunction, gsysFunctionField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证User对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysFunction gsysFunction, GsysFunctionField gsysFunctionField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysFunction, gsysFunctionField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysFunctionField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 获取[GsysFunction]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysFunctionField gsysFunctionField = GsysFunctionField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysFunctionField) {
					sb.append(gsysFunctionField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	 * 获取[GsysFunction]验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}

	/**
	 * 获取[GsysFunction]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues) {
		if (null != invalidValues && invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysFunctionField gsysFunctionField = GsysFunctionField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysFunctionField) {
					sb.append(gsysFunctionField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					sb.append(invalidValue.getMessage());
				}
			}
			return sb.toString();
		}
		return "";
	}
}
