/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.render;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;

/**
 * 输出GsysParameter FlexiGrid json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysParameterFlexiGridJsonWriter extends FlexidGridJsonWriter<GsysParameter> {

	/** @generated */
	public GsysParameterFlexiGridJsonWriter(Page<GsysParameter> page) {
			super(page);
	}

	/** @generated */
	public GsysParameterFlexiGridJsonWriter(int pageNo, long total, List<GsysParameter> items) {
		super(pageNo, total, items);
	}

	/** @generated */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysParameter model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysParameterField.name.getFieldName(),model.getName());//1 参数名
		g.writeStringField(GsysParameterField.value.getFieldName(),model.getValue());//2 参数值
		g.writeStringField(GsysParameterField.descript.getFieldName(),model.getDescript());//3 用途说明
	}

}