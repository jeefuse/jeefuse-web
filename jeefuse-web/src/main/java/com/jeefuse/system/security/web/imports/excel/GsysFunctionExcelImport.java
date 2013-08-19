/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.imports.excel;


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
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;
import com.jeefuse.system.security.model.validate.GsysFunctionValidate;

/**
 * GsysFunction excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysFunctionExcelImport extends AbstractExcelImport<GsysFunction>{

	/**
	 * construct GsysFunctionExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysFunctionExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysFunction readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysFunction model = new GsysFunction();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			String columnName = columnNames[i];
			GsysFunctionField gsysFunctionField = GsysFunctionField.valueOfFieldLabel(columnName);
			if (null == gsysFunctionField) {
				gsysFunctionField = GsysFunctionField.valueOfFieldName(columnName);
			}
			if (null == gsysFunctionField)
				throw new DataNoExistException("无效例名:" + columnName);
			setModelData(model, cell, gsysFunctionField);
			InvalidValue[] invalidValues = GsysFunctionValidate.validateProperty(model, gsysFunctionField);
			if (invalidValues.length > 0) {
				List<String> errors = new ArrayList<String>();
				for (InvalidValue invalidValue : invalidValues) {
					errors.add(gsysFunctionField.getFieldLabel() + ": " + invalidValue.getMessage());
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
	private void setModelData(GsysFunction model, Cell cell, GsysFunctionField gsysFunctionField) {
		switch (gsysFunctionField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 ID
			 break;
		case value:
			 model.setValue(ExcelCheck.getString(cell));//2 权限标志
			 break;
		case name:
			 model.setName(ExcelCheck.getString(cell));//3 权限名称
			 break;
		case descript:
			 model.setDescript(ExcelCheck.getString(cell));//4 描述
			 break;
		case type:
			 model.setType(ExcelCheck.getString(cell));//5 权限类型
			 break;
		case url:
			 model.setUrl(ExcelCheck.getString(cell));//6 url
			 break;
		case parentId:
			 model.setParentId(ExcelCheck.getString(cell));//7 上级ID
			 break;
		case validStatus:
			 model.setValidStatus(ExcelCheck.getString(cell));//8 是否有效
			 break;
		case sortNum:
			 model.setSortNum(ExcelCheck.getLong(cell));//9 排序
			 break;
		case layerCode:
			 model.setLayerCode(ExcelCheck.getString(cell));//10 层次编码
			 break;	
		}
	}
	
}
