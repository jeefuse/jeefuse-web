package com.jeefuse.system.security.service.spring;

/**
 * 登录错误类型.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum LoginErrorType {
	/**
	 * 验证码错误.
	 */
	CHECK_CODE_ERROR("1", "验证码错误!"),
	/**
	 * 用户名或密码错误.
	 */
	USERNAME_OR_PASS_ERROR("3", "用户名或密码错误,请重试!"),
	/**
	 * 该用户已从别处登录.
	 */
	LOGGED_ELSEWHERE("6", "该用户已在别处登录!");

	private LoginErrorType(String key, String lable) {
		this.key = key;
		this.label = lable;
	}

	private String key;
	private String label;

	public String getkey() {
		return key;
	}

	public String getLabel() {
		return label;
	}

	public static LoginErrorType valueOfKey(String param) {
		for (LoginErrorType item : LoginErrorType.values()) {
			if (item.getkey().equalsIgnoreCase(param))
				return item;
		}
		return null;
	}
}
