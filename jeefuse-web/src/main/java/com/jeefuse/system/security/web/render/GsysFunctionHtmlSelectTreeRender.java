package com.jeefuse.system.security.web.render;

import java.util.List;

import com.jeefuse.base.modules.tree.TreeRender;
import com.jeefuse.base.modules.tree.renders.generic.TreeNodeGeneric;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * 构造功能树Html select显示例表.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class GsysFunctionHtmlSelectTreeRender implements TreeRender<TreeNodeGeneric<GsysFunction>> {

	private String layerSeparator = "&nbsp;&nbsp;&nbsp;&nbsp;";
	private String checkId;

	public GsysFunctionHtmlSelectTreeRender(String layerSeparator, String checkId) {
		if (null != layerSeparator) {
			this.layerSeparator = layerSeparator;
		}
		if (null != checkId) {
			this.checkId = checkId;
		}
	}

	public String render(TreeNodeGeneric<GsysFunction> treeNode) {
		if (null == treeNode || !treeNode.hasChildrens())
			return null;
		StringBuilder sb = new StringBuilder(100);
		String layerPath = layerSeparator;
		List<TreeNodeGeneric<GsysFunction>> childrenTreeNodes = treeNode.getChildrens();
		for (TreeNodeGeneric<GsysFunction> curTreeNode : childrenTreeNodes) {
			constructTreeBySelect(sb, curTreeNode, layerPath);
		}
		return sb.toString();
	}

	public void constructTreeBySelect(StringBuilder sb, TreeNodeGeneric<GsysFunction> treeNode, String layerPath) {
		GsysFunction model = treeNode.getTargetObject();
		sb.append("<option value=\"" + model.getId() + "\"");
		if (null != checkId && model.getId().equals(checkId)) {
			sb.append(" selected=\"selected\" ");
		}
		sb.append(">");
		sb.append(layerPath);
		sb.append(model.getName());
		sb.append("</option>\r\n");
		if (treeNode.hasChildrens()) {
			List<TreeNodeGeneric<GsysFunction>> childrenTreeNodes = treeNode.getChildrens();
			for (TreeNodeGeneric<GsysFunction> curTreeNode : childrenTreeNodes) {
				constructTreeBySelect(sb, curTreeNode, layerSeparator + layerPath);
			}
		}
	}

}
