package com.jeefuse.system.security.service.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * spring security访问拒绝处理.若是ajax请求,则返回json提示信息.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class CustomAccessDeniedHandlerImpl implements AccessDeniedHandler {
	/**
	 * 访问拒绝提示信息.
	 */
	public static final String ACCESS_DENIED_MSG = "很抱歉,您还没有访问该资源的权限!";

	public CustomAccessDeniedHandlerImpl() {
	}

	private String errorPage;

	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
			throws ServletException, IOException {
		// 如果是ajax请求
		if (isAjaxRequest(request)) {
			String contentType = "application/json;charset=UTF-8";
			response.setContentType(contentType);
			response.setDateHeader("Expires", 0L);
			response.setHeader("Cache-Control", "no-cache");
			StringBuilder msgsb = new StringBuilder();
			msgsb.append("{\"success\":false," );
			msgsb.append("\"message\":\"").append(ACCESS_DENIED_MSG).append("\",");
			msgsb.append("\"type\":\"").append(AccessDeniedType.AUTHORIZATION_FAILURE.getkey()).append("\"}");
			PrintWriter out = response.getWriter();
			out.print(msgsb.toString());
			out.flush();
			out.close();
		} else {
			if (!response.isCommitted())
				if (errorPage != null) {
					request.setAttribute("SPRING_SECURITY_403_EXCEPTION", accessDeniedException);
					response.setStatus(403);
					RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
					dispatcher.forward(request, response);
				} else {
					response.sendError(403, accessDeniedException.getMessage());
				}
		}
	}

	public void setErrorPage(String errorPage) {
		if (errorPage != null && !errorPage.startsWith("/"))
			throw new IllegalArgumentException("errorPage must begin with '/'");
		else {
			this.errorPage = errorPage;
			return;
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
