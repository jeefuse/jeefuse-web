/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.action;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.condition.order.Order;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.uploadFile.StrutsWebFileUtil;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.RequestUtil;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.ResourceType;
import com.jeefuse.system.security.service.GsysResourceService;
import com.jeefuse.system.security.web.exports.GsysResourceExportFactory;
import com.jeefuse.system.security.web.imports.GsysResourceImportFactory;
import com.jeefuse.system.security.web.render.GsysResourceRenderUtil;
import com.jeefuse.system.security.web.rto.GsysResourceRTO;
import com.opensymphony.xwork2.ModelDriven;

/**
 * GsysResource Entity CRUD action.
 *
 * @author yonclv
 * @generated
 */
public class GsysResourceAction extends BaseAction implements ModelDriven<GsysResourceRTO> {
	/** @generated */
	private static final long serialVersionUID = 1L;
	
	//inject service
	/** @generated */
	@Autowired
	private GsysResourceService gsysResourceService;
	
	//property
	/** @generated */
	private Page<GsysResource> page=null;
	/** @generated */
	private GsysResource mo=null;
	/** @generated */
	private GsysResourceRTO rto=null;

	/** @generated */
	public Page<GsysResource> getPage() {
		if(null==page) {
			page=new Page<GsysResource>();
		}
		return page;
	}

	/** @generated */
	public GsysResourceRTO getModel() {
		if(null==rto) {
			rto = new GsysResourceRTO();
		}
		return rto;
	}
	
	/** @generated */
	public GsysResource getMo() {
		return mo;
	}

	/************************************************************************
	 * code kind define
	 ************************************************************************/
	 
	/** @generated */
	public Map<String, String> getResourceTypeMap() {
		return ResourceType.toMap;
	}
	
	/** @generated */
	public String getResourceTypeJson() {
		return ResourceType.toHtmlJSON;
	}
	
	/** @generated */
	public String getResourceTypeHtmlSelect() {
		return ResourceType.toHtmlSelect(null == mo ? null : getMo().getType());
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
			// find
			Order[] orders = RequestUtil.buildOrders(getRequest());
			page=gsysResourceService.find(page, rto, orders);
			GsysResourceRenderUtil.jsonFlexiGrid(page);
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
			Assert.notNull(rto);
			mo = gsysResourceService.get(rto.getId());
			GsysResourceRenderUtil.jsonResultMsg(true, mo, null);
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
			Assert.notNull(rto.getId(), "更新标识不能为空!");
			mo = gsysResourceService.get(rto.getId());
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
			Assert.notNull(rto);
			if (StringUtils.isBlank(rto.getId())) {
				mo = rto.getNewModel();
				gsysResourceService.save(mo,false);
				RenderUtil.renderJsonResultMsg(true, mo, "保存成功!");
				return;
			} else {
				GsysResource oldmo = gsysResourceService.get(rto.getId());
				mo = rto.getModifiedModel(oldmo);
				gsysResourceService.update(mo,false);
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
	 * 删除Entity,返回json格式.
	 * @generated
	 */
	public void deleteOutJson() {
		try {
			Assert.notNull(rto.getId(), "未指定删除的标识!");
			final String[] delIds = StringUtils.split(rto.getId(), ",");
			int delCount = gsysResourceService.delete(delIds);
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
			int delCount = gsysResourceService.deleteAll();
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
			page = gsysResourceService.find(page, rto, orders);
			GsysResourceExportFactory.excelExportAllField(getResponse(),
					GsysResourceExportFactory.getGsysResourceExcelExportTemplateFileName(), page.getResult());
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
				List<GsysResource> importModelList = GsysResourceImportFactory.excelToModel(fileList.get(0));
				gsysResourceService.save(importModelList);
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
	
}