/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.render;
import java.util.List;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.log.model.GsysLoginlog;

/**
 * GsysLoginlog render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysLoginlogRenderUtil  {

	/**
	 * 输出 GsysLoginlog ResultMsg json对象格式数据.
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysLoginlog model, String message) {
		ResultJsonWriter<GsysLoginlog> jsonWriter=new GsysLoginlogResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysLoginlog FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysLoginlog> items) {
		FlexidGridJsonWriter<GsysLoginlog> jsonWriter = new GsysLoginlogFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}
	
	/**
	 * 输出GsysLoginlog FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysLoginlog> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}
}