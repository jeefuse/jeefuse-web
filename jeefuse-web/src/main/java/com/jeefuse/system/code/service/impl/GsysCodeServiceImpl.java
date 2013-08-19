/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.InvalidDataException;
import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.model.validate.GsysCodeValidate;
import com.jeefuse.system.code.service.GsysCodeService;
import com.jeefuse.system.code.service.GsysCodevalueService;
import com.jeefuse.system.code.web.rto.GsysCodeRTO;

/**
 * GsysCode Entity CRUD service impl.
 * 
 * @author yonclv
 * @generated
 */
@Service(value = "gsysCodeServiceImpl")
public class GsysCodeServiceImpl extends GenericServiceImpl<GsysCode, String> implements GsysCodeService {
	@Autowired
	private GsysCodevalueService gsysCodevalueService;

	/**
	 * GsysCodeServiceImpl constructor with set GsysCode entity Class.
	 * 
	 * @generated
	 */
	@Autowired
	public GsysCodeServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysCode.class);
	}

	/** @generated */
	@Transactional
	public void save(GsysCode gsysCode, Boolean isValidate) throws ValidateViolationException {
		if (isValidate) {
			GsysCodeValidate.validateWithException(gsysCode);
		}
		save(gsysCode);
	}

	/** @generated */
	@Transactional
	public GsysCode save(GsysCodeRTO rto) {
		GsysCode newModel = rto.getNewModel();
		hibernateDao.save(newModel);
		return newModel;
	}

	/** @generated */
	@Transactional
	public void update(GsysCode gsysCode, Boolean isValidate) throws ValidateViolationException {
		if (isValidate) {
			GsysCodeValidate.validateWithException(gsysCode);
		}
		update(gsysCode);
	}

	@Transactional
	/** @generated*/
	public GsysCode update(GsysCodeRTO rto) {
		AppAssert.isNotblank(rto.getId(), "ID不能为空!");
		// for assign id
		AppAssert.isNotblank(rto.getOldId(), "更新ID不能为空!");
		if (!rto.getId().equals(rto.getOldId()))
			throw new InvalidDataException("ID不能更改!");
		GsysCode oldModel = get(rto.getId());
		AppAssert.notNull(oldModel, "您更新的对象不存在!");
		GsysCode newModel = rto.getModifiedModel(oldModel);
		// hibernateDao.update(newModel);//in session will auto update it.
		return newModel;
	}

	/** @generated */
	public List<GsysCode> findByProperty(GsysCodeField gsysCodeField, Object value) {
		return findByProperty(gsysCodeField.getFieldName(), value);
	}

	/** @generated */
	public boolean isPropertyUnique(GsysCodeField gsysCodeField, Object newValue) {
		Object m = findUniqueByProperty(gsysCodeField.getFieldName(), newValue);
		return (m == null);
	}

	/** @generated */
	public Page<GsysCode> find(Page<GsysCode> page, GsysCodeRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysCodeField.name.getFieldName(), rto.getName());
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/** @generated */
	@Transactional
	public ResultMsg<GsysCode> importDatas(List<GsysCode> importList) {
		ResultMsg<GsysCode> result = new ResultMsg<GsysCode>();
		if (null == importList || importList.isEmpty()) {
			result.setMessage("无记录导入");
			return result;
		}
		List<GsysCode> addList = new ArrayList<GsysCode>();
		List<GsysCode> updateList = new ArrayList<GsysCode>();
		for (GsysCode gsysCode : importList) {
			if (StringUtils.isBlank(gsysCode.getId())) {
				gsysCode.setId(null);
				addList.add(gsysCode);
			} else {
				updateList.add(gsysCode);
			}
		}
		hibernateDao.save(addList);
		hibernateDao.update(updateList);
		StringBuilder msgSb = new StringBuilder("");
		int addCount = addList.size();
		int updateCount = updateList.size();
		msgSb.append("共成功导入" + (addCount + updateCount) + "项记录!");
		if (addCount != 0) {
			msgSb.append(" 新增:" + addCount + "项.");
		}
		if (updateCount != 0) {
			msgSb.append(" 更新:" + updateCount + "项.");
		}
		result.setMessage(msgSb.toString());
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<GsysCode> getAllForKeyLabel() {
		final String hql = "select new GsysCode(m.cid,m.name) from GsysCode m";
		return hibernateDao.createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public List<GsysCode> getAllAndCodeValue() {
		final String hql = "select new GsysCode(m.cid,m.name) from GsysCode m";
		List<GsysCode> list = hibernateDao.createQuery(hql).list();
		if (null != list) {
			for (GsysCode gsysCode : list) {
				final String codeValuehql = "select new GsysCodevalue(m.name,m.value) from GsysCodevalue m where m.gsysCode.cid=:cid";
				List<GsysCodevalue> valueList = hibernateDao.createQuery(codeValuehql)
						.setString("cid", gsysCode.getCid()).list();
				gsysCode.setGsysCodevalues(valueList);
			}
		}
		return list;
	}

	@Override
	@Transactional
	public int deleteAll() {
		gsysCodevalueService.deleteAll();
		int count = hibernateDao.deleteAll(entityClass);
		return count;
	}
}
