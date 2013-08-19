package com.jeefuse.system.security.service.spring;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SuppressWarnings("serial")
public class EnhanceUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {

	public EnhanceUsernamePasswordAuthenticationToken(Object principal, Object credentials, String dynamicCode) {
		super(principal, credentials);
		this.dynamicCode = dynamicCode;
		setAuthenticated(false);
	}

	public String getDynamicCode() {
		return dynamicCode;
	}

	public void setDynamicCode(String dynamicCode) {
		this.dynamicCode = dynamicCode;
	}

	private String dynamicCode;
}
