package com.jeefuse.system.config;

/**
 * 系统配置文件.
 * 
 * @author yonclv
 * @email yancanlv@gmail.com
 */
public class SystemConfig {
	private String imageNoFoundUrl;

	public SystemConfig() {
	}

	/**
	 * 图片未找到时的默认地址.
	 */
	public String getImageNoFoundUrl() {
		return imageNoFoundUrl;
	}

	public void setImageNoFoundUrl(String imageNoFoundUrl) {
		this.imageNoFoundUrl = imageNoFoundUrl;
	}


}
