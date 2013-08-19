/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.render;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;

/**
 * 输出GsysResource ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysResourceResultMsgJsonWriter extends ResultJsonWriter<GsysResource> {

	/**
	 * @generated
	 */
	public GsysResourceResultMsgJsonWriter(ResultMsg<GsysResource> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysResourceResultMsgJsonWriter(boolean success, GsysResource model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysResource model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysResourceField.id.getFieldName(),model.getId());//1 id
		g.writeStringField(GsysResourceField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysResourceField.descript.getFieldName(),model.getDescript());//3 descript
		g.writeStringField(GsysResourceField.value.getFieldName(),model.getValue());//4 value
		g.writeStringField(GsysResourceField.type.getFieldName(),model.getType());//5 type
	}

}