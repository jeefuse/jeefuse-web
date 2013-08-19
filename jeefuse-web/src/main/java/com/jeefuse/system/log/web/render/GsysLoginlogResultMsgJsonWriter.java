/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.log.web.render;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.web.result.ResultMsg;
import com.jeefuse.system.log.model.GsysLoginlog;
import com.jeefuse.system.log.model.parse.GsysLoginlogField;
import com.jeefuse.system.security.model.GsysUser;

/**
 * 输出GsysLoginlog ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysLoginlogResultMsgJsonWriter extends ResultJsonWriter<GsysLoginlog> {

	/**
	 * @generated
	 */
	public GsysLoginlogResultMsgJsonWriter(ResultMsg<GsysLoginlog> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysLoginlogResultMsgJsonWriter(boolean success, GsysLoginlog model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysLoginlog model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysLoginlogField.id.getFieldName(),model.getId());//1 id
		g.writeStringField(GsysLoginlogField.loginIp.getFieldName(),model.getLoginIp());//2 登录IP
		g.writeStringField(GsysLoginlogField.createdate.getFieldName(), model.getCreatedateToStr());//3 登录时间
		g.writeStringField(GsysLoginlogField.message.getFieldName(),model.getMessage());//4 信息
		// 关联GsysUser
		GsysUser gsysUser = model.getGsysUser();
		g.writeObjectFieldStart("gsysUser");
		g.writeStringField("username", null == gsysUser ? null : gsysUser.getUsername());// 7
		g.writeEndObject(); // gsysUser
	}

}