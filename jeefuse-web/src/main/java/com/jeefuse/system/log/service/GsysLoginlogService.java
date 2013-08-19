/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.service;

import java.util.List;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
import com.jeefuse.system.log.web.rto.GsysLoginlogRTO;

/**
 * 登入日志 Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysLoginlogService extends GenericService<GsysLoginlog, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public GsysLoginlog save(GsysLoginlogRTO rto) throws ValidateViolationException;

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public GsysLoginlog update(GsysLoginlogRTO rto) throws ValidateViolationException ;
	
	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysLoginlog> findByProperty(GsysLoginlogField gsysLoginlogField, Object value);

	/**
	 * 判断属性的值是否唯一.
	 *
	 * @generated
	 */
	public boolean isPropertyUnique(GsysLoginlogField gsysLoginlogField, Object newValue);
	
	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysLoginlog> find(Page<GsysLoginlog> page, GsysLoginlogRTO rto, Order[] orders);
	
	/**
	 * 导入数据.
 	 * @generated
	 */
	public ResultMsg<GsysLoginlog> importDatas(List<GsysLoginlog> importList);

	/**
	 * 用户登录.
	 */
	public void saveByUserLogin(GsysLoginlog gsysLoginlog);
	

}
