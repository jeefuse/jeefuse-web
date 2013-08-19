package com.jeefuse.system.security.service.spring;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 系统URL资源与相应权限初始化与清除.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class SecurityContextLoaderListener implements ServletContextListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		SecurityResourceLoader.initUrlAuthoritiesMap(servletContext);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seejavax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		SecurityResourceLoader.clearUrlAuthoritiesMap(servletContext);
	}

}
