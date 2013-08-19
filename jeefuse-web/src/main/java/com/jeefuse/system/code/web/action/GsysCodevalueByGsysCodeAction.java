/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.InvalidStateException;
import org.springframework.util.Assert;

import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.model.validate.ValidateUtil;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.service.CodeServiceFactory;
import com.jeefuse.system.code.service.GsysCodevalueService;
import com.jeefuse.system.code.web.render.GsysCodevalueRenderUtil;
import com.jeefuse.system.code.web.rto.GsysCodevalueRTO;
import com.jeefuse.system.log.service.Applogger;
import com.jeefuse.system.security.service.spring.SecurityHolder;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysCodevalue Entity CRUD action.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueByGsysCodeAction extends BaseAction implements ModelDriven<GsysCodevalueRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取GsysCodevalueService CRUD 服务.
	 * 
	 * @generated
	 */
	private GsysCodevalueService getGysCodeValueService() {
		return CodeServiceFactory.getGsysCodevalueService();
	}

	//property
	/** @generated */
	private Page<GsysCodevalue> page=null;
	/** @generated */
	private GsysCodevalue mo=null;
	/** @generated */
	private GsysCodevalueRTO rto=null;

	/** @generated */
	public Page<GsysCodevalue> getPage() {
		if(null==page) {
			page=new Page<GsysCodevalue>();
		}
		return page;
	}

	/** @generated */
	public GsysCodevalueRTO getModel() {
		if (null == rto) {
			rto = new GsysCodevalueRTO();
		}
		return rto;
	}
	
	/** @generated */
	public GsysCodevalue getMo() {
		if (null == mo) {
			mo = new GsysCodevalue();
		}
		return mo;
	}

	
	/************************************************************************
	 * request function invoke
	 ************************************************************************/

	/**
	 * 转向[GsysCodevalue]管理页面.
	 */
	public String manage() {
		try {
			if (SecurityHolder.isUserNoLogin())
				return NO_LOGIN;
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 获取Entity列表.返回json格式.
	 * @generated
	 */
	public void listOutJson() {
		try {
			// find
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGysCodeValueService().findByGsysCode(getPage(), getModel(), orders);
			GsysCodevalueRenderUtil.jsonFlexiGrid(page);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 获取keyLabel格式数据例表.
	 * 
	 * @generated
	 */
	public void listForKeyLabelOutJson() {
		try {
			if (SecurityHolder.isUserNoLogin()) {
				RenderUtil.renderJsonNoLogin();
				return;
			}
			String gsysCodeId = rto.getGsysCode().getCid();
			Assert.notNull(gsysCodeId, "未指定编码!");
			List<KeyLabel> list = getGysCodeValueService().findByGsysCodeForKeyLabel(gsysCodeId);
			KeyLabelRenderUtil.renderResultMsgJson(list);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			Applogger.appError(e.getMessage(), e, getRequest());
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**根据主键获取Entity,并转向修改页面.
	 * 
	 * @generated
	 */
	public String edit() {
		try {
			if (StringUtils.isNotBlank(getModel().getId())) {
				mo = getGysCodeValueService().get(getModel().getId());
			}
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}
	
	/**
	 * 保存或更新Entity,返回json格式.
	 * @generated
	 */
	public void saveOutJson() {
		try {
			AppAssert.isNotblank(getModel().getGsysCode().getCid(), "您还没填写" + GsysCodevalueField.id.getFieldName());
			if (!getGysCodeValueService().isValueUnique(getModel().getGsysCode().getCid(), getModel().getValue())) {
				RenderUtil.renderJsonResultMsgError(getModel().getValue() + ":该值已经存在!");
				return;
			}
			mo = getGysCodeValueService().saveByGsysCode(getModel());
			RenderUtil.renderJsonResultMsg(true, mo, "保存成功!");
			return;
		} catch (InvalidStateException e) {
			String invalidateMsg = ValidateUtil.getValidateMessageWithBR(e.getInvalidValues(), GsysCodevalueField.id);
			logger.error(invalidateMsg, e);
			RenderUtil.renderJsonResultMsgError(invalidateMsg);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 更新Entity,返回json格式.
	 * 
	 * @generated
	 */
	public void updateOutJson() {
		try {
			AppAssert.isNotblank(getModel().getGsysCode().getCid(), "请指定要更新的编码!");
			if (!getGysCodeValueService().isValueUnique(getModel().getGsysCode().getCid(), getModel().getValue())) {
				RenderUtil.renderJsonResultMsgError(getModel().getValue() + ":该值已经存在!");
				return;
			}
			GsysCodevalue newModel = getGysCodeValueService().updateByGsyscode(getModel());
			RenderUtil.renderJsonResultMsg(true, newModel, "更新成功!");
			return;
		} catch (InvalidStateException e) {
			String invalidateMsg = ValidateUtil.getValidateMessageWithBR(e.getInvalidValues(), GsysCodevalueField.id);
			logger.error(invalidateMsg, e);
			RenderUtil.renderJsonResultMsgError(invalidateMsg);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 保存或更新Entity,返回json格式.
	 * 
	 * @generated
	 */
	public void saveOrUpdateOutJson() {
		try {
			AppAssert.notNull(getModel().getGsysCode().getCid(), "编码无效");
			if (StringUtils.isBlank(getModel().getId())) {
				mo = getGysCodeValueService().saveByGsysCode(getModel());
				RenderUtil.renderJsonResultMsg(true, mo, "保存成功!");
				return;
			} else {
				mo = getGysCodeValueService().updateByGsyscode(getModel());
				RenderUtil.renderJsonResultMsg(true, mo, "更新成功!");
				return;
			}
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}
	
	/**
	 * 删除所有根据GsysCode关联的GsysCodevalue,返回json格式.
	 * 
	 * @generated
	 */
	public void deleteAllOutJson() {
		try {
			int delCount = getGysCodeValueService().deleteAllByGsysCode(getModel().getGsysCode().getCid());
			RenderUtil.renderJsonResultMsgSuccess("删除成功" + delCount + "项记录!");
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

}