/*
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * GOOLOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.monitor.web.render;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.monitor.web.listener.OnlineSessionVo;

/**
 * 输出GsysOperatelog  FlexiGrid json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class OnlineSessionFlexiGridJsonWriter extends FlexidGridJsonWriter<OnlineSessionVo> {

	/** @generated */
	public OnlineSessionFlexiGridJsonWriter(Page<OnlineSessionVo> page) {
			super(page);
	}

	/** @generated */
	public OnlineSessionFlexiGridJsonWriter(int pageNo, long total, List<OnlineSessionVo> items) {
		super(pageNo, total, items);
	}

	/** @generated */
	@Override
	protected void writeJsonModel(JsonGenerator g, OnlineSessionVo model) throws JsonProcessingException, IOException {
		g.writeStringField("sessionId", model.getSessionId());// 1
		g.writeStringField("userId", model.getUserId());// 2
		g.writeStringField("createDateCn", model.getCreateDateCn());// 3
		g.writeStringField("lastAccessedTimeCn", model.getLastAccessedTimeCn());// 4
	}
}