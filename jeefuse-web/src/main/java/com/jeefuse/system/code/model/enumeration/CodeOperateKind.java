/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.model.enumeration;

import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.web.component.font.HtmlFont;

/**
 * 操作类型
 *
 * @author yonclv
 * @generated
 */
public enum CodeOperateKind {
	/** @generated*/
	READONLY("2","只读"),//菜单
	/** @generated*/
	EDITABLE("1","可编辑")//按钮
	;

	/** @generated */
	private CodeOperateKind(String key, String label) {
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
	public static CodeOperateKind valueOfKey(String key) {
		if (null == key)
			return null;
		for (CodeOperateKind item : values()) {
			if (item.getKey().equals(key))
				return item;
		}
		return null;
	}
	
	/**
	 * 根据label查找对象,若没有找到则返回null.
	 * @generated
	 */
	static public CodeOperateKind valueOfLabel(String label) {
		if (null == label)
			return null;
		for (CodeOperateKind item : values()) {
			if (item.getLabel().equals(label))
				return item;
		}
		return null;
	}	

	/**
	 * 转化为以key为键,label为值的Map对象.
	 * @generated
	 */
	static public Map<String, String> toMap;
	/** @generated */
	static {
		toMap = new HashMap<String, String>();
		for (CodeOperateKind item : values()) {
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
		for (CodeOperateKind item : values()) {
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
			for (CodeOperateKind item : values()) {
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
		case READONLY:
			return HtmlFont.black.renderHtml(READONLY.getLabel());
		case EDITABLE:
			return HtmlFont.blue.renderHtml(EDITABLE.getLabel());
		default:
			return "";
		}
	}
}
