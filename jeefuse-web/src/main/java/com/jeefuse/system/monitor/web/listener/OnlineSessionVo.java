package com.jeefuse.system.monitor.web.listener;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.system.security.service.spring.SecurityHolder;


public class OnlineSessionVo {

	private HttpSession session;

	public OnlineSessionVo(HttpSession session) {
		this.session = session;
	}

	public String getSessionId() {
		return session.getId();
	}


	public String getUserId() {
		return SecurityHolder.getLoginUserName();
	}


	public long getCreateDate() {
		return session.getCreationTime();
	}

	public String getCreateDateCn() {
		long createDate = getCreateDate();
		if(createDate>0){
			Calendar calendar=Calendar.getInstance();
			calendar.setTimeInMillis(createDate);
			java.util.Date date = calendar.getTime();
			return DateUtil.formatDateTime(date);
		}
		return null;
	}

	public long getLastAccessedTime() {
		return session.getLastAccessedTime();

	}

	public String getLastAccessedTimeCn() {
		long tempDate = getLastAccessedTime();
		if (tempDate > 0) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(tempDate);
			java.util.Date date = calendar.getTime();
			return DateUtil.formatDateTime(date);
		}
		return null;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}


}
