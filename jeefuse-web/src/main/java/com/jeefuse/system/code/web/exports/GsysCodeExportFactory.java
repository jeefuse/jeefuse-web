/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.exports;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.modules.export.ModelExportFactory;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.model.parse.GsysCodeValueGet;

/**
 * GsysCode 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodeExportFactory {

	private static final String gsysCodeExcelExportTemplateFileName= "GsysCode数据Excel导出文件";

	public static String getGsysCodeExcelExportTemplateFileName() {
		return gsysCodeExcelExportTemplateFileName + DateUtil.getCurrentDateString();
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysCodeField[] gsysCodeField, Collection<GsysCode> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysCodeField, items,
				new GsysCodeValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysCode> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysCodeField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysCodeField[] gsysCodeField, Collection<GsysCode> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysCodeField, items, new GsysCodeValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysCode> items)
			throws Exception {
		excelExport(response,exportFileName,GsysCodeField.values(),items);
	}

}
