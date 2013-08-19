/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.service;

import java.util.List;

import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.web.rto.GsysCodevalueRTO;

/**
 * GsysCodevalue Entity CRUD service.
 * 
 * @author yonclv
 * @generated
 */
public interface GsysCodevalueService extends GenericService<GsysCodevalue, String> {

	/**
	 * 从RTO中保存对象.
	 */
	public GsysCodevalue save(GsysCodevalueRTO model);

	/**
	 *从RTO中更新对象.
	 */
	public GsysCodevalue update(GsysCodevalueRTO model);

	/**
	 * 判断属性的值是否唯一.
	 * 
	 * @generated
	 */
	public boolean isPropertyUnique(GsysCodevalueField gsysCodevalueField, Object newValue);

	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysCodevalue> findByProperty(GsysCodevalueField gsysCodevalueField, Object value);

	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysCodevalue> find(Page<GsysCodevalue> page, GsysCodevalueRTO rto, Order[] orders);

	/**
	 * 导入数据.
	 * 
	 * @generated
	 */
	public ResultMsg<GsysCodevalue> importDatas(List<GsysCodevalue> importList);

	/*****************************************************************
	 * manage by Gsyscode
	 *****************************************************************/

	/**
	 * 查询GsysCode关联的GsysCodevalue.
	 */
	public Page<GsysCodevalue> findByGsysCode(Page<GsysCodevalue> page, GsysCodevalueRTO rto, Order[] orders);

	/**
	 * 查询GsysCode关联的GsysCodevalue.
	 */
	public List<GsysCodevalue> findByGsysCode(String gsysCodeId);

	/**
	 * 查询GsysCode关联的GsysCodevalue.只获取name、value属性.
	 */
	public List<KeyLabel> findByGsysCodeForKeyLabel(String gsysCodeId);

	/**
	 * 保存GsysCode关联的GsysCodevalue.
	 */
	public GsysCodevalue saveByGsysCode(GsysCodevalueRTO rto);

	/**
	 * 更新GsysCode关联的GsysCodevalue.
	 */
	public GsysCodevalue updateByGsyscode(GsysCodevalueRTO rto);

	/**
	 * 删除所有GsysCode关联的GsysCodevalue.
	 */
	public int deleteAllByGsysCode(String gsysCodeId);

	/**
	 * 判断属性值是否唯一.唯一返回true,否则返回false.
	 */
	public boolean isValueUnique(String cid, String value);

}
