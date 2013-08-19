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
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.model.validate.GsysCodevalueValidate;

/**
 * GsysCodevalue excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueExcelImport extends AbstractExcelImport<GsysCodevalue>{

	/**
	 * construct GsysCodevalueExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysCodevalueExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysCodevalue readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysCodevalue model = new GsysCodevalue();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			String columnName = columnNames[i];
			GsysCodevalueField gsysCodevalueField = GsysCodevalueField.valueOfFieldLabel(columnName);
			if (null == gsysCodevalueField) {
				gsysCodevalueField = GsysCodevalueField.valueOfFieldName(columnName);
			}
			if (null == gsysCodevalueField)
				throw new DataNoExistException("无效例名:" + columnName);
			setModelData(model, cell, gsysCodevalueField);
			InvalidValue[] invalidValues = GsysCodevalueValidate.validateProperty(model, gsysCodevalueField);
			if (invalidValues.length > 0) {
				List<String> errors = new ArrayList<String>();
				for (InvalidValue invalidValue : invalidValues) {
					errors.add(gsysCodevalueField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	private void setModelData(GsysCodevalue model, Cell cell, GsysCodevalueField gsysCodevalueField) {
		switch (gsysCodevalueField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 ID
			 break;
		case name:
			 model.setName(ExcelCheck.getString(cell));//2 name
			 break;
		case value:
			 model.setValue(ExcelCheck.getString(cell));//3 value
			 break;
		case descript:
			 model.setDescript(ExcelCheck.getString(cell));//4 ˵
			 break;	
		}
	}
	
}
