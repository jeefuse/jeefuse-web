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
import com.jeefuse.system.code.model.enumeration.EnabledType;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.model.parse.GsysUserField;

/**
 * GsysUser excel导入.
 *
 * @author yonclv
 * @generated
 */
public class GsysUserExcelImport extends AbstractExcelImport<GsysUser>{

	/**
	 * construct GsysUserExcelImport with inputStream.
	 * 
	 * @generated
	 */
	public GsysUserExcelImport(InputStream is) throws IOException {
		super(is);
	}

	/**
	 * populate model.
	 * 
	 * @generated
	 */
	@Override
	protected GsysUser readExcelToModel(Row row, String[] columnNames) {
		if (row == null)
			return null;
		GsysUser model = new GsysUser();
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
	private void setModelData(GsysUser model, Cell cell, String columnName) {
		GsysUserField gsysUserField = GsysUserField.valueOfFieldLabel(columnName);
		if (null == gsysUserField) {
			gsysUserField=GsysUserField.valueOfFieldName(columnName);
		}
		if (null == gsysUserField)
			throw new DataNoExistException("invalid field name:" + columnName);
		switch (gsysUserField) {
		case id:
			 model.setId(ExcelCheck.getString(cell));//1 id
			 break;
		case username:
			 model.setUsername(ExcelCheck.getString(cell));//2 username
			 break;
		case createTime:
			 model.setCreateTime(ExcelCheck.getDate(cell));//3 createTime
			 break;
		case email:
			 model.setEmail(ExcelCheck.getString(cell));//4 email
			 break;
		case enabled:
			 model.setEnabled(EnabledType.valueOfLabel(ExcelCheck.getString(cell)).getKey());//5 enabled
			 break;
		case level:
			 model.setLevel(ExcelCheck.getString(cell));//6 level
			 break;
		case loginName:
			 model.setLoginName(ExcelCheck.getString(cell));//7 loginName
			 break;
		case password:
			 model.setPassword(ExcelCheck.getString(cell));//9 password
			 break;
		case remark:
			 model.setRemark(ExcelCheck.getString(cell));//10 remark
			 break;
		case sex:
			 model.setSex(ExcelCheck.getString(cell));//11 sex
			 break;
		case telephone:
			 model.setTelephone(ExcelCheck.getString(cell));//12 telephone
			 break;
		case updateTime:
			 model.setUpdateTime(ExcelCheck.getDate(cell));//13 updateTime
			 break;
		case lastLoginTime:
			 model.setLastLoginTime(ExcelCheck.getDate(cell));//14 lastLoginTime
			 break;	
		}
	}
	
}
