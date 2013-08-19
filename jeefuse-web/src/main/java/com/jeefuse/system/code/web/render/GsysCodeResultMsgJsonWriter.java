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
import com.jeefuse.system.code.model.parse.GsysCodeField;

/**
 * 输出GsysCode ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodeResultMsgJsonWriter extends ResultJsonWriter<GsysCode> {

	/**
	 * @generated
	 */
	public GsysCodeResultMsgJsonWriter(ResultMsg<GsysCode> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysCodeResultMsgJsonWriter(boolean success, GsysCode model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysCode model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysCodeField.cid.getFieldName(),model.getCid());//1 cid
		g.writeStringField(GsysCodeField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysCodeField.descript.getFieldName(),model.getDescript());//3 ˵
		g.writeStringField(GsysCodeField.kind.getFieldName(),model.getKind());//4 kind
	}

}