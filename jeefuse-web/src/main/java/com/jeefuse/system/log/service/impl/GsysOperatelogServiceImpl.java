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
import org.springframework.util.Assert;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.common.DateUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
import com.jeefuse.system.log.service.GsysOperatelogService;
import com.jeefuse.system.log.web.rto.GsysOperatelogRTO;

/**
 * 操作日志 Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysOperatelogServiceImpl")
public class GsysOperatelogServiceImpl extends GenericServiceImpl<GsysOperatelog, String> implements GsysOperatelogService{

	/** 
	 * GsysOperatelogServiceImpl constructor with set GsysOperatelog entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysOperatelogServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysOperatelog.class);
	}
	
	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public GsysOperatelog save(GsysOperatelogRTO rto) throws ValidateViolationException {
		GsysOperatelog newModel = rto.getNewModel();
		hibernateDao.save(newModel);
		return newModel;
	}

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	@Transactional
	public GsysOperatelog update(GsysOperatelogRTO rto) throws ValidateViolationException {
		AppAssert.isNotblank(rto.getId(), "ID不能为空!");
		GsysOperatelog oldModel = get(rto.getId());
		AppAssert.notNull(oldModel, "您更新的对象不存在!");
		GsysOperatelog newModel = rto.getModifiedModel(oldModel);
		// hibernateDao.update(newModel);//in session will auto update it.
		return newModel;
	}
	
	/** @generated*/
	public List<GsysOperatelog> findByProperty(GsysOperatelogField gsysOperatelogField, Object value){
		return findByProperty(gsysOperatelogField.getFieldName(), value);
	}

	/** @generated*/
	public boolean isPropertyUnique(GsysOperatelogField gsysOperatelogField, Object newValue){
		Object m = findUniqueByProperty(gsysOperatelogField.getFieldName(), newValue);
		return (m == null);
	}
	
	/** @generated*/
	public Page<GsysOperatelog> find(Page<GsysOperatelog> page, GsysOperatelogRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addEqIfNotBlank(GsysOperatelogField.loginIp.getFieldName(), rto.getLoginIp());//1 登录IP
		if (StringUtils.isNotBlank(rto.getCreatedateStart())) {//2 创建时间				
			Date createdateStart = DateUtil.getDayStart(DateUtil.parseDate(rto.getCreatedateStart()));
			condition.addGe(GsysOperatelogField.createdate.getFieldName(), createdateStart);
		}
		if (StringUtils.isNotBlank(rto.getCreatedateEnd())) {
			Date createdateEnd = DateUtil.addDays(DateUtil.parseDate(rto.getCreatedateEnd()), 1);;
			condition.addLe(GsysOperatelogField.createdate.getFieldName(), createdateEnd);
		}
		condition.addStartsLikeIfNotBlank(GsysOperatelogField.userId.getFieldName(), rto.getUserId());//3 操作用户
		condition.addEqIfNotBlank(GsysOperatelogField.kind.getFieldName(), rto.getKind());//4 类型
		return hibernateDao.find(entityClass, page, condition, orders);
	}
	
	/** @generated */
	@Transactional
	public ResultMsg<GsysOperatelog> importDatas(List<GsysOperatelog> importList) {
		ResultMsg<GsysOperatelog> result = new ResultMsg<GsysOperatelog>();
		if(null==importList||importList.isEmpty()){
			result.setMessage("无记录导入");
			return result;
		}
		List<GsysOperatelog> addList = new ArrayList<GsysOperatelog>();
		List<GsysOperatelog> updateList = new ArrayList<GsysOperatelog>();
		for (GsysOperatelog gsysOperatelog : importList) {
			if (StringUtils.isBlank(gsysOperatelog.getId())) {
				gsysOperatelog .setId(null);
				addList.add(gsysOperatelog );
			} else {
				updateList.add(gsysOperatelog);
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

	/**
	 * 查询"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	public Page<GsysOperatelog> findByGsysUser(Page<GsysOperatelog> page, GsysOperatelogRTO rto, Order[] orders) {
		AppAssert.notNull(rto.getGsysUser().getId(), "未指定GsysUser!");
		Condition condition = Condition.and();
		condition.addEq("gsysUser.id", rto.getGsysUser().getId());
		condition.addEqIfNotBlank(GsysOperatelogField.loginIp.getFieldName(), rto.getLoginIp());//1 登录IP
		if (StringUtils.isNotBlank(rto.getCreatedateStart())) {//2 创建时间				
			Date createdateStart = DateUtil.getDayStart(DateUtil.parseDate(rto.getCreatedateStart()));
			condition.addGe(GsysOperatelogField.createdate.getFieldName(), createdateStart);
		}
		if (StringUtils.isNotBlank(rto.getCreatedateEnd())) {
			Date createdateEnd = DateUtil.addDays(DateUtil.parseDate(rto.getCreatedateEnd()), 1);;
			condition.addLe(GsysOperatelogField.createdate.getFieldName(), createdateEnd);
		}
		condition.addEqIfNotBlank(GsysOperatelogField.userId.getFieldName(), rto.getUserId());//3 操作用户
		condition.addEqIfNotBlank(GsysOperatelogField.kind.getFieldName(), rto.getKind());//4 类型
		return hibernateDao.find(entityClass, page, condition, orders);
	}

	/**
	 * 保存"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	@Transactional
	public GsysOperatelog saveByGsysUser(GsysOperatelogRTO rto) {
		GsysOperatelog gsysOperatelog=rto.getNewModel();
		//AppAssert.notNull(gsysOperatelog.getGsysUser().getId(), "未指定GsysUser!");
		hibernateDao.save(gsysOperatelog);
		return gsysOperatelog;
	}

	/**
	 * 更新"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	@Transactional
	public GsysOperatelog updateByGsysUser(GsysOperatelogRTO rto) {
		GsysOperatelog oldGsysOperatelog = get(rto.getId());
		AppAssert.notNull(oldGsysOperatelog, "您更新的记录不存在!");
		GsysOperatelog gsysOperatelog = rto.getModifiedModel(oldGsysOperatelog);
		// AppAssert.notNull(gsysOperatelog.getGsysUser().getId(),"未指定GsysUser!");
		// hibernateDao.save(gsysOperatelog);//in session will auto update
		return gsysOperatelog;
	}

	/**
	 * 删除所有"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	@Transactional
	public int deleteAllByGsysUser(String gsysUserId) {	
		Assert.hasText(gsysUserId, "标识不能为空!");
		final String hql = "delete from " + entityClass.getName() + " m where m.gsysUser.id=?";
		return hibernateDao.executeUpdate(hql, gsysUserId);
	}					

}
