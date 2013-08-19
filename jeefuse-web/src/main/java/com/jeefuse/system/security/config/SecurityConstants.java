package com.jeefuse.system.security.config;

import java.util.ArrayList;
import java.util.List;

public class SecurityConstants {
	/**
	 * 注册用户角色.
	 */
	public static final List<String> registered_user_role_list;

	static {
		//普通用户角色
		registered_user_role_list = new ArrayList<String>();
		//r_user
		registered_user_role_list.add("40282ba02add09dc012add0d8c4c0002");
	}
}
