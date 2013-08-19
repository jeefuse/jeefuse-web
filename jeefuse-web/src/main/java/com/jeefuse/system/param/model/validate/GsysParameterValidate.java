/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.model.validate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;
/**
 * GsysParameter  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysParameterValidate {

	private static ClassValidator<GsysParameter> classValidator = new ClassValidator<GsysParameter>(GsysParameter.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysParameter gsysParameter) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysParameter);
		return invalidValues;
	}

	/**
	 * 验证User对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysParameter gsysParameter) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysParameter);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysParameterField gsysParameterField = GsysParameterField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysParameterField) {
					errors.add(gsysParameterField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	static public InvalidValue[] validateProperty(GsysParameter gsysParameter, GsysParameterField gsysParameterField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysParameter, gsysParameterField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证User对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysParameter gsysParameter, GsysParameterField gsysParameterField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysParameter, gsysParameterField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysParameterField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 获取[系统参数]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysParameterField gsysParameterField = GsysParameterField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysParameterField) {
					sb.append(gsysParameterField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	 * 获取[系统参数]验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}
	
}
