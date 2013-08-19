/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.exports;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeefuse.base.modules.export.ModelExportFactory;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;
import com.jeefuse.system.param.model.parse.GsysParameterValueGet;

/**
 * GsysParameter 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysParameterExportFactory {

	private static final String gsysParameterExcelExportTemplateFileName= "GsysParameter数据Excel导出文件";

	public static String getGsysParameterExcelExportTemplateFileName() {
		return gsysParameterExcelExportTemplateFileName + DateUtil.getCurrentDateString();
	}
	
	/**
	 * 导出pdf文件.
	 * 
	 * @generated
	 */
	public static void pdfExport(HttpServletRequest request, HttpServletResponse response, String exportFileName,
			GsysParameterField[] gsysParameterField, Collection<GsysParameter> items) throws Exception {
		ModelExportFactory.createPdfExport(request, response, exportFileName, gsysParameterField, items,
				new GsysParameterValueGet()).export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void pdfExportAllField(HttpServletRequest request, HttpServletResponse response,
			String exportFileName, Collection<GsysParameter> items) throws Exception {
		pdfExport(request, response, exportFileName, GsysParameterField.values(), items);
	}

	/**
	 * 导出excel文件.
	 * 
	 * @generated
	 */
	public static void excelExport(HttpServletResponse response, String exportFileName,
			GsysParameterField[] gsysParameterField, Collection<GsysParameter> items) throws Exception {
		ModelExportFactory.createExcelExport(response, exportFileName, gsysParameterField, items, new GsysParameterValueGet())
				.export();
	}

	/**
	 * 导出user所有字段数据.
	 * 
	 * @generated
	 */
	public static void excelExportAllField(HttpServletResponse response, String exportFileName, Collection<GsysParameter> items)
			throws Exception {
		excelExport(response,exportFileName,GsysParameterField.values(),items);
	}

}
