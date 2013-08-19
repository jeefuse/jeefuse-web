/**
 * Copyright (c) 2009-2013 jeefuse.com, Licensed under GPL (the "License")
 * Email:yonclv@gmail.com
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jeefuse.system.security.web.render;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jeefuse.base.modules.json.FlexidGridJsonWriter;
import com.jeefuse.base.modules.json.JsonWriter;
import com.jeefuse.base.modules.json.ResultJsonWriter;
import com.jeefuse.base.modules.json.TreeViewJsonWriter;
import com.jeefuse.base.modules.json.TreeViewShowcheckJsonWriter;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGenericConstructUtil;
import com.jeefuse.base.modules.tree.renders.menu.TreeMenuUIRender;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewConstructFactory;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.base.utils.page.Page;
import com.jeefuse.base.web.utils.RenderUtil;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * GsysFunction render util.
 * 
 * @author yonclv
 * @generated
 */
public class GsysFunctionRenderUtil {

	private static final String rootName = "所有权限";

	/**
	 * 输出 GsysFunction ResultMsg json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonResultMsg(boolean success, GsysFunction model, String message) {
		ResultJsonWriter<GsysFunction> jsonWriter = new GsysFunctionResultMsgJsonWriter(success, model, message);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysFunction FlexiGrid json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonFlexiGrid(int pageNo, long total, List<GsysFunction> items) {
		FlexidGridJsonWriter<GsysFunction> jsonWriter = new GsysFunctionFlexiGridJsonWriter(pageNo, total, items);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出GsysFunction FlexiGrid json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonFlexiGrid(Page<GsysFunction> page) {
		jsonFlexiGrid(page.getPageNo(), page.getTotalCount(), page.getResult());
	}

	/**
	 * 输出GsysFunction FlexiTreeGrid json对象格式数据.
	 * 
	 * @generated
	 */
	static public void jsonFlexiTreeGrid(long total, List<GsysFunction> items) {
		TreeNodeGeneric<GsysFunction> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(items);
		JsonWriter jsonWriter = new GsysFunctionFlexiTreeJsonWrite(treeNode.getChildrens(), total);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出jquery.treeview.js json树形结构数据.
	 */
	static public <T extends TreeViewItem> void jsonTreeview(List<T> items) {
		TreeViewJsonWriter<T> jsonWriter = TreeViewConstructFactory.contructTreeViewJsonWriter(items, rootName);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出jquery.treeview.js json树形结构数据.
	 */
	static public void jsonTreeviewForMenu(List<GsysFunction> items, HttpServletRequest request) {
		TreeNodeGeneric<GsysFunction> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(items);
		JsonWriter jsonWriter = new GsysFunctionMenuTreeJsonWrite(treeNode, request);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 输出jquery.treeview.js json树形结构数据显示checkbox.
	 * 
	 * @param items
	 *            源数据集合
	 * @param checkIds
	 *            已勾选的ID例表.
	 */
	static public<T extends TreeViewItem> void jsonTreeviewShowCheck(List<T> items, List<String> checkIds) {
		TreeViewShowcheckJsonWriter<T> jsonWriter = TreeViewConstructFactory.contructTreeViewShowcheckJsonWriter(items, checkIds);
		RenderUtil.renderJson(jsonWriter);
	}

	/**
	 * 构造jquery.treeview.js json树形结构数据显示checkbox.
	 * 
	 * @param items
	 * @param checkIds
	 * @return
	 * @throws IOException
	 */
	static public <T extends TreeViewItem> String jsonTreeviewShowCheckString(List<T> items, List<String> checkIds)
			throws IOException {
		TreeViewShowcheckJsonWriter<T> jsonWriter = TreeViewConstructFactory.contructTreeViewShowcheckJsonWriter(items, checkIds);
		StringWriter stringWriter = new StringWriter();
		jsonWriter.writeJson(stringWriter);
		return stringWriter.toString();
	}

	/**
	 * 输出html UI 树形结构.
	 */
	public static final String contructTreeMenuUI(List<GsysFunction> list) {
		TreeNodeGeneric<GsysFunction> treeNode = TreeNodeGenericConstructUtil.constructTreeNode(list);
		TreeMenuUIRender<GsysFunction> render = new TreeMenuUIRender<GsysFunction>();
		return render.render(treeNode);
	}
}