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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.modules.keyLabel.KeyLabelRenderUtil;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.code.model.enumeration.EnabledType;
import com.jeefuse.system.code.model.enumeration.InvalidType;
import com.jeefuse.system.code.model.enumeration.SexType;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.service.GsysUserService;
import com.jeefuse.system.security.service.SecurityServiceFacade;
import com.jeefuse.system.security.service.spring.SecurityHolder;
import com.jeefuse.system.security.web.exports.GsysUserExportFactory;
import com.jeefuse.system.security.web.imports.GsysUserImportFactory;
import com.jeefuse.system.security.web.render.GsysUserRenderUtil;
import com.jeefuse.system.security.web.rto.GsysUserRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysUser Entity CRUD action.
 * 
 * @author yonclv
 * @generated
 */
public class GsysUserAction extends BaseAction implements ModelDriven<GsysUserRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;

	private static final String relGsysRoleCheckboxsDomName = "relGsysRoleIdList";

	@Autowired
	private GsysUserService gsysUserService;


	// property
	/** @generated */
	private Page<GsysUser> page = null;
	/** @generated */
	private GsysUser mo = null;
	/** @generated */
	private GsysUserRTO rto = null;

	private String relGsysRoleCheckboxs;

	private List<KeyLabel> allGsysRoleKeyLabelList;

	private List<String> relGsysRoleIdList;



	/** @generated */
	public Page<GsysUser> getPage() {
		if (null == page) {
			page = new Page<GsysUser>();
		}
		return page;
	}

	/** @generated */
	public GsysUserRTO getModel() {
		if (null == rto) {
			rto = new GsysUserRTO();
		}
		return rto;
	}

	/** @generated */
	public GsysUser getMo() {
		if (null == mo) {
			mo = new GsysUser();
		}
		return mo;
	}

	/************************************************************************
	 * request function invoke
	 ************************************************************************/

	/**
	 * 获取Entity列表.返回json格式.
	 * 
	 * @generated
	 */
	public void listOutJson() {
		try {
			// find
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page = gsysUserService.find(page, rto, orders);
			GsysUserRenderUtil.jsonFlexiGrid(page);
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
			Assert.notNull(rto);
			mo = gsysUserService.get(rto.getId());
			GsysUserRenderUtil.jsonResultMsg(true, mo, null);
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
			if (StringUtils.isBlank(getModel().getId())) {
				allGsysRoleKeyLabelList = SecurityServiceFacade.getAllGsysRoleForKeyLabel();
				relGsysRoleCheckboxs = KeyLabelRenderUtil.renderHtmlCheckboxs(allGsysRoleKeyLabelList, null,
						relGsysRoleCheckboxsDomName);
			} else {
				mo = gsysUserService.get(rto.getId());
				allGsysRoleKeyLabelList = SecurityServiceFacade.getAllGsysRoleForKeyLabel();
				relGsysRoleIdList = SecurityServiceFacade.getRelGsysRoleIdsByGsysUserId(mo.getId());
				relGsysRoleCheckboxs = KeyLabelRenderUtil.renderHtmlCheckboxs(allGsysRoleKeyLabelList,
						relGsysRoleIdList, relGsysRoleCheckboxsDomName);
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
			Assert.notNull(rto);
			if (StringUtils.isBlank(rto.getId())) {
				mo = rto.getNewModel();
				if (!gsysUserService.isLoginNameUnique(mo.getLoginName())) {
					RenderUtil.renderJsonResultMsgError("登录名已存在!");
					return;
				}
				gsysUserService.save(mo, relGsysRoleIdList);
				GsysUserRenderUtil.jsonResultMsg(true, mo, "保存成功!");
				return;
			} else {
				GsysUser oldmo = gsysUserService.get(rto.getId());
				mo = rto.getModifiedModel(oldmo);
				gsysUserService.update(mo, relGsysRoleIdList);
				GsysUserRenderUtil.jsonResultMsg(true, mo, "更新成功!");
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
	 * 删除Entity,返回json格式.
	 * 
	 * @generated
	 */
	public void deleteOutJson() {
		try {
			Assert.notNull(rto.getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(rto.getId(), ",");
			int delCount = gsysUserService.delete(delIds);
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
			int delCount = gsysUserService.deleteAll();
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
			page = gsysUserService.find(page, rto, orders);
			GsysUserExportFactory.excelExportAllField(getResponse(),
					GsysUserExportFactory.getGsysUserExcelExportTemplateFileName(), page.getResult());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 导入excel文件.
	 * 
	 * @generated
	 */
	public String importExcelFile() {
		if (SecurityHolder.isUserNoLogin()) {
			addActionError("请登录后操作!");
			return NO_LOGIN;
		}
		return SUCCESS;
	}

	/**
	 * 导入excel 文件处理.
	 * 
	 * @generated
	 */
	public void importExcelFileProcess() {
		try {
			if (SecurityHolder.isUserNoLogin()) {
				RenderUtil.renderHtmlNoLogin();
				return;
			}
			List<File> fileList = StrutsWebFileUtil.getUploadFile(getRequest());
			if (!fileList.isEmpty()) {
				List<GsysUser> importModelList = GsysUserImportFactory.excelToModel(fileList.get(0));
				gsysUserService.save(importModelList);
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

	/**
	 * 检查登录名是否唯一.
	 */
	public void checkLoginName() {
		String newLoginName = getRequestParam("loginName");
		String oldLoginName = getRequestParam("oldLoginName");
		if (newLoginName == null || newLoginName.equals(oldLoginName)) {
			RenderUtil.renderText("true");
			return;
		}
		if (gsysUserService.isLoginNameUnique(newLoginName)) {
			RenderUtil.renderText("true");
		} else {
			RenderUtil.renderText("false");
		}
	}


	/**
	 * 用户审核.
	 */
	public String verify() {
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
	 * 修改密码.
	 */
	public String modifyPassword() {
		try {
			if (SecurityHolder.isUserNoLogin())
				return NO_LOGIN;
			mo = gsysUserService.get(rto.getId());
			AppAssert.notNull(mo, "该用户不存在!");
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 保存修改的密码.
	 */
	public void modifyPasswordSave() {
		try {
			if (SecurityHolder.isUserNoLogin()) {
				RenderUtil.renderJsonNoLogin();
				return;
			}
			if (StringUtils.isBlank(getModel().getPassword())) {
				RenderUtil.renderJsonResultMsgError("请输入新密码!");
				return;
			}
			mo = gsysUserService.get(rto.getId());
			AppAssert.notNull(mo, "该用户不存在!");
			mo.setPassword(getModel().getPassword());
			gsysUserService.save(mo);
			GsysUserRenderUtil.jsonResultMsg(true, mo, "更新成功!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 修改密码.
	 */
	public String modifyMyPassword() {
		try {
			if (SecurityHolder.isUserNoLogin())
				return NO_LOGIN;
			String userId = SecurityHolder.getLoginUserId();
			mo = gsysUserService.get(userId);
			AppAssert.notNull(mo, "该用户不存在!");
			return SUCCESS;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 保存修改的密码.
	 */
	public void modifyMyPasswordSave() {
		try {
			if (SecurityHolder.isUserNoLogin()) {
				RenderUtil.renderJsonNoLogin();
				return;
			}
			if (StringUtils.isBlank(getModel().getPassword())) {
				RenderUtil.renderJsonResultMsgError("请输入新密码!");
				return;
			}
			String userId = SecurityHolder.getLoginUserId();
			mo = gsysUserService.get(userId);
			AppAssert.notNull(mo, "该用户不存在!");
			mo.setPassword(getModel().getPassword());
			gsysUserService.save(mo);
			GsysUserRenderUtil.jsonResultMsg(true, mo, "更新成功!");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	public String getEnabledHtmlSelect() {
		return EnabledType.toHtmlSelect(getMo() == mo ? null : getMo().getEnabled());
	}

	public String getEnabledJson() {
		return InvalidType.toHtmlJSON;
	}


	public String getSexHtmlSelect() {
		return SexType.toHtmlSelect(getMo() == mo ? null : getMo().getSex());
	}

	public String getSexJson() {
		return SexType.toHtmlJSON;
	}


	/**
	 * @return the relGsysRoleIdList
	 */
	public List<String> getRelGsysRoleIdList() {
		return relGsysRoleIdList;
	}

	/**
	 * @param relGsysRoleIdList
	 *            the relGsysRoleIdList to set
	 */
	public void setRelGsysRoleIdList(List<String> relGsysRoleIdList) {
		this.relGsysRoleIdList = relGsysRoleIdList;
	}

	/**
	 * @return the relGsysRoleCheckboxs
	 */
	public String getRelGsysRoleCheckboxs() {
		return relGsysRoleCheckboxs;
	}

	/**
	 * @return the allGsysRoleKeyLabelList
	 */
	public List<KeyLabel> getAllGsysRoleKeyLabelList() {
		return allGsysRoleKeyLabelList;
	}



}