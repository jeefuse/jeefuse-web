package com.jeefuse.system.security.service.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.RegexUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

public class UrlDefindInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource,
		InitializingBean {
	private UrlMatcher urlMatcher;
	private boolean useAntPath = true;
	private boolean lowercaseComparisons = true;

	public void setUrlMatcher(UrlMatcher urlMatcher) {
		this.urlMatcher = urlMatcher;
	}

	public void setUseAntPath(boolean useAntPath) {
		this.useAntPath = useAntPath;
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return new ArrayList<ConfigAttribute>();
	}

	public Collection<ConfigAttribute> getAttributes(Object filter) throws IllegalArgumentException {
		FilterInvocation filterInvocation = (FilterInvocation) filter;

		String requestURI = filterInvocation.getRequestUrl();
		if (-1 != requestURI.indexOf("?")) {
			requestURI = requestURI.substring(0, requestURI.indexOf("?"));
		}
		Collection<ConfigAttribute> grantedAuthorities = null;
		// 匹配URL获取访问该URL所需要的权限.
		Map<String, Collection<ConfigAttribute>> urlAuthorities = this.getUrlAuthorities();
		// 查看请求的URl是否有定义.
		if (null != urlAuthorities.get(requestURI)) {
			grantedAuthorities = urlAuthorities.get(requestURI);
		}
		//		else {
		//			Iterator<String> ite = urlAuthorities.keySet().iterator();
		//			while (ite.hasNext()) {
		//				String defineUrl = ite.next();
		//				if (urlMatcher.pathMatchesUrl(defineUrl, requestURI)) {
		//					grantedAuthorities = urlAuthorities.get(defineUrl);
		//					break;
		//				}
		//			}
		//		}
		return grantedAuthorities;

	}

	public boolean supports(Class<?> arg0) {
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		if (useAntPath) {
			this.urlMatcher = new AntUrlPathMatcher();
		} else {
			// default url matcher will be RegexUrlPathMatcher
			this.urlMatcher = new RegexUrlPathMatcher();
		}

		if ("true".equals(lowercaseComparisons)) {
			if (!this.useAntPath) {
				((RegexUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(true);
			} else {
				((AntUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(false);
			}
		} else {
			if (!this.useAntPath) {
				((RegexUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(false);
			} else {
				((AntUrlPathMatcher) this.urlMatcher).setRequiresLowerCaseUrl(false);
			}
		}

	}

	private Map<String, Collection<ConfigAttribute>> getUrlAuthorities() {
		return SecurityResourceLoader.getUrlAuthoritiesMap();
	}

}
