/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.exports;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.modules.export.ModelExportFactory;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
import com.jeefuse.system.log.model.parse.GsysLoginlogValueGet;

/**
 * 登入日志 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysLoginlogExportFactory {
	/** @generated */
	private static final String gsysLoginlogExcelExportTemplateFileName= "登入日志数据Excel导出文件";

	/** @generated */
	public static String getGsysLoginlogExcelExportTemplateFileName() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		return gsysLoginlogExcelExportTemplateFileName + format.format(new Date());
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysLoginlogField[] gsysLoginlogField, Collection<GsysLoginlog> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysLoginlogField, items,
				new GsysLoginlogValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysLoginlog> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysLoginlogField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysLoginlogField[] gsysLoginlogField, Collection<GsysLoginlog> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysLoginlogField, items, new GsysLoginlogValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysLoginlog> items)
			throws Exception {
		excelExport(response,exportFileName,GsysLoginlogField.values(),items);
	}

}
