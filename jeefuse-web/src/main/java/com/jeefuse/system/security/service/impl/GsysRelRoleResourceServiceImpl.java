/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.common.ChangeUtil;
import com.jeefuse.system.security.model.GsysRelRoleResource;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.service.GsysRelRoleResourceService;

/**
 * GsysRelRoleResource Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysRelRoleResourceServiceImpl")
public class GsysRelRoleResourceServiceImpl extends GenericServiceImpl<GsysRelRoleResource, String> implements GsysRelRoleResourceService{

	public static final String SERVICE_ID = "gsysRelRoleResourceServiceImpl";

	/** 
	 * GsysRelRoleResourceServiceImpl constructor with set GsysRelRoleResource entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysRelRoleResourceServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysRelRoleResource.class);
	}

	public boolean isGsysRoleHasRelGsysResource(String gsysRoleId, String gsysResourceId) {
		Assert.notNull(gsysRoleId, "角色标识不能为空!");
		Assert.notNull(gsysResourceId, "资源标识不能为空!");
		final String hql = "select count(m) from GsysRelRoleResource m where m.gsysRole.id=? and m.gsysResource.id=?";
		int count = hibernateDao.findInt(hql, gsysRoleId, gsysResourceId);
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRelGsysResourceIdsByGsysRoleId(String gsysRoleId) {
		Assert.notNull(gsysRoleId, "角色标识不能为空");
		final String hql = "select m.gsysResource.id from GsysRelRoleResource m where m.gsysRole.id=?";
		return hibernateDao.find(hql, gsysRoleId);
	}

	@Transactional
	public void checkGsysRoleRelGsysResource(final GsysRole gsysRole, String... gsysResourceIds) {
		Assert.notNull(gsysRole, "角色不能为空!");
		Assert.notNull(gsysRole.getId(), "角色标识不能为空!");
		List<String> relIds = getRelGsysResourceIdsByGsysRoleId(gsysRole.getId());
		if (null == gsysResourceIds) {
			if (null != relIds && relIds.size() > 0) {
				final String hql = "delete from GsysRelRoleResource m where m.gsysRole.id =?";
				hibernateDao.delete(hql, gsysRole.getId());
			}
			return;
		}
		List<String> checkIds = Arrays.asList(gsysResourceIds);
		// 需要添加的对象
		List<String> deleteIds = ChangeUtil.exclude(relIds, checkIds);
		// 需要删除的对象
		List<String> addIds = ChangeUtil.exclude(checkIds, relIds);
		if (null != deleteIds && !deleteIds.isEmpty()) {
			final String hql = "delete from GsysRelRoleResource m where m.gsysRole.id =:roleId and m.gsysResource.id in (:deleteIds)";
			hibernateDao.createQuery(hql).setString("roleId", gsysRole.getId())
					.setParameterList("deleteIds", deleteIds)
					.executeUpdate();
		}
		if (null != addIds && !addIds.isEmpty()) {
			// GsysRole gsysRole = new GsysRole();
			// gsysRole.setId(roleId);
			List<GsysRelRoleResource> gsysRelRoleResourceList = new ArrayList<GsysRelRoleResource>();
			for (String gsysResourceId : addIds) {
				GsysRelRoleResource gsysRelRoleResource = new GsysRelRoleResource();
				// rel gsysResource
				GsysResource gsysResource = new GsysResource();
				gsysResource.setId(gsysResourceId);
				gsysRelRoleResource.setGsysResource(gsysResource);
				// rel gsysRole
				gsysRelRoleResource.setGsysRole(gsysRole);
				gsysRelRoleResourceList.add(gsysRelRoleResource);
			}
			hibernateDao.save(gsysRelRoleResourceList);
		}
	}


}
