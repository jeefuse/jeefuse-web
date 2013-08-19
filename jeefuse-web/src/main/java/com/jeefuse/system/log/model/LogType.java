/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.model;

import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.web.component.font.HtmlFont;

/**
 * 日志记录类型
 * 
 * @author yonclv
 * @generated
 */
public enum LogType {
	/**
	 * 应用异常
	 * 
	 * @generated
	 */
	APP_ERROR("error", "应用异常"),
	/**
	 * 跟踪
	 * 
	 * @generated
	 */
	TRACE("跟踪", "跟踪"), /**
	 * 信息
	 * 
	 * @generated
	 */
	INFO("info", "信息"), /**
	 * 警告
	 * 
	 * @generated
	 */
	WARN("warn", "警告"), /**
	 * 系统异常
	 * 
	 * @generated
	 */
	SYS_ERROR("fatal", "系统异常")

	;

	/** @generated */
	private LogType(String key, String label) {
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
	public static LogType valueOfKey(String key) {
		if (null == key)
			return null;
		for (LogType item : values()) {
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
	static public LogType valueOfLabel(String label) {
		if (null == label)
			return null;
		for (LogType item : values()) {
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
		for (LogType item : values()) {
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
		for (LogType item : values()) {
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
		for (LogType item : values()) {
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
	static public String renderStyle(LogType item) {
		return getRenderFont(item).renderStyle();
	}

	/** @generated */
	static private HtmlFont getRenderFont(LogType item) {
		switch (item) {
		case APP_ERROR:
			return HtmlFont.red;
		case TRACE:
			return HtmlFont.black;
		case INFO:
			return HtmlFont.blue;
		case WARN:
			return HtmlFont.pink;
		case SYS_ERROR:
			return HtmlFont.purple;
		}
		return HtmlFont.black;
	}

	/**
	 * 获取日志顺序号.
	 */
	static public int getIndex(LogType logType) {
		switch (logType) {
		case TRACE:
			return 1;
		case INFO:
			return 2;
		case WARN:
			return 3;
		case APP_ERROR:
			return 4;
		case SYS_ERROR:
			return 5;
		default:
			return 1;
		}
	}
}
