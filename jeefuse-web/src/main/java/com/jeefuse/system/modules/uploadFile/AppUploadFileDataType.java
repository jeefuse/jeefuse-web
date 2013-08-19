package com.jeefuse.system.modules.uploadFile;

import com.jeefuse.base.web.uploadFile.UploadFileDataType;

/**
 * 上传文件类型.
 * 
 * @author yonclv
 */
public enum AppUploadFileDataType implements UploadFileDataType {

	/**
	 * 图片
	 */
	image("image", "image"),
	/**
	 * 附件
	 */
	attachfiles("attachfiles", "attachfiles"),
 ;

	private String name;
	private String directory;

	private AppUploadFileDataType(String name, String directory) {
		this.name = name;
		this.directory = directory;
	}

	public String toParam() {
		if (null != this)
			return name;
		return null;
	}

	public static AppUploadFileDataType valueOfParam(String param) {
		for (AppUploadFileDataType item : AppUploadFileDataType.values()) {
			if (item.toParam().equals(param))
				return item;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jeefuse.base.web.uploadFile.UploadFileDataType#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.jeefuse.base.web.uploadFile.UploadFileDataType#getSavedDirectory()
	 */
	public String getSavedDirectory() {
		// TODO Auto-generated method stub
		return directory;
	}
}
