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
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.ResourceType;
import com.jeefuse.system.security.model.parse.GsysResourceField;

/**
 * GsysResource excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceExcelImport extends AbstractExcelImport<GsysResource>{

	/**
	 * construct GsysResourceExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysResourceExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysResource readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysResource model = new GsysResource();
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
	private void setModelData(GsysResource model, Cell cell, String columnName) {
		GsysResourceField gsysResourceField = GsysResourceField.valueOfFieldLabel(columnName);
		if (null == gsysResourceField) {
			gsysResourceField=GsysResourceField.valueOfFieldName(columnName);
		}
		if (null == gsysResourceField)
			throw new DataNoExistException("invalid field name:" + columnName);
		switch (gsysResourceField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 id
			 break;
		case name:
			 model.setName(ExcelCheck.getString(cell));//2 name
			 break;
		case descript:
			 model.setDescript(ExcelCheck.getString(cell));//3 descript
			 break;
		case value:
			 model.setValue(ExcelCheck.getString(cell));//4 value
			 break;
		case type:
			model.setType(ResourceType.valueOfLabel(ExcelCheck.getString(cell)).getKey());//5 type
			 break;	
		}
	}
	
}
