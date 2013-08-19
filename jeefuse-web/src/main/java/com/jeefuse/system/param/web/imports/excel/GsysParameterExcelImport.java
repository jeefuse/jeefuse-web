/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.imports.excel;


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
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;
import com.jeefuse.system.param.model.validate.GsysParameterValidate;

/**
 * GsysParameter excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysParameterExcelImport extends AbstractExcelImport<GsysParameter>{

	/**
	 * construct GsysParameterExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysParameterExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysParameter readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysParameter model = new GsysParameter();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			String columnName = columnNames[i];
			GsysParameterField gsysParameterField = GsysParameterField.valueOfFieldLabel(columnName);
			if (null == gsysParameterField) {
				gsysParameterField = GsysParameterField.valueOfFieldName(columnName);
			}
			if (null == gsysParameterField)
				throw new DataNoExistException("无效例名:" + columnName);
			setModelData(model, cell, gsysParameterField);
			InvalidValue[] invalidValues = GsysParameterValidate.validateProperty(model, gsysParameterField);
			if (invalidValues.length > 0) {
				List<String> errors = new ArrayList<String>();
				for (InvalidValue invalidValue : invalidValues) {
					errors.add(gsysParameterField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	private void setModelData(GsysParameter model, Cell cell, GsysParameterField gsysParameterField) {
		switch (gsysParameterField) {
		case name:
			 model.setName(ExcelCheck.getString(cell));//1 参数名
			 break;
		case value:
			 model.setValue(ExcelCheck.getString(cell));//2 参数值
			 break;
		case descript:
			 model.setDescript(ExcelCheck.getString(cell));//3 用途说明
			 break;	
		}
	}
	
}
