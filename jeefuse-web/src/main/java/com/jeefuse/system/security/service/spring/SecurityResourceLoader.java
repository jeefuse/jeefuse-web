package com.jeefuse.system.security.service.spring;

import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.web.context.ContextLoader;

import com.jeefuse.base.service.SpringContextUtils;

/**
 * 系统URL资源与相应权限加载.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class SecurityResourceLoader {
	private static String URL_AUTHORITY_MAP = "URL_AUTHORITY_MAP";
	private static Logger logger = LoggerFactory.getLogger(SecurityResourceLoader.class);

	/**
	 * 获取URL资源与相应的权限.
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Collection<ConfigAttribute>> getUrlAuthoritiesMap() {
		ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
		Map<String, Collection<ConfigAttribute>> urlAuthorities = (Map<String, Collection<ConfigAttribute>>) servletContext
				.getAttribute(URL_AUTHORITY_MAP);
		if (null == urlAuthorities) {
			urlAuthorities = getUrlAuthoritiesMap(servletContext);
		}
		return urlAuthorities;
	}

	@SuppressWarnings("unchecked")
	private static synchronized Map<String, Collection<ConfigAttribute>> getUrlAuthoritiesMap(
			ServletContext servletContext) {
		if (null != servletContext.getAttribute(URL_AUTHORITY_MAP))
			return (Map<String, Collection<ConfigAttribute>>) servletContext.getAttribute(URL_AUTHORITY_MAP);
		return initUrlAuthoritiesMap(servletContext);
	}

	/**
	 * 初始化URL资源与相应的权限.
	 */
	public static Map<String, Collection<ConfigAttribute>> initUrlAuthoritiesMap(ServletContext servletContext) {
		servletContext.removeAttribute(URL_AUTHORITY_MAP);
		logger.info("正在初始化URL资源与相应权限...");
		Map<String, Collection<ConfigAttribute>> urlAuthorities = getSystemAuthorizeService(servletContext)
				.urlResourceDefine();
		servletContext.setAttribute(URL_AUTHORITY_MAP, urlAuthorities);
		logger.info("初始化URL资源与相应权限完成!");
		return urlAuthorities;
	}

	/**
	 * 清除URL资源与相应的权限.
	 */
	public static void clearUrlAuthoritiesMap(ServletContext servletContext) {
		servletContext.removeAttribute(URL_AUTHORITY_MAP);
	}

	public static SystemAuthorizeService getSystemAuthorizeService(ServletContext servletContext) {
		return (SystemAuthorizeService) SpringContextUtils.getWebApplicationContext(servletContext).getBean(
				"systemAuthorizeService");
	}
}
