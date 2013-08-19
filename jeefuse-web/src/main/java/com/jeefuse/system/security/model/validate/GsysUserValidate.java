/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model.validate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.model.parse.GsysUserField;
/**
 * GsysUser  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysUserValidate {

	private static ClassValidator<GsysUser> classValidator = new ClassValidator<GsysUser>(GsysUser.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysUser gsysUser) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysUser);
		return invalidValues;
	}

	/**
	 * 验证[GsysUser]对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysUser gsysUser) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysUser);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysUserField gsysUserField = GsysUserField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysUserField) {
					errors.add(gsysUserField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					errors.add(invalidValue.getMessage());
				}
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 验证[GsysUser]对象属性,返回约束违反集合.
	 * 
	 */
	static public InvalidValue[] validateProperty(GsysUser gsysUser, GsysUserField gsysUserField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysUser, gsysUserField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证[GsysUser]对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysUser gsysUser, GsysUserField gsysUserField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysUser, gsysUserField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysUserField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
	/**
	 * 获取[GsysUser]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysUserField gsysUserField = GsysUserField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysUserField) {
					sb.append(gsysUserField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	 * 获取[GsysUser]验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}
}
