/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.InvalidStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.tree.TreeRenderUtil;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.utils.common.ChangeUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.code.model.enumeration.InvalidType;
import com.jeefuse.system.security.model.FunctionType;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.validate.GsysFunctionValidate;
import com.jeefuse.system.security.service.GsysFunctionService;
import com.jeefuse.system.security.service.spring.SecurityHolder;
import com.jeefuse.system.security.web.exports.GsysFunctionExportFactory;
import com.jeefuse.system.security.web.imports.GsysFunctionImportFactory;
import com.jeefuse.system.security.web.render.GsysFunctionRenderUtil;
import com.jeefuse.system.security.web.rto.GsysFunctionRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysFunction Entity CRUD action.
 * 
 * @author yonclv
 * @generated
 */
public class GsysFunctionAction extends BaseAction implements ModelDriven<GsysFunctionRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;

	@Autowired
	private GsysFunctionService gsysFunctionService;

	/**
	 * GsysFunction Entity CRUD service.
	 * 
	 * @generated
	 */
	public GsysFunctionService getGsysFunctionService() {
		// return SecurityServiceFactory.getGsysFunctionService();
		return gsysFunctionService;
	}

	// property
	/** @generated */
	private Page<GsysFunction> page = null;
	/** @generated */
	private GsysFunction mo = null;
	/** @generated */
	private GsysFunctionRTO rto = null;

	/** @generated */
	public Page<GsysFunction> getPage() {
		if (null == page) {
			page = new Page<GsysFunction>();
		}
		return page;
	}

	/** @generated */
	public GsysFunctionRTO getModel() {
		if (null == rto) {
			rto = new GsysFunctionRTO();
		}
		return rto;
	}

	/** @generated */
	public GsysFunction getMo() {
		if (null == mo) {
			mo = new GsysFunction();
		}
		return mo;
	}

	/************************************************************************
	 * code kind define
	 ************************************************************************/

	public String getFunctionTypeHtmlSelect() {
		return FunctionType.toHtmlSelect(getMo() == mo ? null : getMo().getType());
	}

	public String getFunctionTypeJson() {
		return FunctionType.toHtmlJSON;
	}

	public String getInvalidTypeHtmlSelect() {
		return InvalidType.toHtmlSelect(getMo() == mo ? null : getMo().getValidStatus());
	}

	public String getInvalidTypeJson() {
		return InvalidType.toHtmlJSON;
	}

	/************************************************************************
	 * request function invoke
	 ************************************************************************/

	/**
	 * 转向管理页面.
	 */
	public String manage() {
		return SUCCESS;
	}

	/**
	 * 获取Entity列表.返回json格式.
	 * 
	 * @generated
	 */
	public void listOutJson() {
		try {
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGsysFunctionService().find(getPage(), getModel(), orders);
			GsysFunctionRenderUtil.jsonFlexiGrid(getPage());
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
			Assert.notNull(getModel().getId());
			mo = getGsysFunctionService().get(getModel().getId());
			GsysFunctionRenderUtil.jsonResultMsg(true, mo, null);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	private String htmlSelectTree;// 构造Html select 树

	/**
	 * 根据主键获取Entity,并转向修改页面.
	 * 
	 * @notgenerated
	 */
	public String edit() {
		try {
			// List<TreeViewItem> list =
			// gsysFunctionService.getAllForTreeview(null);
			// String parentId = null;
			if (StringUtils.isNotBlank(rto.getId())) {
				mo = gsysFunctionService.get(rto.getId());
				// ChangeUtil.excludeTreeIds(list, mo.getId());
				// parentId = mo.getParentId();
			} else {
				// populate default parent object
				if (StringUtils.isNotBlank(getModel().getParentId())) {
					GsysFunction parent = gsysFunctionService.get(getModel().getParentId());
					mo = new GsysFunction();
					mo.setParent(parent);
				}
			}
			// htmlSelectTree = TreeRenderUtil.renderHtmlTreeSelect(list,
			// parentId);
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 保存Entity,返回json格式.
	 * 
	 * @generated
	 */
	public void saveOutJson() {
		try {
			Assert.notNull(getModel());
			mo = getGsysFunctionService().save(getModel());
			GsysFunctionRenderUtil.jsonResultMsg(true, mo, "保存成功!");
			return;
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysFunctionValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			mo = getGsysFunctionService().update(getModel(), false);
			GsysFunctionRenderUtil.jsonResultMsg(true, mo, "更新成功!");
			return;
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysFunctionValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
	 * 删除对象.但不删除其后代对象.
	 */
	public void deleteOutJson() {
		try {
			Assert.notNull(getModel().getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(getModel().getId(), ",");
			int delCount = gsysFunctionService.delete(delIds);
			String msg = delCount == 0 ? "无记录删除!" : "删除成功" + delCount + "项记录!";
			RenderUtil.renderJsonResultMsgSuccess(msg);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 删除当前对象及后代对象.
	 */
	public void deleteDescendantOutJson() {
		try {
			Assert.notNull(getModel().getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(getModel().getId(), ",");
			int delCount = gsysFunctionService.deleteDescendant(delIds);
			String msg = delCount == 0 ? "无记录删除!" : "删除成功" + delCount + "项记录!";
			RenderUtil.renderJsonResultMsgSuccess(msg);
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
			getGsysFunctionService().deleteAll();
			RenderUtil.renderJsonResultMsgSuccess("成功删除所有记录!");
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
			page = getGsysFunctionService().find(getPage(), getModel(), orders);
			GsysFunctionExportFactory.excelExportAllField(getResponse(),
					GsysFunctionExportFactory.getGsysFunctionExcelExportTemplateFileName(), getPage().getResult());
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

		// if (!SpringSecurityUtils.isUserLogin()) {
		// RenderUtil.renderHtmlNoLogin();
		// return;
		// }

		return SUCCESS;
	}

	/**
	 * 导入excel 文件处理.
	 * 
	 * @generated
	 */
	public void importExcelFileProcess() {

		if (!SecurityHolder.isUserLogin()) {
			RenderUtil.renderHtmlNoLogin();
			return;
		}
		try {
			List<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());
			if (!fileList.isEmpty()) {
				List<GsysFunction> importModelList = GsysFunctionImportFactory.excelToModel(fileList.get(0));
				ResultMsg<GsysFunction> resultMsg = getGsysFunctionService().importDatas(importModelList);
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

	/**
	 * 获取所有数据,构造树形结构JSON.
	 */
	public void listTreeOutJson() {
		try {
			List<TreeViewItem> list = gsysFunctionService.getAllForTreeview(null);
			TreeRenderUtil.jsonTreeview(list, "根节点");
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 返回树形Grid格式json数据.
	 */
	public void listTreeGridOutJson() {
		try {
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page.setNoPageGetAll();
			page = gsysFunctionService.findDescendant(page, rto, orders);
			GsysFunctionRenderUtil.jsonFlexiTreeGrid(page.getTotalCount(), page.getResult());
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 构造树形结构JSON,排除当前选择的ID记录及其后代记录.
	 */
	public void listTreeOutForSelParentJson() {
		try {
			List<TreeViewItem> list = gsysFunctionService.getAllForTreeview(null);
			// String parentId = null;
			if (StringUtils.isNotBlank(rto.getId())) {
				ChangeUtil.excludeTreeIds(list, rto.getId());
			}
			TreeRenderUtil.jsonTreeview(list, "根节点");
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/************************************************************************
	 * 页面属性访问
	 ************************************************************************/

	/**
	 * @return the htmlSelectTree
	 */
	public String getHtmlSelectTree() {
		return htmlSelectTree;
	}

}