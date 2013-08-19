/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model;

import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.web.component.font.HtmlFont;

/**
 * 激活状态
 * 
 * @author yonclv
 * @generated
 */
public enum ActivatedType {
	/** @generated*/
	VALID("1", "有效"), // 有效
	/** @generated*/
	INVALID("0", "无效")// 无效
	;

	/** @generated */
	private ActivatedType(String key, String label) {
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
	 * @generated
	 */
	public static ActivatedType valueOfKey(String key) {
		if (null == key)
			return INVALID;
		for (ActivatedType item : values()) {
			if (key.equals(item.getKey()))
				return item;
		}
		return INVALID;
	}
	
	/**
	 * 根据label查找对象,若没有找到则返回null.
	 * @generated
	 */
	static public ActivatedType valueOfLabel(String label) {
		if (null == label)
			return INVALID;
		for (ActivatedType item : values()) {
			if (item.getLabel().equals(label))
				return item;
		}
		return INVALID;
	}	

	/**
	 * 转化为以key为键,label为值的Map对象.
	 * @generated
	 */
	static public Map<String, String> toMap;
	/** @generated */
	static {
		toMap = new HashMap<String, String>();
		for (ActivatedType item : values()) {
			toMap.put(item.getKey().toString(), item.getLabel());
		}
	}
	
	/**
	 * 转化为以key为键,label为值并渲染为Html的Map对象.
	 * 
	 * @generated
	 */
	static public Map<String, String> toHtmlMap;
	/** @generated */
	static {
		toHtmlMap = new HashMap<String, String>();
		for (ActivatedType item : values()) {
			toHtmlMap.put(item.getKey().toString(), item.renderHtml());
		}
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
			toHtmlJSON = JsonUtil.mapper.writeValueAsString(toHtmlMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 转化为以key为键,label为值并渲染为Html Select标签.
	 * 
	 * @param checkKey
	 *            已选择的键值
	 * @generated
	 */
	static public String toHtmlSelect(Boolean checkKey) {
		StringBuilder sb = new StringBuilder();
		for (ActivatedType item : values()) {
			sb.append(" <option value=\"" + item.getKey() + "\"");
			if (null != checkKey && item.getKey().equals(checkKey)) {
				sb.append(" selected=\"selected\" ");
			}
			sb.append(renderStyle(item));
			sb.append(">");
			sb.append(item.getLabel());
			sb.append("</option>");
		}
		return sb.toString();
	}

	/** @generated */
	public String renderHtml() {
		return getRenderFont(this).renderHtml(this.getLabel());
	}

	/** @generated */
	static public String renderStyle(ActivatedType item) {
		return getRenderFont(item).renderStyle();
	}

	/** @generated */
	static private HtmlFont getRenderFont(ActivatedType item) {
		switch (item) {
		case VALID:
			return HtmlFont.blue;
		case INVALID:
			return HtmlFont.red;
		}
		return HtmlFont.black;
	}
}
