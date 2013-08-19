package com.jeefuse.system.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import com.jeefuse.base.dao.HibernateDao;
import com.jeefuse.base.exception.AppAssert;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.service.GsysFunctionService;
import com.jeefuse.system.security.service.GsysRelRoleFunctionService;
import com.jeefuse.system.security.service.GsysRelUserRoleService;
import com.jeefuse.system.security.service.spring.SystemAuthorizeService;

/**
 * 系统授权服务实现.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
@Service("systemAuthorizeService")
public class SystemAuthorityServiceImpl implements SystemAuthorizeService {
	@Autowired
	private HibernateDao hibernateDao;
	@Autowired
	private GsysRelRoleFunctionService gsysRelRoleFunctionService;
	@Autowired
	private GsysRelUserRoleService gsysRelUserRoleService;
	@Autowired
	private GsysFunctionService gsysFunctionService;


	public Map<String, Collection<ConfigAttribute>> urlResourceDefine() {
		List<GsysFunction> gsysFunctions = gsysFunctionService.getAll();
		Map<String, Collection<ConfigAttribute>> resourceDefine = new HashMap<String, Collection<ConfigAttribute>>();
		if (null != gsysFunctions && !gsysFunctions.isEmpty()) {
			for (GsysFunction gsysFunction : gsysFunctions) {
				if (StringUtils.isNotBlank(gsysFunction.getUrl())) {
					List<String> roleIds=gsysRelRoleFunctionService.getRelGsysRoleIdsByGsysFunctionId(gsysFunction.getId());
					Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
					for(String roleId:roleIds){
						ConfigAttribute ca = new SecurityConfig(roleId);
						atts.add(ca);
					}
					resourceDefine.put(gsysFunction.getUrl(), atts);
				}
			}
		}
		return resourceDefine;
	}

	public List<String> getAuthoritiesByUserId(String userId) {
		List<String> userRoleList = gsysRelUserRoleService.getRelGsysRoleIdsByGsysUserId(userId);
		List<String> authorities = gsysRelRoleFunctionService.getRelGsysFunctionIdsByGsysRoleId(userRoleList);
		return authorities;
	}

	@SuppressWarnings("unchecked")
	public List<GsysFunction> getAuthoritiesListByUserId(String userId) {
		List<String> gsysRoleIdList = gsysRelUserRoleService.getRelGsysRoleIdsByGsysUserId(userId);
		if (null == gsysRoleIdList || gsysRoleIdList.isEmpty())
			return null;
		final String hql = "select distinct new GsysFunction(m.gsysFunction.id,m.gsysFunction.name,m.gsysFunction.parent.id,m.gsysFunction.url) from GsysRelRoleFunction m where m.gsysRole.id in (:gsysRoleIdList) order by m.gsysFunction.sortNum";
		List<GsysFunction> gsysFunctions = hibernateDao.createQuery(hql).setParameterList("gsysRoleIdList",
				gsysRoleIdList).list();
		return gsysFunctions;
	}

	public List<String> getRolesByUserId(String userId) {
		return gsysRelUserRoleService.getRelGsysRoleIdsByGsysUserId(userId);
	}

	@SuppressWarnings("unchecked")
	public List<GsysFunction> getAuthoritiesListByUserIdForSys(String userId, String systemValue) {
		final String hql = "from GsysFunction m where m.value=?";
		GsysFunction gsysFunction = (GsysFunction) hibernateDao.findUnique(hql, systemValue);
		AppAssert.notNull(gsysFunction, "您访问的系统不存在!");
		List<String> gsysRoleIdList = gsysRelUserRoleService.getRelGsysRoleIdsByGsysUserId(userId);
		if (null == gsysRoleIdList || gsysRoleIdList.isEmpty())
			return null;
		final String hqlch = "select new GsysFunction(m.gsysFunction.id,m.gsysFunction.name,m.gsysFunction.parent.id,m.gsysFunction.url) from GsysRelRoleFunction m where m.gsysRole.id in (:gsysRoleIdList) and m.gsysFunction.layerCode like :layerCode and m.gsysFunction.layerCode!=:layerCode_1 and m.gsysFunction.validStatus='Y' order by m.gsysFunction.sortNum";
		List<GsysFunction> gsysFunctions = hibernateDao.createQuery(hqlch)
											.setParameterList("gsysRoleIdList",gsysRoleIdList)
											.setParameter("layerCode", gsysFunction.getLayerCode()+'%')
											.setParameter("layerCode_1", gsysFunction.getLayerCode())
											.list();
		return gsysFunctions;
	}

}
