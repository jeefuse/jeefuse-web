package com.jeefuse.system.security.service.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

public class OnRequestAuthenticationFailureHandler implements AuthenticationFailureHandler {

	public OnRequestAuthenticationFailureHandler() {
		forwardToDestination = false;
		allowSessionCreation = true;
		redirectStrategy = new DefaultRedirectStrategy();
	}

	public OnRequestAuthenticationFailureHandler(String defaultFailureUrl) {
		forwardToDestination = false;
		allowSessionCreation = true;
		redirectStrategy = new DefaultRedirectStrategy();
		setDefaultFailureUrl(defaultFailureUrl);
	}

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (defaultFailureUrl == null) {
//			SysLogger.login(request, "登录失败!No failure URL set, sending 401 Unauthorized error");
			logger.debug("No failure URL set, sending 401 Unauthorized error");
			response.sendError(401, (new StringBuilder()).append("Authentication Failed: ").append(exception.getMessage()).toString());
		} else {
			saveException(request, exception);
			if (forwardToDestination) {
				logger.debug((new StringBuilder()).append("Forwarding to ").append(defaultFailureUrl).toString());
//				SysLogger.login(request, (new StringBuilder()).append("登录失败! 将转向 ").append(defaultFailureUrl).toString());
				request.getRequestDispatcher(defaultFailureUrl).forward(request, response);
			} else {
				logger.debug((new StringBuilder()).append("Redirecting to ").append(defaultFailureUrl).toString());
//				SysLogger.login(request, (new StringBuilder()).append("登录失败! 将转向 ").append(defaultFailureUrl).toString());
				redirectStrategy.sendRedirect(request, response, defaultFailureUrl);
			}
		}
	}

	protected final void saveException(HttpServletRequest request, AuthenticationException exception) {
		if (forwardToDestination) {
			request.setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
		} else {
			HttpSession session = request.getSession(false);
			if (session != null || allowSessionCreation) {
				request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", exception);
			}
		}
	}

	public void setDefaultFailureUrl(String defaultFailureUrl) {
		Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl), (new StringBuilder()).append("'").append(
				defaultFailureUrl).append("' is not a valid redirect URL").toString());
		this.defaultFailureUrl = defaultFailureUrl;
	}

	protected boolean isUseForward() {
		return forwardToDestination;
	}

	public void setUseForward(boolean forwardToDestination) {
		this.forwardToDestination = forwardToDestination;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	protected boolean isAllowSessionCreation() {
		return allowSessionCreation;
	}

	public void setAllowSessionCreation(boolean allowSessionCreation) {
		this.allowSessionCreation = allowSessionCreation;
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private String defaultFailureUrl;
	private boolean forwardToDestination;
	private boolean allowSessionCreation;
	private RedirectStrategy redirectStrategy;

}
