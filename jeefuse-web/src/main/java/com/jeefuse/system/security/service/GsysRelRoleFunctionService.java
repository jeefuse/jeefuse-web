/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import java.util.List;

import com.jeefuse.base.service.GenericService;
import com.jeefuse.system.security.model.GsysRelRoleFunction;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRelRoleFunction Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysRelRoleFunctionService extends GenericService<GsysRelRoleFunction, String> {

	/**
	 * 删除角色所有关联功能,并保存新的关联功能.
	 */
	public void checkGsysRoleRelGsysFunction(final GsysRole gsysRole, final String... functionIds);

	/**
	 * 判断角色是否有关联功能.
	 */
	public boolean isGsysRoleHasRelGsysFunction(String roleId, String functionId);

	/**
	 * 获取角色关联的功能Id例表.
	 * 
	 * @param gsysRoleId
	 *            角色ID
	 */
	public List<String> getRelGsysFunctionIdsByGsysRoleId(String gsysRoleId);

	/**
	 * 获取角色关联的功能Id例表.
	 */
	public List<String> getRelGsysFunctionIdsByGsysRoleId(List<String> gsysRoleIdList);

	/**
	 * 获取功能关联的角色Id例表.
	 */
	public List<String> getRelGsysRoleIdsByGsysFunctionId(String gsysFunctionId);

}
