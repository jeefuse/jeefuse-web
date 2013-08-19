/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.service;

import java.util.List;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.condition.order.OrderSet;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;
import com.jeefuse.system.security.web.rto.GsysFunctionRTO;

/**
 * GsysFunction Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysFunctionService extends GenericService<GsysFunction, String> {

	/**
	 * 保存对象.
	 * 
	 * @throws ValidateViolationException
	 */
	public GsysFunction save(GsysFunctionRTO rto) throws ValidateViolationException;

	/**
	 * 更新对象.并更新所有后代对象.
	 * 
	 * @throws ValidateViolationException
	 */
	public GsysFunction update(GsysFunctionRTO rto, boolean isvalidate) throws ValidateViolationException;

	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysFunction> findByProperty(GsysFunctionField gsysFunctionField, Object value);

	/**
	 * 判断属性的值是否唯一.
	 *
	 * @generated
	 */
	public boolean isPropertyUnique(GsysFunctionField gsysFunctionField, Object newValue);
	
	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysFunction> find(Page<GsysFunction> page, GsysFunctionRTO rto, Order[] orders);


	/**
	 * 导入数据.
	 */
	public ResultMsg<GsysFunction> importDatas(List<GsysFunction> importList);

	/*****************************************************************
	 * 树形操作
	/*****************************************************************/

	/**
	 * 查询所有后代对象,
	 */
	public Page<GsysFunction> findDescendant(Page<GsysFunction> page, GsysFunctionRTO rto, Order[] orders);

	/**
	 * 根据ID检查对象是否有子节点.
	 */
	public boolean hasChildren(String[] ids);

	/**
	 * 删除当前对象,同时删除下级对象.
	 */
	public int deleteDescendant(String[] delIds);

	/**
	 * 获取所有GsysFunction用于构造jquery.tree.js,只获取id,parentId,displayName属性.
	 */
	public List<TreeViewItem> getAllForTreeview(OrderSet orderSet);

	/**
	 * 获取所有GsysFunction用于构造树形菜单.
	 */
	public List<GsysFunction> getAllForTreeMenu();

}
