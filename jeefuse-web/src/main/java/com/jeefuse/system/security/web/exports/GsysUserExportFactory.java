/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.exports;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.modules.export.ModelExportFactory;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.model.parse.GsysUserField;
import com.jeefuse.system.security.model.parse.GsysUserValueGet;

/**
 * GsysUser 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysUserExportFactory {

	private static final String gsysUserExcelExportTemplateFileName= "GsysUser数据Excel导出文件";

	public static String getGsysUserExcelExportTemplateFileName() {
		return gsysUserExcelExportTemplateFileName + DateUtil.getCurrentDateTimeString();
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysUserField[] gsysUserField, Collection<GsysUser> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysUserField, items,
				new GsysUserValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysUser> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysUserField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysUserField[] gsysUserField, Collection<GsysUser> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysUserField, items, new GsysUserValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysUser> items)
			throws Exception {
		excelExport(response,exportFileName,GsysUserField.values(),items);
	}

}
