/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.security.config.SecurityConstants;
import com.jeefuse.system.security.model.ActivatedType;
import com.jeefuse.system.security.model.EmailAndMobile;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.model.parse.GsysUserField;
import com.jeefuse.system.security.service.GsysRelUserRoleService;
import com.jeefuse.system.security.service.GsysUserService;
import com.jeefuse.system.security.web.rto.GsysUserRTO;

/**
 * GsysUser Entity CRUD service impl.
 * 
 * @author yonclv
 * @generated
 */
@Service(value = "gsysUserServiceImpl")
public class GsysUserServiceImpl extends GenericServiceImpl<GsysUser, String> implements GsysUserService {

	public static final String SERVICE_ID = "gsysUserServiceImpl";
	@Autowired
	private GsysRelUserRoleService gsysRelUserRoleService;

	/**
	 * GsysUserServiceImpl constructor with set GsysUser entity Class.
	 * 
	 * @generated
	 */
	@Autowired
	public GsysUserServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysUser.class);
	}

	/** @generated */
	public List<GsysUser> findByProperty(GsysUserField gsysUserField, Object value) {
		return findByProperty(gsysUserField.getFieldName(), value);
	}

	/** @generated */
	public boolean isPropertyUnique(GsysUserField gsysUserField, Object newValue) {
		Object m = findUniqueByProperty(gsysUserField.getFieldName(), newValue);
		return (m == null);
	}

	/** @generated */
	public Page<GsysUser> find(Page<GsysUser> page, GsysUserRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		if (null != rto) {
			condition.addStartsLikeIfNotBlank(GsysUserField.username.getFieldName(), rto.getUsername());
		}
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	@Transactional
	public void save(GsysUser gsysUser, List<String> relGsysRoleIdList) {
		save(gsysUser);
		gsysRelUserRoleService.checkGsysUserRelGsysRole(gsysUser, relGsysRoleIdList);
	}

	@Transactional
	public void update(GsysUser gsysUser, List<String> relGsysRoleIdList) {
		update(gsysUser);
		gsysRelUserRoleService.checkGsysUserRelGsysRole(gsysUser, relGsysRoleIdList);
	}

	public boolean isLoginNameUnique(String loginName) {
		return hibernateDao.isPropertyUnique(entityClass, GsysUserField.loginName.getFieldName(), loginName);
	}

	public GsysUser getByLoginName(String loginName) {
		final String hql = "from GsysUser m where m.loginName=:loginName";
		GsysUser item = (GsysUser) hibernateDao.createQuery(hql).setParameter("loginName", loginName).uniqueResult();
		return item;
	}

	@Transactional
	public void updateActivatedById(String id, ActivatedType activated) {
		Assert.notNull(id);
		final String hql = "update GsysUser m set m.activated = :activated where m.id = :id";
		hibernateDao.createQuery(hql).setString("activated", activated.getKey()).setString("id", id).executeUpdate();

	}

	@Transactional
	public void updateMobileById(String id, String mobile) {
		Assert.notNull(id);
		final String hql = "update GsysUser m set m.mobile = :mobile where m.id = :id";
		hibernateDao.createQuery(hql).setString("mobile", mobile).setString("id", id).executeUpdate();
	}

	@Transactional
	public void updateEmailById(String id, String email) {
		Assert.notNull(id);
		final String hql = "update GsysUser m set m.email = :email where m.id = :id";
		hibernateDao.createQuery(hql).setString("email", email).setString("id", id).executeUpdate();
	}

	public boolean isEmailUnique(String email) {
		final String hql = "SELECT count(*) FROM GsysUser m WHERE m.email=:email";
		long count = Long.parseLong(hibernateDao.createQuery(hql.toString()).setString("email", email).uniqueResult()
				.toString());
		return (count == 0);
	}

	public boolean isEmailUnique(String email, String userId) {
		Assert.notNull(userId);
		final String hql = "SELECT count(*) FROM GsysUser m WHERE m.email=:email and m.id<>:userId";
		long count = Long.parseLong(hibernateDao.createQuery(hql.toString()).setString("email", email).setString(
				"userId", userId).uniqueResult().toString());
		return (count == 0);
	}

	public boolean isMobileUnique(String mobile) {
		final String hql = "SELECT count(*) FROM GsysUser m WHERE m.mobile=:mobile";
		long count = Long.parseLong(hibernateDao.createQuery(hql.toString()).setString("mobile", mobile).uniqueResult()
				.toString());
		return (count == 0);
	}

	public boolean isMobileUnique(String mobile, String userId) {
		final String hql = "SELECT count(*) FROM GsysUser m WHERE m.mobile=:mobile and m.id<>:userId";
		long count = Long.parseLong(hibernateDao.createQuery(hql.toString()).setString("mobile", mobile).setString(
				"userId", userId).uniqueResult().toString());
		return (count == 0);
	}

	@Transactional
	public void registNewUser(GsysUser gsysUser) {
		hibernateDao.save(gsysUser);
		gsysRelUserRoleService.addNewRole(gsysUser, SecurityConstants.registered_user_role_list);
	}


	public GsysUser getUserSimpleInfoById(String userId) {
		final String hql = "select m.username, m.enabled, m.activated, m.level, m.lastLoginTime,m.portraitPhoto from GsysUser m where m.id=:userId";
		Object[] objs = (Object[]) hibernateDao.createQuery(hql).setParameter("userId", userId).uniqueResult();
		if (null == objs)
			return null;
		GsysUser item = new GsysUser();
		item.setUsername((String) objs[0]);
		item.setEnabled((String) objs[1]);
		item.setActivated((String) objs[2]);
		item.setLevel((String) objs[3]);
		item.setLastLoginTime((Date) objs[4]);
		item.setPortraitPhoto((String) objs[5]);
		return item;
	}

	public String getLoginnameById(String userId) {
		final String hql = "select m.loginName from GsysUser m where m.id=:id";
		return (String) hibernateDao.createQuery(hql).setString("id", userId).uniqueResult();
	}

	@Transactional
	public int updateLoginnameById(String newLoginName, String userId) {
		Assert.notNull(newLoginName);
		Assert.notNull(userId);
		final String hql = "update GsysUser m set m.loginName = :loginName where  m.id =:id";
		return hibernateDao.createQuery(hql).setString("loginName", newLoginName).setString("id", userId)
				.executeUpdate();
	}

	public EmailAndMobile getEmailAndMobileById(String userId) {
		final String hql = "select m.email, m.mobile from GsysUser m where m.id=:userId";
		Object[] objs = (Object[]) hibernateDao.createQuery(hql).setParameter("userId", userId).uniqueResult();
		if (null == objs)
			return null;
		EmailAndMobile item = new EmailAndMobile();
		item.setEmail((String) objs[0]);
		item.setMobile((String) objs[1]);
		return item;
	}

	public String getPasswordById(String userId) {
		final String hql = "select m.password from GsysUser m where m.id=:userId";
		return (String) hibernateDao.createQuery(hql).setString("userId", userId).uniqueResult();
	}

	@Transactional
	public int updateMobiledById(String userId, String mobile) {
		Assert.notNull(userId);
		Assert.notNull(mobile);
		final String hql = "update GsysUser m set m.mobile = :mobile where  m.id =:id";
		return hibernateDao.createQuery(hql).setString("mobile", mobile).setString("id", userId).executeUpdate();
	}


	@Transactional
	public int updateMobileActivatedById(String userId, String mobile, ActivatedType valid) {
		Assert.notNull(userId);
		Assert.notNull(mobile);
		Assert.notNull(valid);
		final String hql = "update GsysUser m set m.mobile =:mobile , m.activated=:activated where m.id =:userId";
		return hibernateDao.createQuery(hql).setString("mobile", mobile).setString("activated", valid.getKey())
				.setString("userId", userId).executeUpdate();
	}

	@Transactional
	public int updateEmailActivatedById(String userId, String email, ActivatedType valid) {
		Assert.notNull(userId);
		Assert.notNull(email);
		Assert.notNull(valid);
		final String hql = "update GsysUser m set m.email =:email , m.activated=:activated where m.id =:userId";
		return hibernateDao.createQuery(hql).setString("email", email).setString("activated", valid.getKey())
				.setString("userId", userId).executeUpdate();
	}

	@Transactional
	public int updateLastLoginTimeById(String userId, Date createdate) {
		Assert.notNull(userId);
		final String hql = "update GsysUser m set m.lastLoginTime =:lastLoginTime  where m.id =:userId";
		return hibernateDao.createQuery(hql).setTimestamp("lastLoginTime", createdate).setString("userId", userId)
				.executeUpdate();
	}


	public EmailAndMobile getEmailAndMobileByLoginName(String loginName) {
		Assert.notNull(loginName);
		final String hql = "select m.email, m.mobile from GsysUser m where m.loginName=:loginName";
		Object[] objs = (Object[]) hibernateDao.createQuery(hql).setParameter("loginName", loginName).uniqueResult();
		if (null == objs)
			return null;
		EmailAndMobile item = new EmailAndMobile();
		item.setEmail((String) objs[0]);
		item.setMobile((String) objs[1]);
		return item;
	}

	@SuppressWarnings("unchecked")
	public GsysUser getByEmail(String email) {
		final String hql = " from GsysUser m where m.email=:email";
		List<GsysUser> list = hibernateDao.createQuery(hql).setParameter("email", email).list();
		if (null != list && !list.isEmpty())
			return list.get(0);
		return null;
	}

}
