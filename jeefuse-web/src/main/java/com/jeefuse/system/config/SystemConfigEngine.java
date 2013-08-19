package com.jeefuse.system.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 系统配置参数.
 */
public class SystemConfigEngine {
	private static SystemConfig systemConfig;

	private SystemConfigEngine() {
	}

	public static SystemConfig getSystemConfig() {
		if (systemConfig == null) {
			loadSystemConfig();
		}
		return systemConfig;
	}

	private static synchronized void loadSystemConfig() {
		if (null == systemConfig) {
			BeanDefinitionRegistry reg = new DefaultListableBeanFactory();
			PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(reg);
			try {
				reader.loadBeanDefinitions(new ClassPathResource("system-config.properties"));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			BeanFactory factory = (BeanFactory) reg;
			systemConfig = (SystemConfig) factory.getBean("systemConfig");
		}
	}
}
