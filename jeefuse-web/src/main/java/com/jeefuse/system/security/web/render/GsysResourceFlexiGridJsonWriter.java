/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.render;
import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.system.security.model.GsysResource;
import com.jeefuse.system.security.model.parse.GsysResourceField;

/**
 * 输出GsysResource FlexiGrid json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysResourceFlexiGridJsonWriter extends FlexidGridJsonWriter<GsysResource> {

	/** @generated */
	public GsysResourceFlexiGridJsonWriter(Page<GsysResource> page) {
			super(page);
	}

	/** @generated */
	public GsysResourceFlexiGridJsonWriter(int pageNo, long total, List<GsysResource> items) {
		super(pageNo, total, items);
	}

	/** @generated */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysResource model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysResourceField.id.getFieldName(),model.getId());//1 id
		g.writeStringField(GsysResourceField.name.getFieldName(),model.getName());//2 name
		g.writeStringField(GsysResourceField.descript.getFieldName(),model.getDescript());//3 descript
		g.writeStringField(GsysResourceField.value.getFieldName(),model.getValue());//4 value
		g.writeStringField(GsysResourceField.type.getFieldName(),model.getType());//5 type
	}

}