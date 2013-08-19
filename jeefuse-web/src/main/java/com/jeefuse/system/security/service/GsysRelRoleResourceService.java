/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import java.util.List;

import com.jeefuse.base.service.GenericService;
import com.jeefuse.system.security.model.GsysRelRoleResource;
import com.jeefuse.system.security.model.GsysRole;

/**
 * GsysRelRoleResource Entity CRUD service.
 * 
 * @author yonclv
 * @generated
 */
public interface GsysRelRoleResourceService extends GenericService<GsysRelRoleResource, String> {

	/*****************************************************************
	 * GsysRelRole rel GsysResource /
	 *****************************************************************/

	/**
	 * 判断用户是否有角色.
	 */
	public boolean isGsysRoleHasRelGsysResource(String gsysRoleId, String gsysResourceId);

	/**
	 * 获取角色关联的资源Id例表.
	 * 
	 * @param gsysRoleId
	 *            角色ID
	 */
	public List<String> getRelGsysResourceIdsByGsysRoleId(String gsysRoleId);

	/**
	 * 保存角色与资源的关联.
	 * 
	 * @param id
	 * @param relGsysResourceCheckIds
	 */
	public void checkGsysRoleRelGsysResource(final GsysRole gsysRole, String... gsysResourceIds);


}
