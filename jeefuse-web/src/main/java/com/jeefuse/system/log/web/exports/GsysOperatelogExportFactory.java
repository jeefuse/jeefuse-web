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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
import com.jeefuse.system.log.model.parse.GsysOperatelogValueGet;

/**
 * 操作日志 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogExportFactory {
	/** @generated */
	private static final String gsysOperatelogExcelExportTemplateFileName= "操作日志数据Excel导出文件";

	/** @generated */
	public static String getGsysOperatelogExcelExportTemplateFileName() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
		return gsysOperatelogExcelExportTemplateFileName + format.format(new Date());
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysOperatelogField[] gsysOperatelogField, Collection<GsysOperatelog> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysOperatelogField, items,
				new GsysOperatelogValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysOperatelog> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysOperatelogField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysOperatelogField[] gsysOperatelogField, Collection<GsysOperatelog> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysOperatelogField, items, new GsysOperatelogValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysOperatelog> items)
			throws Exception {
		excelExport(response,exportFileName,GsysOperatelogField.values(),items);
	}

}
