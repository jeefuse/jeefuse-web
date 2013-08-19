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
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.web.imports.excel.GsysCodevalueExcelImport;

/**
 * GsysCodevalue 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueImportFactory {
	public static final String GsysCodevalueExcelImportTemplateFileName = "GsysCodevalue导入Excel模板文件.xml";
	public static final String GsysCodevalueExcelImportTemplateDir =  GsysCodevalueImportFactory.class.getResource("").getPath();
	public static final String GsysCodevalueExcelImportTemplateFilePath = GsysCodevalueExcelImportTemplateDir+ GsysCodevalueExcelImportTemplateFileName;
	public static final String GsysCodevalueExcelImportTemplateCaption = "GsysCodevalue数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysCodevalue List.
	 * 
	 * @generated
	 */
	public static List<GsysCodevalue> excelToModel(InputStream is) throws IOException {
		GsysCodevalueExcelImport excelImport = new GsysCodevalueExcelImport(is);
		List<GsysCodevalue> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysCodevalue> excelToModel(File file) throws IOException {
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
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysCodevalueField.values(),
						GsysCodevalueExcelImportTemplateCaption);
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
		File file = new File(GsysCodevalueExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysCodevalueExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysCodevalue> gsysCodevalueList = excelToModel(file);
		System.out.println("imports GsysCodevalue size:" + gsysCodevalueList.size());
	}

}
