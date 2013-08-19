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
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;
import com.jeefuse.system.security.model.parse.GsysFunctionValueGet;

/**
 * GsysFunction 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysFunctionExportFactory {

	private static final String gsysFunctionExcelExportTemplateFileName= "GsysFunction数据Excel导出文件";

	public static String getGsysFunctionExcelExportTemplateFileName() {
		return gsysFunctionExcelExportTemplateFileName + DateUtil.getCurrentDateString();
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysFunctionField[] gsysFunctionField, Collection<GsysFunction> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysFunctionField, items,
				new GsysFunctionValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysFunction> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysFunctionField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysFunctionField[] gsysFunctionField, Collection<GsysFunction> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysFunctionField, items, new GsysFunctionValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysFunction> items)
			throws Exception {
		excelExport(response,exportFileName,GsysFunctionField.values(),items);
	}

}
