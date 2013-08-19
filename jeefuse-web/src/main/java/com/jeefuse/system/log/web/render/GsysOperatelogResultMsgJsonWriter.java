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
import com.jeefuse.system.log.model.GsysOperatelog;
import com.jeefuse.system.log.model.parse.GsysOperatelogField;
import com.jeefuse.system.security.model.GsysUser;

/**
 * 输出GsysOperatelog ResultMsg json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysOperatelogResultMsgJsonWriter extends ResultJsonWriter<GsysOperatelog> {

	/**
	 * @generated
	 */
	public GsysOperatelogResultMsgJsonWriter(ResultMsg<GsysOperatelog> msg) {
		super(msg);
	}

	/**
	 * @generated
	 */
	public GsysOperatelogResultMsgJsonWriter(boolean success, GsysOperatelog model, String message) {
		super(success, model, message);
	}

	/**
	 * @generated
	 */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysOperatelog model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysOperatelogField.id.getFieldName(), model.getId());// 1
																					// id
		g.writeStringField(GsysOperatelogField.loginIp.getFieldName(), model.getLoginIp());// 2
																							// 登录IP
		g.writeStringField(GsysOperatelogField.createdate.getFieldName(), model.getCreatedateToStr());// 3
																										// 创建时间
		g.writeStringField(GsysOperatelogField.message.getFieldName(), model.getMessage());// 4
																							// 信息
		g.writeStringField(GsysOperatelogField.kind.getFieldName(), model.getKind());// 6
																						// 类型
		// g.writeStringField(GsysOperatelogField.detail.getFieldName(),model.getDetail());//7
		// 详细说明
		// 关联GsysUser
		GsysUser gsysUser = model.getGsysUser();
		g.writeObjectFieldStart("gsysUser");
		g.writeStringField("username", null == gsysUser ? null : gsysUser.getUsername());// 7
		g.writeEndObject(); // gsysUser
	}

}