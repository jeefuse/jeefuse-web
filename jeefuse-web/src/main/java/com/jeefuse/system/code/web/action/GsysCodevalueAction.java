/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.InvalidStateException;
import org.springframework.util.Assert;

import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.model.validate.ValidateUtil;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;
import com.jeefuse.system.code.service.CodeServiceFactory;
import com.jeefuse.system.code.service.GsysCodeService;
import com.jeefuse.system.code.service.GsysCodevalueService;
import com.jeefuse.system.code.web.exports.GsysCodevalueExportFactory;
import com.jeefuse.system.code.web.imports.GsysCodevalueImportFactory;
import com.jeefuse.system.code.web.render.GsysCodevalueRenderUtil;
import com.jeefuse.system.code.web.rto.GsysCodevalueRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysCodevalue Entity CRUD action.
 *
 * @author yonclv
 * @generated
 */
public class GsysCodevalueAction extends BaseAction implements ModelDriven<GsysCodevalueRTO> {
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

	/**
	 * 获取GsysCodeService CRUD 服务.
	 * 
	 * @generated
	 */
	private GsysCodeService getGysCodeService() {
		return CodeServiceFactory.getGsysCodeService();
	}

	//property
	/** @generated */
	private Page<GsysCodevalue> page=null;
	/** @generated */
	private GsysCodevalue mo=null;
	/** @generated */
	private GsysCodevalueRTO rto=null;
	private String gsysCodeKeyLabelSelect;

	/** @generated */
	public Page<GsysCodevalue> getPage() {
		if(null==page) {
			page=new Page<GsysCodevalue>();
		}
		return page;
	}

	/** @generated */
	public GsysCodevalueRTO getModel() {
		if(null==rto) {
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
		return SUCCESS;
	}

	/**
	 * 获取Entity列表.返回json格式.
	 * @generated
	 */
	public void listOutJson() {
		try {
			// find
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGysCodeValueService().find(getPage(), getModel(), orders);
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
	 * 根据ID获取Entity对象,返回json格式.
	 * @generated
	 */
	public void getOutJson() {
		try {
			Assert.notNull(getModel());
			mo = getGysCodeValueService().get(getModel().getId());
			GsysCodevalueRenderUtil.jsonResultMsg(true, mo, null);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
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
			List<GsysCode> gsysCodeKeyLabelList = getGysCodeService().getAllForKeyLabel();
			// for update
			if (StringUtils.isNotBlank(getModel().getId())) {
				mo = getGysCodeValueService().get(getModel().getId());
				String gsysCodeCid = null == mo.getGsysCode() ? null : mo.getGsysCode().getCid();
				gsysCodeKeyLabelSelect = KeyLabelRenderUtil.renderHtmlSelect(gsysCodeKeyLabelList, gsysCodeCid);
			} else {
				gsysCodeKeyLabelSelect = KeyLabelRenderUtil.renderHtmlSelect(gsysCodeKeyLabelList, null);
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
			if (null == getModel().getGsysCode() || null == getModel().getGsysCode().getCid()) {
				RenderUtil.renderJsonResultMsgError("您还没填写" + GsysCodeField.cid.getFieldName());
				return;
			}
			GsysCode gsysCode = getGysCodeService().get(getModel().getGsysCode().getCid());
			if (null == gsysCode) {
				RenderUtil.renderJsonResultMsgError("您选择的编码类别" + getModel().getGsysCode().getCid() + "不存在!");
				return;
			}
			if (StringUtils.isBlank(getModel().getId())) {
				mo = getGysCodeValueService().save(getModel());
			} else {
				mo = getGysCodeValueService().update(getModel());
			}
			mo.setGsysCode(gsysCode);
			GsysCodevalueRenderUtil.jsonResultMsg(true, mo, "保存成功!");
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
			AppAssert.isNotblank(getModel().getId(), "请指定要更新的记录!");
			GsysCodevalue newModel = getGysCodeValueService().update(getModel());
			GsysCodevalueRenderUtil.jsonResultMsg(true, newModel, "更新成功!");
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
			Assert.notNull(getModel());
			if (StringUtils.isBlank(getModel().getId())) {
				mo = getGysCodeValueService().save(getModel());
				RenderUtil.renderJsonResultMsg(true, mo, "保存成功!");
				return;
			} else {
				mo = getGysCodeValueService().update(getModel());
				RenderUtil.renderJsonResultMsg(true, mo, "更新成功!");
				return;
			}
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
	 * 删除Entity,返回json格式.
	 * @generated
	 */
	public void deleteOutJson() {
		try {
			Assert.notNull(getModel().getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(getModel().getId(), ",");
			int delCount = getGysCodeValueService().delete(delIds);
			RenderUtil.renderJsonResultMsgSuccess("删除成功" + delCount + "项记录!");
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 删除所有Entity,返回json格式.
	 * @generated
	 */
	public void deleteAllOutJson() {
		try {
			int delCount = getGysCodeValueService().deleteAll();
			RenderUtil.renderJsonResultMsgSuccess("删除成功" + delCount + "项记录!");
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 导出 Excel 文件.
     * @generated
	 */
	public void exportExcelFile() {
		try {
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGysCodeValueService().find(getPage(), getModel(), orders);
			GsysCodevalueExportFactory.excelExportAllField(getResponse(),
					GsysCodevalueExportFactory.getGsysCodevalueExcelExportTemplateFileName(), getPage().getResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导入excel文件.
	 * @generated
	 */
	public String importExcelFile() {

		// if (!SpringSecurityUtils.isUserLogin()) {
		// RenderUtil.renderHtmlNoLogin();
		// return;
		// }
		
		return SUCCESS;
	}

	/**
	 * 导入excel 文件处理.
	 * @generated
	 */
	public void importExcelFileProcess() {

		// if (!SpringSecurityUtils.isUserLogin()) {
		// RenderUtil.renderHtmlNoLogin();
		// return;
		// }
		try {
			List<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());
			if (!fileList.isEmpty()) {
				List<GsysCodevalue> importModelList = GsysCodevalueImportFactory.excelToModel(fileList.get(0));	
				ResultMsg<GsysCodevalue> resultMsg = getGysCodeValueService().importDatas(importModelList);
				RenderUtil.renderHtml(resultMsg.getMessage());
				return;
			}
			RenderUtil.renderHtml("请上传需要导入的excel文件!");
		} catch (ApplicationException e) {
			RenderUtil.renderHtml(e.getMessage());
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			RenderUtil.renderHtml("导入失败!文件加载错误!");
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			RenderUtil.renderHtml("导入失败!");
			logger.error(e.getMessage(), e);
		}
	}

	/************************************************************************
	 * 页面属性访问
	 ************************************************************************/

	public String getGsysCodeKeyLabelSelect() {
		return gsysCodeKeyLabelSelect;
	}
	
}