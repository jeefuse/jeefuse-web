/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.imports.excel;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.validator.InvalidValue;

import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.imports.excel.AbstractExcelImport;
import com.jeefuse.base.modules.imports.excel.utils.ExcelCheck;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
import com.jeefuse.system.log.model.validate.GsysLoginlogValidate;

/**
 * 登入日志 excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysLoginlogExcelImport extends AbstractExcelImport<GsysLoginlog>{

	/**
	 * construct GsysLoginlogExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysLoginlogExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysLoginlog readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysLoginlog model = new GsysLoginlog();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			String columnName = columnNames[i];
			GsysLoginlogField gsysLoginlogField = GsysLoginlogField.valueOfFieldLabel(columnName);
			if (null == gsysLoginlogField) {
				gsysLoginlogField = GsysLoginlogField.valueOfFieldName(columnName);
			}
			if (null == gsysLoginlogField)
				throw new DataNoExistException("无效例名:" + columnName);
			setModelData(model, cell, gsysLoginlogField);
			InvalidValue[] invalidValues = GsysLoginlogValidate.validateProperty(model, gsysLoginlogField);
			if (invalidValues.length > 0) {
				List<String> errors = new ArrayList<String>();
				for (InvalidValue invalidValue : invalidValues) {
					errors.add(gsysLoginlogField.getFieldLabel() + ": " + invalidValue.getMessage());
				}
				throw new ValidateViolationException("第" + (cell.getRowIndex() + 1) + "行,第"
						+ (cell.getColumnIndex() + 1) + "例输入错误!", errors);
			}
		}
		return model;
	}

	/**
	 * populate model property value.
	 * 
	 * @generated
	 */
	private void setModelData(GsysLoginlog model, Cell cell, GsysLoginlogField gsysLoginlogField) {
		switch (gsysLoginlogField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 id
			 break;
		case loginIp:
			 model.setLoginIp(ExcelCheck.getString(cell));//2 登录IP
			 break;
		case createdate:
			 model.setCreatedate(ExcelCheck.getDate(cell));//3 登录时间
			 break;
		case message:
			 model.setMessage(ExcelCheck.getString(cell));//4 信息
			 break;
		case userId:
			 model.setUserId(ExcelCheck.getString(cell));//5 登入用户
			 break;	
		}
	}
	
}
