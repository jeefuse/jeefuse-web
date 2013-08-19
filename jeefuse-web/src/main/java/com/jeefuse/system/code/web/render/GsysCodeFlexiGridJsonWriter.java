/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.code.web.render;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.code.model.GsysCode;
import com.jeefuse.system.code.model.parse.GsysCodeField;

/**
 * 输出GsysCode FlexiGrid json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodeFlexiGridJsonWriter extends FlexidGridJsonWriter<GsysCode> {

	/** @generated */
	public GsysCodeFlexiGridJsonWriter(Page<GsysCode> page) {
			super(page);
	}

	/** @generated */
	public GsysCodeFlexiGridJsonWriter(int pageNo, long total, List<GsysCode> items) {
		super(pageNo, total, items);
	}

	/** @generated */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysCode model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysCodeField.cid.getFieldName(),model.getCid());//1 cid
		g.writeStringField(GsysCodeField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysCodeField.descript.getFieldName(),model.getDescript());//3 ˵
		g.writeStringField(GsysCodeField.kind.getFieldName(),model.getKind());//4 kind
	}

}