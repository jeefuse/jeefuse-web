/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.exports;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.modules.export.ModelExportFactory;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.parse.GsysRoleField;
import com.jeefuse.system.security.model.parse.GsysRoleValueGet;

/**
 * GsysRole 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysRoleExportFactory {

	private static final String gsysRoleExcelExportTemplateFileName= "GsysRole数据Excel导出文件";

	public static String getGsysRoleExcelExportTemplateFileName() {
		return gsysRoleExcelExportTemplateFileName + new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysRoleField[] gsysRoleField, Collection<GsysRole> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysRoleField, items,
				new GsysRoleValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysRole> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysRoleField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysRoleField[] gsysRoleField, Collection<GsysRole> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysRoleField, items, new GsysRoleValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysRole> items)
			throws Exception {
		excelExport(response,exportFileName,GsysRoleField.values(),items);
	}

}
