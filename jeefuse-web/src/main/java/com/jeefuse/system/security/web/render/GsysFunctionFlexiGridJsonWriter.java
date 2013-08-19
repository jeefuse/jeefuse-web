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
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;

/**
 * 输出GsysFunction FlexiGrid json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysFunctionFlexiGridJsonWriter extends FlexidGridJsonWriter<GsysFunction> {

	/** @generated */
	public GsysFunctionFlexiGridJsonWriter(Page<GsysFunction> page) {
			super(page);
	}

	/** @generated */
	public GsysFunctionFlexiGridJsonWriter(int pageNo, long total, List<GsysFunction> items) {
		super(pageNo, total, items);
	}

	/** @generated */
	@Override
	protected void writeJsonModel(JsonGenerator g, GsysFunction model) throws JsonProcessingException, IOException {
		g.writeStringField(GsysFunctionField.id.getFieldName(),model.getId());//1 ID
		g.writeStringField(GsysFunctionField.value.getFieldName(),model.getValue());//2 权限标志
		g.writeStringField(GsysFunctionField.name.getFieldName(),model.getName());//3 权限名称
		g.writeStringField(GsysFunctionField.descript.getFieldName(),model.getDescript());//4 描述
		g.writeStringField(GsysFunctionField.type.getFieldName(),model.getType());//5 权限类型
		g.writeStringField(GsysFunctionField.url.getFieldName(),model.getUrl());//6 url
		g.writeStringField(GsysFunctionField.parentId.getFieldName(),model.getParentId());//7 上级ID
		g.writeStringField(GsysFunctionField.validStatus.getFieldName(),model.getValidStatus());//8 是否有效
		g.writeNumberField(GsysFunctionField.sortNum.getFieldName(), model.getSortNum());//9 排序
		g.writeStringField(GsysFunctionField.layerCode.getFieldName(),model.getLayerCode());//10 层次编码
	}

}