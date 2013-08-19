package com.jeefuse.system.session;

import com.jeefuse.base.model.userType.EnumStringValue;

/**
 * 保存的用户会话属性键名.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public enum SessionConstantKey implements EnumStringValue {
	/**
	 * 购物车
	 */
	SITE_ORDER_CART("SITE_ORDERS_CART"),
	/**
	 * 请求重定向.
	 */
	REQUEST_REDIRECT_URL("REQUEST_REDIRECT_URL"),
	/**
	 *临时注册用户.
	 */
	REGISTER_TEMP_USER("REGISTER_TEMP_USER"),
	/**
	 * 验证码.
	 */
	CHECK_CODE("CHECK_CODE"),
	/**
	 * 用于用户登录时客户端的登录加密摘要.
	 */
	CLIENT_CODE("CLIENT_CODE");

	private SessionConstantKey(String key) {
		this.key = key;
	}

	private String key;

	public String getkey() {
		return key;
	}

	public String getValue() {

		return key;
	}

}
