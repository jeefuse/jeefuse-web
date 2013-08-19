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
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.GsysRelRoleFunction;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.service.GsysRelRoleFunctionService;

/**
 * GsysRelRoleFunction Entity CRUD service impl.
 * 
 * @author yonclv
 * @generated
 */
@Service(value = "gsysRelRoleFunctionServiceImpl")
public class GsysRelRoleFunctionServiceImpl extends GenericServiceImpl<GsysRelRoleFunction, String> implements
		GsysRelRoleFunctionService {

	public static final String SERVICE_ID = "gsysRelRoleFunctionServiceImpl";

	/**
	 * GsysRelRoleFunctionServiceImpl constructor with set GsysRelRoleFunction
	 * entity Class.
	 * 
	 * @generated
	 */
	@Autowired
	public GsysRelRoleFunctionServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysRelRoleFunction.class);
	}

	public boolean isGsysRoleHasRelGsysFunction(String roleId, String functionId) {
		Assert.notNull(roleId, "角色标识不能为空!");
		Assert.notNull(functionId, "功能标识不能为空!");
		final String hql = "select count(m) from GsysRelRoleFunction m where m.gsysRole.id=? and m.gsysFunction.id=?";
		int count = hibernateDao.findInt(hql, roleId, functionId);
		return count > 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRelGsysFunctionIdsByGsysRoleId(String gsysRoleId) {
		Assert.notNull(gsysRoleId, "角色标识不能为空");
		final String hql = "select m.gsysFunction.id from GsysRelRoleFunction m where m.gsysRole.id=?";
		List<String> list = hibernateDao.find(hql, gsysRoleId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRelGsysFunctionIdsByGsysRoleId(List<String> gsysRoleIdList) {
		Assert.notNull(gsysRoleIdList, "角色标识不能为空");
		final String hql = "select m.gsysFunction.id from GsysRelRoleFunction m where m.gsysRole.id in (:gsysRoleIdList)";
		List<String> list = hibernateDao.createQuery(hql).setParameterList("gsysRoleIdList", gsysRoleIdList).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRelGsysRoleIdsByGsysFunctionId(String gsysFunctionId) {
		Assert.notNull(gsysFunctionId, "功能标识不能为空");
		final String hql = "select m.gsysRole.id from GsysRelRoleFunction m where m.gsysFunction.id=?";
		List<String> list = hibernateDao.find(hql, gsysFunctionId);
		return list;
	}

	@Transactional
	public void checkGsysRoleRelGsysFunction(final GsysRole gsysRole, final String... functionIds) {
		Assert.notNull(gsysRole, "角色不能为空!");
		Assert.notNull(gsysRole.getId(), "角色标识不能为空!");
		List<String> relGsysFunctionIds = getRelGsysFunctionIdsByGsysRoleId(gsysRole.getId());
		if (null == functionIds) {
			if (null != relGsysFunctionIds && relGsysFunctionIds.size() > 0) {
				final String hql = "delete from GsysRelRoleFunction m where m.gsysRole.id =?";
				hibernateDao.delete(hql, gsysRole.getId());
			}
			return;
		}
		List<String> checkIds = Arrays.asList(functionIds);
		// 需要添加的对象
		List<String> deleteIds = ChangeUtil.exclude(relGsysFunctionIds, checkIds);
		// 需要删除的对象
		List<String> addIds = ChangeUtil.exclude(checkIds, relGsysFunctionIds);
		if (null != deleteIds && !deleteIds.isEmpty()) {
			final String hql = "delete from GsysRelRoleFunction m where m.gsysRole.id =:roleId and m.gsysFunction.id in (:deleteIds)";
			hibernateDao.createQuery(hql)
			.setString("roleId", gsysRole.getId())
			.setParameterList("deleteIds", deleteIds).executeUpdate();
		}
		if (null != addIds && !addIds.isEmpty()) {
			List<GsysRelRoleFunction> modelList = new ArrayList<GsysRelRoleFunction>();
			for (String functionId : addIds) {
				GsysRelRoleFunction gsysRelRoleFunction = new GsysRelRoleFunction();
				// rel gsysFunction
				GsysFunction gsysFunction = new GsysFunction();
				gsysFunction.setId(functionId);
				gsysRelRoleFunction.setGsysFunction(gsysFunction);
				// rel gsysRole
				gsysRelRoleFunction.setGsysRole(gsysRole);
				modelList.add(gsysRelRoleFunction);
			}
			hibernateDao.save(modelList);
		}
	}
}
