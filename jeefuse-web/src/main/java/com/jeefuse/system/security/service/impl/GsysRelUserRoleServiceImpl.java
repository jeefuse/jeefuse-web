/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.calculate.IntegerUtil;
import com.jeefuse.base.utils.common.ChangeUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.security.model.GsysRelUserRole;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.service.GsysRelUserRoleService;

/**
 * GsysRelUserRole Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysRelUserRoleServiceImpl")
public class GsysRelUserRoleServiceImpl extends GenericServiceImpl<GsysRelUserRole, String> implements GsysRelUserRoleService{

	public static final String SERVICE_ID = "gsysRelUserRoleServiceImpl";

	/** 
	 * GsysRelUserRoleServiceImpl constructor with set GsysRelUserRole entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysRelUserRoleServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysRelUserRole.class);
	}
	

	/** @generated */
	@Transactional
	public void check(String userId, String[] roleIds) {
		Assert.notNull(userId, "用户标识不能为空!");
		final String sql = "delete from GsysRelUserRole m where m.gsysUser.id=?";
		hibernateDao.delete(sql, userId);
		if (null == roleIds || roleIds.length == 0)
			return;
		save(userId, roleIds);
	}

	public boolean checkGsysUserHasRelGsysRole(String userId, String roleId) {
		Assert.notNull(userId, "检查用户不能为空!");
		Assert.notNull(roleId, "检查角色不能为空!");
		final String hql = "select count(m) from GsysRelUserRole m where m.gsysUser.id=? and m.gsysRole.id=?";
		int count = hibernateDao.findInt(hql, userId, roleId);
		return count > 0 ? true : false;
	}

	/** @generated */
	@Transactional
	public int delete(String userId, String roleId) {
		Assert.notNull(userId, "未指定删除用户");
		Assert.notNull(roleId, "未指定删除角色");
		final String sql = "delete from " + entityClass.getName() + " m where m.gsysUser.id=? and m.gsysRole.id=?";
		return hibernateDao.delete(sql, userId, roleId);
	}

	/** @generated */
	@Transactional
	public int delete(String userId, String[] roleIds) {
		Assert.notNull(userId, "未指定删除用户");
		Assert.notNull(roleIds, "未指定删除角色");
		final String sql = "delete from " + entityClass.getName() + " m where m.gsysUser.id=? and m.gsysRole.id in (?)";
		return hibernateDao.delete(sql, userId, roleIds);
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public Page<GsysRole> findRelGsysRoleByGsysUserId(String userId, Page<GsysRole> page) {
		Assert.notNull(userId, "查询用户标识不能为空!");
		Assert.notNull(page, "分页参数不能为空!");
		final String hqlClause = "from GsysRole m,GsysRelUserRole m1 where m.id=m1.gsysRole.id and m1.gsysUser.id=?";
		List<GsysRole> list = hibernateDao.find("select m " + hqlClause, page.getFirst(), page.getPageSize(), userId);
		page.setResult(list);
		if (page.isAutoCountTotal()) {
			long totalCount =hibernateDao.findInt("select count(*) "+hqlClause, userId);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public List<GsysRole> findRelGsysRoleByGsysUserId(String userId) {
		Assert.notNull(userId, "查询用户标识不能为空!");
		final String hqlClause = "Select m from GsysRole m,GsysRelUserRole m1 where m.id=m1.gsysRole.id and m1.gsysUser.id=?";
		List<GsysRole> list = hibernateDao.find(hqlClause, userId);
		return list;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public Page<GsysUser> findRelGsysUserByGsysRoleId(String roleId, Page<GsysUser> page) {
		Assert.notNull(roleId, "查询用户标识不能为空!");
		Assert.notNull(page, "分页参数不能为空!");
		final String hqlClause = "from GsysUser m,GsysRelUserRole m1 where m.id=m1.GsysUser.id and m1.gsysRole.id=?";
		List<GsysUser> list = hibernateDao.find("select m " + hqlClause, page.getFirst(), page.getPageSize(), roleId);
		page.setResult(list);
		if (page.isAutoCountTotal()) {
			long totalCount = hibernateDao.findInt("select count(*) " + hqlClause, roleId);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public List<GsysUser> findRelGsysUserByGsysRoleId(String roleId) {
		Assert.notNull(roleId, "查询用户标识不能为空!");
		final String hqlClause = "from GsysUser m,GsysRelUserRole m1 where m.id=m1.GsysUser.id and m1.gsysRole.id=?";
		List<GsysUser> list = hibernateDao.find(hqlClause, roleId);
		return list;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public Page<GsysRole> findUnRelGsysRoleByGsysUserId(String userId, Page<GsysRole> page) {
		Assert.notNull(userId, "查询用户标识不能为空!");
		Assert.notNull(page, "分页参数不能为空!");
		final String hqlClause = "from GsysRole m,GsysRelUserRole m1 where m.id!=m1.gsysRole.id and m1.gsysUser.id=?";
		List<GsysRole> list = hibernateDao.find("select m " + hqlClause, page.getFirst(), page.getPageSize(), userId);
		page.setResult(list);
		if (page.isAutoCountTotal()) {
			long totalCount = hibernateDao.findInt("select count(*) " + hqlClause, userId);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public List<GsysRole> findUnRelGsysRoleByGsysUserId(String userId) {
		Assert.notNull(userId, "查询用户标识不能为空!");
		final String hqlClause = "select m from GsysRole m,GsysRelUserRole m1 where m.id!=m1.gsysRole.id and m1.gsysUser.id=?";
		List<GsysRole> list = hibernateDao.find(hqlClause, userId);
		return list;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public Page<GsysUser> findUnRelGsysUserByGsysRoleId(String roleId, Page<GsysUser> page) {
		Assert.notNull(roleId, "查询用户标识不能为空!");
		Assert.notNull(page, "分页参数不能为空!");
		final String hqlClause = "from GsysUser m,GsysRelUserRole m1 where m.id!=m1.GsysUser.id and m1.gsysRole.id=?";
		List<GsysUser> list = hibernateDao.find("select m " + hqlClause, page.getFirst(), page.getPageSize(), roleId);
		page.setResult(list);
		if (page.isAutoCountTotal()) {
			long totalCount = hibernateDao.findInt("select count(*) " + hqlClause, roleId);
			page.setTotalCount(totalCount);
		}
		return page;
	}

	/** @generated */
	@SuppressWarnings("unchecked")
	public List<GsysUser> findUnRelGsysUserByGsysRoleId(String roleId) {
		Assert.notNull(roleId, "查询用户标识不能为空!");
		final String hqlClause = "select m from GsysUser m,GsysRelUserRole m1 where m.id=m1.GsysUser.id and m1.gsysRole.id=?";
		List<GsysUser> list = hibernateDao.find(hqlClause, roleId);
		return list;
	}

	/** @generated */
	@Transactional
	public void save(String userId, String roleId) {
		Assert.notNull(userId, "保存用户不能为空!");
		Assert.notNull(roleId, "保存角色不能为空!");
		GsysUser gsysUser = new GsysUser();
		gsysUser.setId(userId);
		GsysRole gsysRole = new GsysRole();
		gsysRole.setId(roleId);
		GsysRelUserRole gsysRelUserRole = new GsysRelUserRole();
		gsysRelUserRole.setGsysUser(gsysUser);
		gsysRelUserRole.setGsysRole(gsysRole);
		hibernateDao.save(gsysRelUserRole);
	}

	/** @generated */
	@Transactional
	public void save(String userId, String[] roleIds) {
		Assert.notNull(userId, "保存用户不能为空!");
		Assert.notNull(roleIds, "保存角色不能为空!");
		GsysUser gsysUser = new GsysUser();
		gsysUser.setId(userId);
		List<GsysRelUserRole> gsysRelUserRoleList = new ArrayList<GsysRelUserRole>();
		for (String roleId : roleIds) {
			GsysRole gsysRole = new GsysRole();
			gsysRole.setId(roleId);
			GsysRelUserRole gsysRelUserRole = new GsysRelUserRole();
			gsysRelUserRole.setGsysUser(gsysUser);
			gsysRelUserRole.setGsysRole(gsysRole);
			gsysRelUserRoleList.add(gsysRelUserRole);
		}
		hibernateDao.save(gsysRelUserRoleList);
	}

	@SuppressWarnings("unchecked")
	public List<String> getRelGsysRoleIdsByGsysUserId(String gsysUserId) {
		Assert.notNull(gsysUserId, "角户标识不能为空");
		final String hql = "select m.gsysRole.id from GsysRelUserRole m where m.gsysUser.id=?";
		return hibernateDao.find(hql, gsysUserId);
	}

	public boolean isGsysUserHasRelGsysRole(String userId, String roleId) {
		Assert.notNull(userId, "用户标识不能为空!");
		Assert.notNull(roleId, "角色标识不能为空!");
		final String hql = "select count(m) from GsysRelUserRole m where m.gsysUser.id=? and m.gsysRole.id=?";
		int count = hibernateDao.findInt(hql, userId, roleId);
		return count > 0 ? true : false;
	}

	public void checkGsysUserRelGsysRole(GsysUser gsysUser, List<String> relGsysRoleCheckIdList) {
		Assert.notNull(gsysUser, "用户不能为空!");
		Assert.notNull(gsysUser.getId(), "用户标识不能为空!");
		List<String> relIds = getRelGsysRoleIdsByGsysUserId(gsysUser.getId());
		if (null == relGsysRoleCheckIdList || relGsysRoleCheckIdList.isEmpty()) {
			if (null != relIds && relIds.size() > 0) {
				final String hql = "delete from GsysRelUserRole m where m.gsysUser.id =?";
				hibernateDao.delete(hql, gsysUser.getId());
			}
			return;
		}
		// 需要添加的对象
		List<String> deleteIds = ChangeUtil.exclude(relIds, relGsysRoleCheckIdList);
		// 需要删除的对象
		List<String> addIds = ChangeUtil.exclude(relGsysRoleCheckIdList, relIds);
		if (null != deleteIds && !deleteIds.isEmpty()) {
			final String hql = "delete from GsysRelUserRole m where m.gsysUser.id =:userId and m.gsysRole.id in (:deleteIds)";
			hibernateDao.createQuery(hql).setString("userId", gsysUser.getId())
					.setParameterList("deleteIds", deleteIds).executeUpdate();
		}
		if (null != addIds && !addIds.isEmpty()) {
			List<GsysRelUserRole> gsysRelUserRolelist = new ArrayList<GsysRelUserRole>();
			for (String gsysRoleId : addIds) {
				GsysRelUserRole gsysRoleUserRole = new GsysRelUserRole();
				// rel gsysRole
				GsysRole gsysRole = new GsysRole();
				gsysRole.setId(gsysRoleId);
				gsysRoleUserRole.setGsysRole(gsysRole);
				// rel gsysUser
				gsysRoleUserRole.setGsysUser(gsysUser);
				gsysRelUserRolelist.add(gsysRoleUserRole);
			}
			hibernateDao.save(gsysRelUserRolelist);
		}
	}

	@Transactional
	public void addNewRole(GsysUser gsysUser, List<String> relGsysRoleCheckIdList) {
		Assert.notNull(gsysUser, "用户不能为空!");
		Assert.notNull(gsysUser.getId(), "用户标识不能为空!");
		if (null == relGsysRoleCheckIdList)
			return;
		List<GsysRelUserRole> gsysRelUserRolelist = new ArrayList<GsysRelUserRole>();
		for (String roleId : relGsysRoleCheckIdList) {
			final String hql = "select count(*) from GsysRelUserRole m where m.gsysUser.id =:userId and m.gsysRole.id =:roleId";
			int count = IntegerUtil.valueOf(hibernateDao.createQuery(hql).setString("userId", gsysUser.getId())
					.setString("roleId", roleId).uniqueResult());
			if (count == 1) {
				continue;
			}
			if (count > 1) {
				final String delhql = "delete from GsysRelUserRole m where m.gsysUser.id =:userId and m.gsysRole.id =:roleId";
				hibernateDao.createQuery(delhql).setString("userId", gsysUser.getId()).setString("roleId", roleId)
						.executeUpdate();
			}
			GsysRelUserRole gsysRoleUserRole = new GsysRelUserRole();
			// rel gsysRole
			GsysRole gsysRole = new GsysRole();
			gsysRole.setId(roleId);
			gsysRoleUserRole.setGsysRole(gsysRole);
			// rel gsysUser
			gsysRoleUserRole.setGsysUser(gsysUser);
			gsysRelUserRolelist.add(gsysRoleUserRole);
		}
		if (!gsysRelUserRolelist.isEmpty()) {
			hibernateDao.save(gsysRelUserRolelist);
		}
	}
	
}
