package com.jeefuse.system.security.service.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

/**
 * 未登录切入点,若是ajax请求,则返回json格式的登录提示信息.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class CustomLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
	private static final Log logger = LogFactory.getLog(CustomLoginUrlAuthenticationEntryPoint.class);
	/**
	 * 未登录提示信息.
	 */
	public static final String NOLOGIN_MSG = "您还未登录或当前会话已过期!请您登录后操作.谢谢!";

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = request;
		HttpServletResponse httpResponse = response;
		String redirectUrl = null;
		// 非ajax请求
		if (!isAjaxRequest(httpRequest)) {

			if (this.isUseForward()) {

				if (this.isForceHttps() && "http".equals(request.getScheme())) {
					// First redirect the current request to HTTPS.
					// When that request is received, the forward to the login
					// page will be used.
					redirectUrl = buildHttpsRedirectUrlForRequest(httpRequest);
				}

				if (redirectUrl == null) {
					String loginForm = determineUrlToUseForThisRequest(httpRequest, httpResponse, authException);

					if (logger.isDebugEnabled()) {
						logger.debug("Server side forward to: " + loginForm);
					}

					RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(loginForm);

					dispatcher.forward(request, response);

					return;
				}
			} else {
				// redirect to login page. Use https if forceHttps true
				redirectUrl = buildRedirectUrlToLoginPage(httpRequest, httpResponse, authException);
			}

			redirectStrategy.sendRedirect(httpRequest, httpResponse, redirectUrl);
		} else {
			// ajax请求，返回json，替代redirect到login page
			if (logger.isDebugEnabled()) {
				logger.debug("ajax request need login. url:" + request.getRequestURI());
			}
			String contentType = "application/json;charset=UTF-8";
			response.setContentType(contentType);
			response.setDateHeader("Expires", 0L);
			response.setHeader("Cache-Control", "no-cache");
			redirectUrl = buildRedirectUrlToLoginPage(httpRequest, httpResponse, authException);
			StringBuilder msgsb = new StringBuilder();
			msgsb.append("{\"success\":false,");
			msgsb.append("\"message\":\"").append(NOLOGIN_MSG).append("立即<a href='").append(redirectUrl).append("' target='_top'>登录</a>")
					.append("\",");
			msgsb.append("\"type\":\"").append(AccessDeniedType.AUTHORIZATION_FAILURE.getkey()).append("\"}");
			PrintWriter out = response.getWriter();
			out.print(msgsb.toString());
			out.flush();
			out.close();
		}
	}

	/**
	 * 判断是否为Ajax请求
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return 是true, 否false
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		String requestType = request.getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(requestType))
			return true;
		else
			return false;
	}

}
