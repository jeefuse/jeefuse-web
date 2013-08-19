/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.render;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.modules.json.FlexidTreeGridJsonWriter;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.model.parse.GsysFunctionField;

/**
 * 输出GsysFunction FlexiGridTree json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysFunctionFlexiTreeJsonWrite extends FlexidTreeGridJsonWriter<GsysFunction> {

	public GsysFunctionFlexiTreeJsonWrite(List<TreeNodeGeneric<GsysFunction>> treeNodeList, long total) {
		super(treeNodeList, total);
	}

	@Override
	protected void writeJsonModel(JsonGenerator g, TreeNodeGeneric<GsysFunction> treeNode)
			throws JsonGenerationException, IOException {
		GsysFunction model = treeNode.getTargetObject();
		g.writeStringField(GsysFunctionField.id.getFieldName(),model.getId());//1 ID
		g.writeStringField(GsysFunctionField.value.getFieldName(), model.getName());// 2 权限标志
		g.writeStringField(GsysFunctionField.name.getFieldName(), model.getName());// 3 权限名称
		g.writeStringField(GsysFunctionField.descript.getFieldName(),model.getDescript());//4 描述
		g.writeStringField(GsysFunctionField.type.getFieldName(),model.getType());//5 权限类型
		g.writeStringField(GsysFunctionField.url.getFieldName(),model.getUrl());//6 url
		// g.writeStringField(GsysFunctionField.parentId.getFieldName(),model.getParentId());//7 上级ID
		g.writeStringField(GsysFunctionField.validStatus.getFieldName(),model.getValidStatus());//8 validStatus
		g.writeNumberField(GsysFunctionField.sortNum.getFieldName(), model.getSortNum());//9 排序
		g.writeStringField(GsysFunctionField.layerCode.getFieldName(),model.getLayerCode());//10 layerCode
		// 关联
		GsysFunction parent = model.getParent();
		g.writeStringField("parentName", null == parent ? null : parent.getName());// 上级名称
		// 树形属性
		g.writeStringField(TEXT, model.getText());
		g.writeBooleanField(COMPLETE, model.getComplete());
		g.writeBooleanField(HAS_CHILDREN, treeNode.hasChildrens());
		if (treeNode.hasChildrens()) {
			g.writeArrayFieldStart(CHILD_NODES);
			List<TreeNodeGeneric<GsysFunction>> treeNodeChildrens = treeNode.getChildrens();
			for (TreeNodeGeneric<GsysFunction> childTreeNode : treeNodeChildrens) {
				g.writeStartObject();// write model data
				writeJsonModel(g, childTreeNode);
				g.writeEndObject();// write model data end
			}
			g.writeEndArray();
		}
	}

}