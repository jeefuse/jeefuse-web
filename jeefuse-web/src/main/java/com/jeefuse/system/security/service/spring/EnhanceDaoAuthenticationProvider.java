package com.jeefuse.system.security.service.spring;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.Assert;

public class EnhanceDaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	public EnhanceDaoAuthenticationProvider() {
		passwordEncoder = new Md5PasswordEncoder();
		includeDetailsObject = true;
	}
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		Object salt = null;
		if (saltSource != null) {
			salt = saltSource.getSalt(userDetails);
		}
		if (authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");
			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
					includeDetailsObject ? ((Object) (userDetails)) : null);
		}
		String presentedPassword = authentication.getCredentials().toString();
		String dynamicCode = ((EnhanceUsernamePasswordAuthenticationToken) authentication).getDynamicCode();
		if (!passwordEncoder.isPasswordValid(userDetails.getPassword(), presentedPassword, dynamicCode, salt)) {
			logger.debug("Authentication failed: password does not match stored value");
			throw new BadCredentialsException(messages.getMessage(
					"AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
					includeDetailsObject ? ((Object) (userDetails)) : null);
		} else
			return;
	}

	@Override
	protected void doAfterPropertiesSet() throws Exception {
		Assert.notNull(userDetailsService, "A UserDetailsService must be set");
	}

	@Override
	protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDetails loadedUser;
		try {
			loadedUser = getUserDetailsService().loadUserByUsername(username);
		} catch (DataAccessException repositoryProblem) {
			throw new AuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
		}
		if (loadedUser == null)
			throw new AuthenticationServiceException(
					"UserDetailsService returned null, which is an interface contract violation");
		else
			return loadedUser;
	}


	public void setSaltSource(SaltSource saltSource) {
		this.saltSource = saltSource;
	}

	protected SaltSource getSaltSource() {
		return saltSource;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	protected boolean isIncludeDetailsObject() {
		return includeDetailsObject;
	}

	/**
	 * @deprecated Method setIncludeDetailsObject is deprecated
	 */

	@Deprecated
	public void setIncludeDetailsObject(boolean includeDetailsObject) {
		this.includeDetailsObject = includeDetailsObject;
	}

	private Md5PasswordEncoder passwordEncoder;
	private SaltSource saltSource;
	private UserDetailsService userDetailsService;
	private boolean includeDetailsObject;
}
