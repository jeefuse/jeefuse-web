/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.imports.excel;


import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.jeefuse.base.exception.DataNoExistException;
import com.jeefuse.base.modules.imports.excel.AbstractExcelImport;
import com.jeefuse.base.modules.imports.excel.utils.ExcelCheck;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.parse.GsysRoleField;

/**
 * GsysRole excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysRoleExcelImport extends AbstractExcelImport<GsysRole>{

	/**
	 * construct GsysRoleExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysRoleExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysRole readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysRole model = new GsysRole();
		int cellLenght = columnNames.length;
		Cell cell = null;
		for (int i = 0; i < cellLenght; i++) {
			cell = row.getCell(i);
			setModelData(model, cell, columnNames[i]);
		}
		return model;
	}

	/**
	 * populate model property value.
	 * 
	 * @generated
	 */
	private void setModelData(GsysRole model, Cell cell, String columnName) {
		GsysRoleField gsysRoleField = GsysRoleField.valueOfFieldLabel(columnName);
		if (null == gsysRoleField) {
			gsysRoleField=GsysRoleField.valueOfFieldName(columnName);
		}
		if (null == gsysRoleField)
			throw new DataNoExistException("invalid field name:" + columnName);
		switch (gsysRoleField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 id
			 break;
		case name:
			 model.setName(ExcelCheck.getString(cell));//2 name
			 break;
		case displayName:
			 model.setDisplayName(ExcelCheck.getString(cell));//3 displayName
			 break;
		case descript:
			 model.setDescript(ExcelCheck.getString(cell));//4 descript
			 break;	
		}
	}
	
}
