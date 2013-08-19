/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.service;

import java.util.List;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.web.rto.GsysCodeRTO;

/**
 * GsysCode Entity CRUD service.
 * 
 * @author yonclv
 * @generated
 */
public interface GsysCodeService extends GenericService<GsysCode, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public void save(GsysCode gsysCode, Boolean isValidate) throws ValidateViolationException;

	/**
	 * 从RTO中保存对象.
	 */
	public GsysCode save(GsysCodeRTO rto);

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public void update(GsysCode gsysCode, Boolean isValidate) throws ValidateViolationException;

	/**
	 * 从RTO中更新对象.
	 */
	public GsysCode update(GsysCodeRTO rto);

	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysCode> findByProperty(GsysCodeField gsysCodeField, Object value);

	/**
	 * 判断属性的值是否唯一.唯一返回true,否则返回false.
	 * 
	 * @generated
	 */
	public boolean isPropertyUnique(GsysCodeField gsysCodeField, Object newValue);

	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysCode> find(Page<GsysCode> page, GsysCodeRTO rto, Order[] orders);

	/**
	 * 导入数据.
	 * 
	 * @generated
	 */
	public ResultMsg<GsysCode> importDatas(List<GsysCode> importList);

	/**
	 * 获取所有对象用于构造keyLabel,只获取key,label属性.
	 */
	public List<GsysCode> getAllForKeyLabel();

	/**
	 * 获取所有编码数据及相关属性值.
	 */
	public List<GsysCode> getAllAndCodeValue();

	/*
	 * 删除所有记录.
	 * 
	 * @see com.jeefuse.base.service.GenericService#deleteAll()
	 */
	public int deleteAll();

}
