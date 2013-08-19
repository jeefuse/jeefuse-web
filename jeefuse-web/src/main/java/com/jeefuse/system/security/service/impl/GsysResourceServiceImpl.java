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
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;
import com.jeefuse.system.security.model.validate.GsysResourceValidate;
import com.jeefuse.system.security.service.GsysResourceService;
import com.jeefuse.system.security.web.rto.GsysResourceRTO;

/**
 * GsysResource Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysResourceServiceImpl")
public class GsysResourceServiceImpl extends GenericServiceImpl<GsysResource, String> implements GsysResourceService{

	public static final String SERVICE_ID = "gsysResourceServiceImpl";

	/** 
	 * GsysResourceServiceImpl constructor with set GsysResource entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysResourceServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysResource.class);
	}
	
	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public void save(GsysResource gsysResource, Boolean isValidate) throws ValidateViolationException {
		if (isValidate) {
			GsysResourceValidate.validateWithException(gsysResource);
		}
		save(gsysResource);
	}

	/**
	 * 更新并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public void update(GsysResource gsysResource, Boolean isValidate) throws ValidateViolationException {
		if (isValidate) {
			GsysResourceValidate.validateWithException(gsysResource);
		}
		update(gsysResource);
	}
	
	/** @generated*/
	public List<GsysResource> findByProperty(GsysResourceField gsysResourceField, Object value){
		return findByProperty(gsysResourceField.getFieldName(), value);
	}

	/** @generated*/
	public boolean isPropertyUnique(GsysResourceField gsysResourceField, Object newValue){
		Object m = findUniqueByProperty(gsysResourceField.getFieldName(), newValue);
		return (m == null);
	}
	
	/** @generated*/
	public Page<GsysResource> find(Page<GsysResource> page, GsysResourceRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysResourceField.name.getFieldName(), rto.getName());
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	@SuppressWarnings("unchecked")
	public List<KeyLabel> getAllForKeyLabel() {
		final String hql = "select new GsysResource(m.id,m.name) from GsysResource m";
		return hibernateDao.createQuery(hql).list();
	}
	
}
