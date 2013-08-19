package com.jeefuse.system.security.service.spring;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import com.jeefuse.base.service.exception.NoLoginException;
import com.jeefuse.system.security.model.GsysFunction;
import com.jeefuse.system.security.service.SecurityServiceFactory;

/**
 * 系统安全管理.
 * 
 * @author yonclv
 * @email yonclv@gmail.com
 */
public class SecurityHolder {

	/**
	 * 取得当前用户的认证对象.
	 * 
	 * @return
	 */
	private static Authentication getCurrentAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	/**
	 * 获取当前登录用户的详细信息,如果当前用户未登录返回null.
	 */
	public static UserDetailsImpl getLoginUserDetail() {
		Authentication auth = getCurrentAuthentication();
		if (null == auth)
			return null;
		Object obj = auth.getPrincipal();
		if (obj instanceof UserDetailsImpl)
			return (UserDetailsImpl) obj;
		return null;
	}

	/**
	 * 取得当前登录用户名,如果当前用户未登录返回null.
	 * 
	 * @return
	 */
	public static String getLoginUserName() {
		UserDetailsImpl userDetail = getLoginUserDetail();
		if (null != userDetail)
			return userDetail.getNickname();
		return null;
	}

	/**
	 * 取得当前登录用户ID,如果当前用户未登录返回null.
	 * 
	 * @return
	 */
	public static String getLoginUserId() {
		UserDetailsImpl userDetail = getLoginUserDetail();
		if (null != userDetail)
			return userDetail.getId();
		return null;
	}

	/**
	 * 用户是否登录.已登入返回true,未登入返回false.
	 * 
	 * @return
	 */
	public static boolean isUserLogin() {
		UserDetailsImpl detailsImpl = getLoginUserDetail();
		if (null == detailsImpl)
			return false;
		return true;
	}

	/**
	 * 如果用户未登录则返回true.
	 */
	public static boolean isUserNoLogin() {
		UserDetailsImpl detailsImpl = getLoginUserDetail();
		if (null == detailsImpl)
			return true;
		return false;
	}

	/**
	 * 获取登录用户的所有功能权限。
	 */
	public static List<GsysFunction> getLoginUserFunction() {
		if (!isUserLogin())
			throw new NoLoginException("未登录用户试图获取功能权限!");
		String loginUserId = getLoginUserId();
		SystemAuthorizeService tPubAuthorityService = SecurityServiceFactory.getSystemAuthorizeService();
		return tPubAuthorityService.getAuthoritiesListByUserId(loginUserId);
	}

	/**
	 * 判断当前用户是否有指定 authorityId的权限.
	 * 
	 * @param authorityId
	 *            权根ID,即系统的功能菜单ID.
	 */
	public static boolean hasAuthority(String authorityId) {
		Assert.notNull(authorityId);
		List<GsysFunction> authorities = getLoginUserFunction();
		if (null == authorities || authorities.isEmpty())
			return false;
		for (GsysFunction tPubAuthority : authorities) {
			if (authorityId.equals(tPubAuthority.getId()))
				return true;
		}
		return false;
	}

}
