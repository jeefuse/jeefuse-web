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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
import com.jeefuse.system.log.web.imports.excel.GsysOperatelogExcelImport;

/**
 * 操作日志 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogImportFactory {
	public static final String GsysOperatelogExcelImportTemplateFileName = "操作日志导入Excel模板文件.xml";
	public static final String GsysOperatelogExcelImportTemplateDir =  GsysOperatelogImportFactory.class.getResource("").getPath();
	public static final String GsysOperatelogExcelImportTemplateFilePath = GsysOperatelogExcelImportTemplateDir+ GsysOperatelogExcelImportTemplateFileName;
	public static final String GsysOperatelogExcelImportTemplateCaption = "操作日志数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysOperatelog List.
	 * 
	 * @generated
	 */
	public static List<GsysOperatelog> excelToModel(InputStream is) throws IOException {
		GsysOperatelogExcelImport excelImport = new GsysOperatelogExcelImport(is);
		List<GsysOperatelog> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysOperatelog> excelToModel(File file) throws IOException {
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
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysOperatelogField.values(),
						GsysOperatelogExcelImportTemplateCaption);
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
		File file = new File(GsysOperatelogExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysOperatelogExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysOperatelog> gsysOperatelogList = excelToModel(file);
		System.out.println("imports GsysOperatelog size:" + gsysOperatelogList.size());
	}

}
