/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.action;

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
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.validate.GsysParameterValidate;
import com.jeefuse.system.param.service.GsysParameterService;
import com.jeefuse.system.param.service.ParamServiceFactory;
import com.jeefuse.system.param.web.exports.GsysParameterExportFactory;
import com.jeefuse.system.param.web.imports.GsysParameterImportFactory;
import com.jeefuse.system.param.web.render.GsysParameterRenderUtil;
import com.jeefuse.system.param.web.rto.GsysParameterRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysParameter Entity CRUD action.
 *
 * @author yonclv
 * @generated
 */
public class GsysParameterAction extends BaseAction implements ModelDriven<GsysParameterRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 系统参数 Entity CRUD service.
	 * @generated
	 */
	public GsysParameterService getGsysParameterService() {
		return ParamServiceFactory.getGsysParameterService();
	}

	//property
	/** @generated */
	private Page<GsysParameter> page=null;
	/** @generated */
	private GsysParameter mo=null;
	/** @generated */
	private GsysParameterRTO rto=null;

	/** @generated */
	public Page<GsysParameter> getPage() {
		if(null==page) {
			page=new Page<GsysParameter>();
		}
		return page;
	}

	/** @generated */
	public GsysParameterRTO getModel() {
		if(null==rto) {
			rto = new GsysParameterRTO();
		}
		return rto;
	}
	
	/** @generated */
	public GsysParameter getMo() {
		if (null == mo) {
			mo = new GsysParameter();
		}
		return mo;
	}

	
	/**
	 * 转向管理页面.
	 * @generated
	 */
	public String manage() {
		return SUCCESS;
	}

	/************************************************************************
	 * request function invoke
	 ************************************************************************/
	
	/**
	 * 获取Entity列表.返回json格式.
	 * @generated
	 */
	public void listOutJson() {
		try {
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page=getGsysParameterService().find(getPage(), getModel(), orders);
			GsysParameterRenderUtil.jsonFlexiGrid(getPage());
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
			mo = getGsysParameterService().get(getModel().getId());
			GsysParameterRenderUtil.jsonResultMsg(true, mo, null);
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
				mo = getGsysParameterService().get(rto.getId());								
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
			mo=getGsysParameterService().save(getModel());			
			GsysParameterRenderUtil.jsonResultMsg(true, mo, "保存成功!");
			return;			
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysParameterValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			mo=getGsysParameterService().update(getModel());
			GsysParameterRenderUtil.jsonResultMsg(true, mo, "更新成功!");
			return; 
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysParameterValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			int delCount = getGsysParameterService().delete(delIds);
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
			int delCount = getGsysParameterService().deleteAll();
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
			page = getGsysParameterService().find(getPage(), getModel(), orders);
			GsysParameterExportFactory.excelExportAllField(getResponse(),
					GsysParameterExportFactory.getGsysParameterExcelExportTemplateFileName(), getPage().getResult());
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
				List<GsysParameter> importModelList = GsysParameterImportFactory.excelToModel(fileList.get(0));	
				ResultMsg<GsysParameter> resultMsg =getGsysParameterService().importDatas(importModelList);
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
	
}