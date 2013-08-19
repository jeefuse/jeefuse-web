/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
import com.jeefuse.system.log.service.GsysLoginlogService;
import com.jeefuse.system.log.web.rto.GsysLoginlogRTO;
import com.jeefuse.system.security.service.GsysUserService;

/**
 * 登入日志 Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysLoginlogServiceImpl")
public class GsysLoginlogServiceImpl extends GenericServiceImpl<GsysLoginlog, String> implements GsysLoginlogService{

	@Autowired
	private GsysUserService gsysUserService;

	/** 
	 * GsysLoginlogServiceImpl constructor with set GsysLoginlog entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysLoginlogServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysLoginlog.class);
	}
	
	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public GsysLoginlog save(GsysLoginlogRTO rto) throws ValidateViolationException {
		GsysLoginlog newModel = rto.getNewModel();
		hibernateDao.save(newModel);
		return newModel;
	}

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	@Transactional
	public GsysLoginlog update(GsysLoginlogRTO rto) throws ValidateViolationException {
		AppAssert.isNotblank(rto.getId(), "ID不能为空!");
		GsysLoginlog oldModel = get(rto.getId());
		AppAssert.notNull(oldModel, "您更新的对象不存在!");
		GsysLoginlog newModel = rto.getModifiedModel(oldModel);
		// hibernateDao.update(newModel);//in session will auto update it.
		return newModel;
	}
	
	/** @generated*/
	public List<GsysLoginlog> findByProperty(GsysLoginlogField gsysLoginlogField, Object value){
		return findByProperty(gsysLoginlogField.getFieldName(), value);
	}

	/** @generated*/
	public boolean isPropertyUnique(GsysLoginlogField gsysLoginlogField, Object newValue){
		Object m = findUniqueByProperty(gsysLoginlogField.getFieldName(), newValue);
		return (m == null);
	}
	
	/** @generated*/
	public Page<GsysLoginlog> find(Page<GsysLoginlog> page, GsysLoginlogRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysLoginlogField.loginIp.getFieldName(), rto.getLoginIp());//1 登录IP
		if (StringUtils.isNotBlank(rto.getCreatedateStart())) {//2 登录时间				
			Date createdateStart = DateUtil.getDayStart(DateUtil.parseDate(rto.getCreatedateStart()));
			condition.addGe(GsysLoginlogField.createdate.getFieldName(), createdateStart);
		}
		if (StringUtils.isNotBlank(rto.getCreatedateEnd())) {
			Date createdateEnd = DateUtil.addDays(DateUtil.parseDate(rto.getCreatedateEnd()), 1);
			;
			condition.addLe(GsysLoginlogField.createdate.getFieldName(), createdateEnd);
		}
		condition.addEqIfNotBlank(GsysLoginlogField.userId.getFieldName(), rto.getUserId());//3 登入用户
		return hibernateDao.find(entityClass, page, condition, orders);
	}
	
	/** @generated */
	@Transactional
	public ResultMsg<GsysLoginlog> importDatas(List<GsysLoginlog> importList) {
		ResultMsg<GsysLoginlog> result = new ResultMsg<GsysLoginlog>();
		if(null==importList||importList.isEmpty()){
			result.setMessage("无记录导入");
			return result;
		}
		List<GsysLoginlog> addList = new ArrayList<GsysLoginlog>();
		List<GsysLoginlog> updateList = new ArrayList<GsysLoginlog>();
		for (GsysLoginlog gsysLoginlog : importList) {
			if (StringUtils.isBlank(gsysLoginlog.getId())) {
				gsysLoginlog .setId(null);
				addList.add(gsysLoginlog );
			} else {
				updateList.add(gsysLoginlog);
			}
		}
		hibernateDao.save(addList);
		hibernateDao.update(updateList);
		StringBuilder msgSb = new StringBuilder("");
		int addCount = addList.size();
		int updateCount = updateList.size();
		msgSb.append("共成功导入" + (addCount+updateCount) + "项记录!");
		if(addCount!=0){
			msgSb.append(" 新增:"+addCount+"项.");
		}
		if(updateCount!=0){
			msgSb.append(" 更新:"+updateCount+"项.");
		}
		result.setMessage(msgSb.toString());
		return result;
	}

	@Transactional
	public void saveByUserLogin(GsysLoginlog gsysLoginlog) {
		if (null != gsysLoginlog.getUserId()) {
			gsysUserService.updateLastLoginTimeById(gsysLoginlog.getUserId(), gsysLoginlog.getCreatedate());
		}
		hibernateDao.save(gsysLoginlog);
	}					

}
