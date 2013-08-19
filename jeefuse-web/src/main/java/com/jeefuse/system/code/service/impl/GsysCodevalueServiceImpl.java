/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.service.GsysCodevalueService;
import com.jeefuse.system.code.web.rto.GsysCodevalueRTO;

/**
 * GsysCodevalue Entity CRUD service impl.
 * 
 * @author yonclv
 * @generated
 */
@Service(value = "gsysCodevalueServiceImpl")
public class GsysCodevalueServiceImpl extends GenericServiceImpl<GsysCodevalue, String> implements GsysCodevalueService {

	/**
	 * GsysCodevalueServiceImpl constructor with set GsysCodevalue entity Class.
	 * 
	 * @generated
	 */
	@Autowired
	public GsysCodevalueServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysCodevalue.class);
	}

	@Transactional
	public GsysCodevalue save(GsysCodevalueRTO rto) {
		GsysCodevalue gsysCodevalue = rto.getNewModel();
		hibernateDao.save(gsysCodevalue);
		return gsysCodevalue;
	}

	@Transactional
	public GsysCodevalue update(GsysCodevalueRTO rto) {
		GsysCodevalue oldGsysCodevalue = get(rto.getId());
		AppAssert.notNull(oldGsysCodevalue, "您更新的记录不存在!");
		GsysCodevalue gsysCodevalue = rto.getModifiedModel(oldGsysCodevalue);
		// hibernateDao.save(gsysCodevalue);//in session will auto update
		return gsysCodevalue;
	}

	/** @generated */
	public List<GsysCodevalue> findByProperty(GsysCodevalueField gsysCodevalueField, Object value) {
		return findByProperty(gsysCodevalueField.getFieldName(), value);
	}

	/** @generated */
	public boolean isPropertyUnique(GsysCodevalueField gsysCodevalueField, Object newValue) {
		Object m = findUniqueByProperty(gsysCodevalueField.getFieldName(), newValue);
		return (m == null);
	}

	/** @generated */
	public Page<GsysCodevalue> find(Page<GsysCodevalue> page, GsysCodevalueRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysCodevalueField.name.getFieldName(), rto.getName());
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/** @generated */
	@Transactional
	public ResultMsg<GsysCodevalue> importDatas(List<GsysCodevalue> importList) {
		ResultMsg<GsysCodevalue> result = new ResultMsg<GsysCodevalue>();
		if (null == importList || importList.isEmpty()) {
			result.setMessage("无记录导入");
			return result;
		}
		List<GsysCodevalue> addList = new ArrayList<GsysCodevalue>();
		List<GsysCodevalue> updateList = new ArrayList<GsysCodevalue>();
		for (GsysCodevalue gsysCodevalue : importList) {
			if (StringUtils.isBlank(gsysCodevalue.getId())) {
				gsysCodevalue.setId(null);
				addList.add(gsysCodevalue);
			} else {
				updateList.add(gsysCodevalue);
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

	/*****************************************************************
	 * manage by Gsyscode
	 *****************************************************************/

	/** @generated */
	public Page<GsysCodevalue> findByGsysCode(Page<GsysCodevalue> page, GsysCodevalueRTO rto, Order[] orders) {
		AppAssert.notNull(rto.getGsysCode().getCid(), "未指定编码!");
		Condition condition = Condition.and();
		condition.addEq("gsysCode.cid", rto.getGsysCode().getCid());
		condition.addStartsLikeIfNotBlank(GsysCodevalueField.name.getFieldName(), rto.getName());
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/**
	 * 查询GsysCode关联的GsysCodevalue.
	 */
	public List<GsysCodevalue> findByGsysCode(String gsysCodeId) {
		AppAssert.notNull(gsysCodeId, "未指定编码!");
		Condition condition = Condition.and();
		condition.addEq("gsysCode.cid", gsysCodeId);
		return hibernateDao.find(entityClass, condition);
	}

	/**
	 * 查询GsysCode关联的GsysCodevalue.只获取name、value字段.
	 */
	@SuppressWarnings("unchecked")
	public List<KeyLabel> findByGsysCodeForKeyLabel(String gsysCodeId) {
		AppAssert.notNull(gsysCodeId, "未指定编码!");
		final String hql = "select new GsysCodevalue(m.name, m.value) from GsysCodevalue m where m.gsysCode.cid=?";
		return hibernateDao.find(hql, gsysCodeId);
	}

	/** @generated */
	@Transactional
	public GsysCodevalue saveByGsysCode(GsysCodevalueRTO rto) {
		GsysCodevalue gsysCodevalue = rto.getNewModel();
		AppAssert.notNull(gsysCodevalue.getGsysCode().getCid(), "未指定编码!");
		hibernateDao.save(gsysCodevalue);
		return gsysCodevalue;
	}

	/** @generated */
	@Transactional
	public GsysCodevalue updateByGsyscode(GsysCodevalueRTO rto) {
		AppAssert.notNull(rto.getGsysCode().getCid(), "未指定编码!");
		GsysCodevalue oldGsysCodevalue = get(rto.getId());
		AppAssert.notNull(oldGsysCodevalue, "您更新的记录不存在!");
		GsysCodevalue gsysCodevalue = rto.getModifiedModel(oldGsysCodevalue);
		// hibernateDao.save(gsysCodevalue);//in session will auto update
		return gsysCodevalue;
	}

	@Transactional
	public int deleteAllByGsysCode(String gsysCodeId) {
		Assert.hasText(gsysCodeId, "编码标识不能为空!");
		final String hql = "delete from " + entityClass.getName() + " m where m.gsysCode.cid=?";
		return hibernateDao.executeUpdate(hql, gsysCodeId);
	}

	public boolean isValueUnique(String cid, String value) {
		Assert.notNull(cid);
		Assert.notNull(value);
		final String hql = "select count(*) from GsysCodevalue m where m.gsysCode.cid=:cid and m.value=:value";
		Query q = hibernateDao.createQuery(hql);
		q.setString("cid", cid);
		q.setString("value", value);
		int count = Integer.parseInt(q.uniqueResult().toString());
		return count > 0 ? false : true;
	}
}
