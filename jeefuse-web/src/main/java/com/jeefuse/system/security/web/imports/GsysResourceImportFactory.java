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
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;
import com.jeefuse.system.security.web.imports.excel.GsysResourceExcelImport;

/**
 * GsysResource 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceImportFactory {
	public static final String GsysResourceExcelImportTemplateFileName = "GsysResource导入Excel模板文件.xml";
	public static final String GsysResourceExcelImportTemplateDir =  GsysResourceImportFactory.class.getResource("").getPath();
	public static final String GsysResourceExcelImportTemplateFilePath = GsysResourceExcelImportTemplateDir+ GsysResourceExcelImportTemplateFileName;
	public static final String GsysResourceExcelImportTemplateCaption = "GsysResource数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysResource List.
	 * 
	 * @generated
	 */
	public static List<GsysResource> excelToModel(InputStream is) throws IOException {
		GsysResourceExcelImport excelImport = new GsysResourceExcelImport(is);
		List<GsysResource> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysResource> excelToModel(File file) throws IOException {
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
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysResourceField.values(),
						GsysResourceExcelImportTemplateCaption);
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
		File file = new File(GsysResourceExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysResourceExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysResource> gsysResourceList = excelToModel(file);
		System.out.println("imports GsysResource size:" + gsysResourceList.size());
	}

}
