/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.sequence.model.validate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.system.sequence.model.GsysSequence;
import com.jeefuse.system.sequence.model.parse.GsysSequenceField;
/**
 * 序例  validate.
 *
 * @author yonclv
 * @generated
 */
public class GsysSequenceValidate {

	private static ClassValidator<GsysSequence> classValidator = new ClassValidator<GsysSequence>(GsysSequence.class);

	/**
	 * 验证User对象,返回约束违反错误集合.
	 * 
	 */
	static public InvalidValue[] validate(GsysSequence gsysSequence) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysSequence);
		return invalidValues;
	}

	/**
	 * 验证[序例]对象,若出现约束违反错误则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validateWithException(GsysSequence gsysSequence) throws ValidateViolationException {
		InvalidValue[] invalidValues = validate(gsysSequence);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				GsysSequenceField gsysSequenceField = GsysSequenceField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysSequenceField) {
					errors.add(gsysSequenceField.getFieldLabel() + ": " + invalidValue.getMessage());
				} else {
					errors.add(invalidValue.getMessage());
				}
			}
			throw new ValidateViolationException(errors);
		}
	}

	/**
	 * 验证[序例]对象属性,返回约束违反集合.
	 * 
	 */
	static public InvalidValue[] validateProperty(GsysSequence gsysSequence, GsysSequenceField gsysSequenceField) {
		InvalidValue[] invalidValues = classValidator.getInvalidValues(gsysSequence, gsysSequenceField.getFieldName());
		return invalidValues;
	}

	/**
	 * 验证[序例]对象属性,若出现异常则抛出ValidateViolationException异常.
	 * 
	 */
	static public void validatePropertyWithException(GsysSequence gsysSequence, GsysSequenceField gsysSequenceField) throws ValidateViolationException {
		InvalidValue[] invalidValues = validateProperty(gsysSequence, gsysSequenceField);
		if (invalidValues.length > 0) {
			List<String> errors = new ArrayList<String>();
			for (InvalidValue invalidValue : invalidValues) {
				errors.add(gsysSequenceField.getFieldLabel() + ": " + invalidValue.getMessage());
			}
			throw new ValidateViolationException(errors);
		}
	}
	
	/**
	 * 获取[序例]验证失败信息.
	 */
	static public String getValidateMessage(InvalidValue[] invalidValues, String newLineChar) {
		if (invalidValues.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (InvalidValue invalidValue : invalidValues) {
				GsysSequenceField gsysSequenceField = GsysSequenceField.valueOfFieldName(invalidValue.getPropertyName());
				if (null != gsysSequenceField) {
					sb.append(gsysSequenceField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	 * 获取[序例]验证失败信息.设置换行符为<code><</code>br/>.
	 */
	public static String getValidateMessageWithHtmlBR(InvalidValue[] invalidValues) {
		return getValidateMessage(invalidValues, "<br/>");
	}
}
