package com.jeefuse.system.security.model;

public class EmailAndMobile {

	private String email;
	private String mobile;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailProtected() {
		if(null!=email){
			String[] strs = email.split("@");
			int prefixLen = strs[0].length();
			if(prefixLen>3) {
				String result = strs[0].replace(strs[0].substring(prefixLen / 3, 2 * (prefixLen / 3)), "***");
				if (strs.length > 1)
					return result + "@" + strs[1];
				return result;
			}
		}
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobileProtected() {
		if (null != mobile) {
			int len = mobile.length();
			if (len > 9)
				return mobile.substring(0, 4) + "***" + mobile.substring(8, mobile.length());
		}
		return mobile;
	}
}
