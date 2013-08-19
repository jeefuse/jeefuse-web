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
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;
import com.jeefuse.system.security.model.parse.GsysResourceValueGet;

/**
 * GsysResource 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceExportFactory {

	private static final String gsysResourceExcelExportTemplateFileName= "GsysResource数据Excel导出文件";

	public static String getGsysResourceExcelExportTemplateFileName() {
		return gsysResourceExcelExportTemplateFileName + DateUtil.getCurrentDateTimeString();
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysResourceField[] gsysResourceField, Collection<GsysResource> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysResourceField, items,
				new GsysResourceValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysResource> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysResourceField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysResourceField[] gsysResourceField, Collection<GsysResource> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysResourceField, items, new GsysResourceValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysResource> items)
			throws Exception {
		excelExport(response,exportFileName,GsysResourceField.values(),items);
	}

}
