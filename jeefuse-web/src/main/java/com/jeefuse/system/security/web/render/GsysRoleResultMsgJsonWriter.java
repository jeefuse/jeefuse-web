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
import com.jeefuse.system.security.model.GsysRole;
import com.jeefuse.system.security.model.parse.GsysRoleField;

/**
 * 输出GsysRole ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysRoleResultMsgJsonWriter extends ResultJsonWriter<GsysRole> {

	/**
	 * @generated
	 */
	public GsysRoleResultMsgJsonWriter(ResultMsg<GsysRole> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysRoleResultMsgJsonWriter(boolean success, GsysRole model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysRole model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysRoleField.id.getFieldName(),model.getId());//1 id
		g.writeStringField(GsysRoleField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysRoleField.displayName.getFieldName(),model.getDisplayName());//3 displayName
		g.writeStringField(GsysRoleField.descript.getFieldName(),model.getDescript());//4 descript
	}

}