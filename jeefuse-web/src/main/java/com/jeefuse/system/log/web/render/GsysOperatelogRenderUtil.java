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
import com.jeefuse.system.log.model.GsysOperatelog;

/**
 * GsysOperatelog render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysOperatelogRenderUtil  {

	/**
	 * 输出 GsysOperatelog ResultMsg json对象格式数据.
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysOperatelog model, String message) {
		ResultJsonWriter<GsysOperatelog> jsonWriter=new GsysOperatelogResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysOperatelog FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysOperatelog> items) {
		FlexidGridJsonWriter<GsysOperatelog> jsonWriter = new GsysOperatelogFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}
	
	/**
	 * 输出GsysOperatelog FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysOperatelog> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}
}