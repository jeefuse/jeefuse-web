/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.render;
import java.util.List;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.param.model.GsysParameter;

/**
 * GsysParameter render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysParameterRenderUtil  {

	/**
	 * 输出 GsysParameter ResultMsg json对象格式数据.
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysParameter model, String message) {
		ResultJsonWriter<GsysParameter> jsonWriter=new GsysParameterResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysParameter FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysParameter> items) {
		FlexidGridJsonWriter<GsysParameter> jsonWriter = new GsysParameterFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}
	
	/**
	 * 输出GsysParameter FlexiGrid json对象格式数据.
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysParameter> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}
}