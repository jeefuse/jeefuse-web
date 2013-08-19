package com.jeefuse.system.monitor.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 在线会话统计.
 * 
 * @author <a href="mailto:yancanlv@gmail.com">lyc</a>
 */
public class OnlineSessionListener implements HttpSessionListener{
	private static int sessionCounter = 0;
	private static Map<String, OnlineSessionVo> onlineSessionMap = new HashMap<String, OnlineSessionVo>();

	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		OnlineSessionVo sessionVo = new OnlineSessionVo(session);
		onlineSessionMap.put(session.getId(), sessionVo);
		sessionCounter++;   
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		onlineSessionMap.remove(session.getId());
		sessionCounter--;
	}

	public static int getSessionCounter() {
		return sessionCounter;
	}

	public static Map<String, OnlineSessionVo> getOnlineSessionMap() {
		return onlineSessionMap;
	}

}
