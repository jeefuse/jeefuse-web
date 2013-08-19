/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import java.util.List;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;
import com.jeefuse.system.security.web.rto.GsysResourceRTO;

/**
 * GsysResource Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysResourceService extends GenericService<GsysResource, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public void save(GsysResource gsysResource, Boolean isValidate) throws ValidateViolationException;

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public void update(GsysResource gsysResource, Boolean isValidate) throws ValidateViolationException ;
	
	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysResource> findByProperty(GsysResourceField gsysResourceField, Object value);

	/**
	 * 判断属性的值是否唯一.
	 *
	 * @generated
	 */
	public boolean isPropertyUnique(GsysResourceField gsysResourceField, Object newValue);
	
	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysResource> find(Page<GsysResource> page, GsysResourceRTO rto, Order[] orders);

	/**
	 * 获取所有GsysResource对象用于构造keyLabel,只获取key,label属性.
	 */
	public List<KeyLabel> getAllForKeyLabel();
	
}
