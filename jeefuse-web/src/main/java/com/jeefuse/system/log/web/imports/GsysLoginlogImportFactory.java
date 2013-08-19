/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.imports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.jeefuse.base.modules.imports.ModelImportFactory;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
import com.jeefuse.system.log.web.imports.excel.GsysLoginlogExcelImport;

/**
 * 登入日志 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysLoginlogImportFactory {
	public static final String GsysLoginlogExcelImportTemplateFileName = "登入日志导入Excel模板文件.xml";
	public static final String GsysLoginlogExcelImportTemplateDir =  GsysLoginlogImportFactory.class.getResource("").getPath();
	public static final String GsysLoginlogExcelImportTemplateFilePath = GsysLoginlogExcelImportTemplateDir+ GsysLoginlogExcelImportTemplateFileName;
	public static final String GsysLoginlogExcelImportTemplateCaption = "登入日志数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysLoginlog List.
	 * 
	 * @generated
	 */
	public static List<GsysLoginlog> excelToModel(InputStream is) throws IOException {
		GsysLoginlogExcelImport excelImport = new GsysLoginlogExcelImport(is);
		List<GsysLoginlog> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysLoginlog> excelToModel(File file) throws IOException {
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
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysLoginlogField.values(),
						GsysLoginlogExcelImportTemplateCaption);
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
		File file = new File(GsysLoginlogExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysLoginlogExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysLoginlog> gsysLoginlogList = excelToModel(file);
		System.out.println("imports GsysLoginlog size:" + gsysLoginlogList.size());
	}

}
