package com.jeefuse.system.session;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户会话属性维护.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class UserSessionHolder {

	/**
	 * 获取会话属性.
	 */
	public static Object getSessionAttr(HttpServletRequest request, SessionConstantKey sessionConstantKey) {
		return request.getSession().getAttribute(sessionConstantKey.getkey());
	}

	/**
	 * 保存会话属性.
	 */
	public static void setSessionAttr(HttpServletRequest request, SessionConstantKey sessionConstantKey, Object value) {
		request.getSession().setAttribute(sessionConstantKey.getkey(), value);
	}

	/**
	 * 删除会话属性.
	 */
	public static void removeSessionAttr(HttpServletRequest request, SessionConstantKey sessionConstantKey) {
		request.getSession().removeAttribute(sessionConstantKey.getkey());
	}

}
