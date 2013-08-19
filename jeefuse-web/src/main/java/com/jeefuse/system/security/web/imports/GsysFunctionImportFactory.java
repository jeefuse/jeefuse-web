/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.jeefuse.base.modules.imports.ModelImportFactory;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;
import com.jeefuse.system.security.web.imports.excel.GsysFunctionExcelImport;

/**
 * GsysFunction 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysFunctionImportFactory {
	public static final String GsysFunctionExcelImportTemplateFileName = "GsysFunction导入Excel模板文件.xml";
	public static final String GsysFunctionExcelImportTemplateDir =  GsysFunctionImportFactory.class.getResource("").getPath();
	public static final String GsysFunctionExcelImportTemplateFilePath = GsysFunctionExcelImportTemplateDir+ GsysFunctionExcelImportTemplateFileName;
	public static final String GsysFunctionExcelImportTemplateCaption = "GsysFunction数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysFunction List.
	 * 
	 * @generated
	 */
	public static List<GsysFunction> excelToModel(InputStream is) throws IOException {
		GsysFunctionExcelImport excelImport = new GsysFunctionExcelImport(is);
		List<GsysFunction> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysFunction> excelToModel(File file) throws IOException {
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
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysFunctionField.values(),
						GsysFunctionExcelImportTemplateCaption);
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
		File file = new File(GsysFunctionExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysFunctionExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysFunction> gsysFunctionList = excelToModel(file);
		System.out.println("imports GsysFunction size:" + gsysFunctionList.size());
	}

}
