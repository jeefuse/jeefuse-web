/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model.validate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
/**
 * 登入日志  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysLoginlogValidate {

	private static ClassValidator<GsysLoginlog> classValidator = new ClassValidator<GsysLoginlog>(GsysLoginlog.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysLoginlog gsysLoginlog) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysLoginlog);
		return invalidValues;
	}

	/**
	 * 验证[登入日志]对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysLoginlog gsysLoginlog) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysLoginlog);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysLoginlogField gsysLoginlogField = GsysLoginlogField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysLoginlogField) {
					errors.add(gsysLoginlogField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					errors.add(invalidValue.getMessage());
				}
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 验证[登入日志]对象属性,返回约束违反集合.
	 * 
	 */
	static public InvalidValue[] validateProperty(GsysLoginlog gsysLoginlog, GsysLoginlogField gsysLoginlogField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysLoginlog, gsysLoginlogField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证[登入日志]对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysLoginlog gsysLoginlog, GsysLoginlogField gsysLoginlogField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysLoginlog, gsysLoginlogField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysLoginlogField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
	/**
	 * 获取[登入日志]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysLoginlogField gsysLoginlogField = GsysLoginlogField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysLoginlogField) {
					sb.append(gsysLoginlogField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	 * 获取[登入日志]验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}
}
