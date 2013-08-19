package com.jeefuse.system.security.service;

import java.util.List;

import com.jeefuse.base.modules.keyLabel.KeyLabel;
import com.jeefuse.base.modules.tree.renders.treeview.TreeViewItem;
import com.jeefuse.system.security.model.GsysFunction;

/**
 * 安全模块服务Facade.
 * 
 */
public class SecurityServiceFacade {
	
	/*****************************************************************
	 * gsysFunction service facade
	/*****************************************************************/


	/**
	 * 获取所有GsysFunction用于构造tree,只获取id,parentId,displayName属性.
	 */
	static public List<TreeViewItem> getAllGsysFunctionForTreeview() {
		return SecurityServiceFactory.getGsysFunctionService().getAllForTreeview(null);
	}

	/**
	 * 获取所有GsysFunction用于构造tree,只获取id,parentId,displayName属性.
	 */
	static public List<GsysFunction> getAllGsysFunctionForTreeMenu() {
		return SecurityServiceFactory.getGsysFunctionService().getAllForTreeMenu();
	}

	/**
	 * 获取角色关联的功能Id例表.
	 */
	public static List<String> getRelGsysFunctionIdsByGsysRoleId(String gsysRoleId) {
		return SecurityServiceFactory.getGsysRelRoleFunctionService().getRelGsysFunctionIdsByGsysRoleId(gsysRoleId);
	}


	/**
	 * 获取所有GsysResource对象用于构造keyLabel,只获取key,label属性.
	 */
	public static List<KeyLabel> getAllGsysResourceForKeyLabel() {
		return SecurityServiceFactory.getGsysResourceService().getAllForKeyLabel();
	}

	/**
	 * 获取角色关联的资源Id例表.
	 */
	public static List<String> getRelGsysResourceIdsByGsysRoleId(String gsysRoleId) {

		return SecurityServiceFactory.getGsysRelRoleResourceService().getRelGsysResourceIdsByGsysRoleId(gsysRoleId);
	}

	/**
	 * 获取所有GsysRole对象用于构造keyLabel,只获取key,label属性.
	 */
	public static List<KeyLabel> getAllGsysRoleForKeyLabel() {

		return SecurityServiceFactory.getGsysRoleService().getAllGsysRoleForKeyLabel();
	}

	/**
	 * 获取用户关联的角色Id例表.
	 */
	public static List<String> getRelGsysRoleIdsByGsysUserId(String gsysUserId) {

		return SecurityServiceFactory.getGsysRelUserRoleService().getRelGsysRoleIdsByGsysUserId(gsysUserId);
	}
}
