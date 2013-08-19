package com.jeefuse.system.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 系统参数常量配置.
 */
public class SystemConstants {

	/**
	 * Action请求后缀.
	 */
	public static final String action_invoke_suffix = ".vhtml";

	/**
	 * 提拱图片访问的域名例表
	 */
	private static List<String> domain_images_list = null;
	static {
		domain_images_list = new ArrayList<String>();
		domain_images_list.add("http://www.jeefuse.com");
	}

	/**
	 * 随机获取图片访问的域名
	 */
	public static String getImagesRandomDomain() {
		return domain_images_list.get(0);
	}
}
