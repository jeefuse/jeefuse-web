package com.jeefuse.system.security.service.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.TextEscapeUtils;
import org.springframework.util.Assert;

import com.jeefuse.system.session.SessionConstantKey;

/**
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class EnhanceUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
	public EnhanceUsernamePasswordAuthenticationFilter() {
		super("/j_spring_security_check");
		usernameParameter = "j_username";
		passwordParameter = "j_password";
		postOnly = true;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST"))
			throw new AuthenticationServiceException((new StringBuilder()).append(
					"Authentication method not supported: ").append(request.getMethod()).toString());
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		username = username.trim();
		HttpSession session = request.getSession(false);
		String clienCode = null;
		if (session != null || getAllowSessionCreation()) {
			request.getSession()
					.setAttribute("SPRING_SECURITY_LAST_USERNAME", TextEscapeUtils.escapeEntities(username));
			clienCode = (String) request.getSession().getAttribute(SessionConstantKey.CLIENT_CODE.getkey());
		}
		if (clienCode == null) {
			clienCode = "";
		}
		EnhanceUsernamePasswordAuthenticationToken authRequest = new EnhanceUsernamePasswordAuthenticationToken(
				username, password, clienCode);
		setDetails(request, authRequest);
		request.getSession().removeAttribute(SessionConstantKey.CLIENT_CODE.getkey());
		return getAuthenticationManager().authenticate(authRequest);
	}

	protected String obtainPassword(HttpServletRequest request) {
		return request.getParameter(passwordParameter);
	}

	protected String obtainUsername(HttpServletRequest request) {
		return request.getParameter(usernameParameter);
	}

	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
	}

	public void setUsernameParameter(String usernameParameter) {
		Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
		this.usernameParameter = usernameParameter;
	}

	public void setPasswordParameter(String passwordParameter) {
		Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
		this.passwordParameter = passwordParameter;
	}

	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}

	public final String getUsernameParameter() {
		return usernameParameter;
	}

	public final String getPasswordParameter() {
		return passwordParameter;
	}

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "j_username";
	public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "j_password";
	public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";
	private String usernameParameter;
	private String passwordParameter;
	private boolean postOnly;
}
