/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.imports.excel;


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
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.enumeration.CodeOperateKind;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.model.validate.GsysCodeValidate;

/**
 * GsysCode excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodeExcelImport extends AbstractExcelImport<GsysCode>{

	/**
	 * construct GsysCodeExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysCodeExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysCode readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysCode model = new GsysCode();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			String columnName = columnNames[i];
			GsysCodeField gsysCodeField = GsysCodeField.valueOfFieldLabel(columnName);
			if (null == gsysCodeField) {
				gsysCodeField = GsysCodeField.valueOfFieldName(columnName);
			}
			if (null == gsysCodeField)
				throw new DataNoExistException("无效例名:" + columnName);
			setModelData(model, cell, gsysCodeField);
			InvalidValue[] invalidValues = GsysCodeValidate.validateProperty(model, gsysCodeField);
			if (invalidValues.length > 0) {
				List<String> errors = new ArrayList<String>();
				for (InvalidValue invalidValue : invalidValues) {
					errors.add(gsysCodeField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	private void setModelData(GsysCode model, Cell cell, GsysCodeField gsysCodeField) {
		switch (gsysCodeField) {
		case cid:
			 model.setCid(ExcelCheck.getString(cell));//1 cid
			 break;
		case name:
			 model.setName(ExcelCheck.getString(cell));//2 name
			 break;
		case descript:
			 model.setDescript(ExcelCheck.getString(cell));//3 ˵
			 break;
		case kind:
			CodeOperateKind codeOperateKind = CodeOperateKind.valueOfLabel(ExcelCheck.getString(cell));
			if (null != codeOperateKind) {
				model.setKind(codeOperateKind.getKey());//4 kind
			} else {
				model.setKind(null);
			}
			 break;	
		}
	}
	
}
