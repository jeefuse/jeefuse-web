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
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.parse.GsysRoleField;
/**
 * GsysRole  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysRoleValidate {

	private static ClassValidator<GsysRole> classValidator = new ClassValidator<GsysRole>(GsysRole.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysRole gsysRole) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysRole);
		return invalidValues;
	}

	/**
	 * 验证User对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysRole gsysRole) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysRole);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysRoleField gsysRoleField = GsysRoleField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysRoleField) {
					errors.add(gsysRoleField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	static public InvalidValue[] validateProperty(GsysRole gsysRole, GsysRoleField gsysRoleField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysRole, gsysRoleField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证User对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysRole gsysRole, GsysRoleField gsysRoleField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysRole, gsysRoleField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysRoleField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
	/**
	 * 获取GsysRole验证失败信息.
	 */
	public static String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (null != invalidValues && invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysRoleField columnField = GsysRoleField.valueOfFieldName(invalidValue.getPropertyName());
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
	 * 获取GsysRole验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}
}
