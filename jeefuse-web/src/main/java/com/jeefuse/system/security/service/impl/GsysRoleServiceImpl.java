/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.parse.GsysRoleField;
import com.jeefuse.system.security.model.validate.GsysRoleValidate;
import com.jeefuse.system.security.service.GsysRelRoleFunctionService;
import com.jeefuse.system.security.service.GsysRelRoleResourceService;
import com.jeefuse.system.security.service.GsysRoleService;
import com.jeefuse.system.security.web.rto.GsysRoleRTO;

/**
 * GsysRole Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysRoleServiceImpl")
public class GsysRoleServiceImpl extends GenericServiceImpl<GsysRole, String> implements GsysRoleService{

	public static final String SERVICE_ID = "gsysRoleServiceImpl";

	@Autowired
	private GsysRelRoleFunctionService gsysRelRoleFunctionService;

	@Autowired
	private GsysRelRoleResourceService gsysRelRoleResourceService;

	/** 
	 * GsysRoleServiceImpl constructor with set GsysRole entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysRoleServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysRole.class);
	}
	
	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public void save(GsysRole gsysRole, Boolean isValidate) throws ValidateViolationException {
		if (isValidate) {
			GsysRoleValidate.validateWithException(gsysRole);
		}
		hibernateDao.save(gsysRole);
	}

	/**
	 * 更新并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public void update(GsysRole gsysRole, Boolean isValidate) throws ValidateViolationException {
		if (isValidate) {
			GsysRoleValidate.validateWithException(gsysRole);
		}
		hibernateDao.update(gsysRole);
	}
	
	/** @generated*/
	public List<GsysRole> findByProperty(GsysRoleField gsysRoleField, Object value){
		return findByProperty(gsysRoleField.getFieldName(), value);
	}

	/** @generated*/
	public boolean isPropertyUnique(GsysRoleField gsysRoleField, Object newValue){
		Object m = findUniqueByProperty(gsysRoleField.getFieldName(), newValue);
		return (m == null);
	}
	
	/** @generated*/
	public Page<GsysRole> find(Page<GsysRole> page, GsysRoleRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysRoleField.name.getFieldName(), rto.getName());
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/** @generated */
	@Transactional
	public GsysRole save(GsysRoleRTO rto, boolean isValidate, String[] relGsysFunctionCheckIds,
			String[] relGsysResourceCheckIds) {
		GsysRole gsysRole = rto.getNewModel();
		save(gsysRole, isValidate);
		gsysRelRoleFunctionService.checkGsysRoleRelGsysFunction(gsysRole, relGsysFunctionCheckIds);
		gsysRelRoleResourceService.checkGsysRoleRelGsysResource(gsysRole, relGsysResourceCheckIds);
		return gsysRole;
	}

	@Transactional
	public GsysRole update(GsysRoleRTO rto, boolean isValidate, String[] relGsysFunctionCheckIds,
			String[] relGsysResourceCheckIds) {
		GsysRole oldmo = get(rto.getId());
		GsysRole gsysRole = rto.getModifiedModel(oldmo);
		update(gsysRole, isValidate);
		gsysRelRoleFunctionService.checkGsysRoleRelGsysFunction(gsysRole, relGsysFunctionCheckIds);
		gsysRelRoleResourceService.checkGsysRoleRelGsysResource(gsysRole, relGsysResourceCheckIds);
		return gsysRole;
	}

	@SuppressWarnings("unchecked")
	public List<KeyLabel> getAllGsysRoleForKeyLabel() {
		final String hql = "select new com.jeefuse.base.modules.keyLabel.KeyLabelImpl(m.id,m.displayName) from GsysRole m";
		return hibernateDao.createQuery(hql).list();
	}
	
}
