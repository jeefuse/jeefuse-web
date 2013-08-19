/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.jeefuse.base.modules.imports.ModelImportFactory;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.web.imports.excel.GsysCodeExcelImport;

/**
 * GsysCode 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodeImportFactory {
	public static final String GsysCodeExcelImportTemplateFileName = "GsysCode导入Excel模板文件.xml";
	public static final String GsysCodeExcelImportTemplateDir =  GsysCodeImportFactory.class.getResource("").getPath();
	public static final String GsysCodeExcelImportTemplateFilePath = GsysCodeExcelImportTemplateDir+ GsysCodeExcelImportTemplateFileName;
	public static final String GsysCodeExcelImportTemplateCaption = "GsysCode数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysCode List.
	 * 
	 * @generated
	 */
	public static List<GsysCode> excelToModel(InputStream is) throws IOException {
		GsysCodeExcelImport excelImport = new GsysCodeExcelImport(is);
		List<GsysCode> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysCode> excelToModel(File file) throws IOException {
		InputStream fis = new FileInputStream(file);
		return excelToModel(fis);
	}

	/**
	 * 创建Excel导入文件模板.
	 * @generated
	 */
	private static synchronized File createExcelImportTemplateFile(String filePath,boolean isRecreate) {
		File file = new File(filePath);
		if (!file.exists() || isRecreate) {
			OutputStream fileOS = null;
			try {
				fileOS = new FileOutputStream(file);
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysCodeField.values(),
						GsysCodeExcelImportTemplateCaption);
				fileOS.flush();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (null != fileOS) {
						fileOS.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}


	/**
	 * 获取Excel导入文件模板.
	 * @generated
	 */
	public static File getExcelImportTemplateFile() {
		File file = new File(GsysCodeExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysCodeExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysCode> gsysCodeList = excelToModel(file);
		System.out.println("imports GsysCode size:" + gsysCodeList.size());
	}

}
