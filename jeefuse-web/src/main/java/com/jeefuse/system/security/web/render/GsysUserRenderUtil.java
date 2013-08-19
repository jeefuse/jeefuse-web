/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.render;
import java.util.List;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.security.model.GsysUser;

/**
 * GsysUser render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysUserRenderUtil  {

	/**
	 * 输出 GsysUser ResultMsg json对象格式数据.
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysUser model, String message) {
		ResultJsonWriter<GsysUser> jsonWriter = new GsysUserResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysUser FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysUser> items) {
		FlexidGridJsonWriter<GsysUser> jsonWriter = new GsysUserFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}
	
	/**
	 * 输出GsysUser FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysUser> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}
}