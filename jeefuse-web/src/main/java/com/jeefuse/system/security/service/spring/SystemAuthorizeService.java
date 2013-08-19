package com.jeefuse.system.security.service.spring;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

import com.jeefuse.system.security.model.GsysFunction;

/**
 * 系统权限服务接口.
 * 
 * @author yonclv
 * @email yonclv@sohu.com
 */
public interface SystemAuthorizeService {

	/**
	 * 根据用户ID获取用户所属功能权限.
	 */
	public List<String> getAuthoritiesByUserId(String userId);

	/**
	 * 获取用户所属功能权限例表.
	 */
	public List<GsysFunction> getAuthoritiesListByUserId(String userId);

	/**
	 * 根据用户ID获取用户所属角色.
	 */
	public List<String> getRolesByUserId(String userId);

	/**
	 * 获取所有Url资源与相应的权限匹配.
	 */
	public Map<String, Collection<ConfigAttribute>> urlResourceDefine();

	/**
	 * 获取用户所属系统的功能权限例表.
	 * 
	 * @param userId
	 *            用户
	 * @param system_value
	 *            功能值
	 */
	public List<GsysFunction> getAuthoritiesListByUserIdForSys(String userId, String system_value);

}
