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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.LogType;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
import com.jeefuse.system.log.model.validate.GsysOperatelogValidate;

/**
 * 操作日志 excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogExcelImport extends AbstractExcelImport<GsysOperatelog>{

	/**
	 * construct GsysOperatelogExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysOperatelogExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysOperatelog readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysOperatelog model = new GsysOperatelog();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			String columnName = columnNames[i];
			GsysOperatelogField gsysOperatelogField = GsysOperatelogField.valueOfFieldLabel(columnName);
			if (null == gsysOperatelogField) {
				gsysOperatelogField = GsysOperatelogField.valueOfFieldName(columnName);
			}
			if (null == gsysOperatelogField)
				throw new DataNoExistException("无效例名:" + columnName);
			setModelData(model, cell, gsysOperatelogField);
			InvalidValue[] invalidValues = GsysOperatelogValidate.validateProperty(model, gsysOperatelogField);
			if (invalidValues.length > 0) {
				List<String> errors = new ArrayList<String>();
				for (InvalidValue invalidValue : invalidValues) {
					errors.add(gsysOperatelogField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	private void setModelData(GsysOperatelog model, Cell cell, GsysOperatelogField gsysOperatelogField) {
		switch (gsysOperatelogField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 id
			 break;
		case loginIp:
			 model.setLoginIp(ExcelCheck.getString(cell));//2 登录IP
			 break;
		case createdate:
			 model.setCreatedate(ExcelCheck.getDate(cell));//3 创建时间
			 break;
		case message:
			 model.setMessage(ExcelCheck.getString(cell));//4 信息
			 break;
		case userId:
			 model.setUserId(ExcelCheck.getString(cell));//5 操作用户
			 break;
		case kind:
			LogType logType = LogType.valueOfLabel(ExcelCheck.getString(cell));
			if (null != logType) {
				model.setKind(logType.getKey());//6 类型
			} else {
				model.setKind(null);
			}
			 break;
		case detail:
			 model.setDetail(ExcelCheck.getString(cell));//7 详细说明
			 break;	
		}
	}
	
}
