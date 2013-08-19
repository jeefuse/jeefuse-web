/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import java.util.List;

import com.jeefuse.base.service.GenericService;
import com.jeefuse.system.security.model.GsysRelUserRole;
import com.jeefuse.system.security.model.GsysUser;

/**
 * GsysRelUserRole Entity CRUD service.
 * 
 * @author yonclv
 * @generated
 */
public interface GsysRelUserRoleService extends GenericService<GsysRelUserRole, String> {

	/**
	 * 判断用户是否有角色.
	 */
	public boolean isGsysUserHasRelGsysRole(String userId, String roleId);

	/**
	 * 获取用户关联的角色Id例表.
	 */
	public List<String> getRelGsysRoleIdsByGsysUserId(String gsysUserId);

	/**
	 * 删除原来用户与角色的关联,并保存新的用户与角色的关联.
	 */
	public void checkGsysUserRelGsysRole(GsysUser gsysUser, List<String> relGsysRoleIdList);

	/**
	 * 添加新的角色.
	 */
	public void addNewRole(GsysUser gsysUser, List<String> relGsysRoleCheckIdList);

}
