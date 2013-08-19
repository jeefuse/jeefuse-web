/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import java.util.Date;
import java.util.List;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.security.model.ActivatedType;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.model.parse.GsysUserField;
import com.jeefuse.system.security.web.rto.GsysUserRTO;

/**
 * GsysUser Entity CRUD service.
 * 
 * @author yonclv
 * @generated
 */
public interface GsysUserService extends GenericService<GsysUser, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public void save(GsysUser gsysUser) throws ValidateViolationException;

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public void update(GsysUser gsysUser) throws ValidateViolationException;

	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysUser> findByProperty(GsysUserField gsysUserField, Object value);

	/**
	 * 判断属性的值是否已存在,如果不存在则返回true,存在则返回false.
	 * 
	 * @generated
	 */
	public boolean isPropertyUnique(GsysUserField gsysUserField, Object newValue);

	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysUser> find(Page<GsysUser> page, GsysUserRTO rto, Order[] orders);

	/**
	 * 保存对象并关联的系统角色.
	 */
	public void save(GsysUser mo, List<String> relGsysRoleIdList);

	/**
	 * 更新对象并关联的系统角色.
	 */
	public void update(GsysUser mo, List<String> relGsysRoleIdList);

	/**
	 * 登录名是否唯一.唯一则返回true,否则返回false.
	 */
	public boolean isLoginNameUnique(String loginName);

	/**
	 * 根据登录用户名获取用户对象.
	 */
	public GsysUser getByLoginName(String username);

	/**
	 * 更新激活状态.
	 */
	public void updateActivatedById(String id, ActivatedType activated);

	/**
	 * 更新手机号码.
	 */
	public void updateMobileById(String id, String mobile);

	/**
	 * 更新邮箱.
	 */
	public void updateEmailById(String id, String email);

	/**
	 * 验证邮箱是否唯一.唯一则返回true,否则返回false.
	 */
	public boolean isEmailUnique(String email);

	/**
	 * 验证手机号是否唯一.唯一则返回true,否则返回false.
	 */
	public boolean isMobileUnique(String mobile);

	/**
	 * 验证用户的邮箱是否唯一.唯一则返回true,否则返回false.
	 */
	public boolean isMobileUnique(String mobile, String userId);

	/**
	 * 验证用户的手机号是否唯一.唯一则返回true,否则返回false.
	 */
	public boolean isEmailUnique(String email, String userId);

	/**
	 * 获取用户的基本信息.
	 */
	public GsysUser getUserSimpleInfoById(String userId);

	/**
	 * 获取用户的登录名.
	 */
	public String getLoginnameById(String userId);

	/**
	 * 更新用户的登录名.
	 */
	public int updateLoginnameById(String newLoginName, String userId);

	/**
	 * 获取用户的密码.
	 */
	public String getPasswordById(String userId);


	/**
	 * 获取邮件注册的用户.
	 */
	public GsysUser getByEmail(String email);

	/**
	 * 更新最后登录时间.
	 * 
	 * @param userId
	 * @param createdate
	 */
	public int updateLastLoginTimeById(String userId, Date createdate);

}
