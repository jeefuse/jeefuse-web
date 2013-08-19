/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import com.jeefuse.base.service.SpringContextUtils;
import com.jeefuse.system.security.service.impl.GsysFunctionServiceImpl;
import com.jeefuse.system.security.service.impl.GsysRelRoleFunctionServiceImpl;
import com.jeefuse.system.security.service.impl.GsysRelRoleResourceServiceImpl;
import com.jeefuse.system.security.service.impl.GsysRelUserRoleServiceImpl;
import com.jeefuse.system.security.service.impl.GsysResourceServiceImpl;
import com.jeefuse.system.security.service.impl.GsysRoleServiceImpl;
import com.jeefuse.system.security.service.impl.GsysUserServiceImpl;
import com.jeefuse.system.security.service.spring.SystemAuthorizeService;

/**
 * security 服务工厂.
 *
 * @author yonclv
 * @generated
 */
public class SecurityServiceFactory{

	/**
	 * 获取GsysFunction CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysFunctionService getGsysFunctionService() {
		return (GsysFunctionService) SpringContextUtils.getBean(GsysFunctionServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取GsysRelRoleFunction CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysRelRoleFunctionService getGsysRelRoleFunctionService() {
		return (GsysRelRoleFunctionService) SpringContextUtils.getBean(GsysRelRoleFunctionServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取GsysRelRoleResource CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysRelRoleResourceService getGsysRelRoleResourceService() {
		return (GsysRelRoleResourceService) SpringContextUtils.getBean(GsysRelRoleResourceServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取GsysRelUserRole CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysRelUserRoleService getGsysRelUserRoleService() {
		return (GsysRelUserRoleService) SpringContextUtils.getBean(GsysRelUserRoleServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取GsysResource CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysResourceService getGsysResourceService() {
		return (GsysResourceService) SpringContextUtils.getBean(GsysResourceServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取GsysRole CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysRoleService getGsysRoleService() {
		return (GsysRoleService) SpringContextUtils.getBean(GsysRoleServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取GsysUser CRUD 服务.
	 * 
	 * @generated
	 */
	public static GsysUserService getGsysUserService() {
		return (GsysUserService) SpringContextUtils.getBean(GsysUserServiceImpl.SERVICE_ID);
	}

	/**
	 * 获取系统权限服务.
	 * 
	 */
	public final static SystemAuthorizeService getSystemAuthorizeService() {
		return (SystemAuthorizeService) SpringContextUtils.getBean("systemAuthorizeService");
	}
	
}
