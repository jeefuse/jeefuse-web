/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.render;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;

/**
 * 输出GsysCodevalue ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodevalueResultMsgJsonWriter extends ResultJsonWriter<GsysCodevalue> {

	/**
	 * @generated
	 */
	public GsysCodevalueResultMsgJsonWriter(ResultMsg<GsysCodevalue> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysCodevalueResultMsgJsonWriter(boolean success, GsysCodevalue model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysCodevalue model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysCodevalueField.id.getFieldName(),model.getId());//1 ID
		g.writeStringField(GsysCodevalueField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysCodevalueField.value.getFieldName(),model.getValue());//3 value
		g.writeStringField(GsysCodevalueField.descript.getFieldName(),model.getDescript());//4 
		GsysCode gsysCode = model.getGsysCode();
		g.writeObjectFieldStart("gsysCode");
		g.writeStringField("name", null == gsysCode ? null : gsysCode.getName());//21 gsysCode
		g.writeEndObject();
	}

}