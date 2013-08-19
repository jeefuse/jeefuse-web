package com.jeefuse.system.security.service.spring;

/**
 * 拒绝访问类型.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum AccessDeniedType {
	/**
	 * 用户未登录.
	 */
	NOLOGIN("NO_LOGIN", "用户未登录!"),
	/**
	 * 没有访问资源的权限.
	 */
	AUTHORIZATION_FAILURE("AUTHORIZATION_FAILURE", "您还没有访问该资源的权限!");

	private AccessDeniedType(String key, String msg) {
		this.key = key;
		this.msg = msg;
	}

	final private String key;
	final private String msg;

	public String getkey() {
		return key;
	}

	public String getKey() {
		return key;
	}

	public String getMsg() {
		return msg;
	}

	public static AccessDeniedType valueOfKey(String param) {
		for (AccessDeniedType item : AccessDeniedType.values()) {
			if (item.getkey().equalsIgnoreCase(param))
				return item;
		}
		return null;
	}
}
