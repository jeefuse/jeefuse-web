/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model;

import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.web.component.font.HtmlFont;

/**
 * 功能类型
 * 
 * @author yonclv
 * @generated
 */
public enum FunctionType implements KeyLabel {
	/** @generated */
	URL("url", "链接(URL)"), // 链接地址(URL)
	/** @generated */
	MENU("menu", "菜单"), // 菜单
	/** @generated */
	WEBSERVICE("webService", "webService服务"), // WebService
	/** @generated */
	BUTTON("btn", "按钮"), // 按钮
	/** @generated */
	SYSTEM("sys", "系统")// 系统
	;

	/** @generated */
	private FunctionType(String key, String label) {
		this.key = key;
		this.label = label;
	}

	/** @generated */
	private final String key;
	/** @generated */
	private final String label;

	/** @generated */
	public String getKey() {
		return key;
	}

	/** @generated */
	public String getLabel() {
		return label;
	}

	/**
	 * 根据key查找对象,若没有找到则返回null.
	 * 
	 * @generated
	 */
	public static FunctionType valueOfKey(String key) {
		if (null == key)
			return null;
		for (FunctionType item : values()) {
			if (item.getKey().equals(key))
				return item;
		}
		return null;
	}

	/**
	 * 根据label查找对象,若没有找到则返回null.
	 * 
	 * @generated
	 */
	static public FunctionType valueOfLabel(String label) {
		if (null == label)
			return null;
		for (FunctionType item : values()) {
			if (item.getLabel().equals(label))
				return item;
		}
		return null;
	}

	/**
	 * 转化为以key为键,label为值的Map对象.
	 * 
	 * @generated
	 */
	static public Map<String, String> toMap;
	/** @generated */
	static {
		toMap = new HashMap<String, String>();
		for (FunctionType item : values()) {
			toMap.put(item.getKey(), item.getLabel());
		}
	}

	/**
	 * 转化为以key为键,label为值并渲染为Html Select标签.
	 * 
	 * @generated
	 */
	static public String toHtmlSelect(String checkKey) {
		StringBuilder sb = new StringBuilder();
		for (FunctionType item : values()) {
			sb.append(" <option value=\"" + item.getKey() + "\"");
			if (null != checkKey && item.getKey().equals(checkKey)) {
				sb.append(" selected=\"selected\" ");
			}
			sb.append(">");
			sb.append(item.renderHtml());
			sb.append("</option>");
		}
		return sb.toString();
	}

	/**
	 * 以key为键,label为值的Map对象转化为json字符串.
	 * 
	 * @generated
	 */
	static public String toHtmlJSON;
	/** @generated */
	static {
		try {
			Map<String, String> toHtmlMap = new HashMap<String, String>();
			for (FunctionType item : values()) {
				toHtmlMap.put(item.getKey(), item.renderHtml());
			}
			toHtmlJSON = JsonUtil.mapper.writeValueAsString(toHtmlMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** @generated */
	public String renderHtml() {
		switch (this) {
		case URL:
			return HtmlFont.darkGray.renderHtml(URL.getLabel());
		case MENU:
			return HtmlFont.blue.renderHtml(MENU.getLabel());
		case WEBSERVICE:
			return HtmlFont.gray.renderHtml(WEBSERVICE.getLabel());
		case BUTTON:
			return HtmlFont.black.renderHtml(BUTTON.getLabel());
		case SYSTEM:
			return HtmlFont.cyan.renderHtml(SYSTEM.getLabel());
		default:
			return "";
		}
	}
}
