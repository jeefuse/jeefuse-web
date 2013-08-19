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
import com.jeefuse.system.code.model.GsysCodevalue;
import com.jeefuse.system.code.model.parse.GsysCodevalueField;

/**
 * 输出GsysCodevalue FlexiGrid json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysCodevalueFlexiGridJsonWriter extends FlexidGridJsonWriter<GsysCodevalue> {

	/** @generated */
	public GsysCodevalueFlexiGridJsonWriter(Page<GsysCodevalue> page) {
			super(page);
	}

	/** @generated */
	public GsysCodevalueFlexiGridJsonWriter(int pageNo, long total, List<GsysCodevalue> items) {
		super(pageNo, total, items);
	}

	/** @generated */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysCodevalue model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysCodevalueField.id.getFieldName(),model.getId());//1 ID
		g.writeStringField(GsysCodevalueField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysCodevalueField.value.getFieldName(),model.getValue());//3 value
		g.writeStringField(GsysCodevalueField.descript.getFieldName(),model.getDescript());//4 descript
		//		GsysCode gsysCode = model.getGsysCode();
		//		g.writeObjectFieldStart("gsysCode");
		//		g.writeStringField("name", null == gsysCode ? null : gsysCode.getName());//21 gsysCode
		//		g.writeEndObject();
	}

}