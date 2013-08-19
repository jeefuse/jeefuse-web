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
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.enumeration.CodeOperateKind;
import com.jeefuse.system.code.model.parse.GsysCodeField;
import com.jeefuse.system.code.model.validate.GsysCodeValidate;
import com.jeefuse.system.code.service.CodeServiceFactory;
import com.jeefuse.system.code.service.GsysCodeService;
import com.jeefuse.system.code.web.exports.GsysCodeExportFactory;
import com.jeefuse.system.code.web.imports.GsysCodeImportFactory;
import com.jeefuse.system.code.web.render.GsysCodeRenderUtil;
import com.jeefuse.system.code.web.rto.GsysCodeRTO;
import com.jeefuse.system.security.service.spring.SecurityHolder;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysCode Entity CRUD action.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodeAction extends BaseAction implements ModelDriven<GsysCodeRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/**
	 * 获取GsysCode CRUD 服务.
	 * 
	 * @generated
	 */
	private GsysCodeService getGysCodeService() {
		return CodeServiceFactory.getGsysCodeService();
	}

	/*****************************************************************
	 * property /
	 *****************************************************************/

	/** @generated */
	private Page<GsysCode> page;
	/** @generated */
	private GsysCode mo;
	/** @generated */
	private GsysCodeRTO rto;

	/** @generated */
	public Page<GsysCode> getPage() {
		if (null == page) {
			page = new Page<GsysCode>();
		}
		return page;
	}

	/** @generated */
	public GsysCodeRTO getModel() {
		if (null == rto) {
			rto = new GsysCodeRTO();
		}
		return rto;
	}

	/** @generated */
	public GsysCode getMo() {
		if (null == mo) {
			mo = new GsysCode();
		}
		return mo;
	}

	/** @generated */
	public String getCodeOperateKindHtmlSelect() {
		return CodeOperateKind.toHtmlSelect(null == mo ? null : mo.getKind());
	}

	/** @generated */
	public String getCodeOperateKindJson() {
		return CodeOperateKind.toHtmlJSON;
	}

	/***********************************************************************
	 * request function invoke
	 ***********************************************************************/

	/**
	 * 获取Entity列表.返回json格式.
	 * 
	 * @generated
	 */
	public void listOutJson() {
		try {
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGysCodeService().find(getPage(), getModel(), orders);
			GsysCodeRenderUtil.jsonFlexiGrid(getPage());
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
	 * 
	 * @generated
	 */
	public void getOutJson() {
		try {
			Assert.notNull(getModel());
			mo = getGysCodeService().get(getModel().getId());
			GsysCodeRenderUtil.jsonResultMsg(true, mo, null);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 根据主键获取Entity,并转向修改页面.
	 * 
	 * @generated
	 */
	public String edit() {
		try {
			if (StringUtils.isNotBlank(rto.getId())) {
				mo = getGysCodeService().get(rto.getId());
			}
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 保存或更新Entity,返回json格式.
	 * 
	 * @generated
	 */
	public void saveOutJson() {
		try {
			// for assign id validate unique
			AppAssert.isNotblank(getModel().getId(), "您还没填写" + GsysCodeField.cid.getFieldName());
			if (!getGysCodeService().isPropertyUnique(GsysCodeField.cid, getModel().getId())) {
				RenderUtil.renderJsonResultMsgError(GsysCodeField.cid.getFieldName() + "已经存在!");
				return;
			}
			mo = getGysCodeService().save(getModel());
			RenderUtil.renderJsonResultMsg(true, mo, "保存成功!");
			return;
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysCodeValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			AppAssert.isNotblank(getModel().getId(), "ID不能为空!");
			// for assign id
			AppAssert.isNotblank(getModel().getOldId(), "请指定要更新的记录!");
			GsysCode newModel = getGysCodeService().update(getModel());
			GsysCodeRenderUtil.jsonResultMsg(true, newModel, "更新成功!");
			return;
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysCodeValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
	 * 
	 * @generated
	 */
	public void deleteOutJson() {
		try {
			Assert.notNull(getModel().getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(getModel().getId(), ",");
			int delCount = getGysCodeService().delete(delIds);
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
	 * 
	 * @generated
	 */
	public void deleteAllOutJson() {
		try {
			if (!SecurityHolder.isUserLogin()) {
				RenderUtil.renderJsonNoLogin();
				return;
			}
			int delCount = getGysCodeService().deleteAll();
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
	 * 
	 * @generated
	 */
	public void exportExcelFile() {
		try {
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGysCodeService().find(getPage(), getModel(), orders);
			GsysCodeExportFactory.excelExportAllField(getResponse(),
					GsysCodeExportFactory.getGsysCodeExcelExportTemplateFileName(), getPage().getResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导入excel文件.
	 * 
	 * @generated
	 */
	public String importExcelFile() {
		return SUCCESS;
	}

	/**
	 * 导入excel 文件处理.
	 * 
	 * @generated
	 */
	public void importExcelFileProcess() {

		try {
			List<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());
			if (!fileList.isEmpty()) {
				List<GsysCode> importModelList = GsysCodeImportFactory.excelToModel(fileList.get(0));
				ResultMsg<GsysCode> resultMsg = getGysCodeService().importDatas(importModelList);
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