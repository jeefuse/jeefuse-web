package com.jeefuse.system.code.model.enumeration;

import java.util.HashMap;
import java.util.Map;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.keyLabel.KeyLabel;

/**
 * 用户类别.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum LevelKind implements KeyLabel {
	superManager("0", "超级管理员"), manager("1", "系统管理员"), userManager("2", "用户管理员"), member("3", "会员用户"), commonMember(
			"4", "普通用户");

	private String key;
	private String label;


	private LevelKind(String key, String label) {
		this.key = key;
		this.label = label;
	}

	public String getKey() {
		
		return key;
	}

	public String getLabel() {
		
		return label;
	}

	/**
	 * 根据key查找对象,若没有找到则返回null.
	 */
	static public LevelKind valueOfKey(String key) {
		if (null == key)
			return null;
		for (LevelKind item : values()) {
			if (item.getKey().equals(key))
				return item;
		}
		return null;
	}

	/**
	 * 根据label查找对象,若没有找到则返回null.
	 * 
	 */
	static public LevelKind valueOfLabel(String label) {
		if (null == label)
			return null;
		for (LevelKind item : values()) {
			if (item.getLabel().equals(label))
				return item;
		}
		return null;
	}

	/**
	 * 转化为以key为键,label为值的Map对象
	 * 
	 * @generated
	 */
	static public Map<String, String> toMap;
	/** @generated */
	static {
		toMap = new HashMap<String, String>();
		for (LevelKind item : values()) {
			toMap.put(item.getKey(), item.getLabel());
		}
	}

	/**
	 * 以key为键,label为值的Map对象转化为json字符串.
	 * 
	 * @generated
	 */
	static public String toJSON;
	/** @generated */
	static {
		try {
			toJSON = JsonUtil.mapper.writeValueAsString(toMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
