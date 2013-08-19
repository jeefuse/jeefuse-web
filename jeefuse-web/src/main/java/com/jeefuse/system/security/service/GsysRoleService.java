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
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.parse.GsysRoleField;
import com.jeefuse.system.security.web.rto.GsysRoleRTO;

/**
 * GsysRole Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysRoleService extends GenericService<GsysRole, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public void save(GsysRole gsysRole, Boolean isValidate) throws ValidateViolationException;

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public void update(GsysRole gsysRole, Boolean isValidate) throws ValidateViolationException ;
	
	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysRole> findByProperty(GsysRoleField gsysRoleField, Object value);

	/**
	 * 判断属性的值是否唯一.
	 *
	 * @generated
	 */
	public boolean isPropertyUnique(GsysRoleField gsysRoleField, Object newValue);
	
	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysRole> find(Page<GsysRole> page, GsysRoleRTO rto, Order[] orders);

	/**
	 * 保存对象,及其关联的功能、资源.
	 * 
	 * @param rto
	 * @param isValidate
	 * @param relGsysFunctionCheckIds
	 * @param relGsysResourceCheckIds
	 * @return
	 */
	public GsysRole save(GsysRoleRTO rto, boolean isValidate, String[] relGsysFunctionCheckIds,
			String[] relGsysResourceCheckIds);

	/**
	 * 更新对象,及其关联的功能、资源.
	 * 
	 * @param rto
	 * @param isValidate
	 * @param relGsysFunctionCheckIds
	 * @param relGsysResourceCheckIds
	 * @return
	 */
	public GsysRole update(GsysRoleRTO rto, boolean isValidate, String[] relGsysFunctionCheckIds,
			String[] relGsysResourceCheckIds);

	/**
	 * 获取所有GsysRole对象用于构造keyLabel,只获取key,label属性.
	 */
	public List<KeyLabel> getAllGsysRoleForKeyLabel();
	
}
