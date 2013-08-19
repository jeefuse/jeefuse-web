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
import org.springframework.util.Assert;

import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil;
import com.jeefuse.base.modules.tree.TreeRenderUtil;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.utils.common.ChangeUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.validate.GsysRoleValidate;
import com.jeefuse.system.security.service.GsysRoleService;
import com.jeefuse.system.security.service.SecurityServiceFacade;
import com.jeefuse.system.security.service.SecurityServiceFactory;
import com.jeefuse.system.security.web.exports.GsysRoleExportFactory;
import com.jeefuse.system.security.web.imports.GsysRoleImportFactory;
import com.jeefuse.system.security.web.render.GsysFunctionRenderUtil;
import com.jeefuse.system.security.web.render.GsysRoleRenderUtil;
import com.jeefuse.system.security.web.rto.GsysRoleRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysRole Entity CRUD action.
 * 
 * @author yonclv
 * @generated
 */
public class GsysRoleAction extends BaseAction implements ModelDriven<GsysRoleRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;

	/**
	 * GsysRole Entity CRUD service.
	 * 
	 * @generated
	 */
	private final GsysRoleService getGsysRoleService() {
		return SecurityServiceFactory.getGsysRoleService();
	}

	/*****************************************************************
	 * property define
	/*****************************************************************/

	/** @generated */
	private Page<GsysRole> page = null;
	/** @generated */
	private GsysRole mo = null;
	/** @generated */
	private GsysRoleRTO rto = null;



	/** @generated */
	public Page<GsysRole> getPage() {
		if (null == page) {
			page = new Page<GsysRole>();
		}
		return page;
	}

	/** @generated */
	public GsysRoleRTO getModel() {
		if (null == rto) {
			rto = new GsysRoleRTO();
		}
		return rto;
	}

	/** @generated */
	public GsysRole getMo() {
		if (null == mo) {
			mo = new GsysRole();
		}
		return mo;
	}

	/************************************************************************
	 * request function invoke
	 ************************************************************************/

	/**
	 * 管理页面.
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
			// find
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = getGsysRoleService().find(page, rto, orders);
			GsysRoleRenderUtil.jsonFlexiGrid(page);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 获取关联GsysFuntion Check.返回json格式.
	 * 
	 * @generated
	 */
	public void listRelGsysFunctionCheckOutJson() {
		try {
			// find
			Assert.notNull(getModel().getId(), "未指定角色标识!");
			List<TreeViewItem> gsysFunctionList = SecurityServiceFacade.getAllGsysFunctionForTreeview();
			List<String> relateGsysFunctionIdsList = SecurityServiceFacade.getRelGsysFunctionIdsByGsysRoleId(getModel().getId());
			GsysFunctionRenderUtil.jsonTreeviewShowCheck(gsysFunctionList, relateGsysFunctionIdsList);
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
			mo = getGsysRoleService().get(getModel().getId());
			GsysRoleRenderUtil.jsonResultMsg(true, mo, null);
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}



	private static final String relGsysResourceCheckboxsDomId = "relGsysResourceCheckboxs";
	private String relGsysResourceCheckboxs;// rel gsysResource for checkboxs
	private String relGsysFunctionShowCheckJson;// rel GsysFunction for Treeview

	/**
	 * 根据主键获取Entity,并转向修改页面.
	 * 
	 * @generated
	 */
	public String edit() {
		try {
			if (StringUtils.isBlank(getModel().getId())) {
				// rel GsysFunction for Treeview
				List<TreeViewItem> allGsysFunctionTreeviewList = SecurityServiceFacade.getAllGsysFunctionForTreeview();
				relGsysFunctionShowCheckJson = TreeRenderUtil.jsonTreeviewShowCheckString(allGsysFunctionTreeviewList, null);
				// rel gsysResource for checkboxs
				List<KeyLabel> allGsysResourceKeyLabelList = SecurityServiceFacade.getAllGsysResourceForKeyLabel();
				relGsysResourceCheckboxs = KeyLabelRenderUtil.renderHtmlCheckboxs(allGsysResourceKeyLabelList, null,relGsysResourceCheckboxsDomId);
			} else {
				mo = getGsysRoleService().get(rto.getId());
				// rel gsysFunction for treeview
				List<TreeViewItem> allGsysFunctionTreeviewList = SecurityServiceFacade.getAllGsysFunctionForTreeview();
				List<String> relGsysFunctionIdList = SecurityServiceFacade.getRelGsysFunctionIdsByGsysRoleId(mo.getId());
				relGsysFunctionShowCheckJson = TreeRenderUtil.jsonTreeviewShowCheckString(allGsysFunctionTreeviewList, relGsysFunctionIdList);
				// rel gsysResource for checkboxs
				List<KeyLabel> allGsysResourceKeyLabelList = SecurityServiceFacade.getAllGsysResourceForKeyLabel();
				List<String> relGsysResourceIdList = SecurityServiceFacade.getRelGsysResourceIdsByGsysRoleId(mo.getId());
				relGsysResourceCheckboxs = KeyLabelRenderUtil.renderHtmlCheckboxs(allGsysResourceKeyLabelList,relGsysResourceIdList, relGsysResourceCheckboxsDomId);
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
	public void saveOrUpdateOutJson() {
		try {
			Assert.notNull(rto);
			String[] relGsysFunctionCheckIds = ChangeUtil.split(getModel().getRelGsysFunctionCheckIds(), ",", true);
			String[] relGsysResourceCheckIds = ChangeUtil.split(getModel().getRelGsysResourceCheckIds(), ",", true);
			if (StringUtils.isBlank(rto.getId())) {
				mo = getGsysRoleService().save(getModel(), false, relGsysFunctionCheckIds, relGsysResourceCheckIds);
				GsysRoleRenderUtil.jsonResultMsg(true, mo, "保存成功!");
				return;
			} else {
				mo = getGsysRoleService().update(getModel(), false, relGsysFunctionCheckIds, relGsysResourceCheckIds);
				GsysRoleRenderUtil.jsonResultMsg(true, mo, "更新成功!");
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
	 * 保存Entity,返回json格式.
	 * 
	 * @generated
	 */
	public void saveOutJson() {
		try {
			Assert.notNull(rto);
			String[] relGsysFunctionCheckIds = ChangeUtil.split(getModel().getRelGsysFunctionCheckIds(), ",", true);
			String[] relGsysResourceCheckIds = ChangeUtil.split(getModel().getRelGsysResourceCheckIds(), ",", true);
			mo = getGsysRoleService().save(getModel(), false, relGsysFunctionCheckIds, relGsysResourceCheckIds);
			GsysRoleRenderUtil.jsonResultMsg(true, mo, "保存成功!");
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysRoleValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			String[] relGsysFunctionCheckIds = ChangeUtil.split(getModel().getRelGsysFunctionCheckIds(), ",", true);
			String[] relGsysResourceCheckIds = ChangeUtil.split(getModel().getRelGsysResourceCheckIds(), ",", true);
			mo = getGsysRoleService().update(getModel(), false, relGsysFunctionCheckIds, relGsysResourceCheckIds);
			GsysRoleRenderUtil.jsonResultMsg(true, mo, "更新成功!");
		} catch (InvalidStateException e) {
			String invalidateMsg = GsysRoleValidate.getValidateMessageWithHtmlBR(e.getInvalidValues());
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
			Assert.notNull(rto.getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(rto.getId(), ",");
			int delCount = getGsysRoleService().delete(delIds);
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
			int delCount = getGsysRoleService().deleteAll();
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
			page = getGsysRoleService().find(page, rto, orders);
			GsysRoleExportFactory.excelExportAllField(getResponse(), GsysRoleExportFactory
					.getGsysRoleExcelExportTemplateFileName(), page.getResult());
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

		// if (!SpringSecurityUtils.isUserLogin()) {
		// RenderUtil.renderHtmlNoLogin();
		// return;
		// }
		try {
			List<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());
			if (!fileList.isEmpty()) {
				List<GsysRole> importModelList = GsysRoleImportFactory.excelToModel(fileList.get(0));
				getGsysRoleService().save(importModelList);
				RenderUtil.renderHtml("成功导入" + importModelList.size() + "项记录!");
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

	/**
	 * @return the relGsysFunctionShowCheckJson
	 */
	public String getRelGsysFunctionShowCheckJson() {
		if (null == relGsysFunctionShowCheckJson)
			return "{}";
		return relGsysFunctionShowCheckJson;
	}

	/**
	 * @return the relGsysResourceCheckboxs
	 */
	public String getRelGsysResourceCheckboxs() {
		return relGsysResourceCheckboxs;
	}

}