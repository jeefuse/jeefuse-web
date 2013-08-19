/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.param.web.render;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.param.model.GsysParameter;
import com.jeefuse.system.param.model.parse.GsysParameterField;

/**
 * 输出GsysParameter ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysParameterResultMsgJsonWriter extends ResultJsonWriter<GsysParameter> {

	/**
	 * @generated
	 */
	public GsysParameterResultMsgJsonWriter(ResultMsg<GsysParameter> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysParameterResultMsgJsonWriter(boolean success, GsysParameter model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysParameter model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysParameterField.name.getFieldName(),model.getName());//1 参数名
		g.writeStringField(GsysParameterField.value.getFieldName(),model.getValue());//2 参数值
		g.writeStringField(GsysParameterField.descript.getFieldName(),model.getDescript());//3 用途说明
	}

}