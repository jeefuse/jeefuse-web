package com.jeefuse.index.web.action;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeefuse.base.exception.ApplicationException;
import com.jeefuse.base.modules.tree.renders.menu.TreeMenuRenderUtil;
import com.jeefuse.base.web.action.BaseAction;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.base.web.utils.WebContextUtil;
import com.jeefuse.index.web.config.SystemFrameStyle;
import com.jeefuse.system.log.service.Applogger;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.service.GsysUserService;
import com.jeefuse.system.security.service.spring.SecurityHolder;
import com.jeefuse.system.security.web.render.GsysFunctionRenderUtil;

@SuppressWarnings("serial")
public class IndexAction extends BaseAction {
	private final static String FRAME_STYLE = "style";

	private String systemMenuUIHrefMethod;

	@Autowired
	private GsysUserService gsysUserService;

	private GsysUser loginUser;

	/**
	 * 系统登录页面.
	 */
	public String login() {
		if (SecurityHolder.isUserLogin())
			return SUCCESS;
		return LOGIN;
	}

	/**
	 * 系统主页面.
	 */
	public String main() {
		try {
			if (!SecurityHolder.isUserLogin()) {
				Applogger.login(getRequest(), "用户未登录!阻止登录系统页面,转向登录页面!");
				return LOGIN;
			}
			String userId = SecurityHolder.getLoginUserId();
			loginUser = gsysUserService.get(userId);
			String frameStyle = getRequestParam(FRAME_STYLE);
			if (StringUtils.isNotBlank(frameStyle)) {
				SystemFrameStyle item = SystemFrameStyle.valueOfString(frameStyle);
				if (null == item || SystemFrameStyle.leftMenu == item) {
					logger.warn("This is no exist of system frame style for :" + frameStyle);
					return SystemFrameStyle.leftMenu.toString();
				} else {
					List<GsysFunction> list = SecurityHolder.getLoginUserFunction();
					systemMenuUIHrefMethod = TreeMenuRenderUtil.contructTreeMenuUIHrefMethod(list, null, null,
							WebContextUtil.getContextPath(getRequest()));
					return item.toString();
				}
			}
			return SystemFrameStyle.leftMenu.toString();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ERROR;
		}
	}

	/**
	 * 系统登录页面.
	 */
	public String index() {
		if (SecurityHolder.isUserLogin())
			return SUCCESS;
		return LOGIN;
	}

	/**
	 * 返回树形菜单.
	 */
	public void listTreeMenuOutJson() {
		try {
			List<GsysFunction> list = SecurityHolder.getLoginUserFunction();
			GsysFunctionRenderUtil.jsonTreeviewForMenu(list, getRequest());
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e);
			Applogger.appError(e.getMessage(), getRequest());
			RenderUtil.renderJsonResultMsgError(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			RenderUtil.renderJsonResultMsgError();
		}
	}

	/**
	 * 获取系统菜单输出html UI 树形结构.
	 */
	public String getSystemMenuUIHrefMethod() {
		return systemMenuUIHrefMethod;
	}

	public GsysUser getLoginUser() {
		return loginUser;
	}

}
