package com.jeefuse.system.security.service.spring;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jeefuse.system.code.model.enumeration.EnabledType;
import com.jeefuse.system.security.model.GsysUser;
import com.jeefuse.system.security.service.GsysUserService;

/**
 * 用户认证实现.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class UserDetailServiceImpl implements UserDetailsService{
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private GsysUserService gsysUserService;// 用户服务
	@Autowired
	private SystemAuthorizeService systemAuthorizeService;// 系统授权服务

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if (logger.isDebugEnabled()) {
			logger.debug("loading user Details for userName:" + username);
		}
		GsysUser user = gsysUserService.getByLoginName(username);
		if (user == null)
			throw new UsernameNotFoundException(username + "用户不存在!");
		boolean enabled = EnabledType.VALID.getKey().equals(user.getEnabled());
		Set<GrantedAuthority> grantedAuths = obtainGrantedRoles(user.getId());
		UserDetailsImpl userDetail = new UserDetailsImpl(user.getPassword(), user.getLoginName(), user.getId(),
				grantedAuths, true, true, true, enabled, user.getUsername());
		return userDetail;
	}


	/**
	 * 用户所有角色.
	 */
	private Set<GrantedAuthority> obtainGrantedRoles(String userId) {
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		List<String> roles = systemAuthorizeService.getRolesByUserId(userId);
		if (null != roles && !roles.isEmpty()) {
			for (String role : roles) {
				authSet.add(new GrantedAuthorityImpl(role));
			}
		}
		return authSet;
	}
}