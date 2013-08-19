/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.render;

import java.util.List;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.code.model.GsysCode;

/**
 * GsysCode render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodeRenderUtil  {

	/**
	 * 输出 GsysCode ResultMsg json对象格式数据.
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysCode model, String message) {
		ResultJsonWriter<GsysCode> jsonWriter = new GsysCodeResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysCode FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysCode> items) {
		FlexidGridJsonWriter<GsysCode> jsonWriter = new GsysCodeFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}
	
	/**
	 * 输出GsysCode FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysCode> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}


}