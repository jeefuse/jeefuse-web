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
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.model.parse.GsysUserField;
import com.jeefuse.system.security.web.imports.excel.GsysUserExcelImport;

/**
 * GsysUser 数据导入工厂.
 *
 * @author yonclv
 * @generated
 */
public class GsysUserImportFactory {
	public static final String GsysUserExcelImportTemplateFileName = "GsysUser导入Excel模板文件.xml";
	public static final String GsysUserExcelImportTemplateDir =  GsysUserImportFactory.class.getResource("").getPath();
	public static final String GsysUserExcelImportTemplateFilePath = GsysUserExcelImportTemplateDir+ GsysUserExcelImportTemplateFileName;
	public static final String GsysUserExcelImportTemplateCaption = "GsysUser数据Excel导入";
	
	/**
	 * excel文件流转化为 GsysUser List.
	 * 
	 * @generated
	 */
	public static List<GsysUser> excelToModel(InputStream is) throws IOException {
		GsysUserExcelImport excelImport = new GsysUserExcelImport(is);
		List<GsysUser> importList = excelImport.importToModel();
		return importList;
	}
	
	/**
	 * excel文件导入.
	 * @generated
	 */
	public static List<GsysUser> excelToModel(File file) throws IOException {
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
				ModelImportFactory.outExcelImportTemplateStream(fileOS, GsysUserField.values(),
						GsysUserExcelImportTemplateCaption);
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
		File file = new File(GsysUserExcelImportTemplateFilePath);
		return file;
	}

	/**
	 * 测试创建Excel导入文件模板.
	 * @generated
	 */
	public static void main(String[] args) throws IOException {
		// create excel import file template
		File file = createExcelImportTemplateFile(GsysUserExcelImportTemplateFilePath, false);
		System.out.println("file is exists:" + file.exists() + " filePath:" + file.getAbsolutePath());

		// excute import excel File to model
		List<GsysUser> gsysUserList = excelToModel(file);
		System.out.println("imports GsysUser size:" + gsysUserList.size());
	}

}
