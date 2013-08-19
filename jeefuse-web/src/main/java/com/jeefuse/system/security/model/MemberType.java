/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.model;

import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.web.component.font.HtmlFont;

/**
 * 用户类别
 * 
 * @author yonclv
 * @generated
 */
public enum MemberType {
	/**
	 * 游客
	 * @generated
	 */
	UNREGISTERED("1", "游客"), // 游客
	/** @generated */
	COMMON_USER("2", "普通用户"), // 商家
	/** @generated */
	MEMBER("3", "会员用户")// 普通用户
	;

	/** @generated */
	private MemberType(String key, String label) {
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
	public static MemberType valueOfKey(String key) {
		if (null == key)
			return null;
		for (MemberType item : values()) {
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
	static public MemberType valueOfLabel(String label) {
		if (null == label)
			return null;
		for (MemberType item : values()) {
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
		for (MemberType item : values()) {
			toMap.put(item.getKey(), item.getLabel());
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
		for (MemberType item : values()) {
			toHtmlMap.put(item.getKey(), item.renderHtml());
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
	static public String toHtmlSelect(String checkKey) {
		StringBuilder sb = new StringBuilder();
		for (MemberType item : values()) {
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
	static public String renderStyle(MemberType item) {
		return getRenderFont(item).renderStyle();
	}

	/** @generated */
	static private HtmlFont getRenderFont(MemberType item) {
		switch (item) {
		case UNREGISTERED:
			return HtmlFont.orange;
		case COMMON_USER:
			return HtmlFont.black;
		case MEMBER:
			return HtmlFont.blue;
		}
		return HtmlFont.black;
	}

}
