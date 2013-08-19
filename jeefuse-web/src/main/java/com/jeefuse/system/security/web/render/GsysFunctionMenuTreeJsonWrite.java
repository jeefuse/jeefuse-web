/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.render;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;

import com.jeefuse.base.modules.json.JsonUtil;
import com.jeefuse.base.modules.json.JsonWriter;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.web.utils.WebContextUtil;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * 输出GsysFunction FlexiGridTree json格式数据.
 * 
 * @author yonclv
 * @generated
 */
public class GsysFunctionMenuTreeJsonWrite implements JsonWriter {
	// treeview 输出字段
	private static final String ID = "id";
	private static final String TEXT = "text";
	private static final String VALUE = "value";
	private static final String HASCHILDREN = "hasChildren";
	private static final String ISEXPAND = "isexpand";
	private static final String COMPLETE = "complete";
	private static final String CHILD_NODES = "childNodes";
	private static final String DEFAULT_ROOT_ID = "root";
	private static final String URL = "url";

	private String rootName;
	private String rootId = DEFAULT_ROOT_ID;
	private TreeNodeGeneric<GsysFunction> rootTreeNode;
	HttpServletRequest request;

	public GsysFunctionMenuTreeJsonWrite(TreeNodeGeneric<GsysFunction> rootTreeNode, HttpServletRequest request) {
		this.rootTreeNode = rootTreeNode;
		this.request = request;
	}

	public GsysFunctionMenuTreeJsonWrite(TreeNodeGeneric<GsysFunction> treeNode, String rootName, String rootId, HttpServletRequest request) {
		this.rootTreeNode = treeNode;
		this.rootName = rootName;
		this.rootId = rootId;
		this.request = request;
	}

	public void writeJson(Writer writer) throws IOException {
		JsonGenerator g = JsonUtil.jsonFactory.createJsonGenerator(writer);
		writeJson(g);
	}

	public void writeJson(JsonGenerator g) {
		try {
			g.writeStartArray();
			if (null != rootName) {
				g.writeStartObject();
				g.writeStringField(ID, rootId);
				g.writeStringField(TEXT, rootName);
				g.writeStringField(VALUE, rootId);
				g.writeBooleanField(ISEXPAND, true);
				g.writeBooleanField(COMPLETE, true);
				g.writeBooleanField(HASCHILDREN, null != rootTreeNode && rootTreeNode.hasChildrens());
				if (null != rootTreeNode && rootTreeNode.hasChildrens()) {
					g.writeArrayFieldStart(CHILD_NODES);
					List<TreeNodeGeneric<GsysFunction>> treeViewItems = rootTreeNode.getChildrens();
					for (TreeNodeGeneric<GsysFunction> model : treeViewItems) {
						writeJsonModel(g, model);
					}
					g.writeEndArray();
				}
				g.writeEndObject();
			} else {
				if (null != rootTreeNode) {
					List<TreeNodeGeneric<GsysFunction>> treeViewItems = rootTreeNode.getChildrens();
					for (TreeNodeGeneric<GsysFunction> model : treeViewItems) {
						writeJsonModel(g, model);
					}
				}
			}
			g.writeEndArray();
			g.flush();
			g.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeJsonModel(JsonGenerator g, TreeNodeGeneric<GsysFunction> treeNode)
			throws JsonGenerationException, IOException {
		g.writeStartObject();// write model data
		GsysFunction treeViewItem = treeNode.getTargetObject();
		g.writeStringField(ID, treeViewItem.getId());
		g.writeStringField(TEXT, treeViewItem.getText());
		g.writeStringField(VALUE, treeViewItem.getValue());
		g.writeStringField(URL, WebContextUtil.getContextUrl(request, treeViewItem.getUrl()));
		// g.writeNumberField(checkstate, treeViewItem.getCheckstate());
		g.writeBooleanField(ISEXPAND, treeViewItem.getIsexpand());
		g.writeBooleanField(COMPLETE, treeViewItem.getComplete());
		g.writeBooleanField(HASCHILDREN, treeNode.hasChildrens());
		if (treeNode.hasChildrens()) {
			List<TreeNodeGeneric<GsysFunction>> treeNodeChildren = treeNode.getChildrens();
			g.writeArrayFieldStart(CHILD_NODES);
			int len = treeNodeChildren.size();
			for (int i = 0; i < len; i++) {
				TreeNodeGeneric<GsysFunction> model = treeNodeChildren.get(i);
				writeJsonModel(g, model);
			}
			g.writeEndArray();
		}
		g.writeEndObject();// write model data end

	}

}