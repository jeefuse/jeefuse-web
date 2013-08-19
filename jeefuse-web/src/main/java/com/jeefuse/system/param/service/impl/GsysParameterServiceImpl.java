/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ValidateViolationException;
import com.jeefuse.base.modules.condition.criteria.Condition;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.service.impl.GenericServiceImpl;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;
import com.jeefuse.system.param.service.GsysParameterService;
import com.jeefuse.system.param.web.rto.GsysParameterRTO;

/**
 * GsysParameter Entity CRUD service impl.
 *
 * @author yonclv
 * @generated
 */
@Service(value="gsysParameterServiceImpl")
public class GsysParameterServiceImpl extends GenericServiceImpl<GsysParameter, String> implements GsysParameterService{

	/** 
	 * GsysParameterServiceImpl constructor with set GsysParameter entity Class.
	 * @generated 
	 */
	@Autowired
	public GsysParameterServiceImpl(HibernateDao HibernateDao) {
		super(HibernateDao, GsysParameter.class);
	}
	
	/**
	 * 验证并保存对象.
	 * 
	 * @generated
	 */
	@Transactional
	public GsysParameter save(GsysParameterRTO rto) throws ValidateViolationException {
		GsysParameter newModel = rto.getNewModel();
		hibernateDao.save(newModel);
		return newModel;
	}

	/**
	 * 验证并更新对象.
	 * 
	 * @generated
	 */
	@Transactional
	public GsysParameter update(GsysParameterRTO rto) throws ValidateViolationException {
		AppAssert.isNotblank(rto.getId(), "ID不能为空!");
		GsysParameter oldModel = get(rto.getId());
		AppAssert.notNull(oldModel, "您更新的对象不存在!");
		GsysParameter newModel = rto.getModifiedModel(oldModel);
		// hibernateDao.update(newModel);//in session will auto update it.
		return newModel;
	}

	/** @generated*/
	public List<GsysParameter> findByProperty(GsysParameterField gsysParameterField, Object value){
		return findByProperty(gsysParameterField.getFieldName(), value);
	}

	/** @generated*/
	public boolean isPropertyUnique(GsysParameterField gsysParameterField, Object newValue){
		Object m = findUniqueByProperty(gsysParameterField.getFieldName(), newValue);
		return (m == null);
	}
	
	/** @generated*/
	public Page<GsysParameter> find(Page<GsysParameter> page, GsysParameterRTO rto, Order[] orders) {
		Condition condition = Condition.and();
		condition.addStartsLikeIfNotBlank(GsysParameterField.name.getFieldName(), rto.getName());//1 参数名
		condition.addEqIfNotBlank(GsysParameterField.value.getFieldName(), rto.getValue());//2 参数值
		return hibernateDao.find(entityClass, page, condition, orders);
	}
	
	/** @generated */
	@Transactional
	public ResultMsg<GsysParameter> importDatas(List<GsysParameter> importList) {
		ResultMsg<GsysParameter> result = new ResultMsg<GsysParameter>();
		if(null==importList||importList.isEmpty()){
			result.setMessage("无记录导入");
			return result;
		}
		List<GsysParameter> addList = new ArrayList<GsysParameter>();
		List<GsysParameter> updateList = new ArrayList<GsysParameter>();
		for (GsysParameter gsysParameter : importList) {
			if (StringUtils.isBlank(gsysParameter.getId())) {
				gsysParameter .setId(null);
				addList.add(gsysParameter );
			} else {
				updateList.add(gsysParameter);
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
	
	
}
