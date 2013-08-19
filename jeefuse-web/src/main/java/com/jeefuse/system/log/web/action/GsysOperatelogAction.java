/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.action;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.InvalidStateException;
import org.springframework.util.Assert;

import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.LogType;
import com.jeefuse.system.log.model.validate.GsysOperatelogValidate;
import com.jeefuse.system.log.service.GsysOperatelogService;
import com.jeefuse.system.log.service.LogServiceFactory;
import com.jeefuse.system.log.web.exports.GsysOperatelogExportFactory;
import com.jeefuse.system.log.web.imports.GsysOperatelogImportFactory;
import com.jeefuse.system.log.web.render.GsysOperatelogRenderUtil;
import com.jeefuse.system.log.web.rto.GsysOperatelogRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 操作日志 Entity CRUD action.
 *
 * @author yonclv
 * @generated
 */
public class GsysOperatelogAction extends BaseAction implements ModelDriven<GsysOperatelogRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 操作日志 Entity CRUD service.
	 * @generated
	 */
	public GsysOperatelogService getGsysOperatelogService() {
		return LogServiceFactory.getGsysOperatelogService();
	}
	
	/*****************************************************************
	 * property define
	/*****************************************************************/

	/** @generated */
	private Page<GsysOperatelog> page=null;
	/** @generated */
	private GsysOperatelog mo=null;
	/** @generated */
	private GsysOperatelogRTO rto=null;

	/** @generated */
	public Page<GsysOperatelog> getPage() {
		if(null==page) {
			page=new Page<GsysOperatelog>();
		}
		return page;
	}

	/** @generated */
	public GsysOperatelogRTO getModel() {
		if(null==rto) {
			rto = new GsysOperatelogRTO();
		}
		return rto;
	}
	
	/** @generated */
	public GsysOperatelog getMo() {
		if (null == mo) {
			mo = new GsysOperatelog();
		}
		return mo;
	}

	
	/** @generated */
	public String getLogTypeHtmlSelect() {
		return LogType.toHtmlSelect(null == mo ? null : mo.getKind());
	}

	/** @generated */
	public String getLogTypeJson() {
		return LogType.toHtmlJSON;
	}

	/************************************************************************
	 * request function invoke
	 ************************************************************************/

	/**
	 * 转向管理页面.
	 * @generated
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
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page=getGsysOperatelogService().find(getPage(), getModel(), orders);
			GsysOperatelogRenderUtil.jsonFlexiGrid(getPage());
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
			Assert.notNull(getModel().getId());
			mo = getGsysOperatelogService().get(getModel().getId());
			GsysOperatelogRenderUtil.jsonResultMsg(true, mo, null);
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
			if (StringUtils.isBlank(getModel().getId())) {				
			} else {
				mo = getGsysOperatelogService().get(rto.getId());								
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
			Assert.notNull(getModel());
			mo=getGsysOperatelogService().save(getModel());			
			GsysOperatelogRenderUtil.jsonResultMsg(true, mo, "保存成功!");
			return;			
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysOperatelogValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			AppAssert.notNull(getModel().getId(), "未指定更新记录!");
			mo=getGsysOperatelogService().update(getModel());
			GsysOperatelogRenderUtil.jsonResultMsg(true, mo, "更新成功!");
			return; 
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysOperatelogValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			int delCount = getGsysOperatelogService().delete(delIds);
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
			int delCount = getGsysOperatelogService().deleteAll();
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
			page = getGsysOperatelogService().find(getPage(), getModel(), orders);
			GsysOperatelogExportFactory.excelExportAllField(getResponse(),
					GsysOperatelogExportFactory.getGsysOperatelogExcelExportTemplateFileName(), getPage().getResult());
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
				List<GsysOperatelog> importModelList = GsysOperatelogImportFactory.excelToModel(fileList.get(0));	
				ResultMsg<GsysOperatelog> resultMsg =getGsysOperatelogService().importDatas(importModelList);
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
}
