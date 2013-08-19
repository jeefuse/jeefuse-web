/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.service;

import java.util.List;

import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.GenericService;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;
import com.jeefuse.system.param.web.rto.GsysParameterRTO;

/**
 * GsysParameter Entity CRUD service.
 *
 * @author yonclv
 * @generated
 */
public interface GsysParameterService extends GenericService<GsysParameter, String> {

	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	public GsysParameter save(GsysParameterRTO rto) throws ValidateViolationException;

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	public GsysParameter update(GsysParameterRTO rto) throws ValidateViolationException ;

	/**
	 * 根据属性值查找对象.
	 * 
	 * @generated
	 */
	public List<GsysParameter> findByProperty(GsysParameterField gsysParameterField, Object value);

	/**
	 * 判断属性的值是否唯一.
	 *
	 * @generated
	 */
	public boolean isPropertyUnique(GsysParameterField gsysParameterField, Object newValue);
	
	/**
	 * 根据请求参数查询.
	 * 
	 * @generated
	 */
	public Page<GsysParameter> find(Page<GsysParameter> page, GsysParameterRTO rto, Order[] orders);
	
	/**
	 * 导入数据.
 	 * @generated
	 */
	public ResultMsg<GsysParameter> importDatas(List<GsysParameter> importList);
	
}
