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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
/**
 * 操作日志  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogValidate {

	private static ClassValidator<GsysOperatelog> classValidator = new ClassValidator<GsysOperatelog>(GsysOperatelog.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysOperatelog gsysOperatelog) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysOperatelog);
		return invalidValues;
	}

	/**
	 * 验证[操作日志]对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysOperatelog gsysOperatelog) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysOperatelog);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysOperatelogField gsysOperatelogField = GsysOperatelogField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysOperatelogField) {
					errors.add(gsysOperatelogField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					errors.add(invalidValue.getMessage());
				}
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 验证[操作日志]对象属性,返回约束违反集合.
	 * 
	 */
	static public InvalidValue[] validateProperty(GsysOperatelog gsysOperatelog, GsysOperatelogField gsysOperatelogField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysOperatelog, gsysOperatelogField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证[操作日志]对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysOperatelog gsysOperatelog, GsysOperatelogField gsysOperatelogField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysOperatelog, gsysOperatelogField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysOperatelogField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
	/**
	 * 获取[操作日志]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysOperatelogField gsysOperatelogField = GsysOperatelogField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysOperatelogField) {
					sb.append(gsysOperatelogField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	 * 获取[操作日志]验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}
}
