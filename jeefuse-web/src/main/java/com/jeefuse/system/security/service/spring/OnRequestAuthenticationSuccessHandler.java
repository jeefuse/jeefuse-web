package com.jeefuse.system.security.service.spring;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.jeefuse.system.log.service.Applogger;

public class OnRequestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	public OnRequestAuthenticationSuccessHandler() {
		requestCache = new HttpSessionRequestCache();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		if (savedRequest == null) {
			Applogger.login(request, "登录成功!");
			super.onAuthenticationSuccess(request, response, authentication);
			return;
		}
		if (isAlwaysUseDefaultTargetUrl() || StringUtils.hasText(request.getParameter(getTargetUrlParameter()))) {
			Applogger.login(request, "登录成功!");
			requestCache.removeRequest(request, response);
			super.onAuthenticationSuccess(request, response, authentication);
			return;
		} else {
			clearAuthenticationAttributes(request);
			String targetUrl = savedRequest.getRedirectUrl();
			Applogger.login(request, new StringBuilder().append("登录成功!").append("将转向").append(targetUrl).toString());
			logger.debug((new StringBuilder()).append("Redirecting to DefaultSavedRequest Url: ").append(targetUrl)
					.toString());
			getRedirectStrategy().sendRedirect(request, response, targetUrl);
			return;
		}
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private RequestCache requestCache;
}
