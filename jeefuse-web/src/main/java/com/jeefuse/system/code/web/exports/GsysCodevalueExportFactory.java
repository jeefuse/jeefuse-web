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
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.model.parse.GsysCodevalueValueGet;

/**
 * GsysCodevalue 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueExportFactory {

	private static final String gsysCodevalueExcelExportTemplateFileName= "GsysCodevalue数据Excel导出文件";

	public static String getGsysCodevalueExcelExportTemplateFileName() {
		return gsysCodevalueExcelExportTemplateFileName + DateUtil.getCurrentDateString();
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysCodevalueField[] gsysCodevalueField, Collection<GsysCodevalue> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysCodevalueField, items,
				new GsysCodevalueValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysCodevalue> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysCodevalueField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysCodevalueField[] gsysCodevalueField, Collection<GsysCodevalue> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysCodevalueField, items, new GsysCodevalueValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysCodevalue> items)
			throws Exception {
		excelExport(response,exportFileName,GsysCodevalueField.values(),items);
	}

}
