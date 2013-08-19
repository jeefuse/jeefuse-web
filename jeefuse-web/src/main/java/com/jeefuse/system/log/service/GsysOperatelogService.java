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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
import com.jeefuse.system.log.web.rto.GsysOperatelogRTO;

/**
 * 操作日志 Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysOperatelogService extends GenericService<GsysOperatelog, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public GsysOperatelog save(GsysOperatelogRTO rto) throws ValidateViolationException;

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public GsysOperatelog update(GsysOperatelogRTO rto) throws ValidateViolationException ;
	
	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysOperatelog> findByProperty(GsysOperatelogField gsysOperatelogField, Object value);

	/**
	 * 判断属性的值是否唯一.
	 *
	 * @generated
	 */
	public boolean isPropertyUnique(GsysOperatelogField gsysOperatelogField, Object newValue);
	
	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysOperatelog> find(Page<GsysOperatelog> page, GsysOperatelogRTO rto, Order[] orders);
	
	/**
	 * 导入数据.
 	 * @generated
	 */
	public ResultMsg<GsysOperatelog> importDatas(List<GsysOperatelog> importList);

	/**
	 * 查询"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	public Page<GsysOperatelog> findByGsysUser(Page<GsysOperatelog> page, GsysOperatelogRTO rto, Order[] orders);

	/**
	 * 保存"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	public GsysOperatelog saveByGsysUser(GsysOperatelogRTO rto);

	/**
	 * 更新"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	public GsysOperatelog updateByGsysUser(GsysOperatelogRTO rto);

	/**
	 * 删除所有"GsysUser(GsysUser)"关联的"操作日志(GsysOperatelog)".
	 * @generated
	 */
	public int deleteAllByGsysUser(String gsysUserId);
	

}
