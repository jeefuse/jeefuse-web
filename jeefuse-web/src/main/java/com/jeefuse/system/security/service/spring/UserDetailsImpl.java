package com.jeefuse.system.security.service.spring;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	private String password;
	private String username;
	private String nickname;
	private String id;
	private Collection<GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	private String siteId;
	private String visitDomain;
	private String menberType;

	public UserDetailsImpl(String password, String username, String id, Set<GrantedAuthority> authorities,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled,
			String nickname) {
		if (username == null || "".equals(username) || password == null)
			throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
		this.password = password;
		this.username = username;
		this.id = id;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
		this.nickname = nickname;
		setAuthorities(authorities);
	}

	public String getVisitDomain() {
		return visitDomain;
	}

	public void setVisitDomain(String visitDomain) {
		this.visitDomain = visitDomain;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {

		return username;

	}

	public boolean isAccountNonExpired() {

		return accountNonExpired;

	}

	public boolean isAccountNonLocked() {

		return accountNonLocked;

	}

	public boolean isCredentialsNonExpired() {

		return credentialsNonExpired;

	}

	public boolean isEnabled() {

		return enabled;

	}

	public String getNickname() {
		return nickname;
	}

	public String getMenberType() {
		return menberType;
	}

	public void setMenberType(String menberType) {
		this.menberType = menberType;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getId() {
		return id;
	}

	public String getSiteId() {
		return siteId;
	}

	protected void setAuthorities(Set<GrantedAuthority> grantAuthorities) {
		Assert.notNull(grantAuthorities, "Cannot pass a null GrantedAuthority array");
		//		java.util.SortedSet<GrantedAuthority> sorter = new TreeSet<GrantedAuthority>();
		//		for (int i = 0; i < grantAuthorities.length; i++) {
		//			Assert.notNull(grantAuthorities[i], "Granted authority element " + i
		//					+ " is null - GrantedAuthority[] cannot contain any null elements");
		//			sorter.add(grantAuthorities[i]);
		//		}
		this.authorities = grantAuthorities;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString()).append(": ");
		sb.append("ID: ").append(id).append("; ");
		sb.append("Username: ").append(username).append("; ");
		sb.append("Password: [PROTECTED]; ");
		sb.append("Enabled: ").append(enabled).append("; ");
		sb.append("AccountNonExpired: ").append(accountNonExpired).append("; ");
		sb.append("credentialsNonExpired: ").append(credentialsNonExpired).append("; ");
		sb.append("AccountNonLocked: ").append(accountNonLocked).append("; ");
		if (getAuthorities() != null) {
			sb.append("Granted Authorities: ");
			Iterator<GrantedAuthority> it = getAuthorities().iterator();
			while (it.hasNext()) {
				sb.append(it.next().getAuthority());
				if (it.hasNext()) {
					sb.append(", ");
				}
			}
		} else {
			sb.append("Not granted any authorities");
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int code = 9792;
		Iterator<GrantedAuthority> it = getAuthorities().iterator();
		while (it.hasNext()) {
			code *= it.next().getAuthority().hashCode() % 7;
		}
		if (getPassword() != null) {
			code *= getPassword().hashCode() % 7;
		}
		if (getUsername() != null) {
			code *= getUsername().hashCode() % 7;
		}
		if (isAccountNonExpired()) {
			code *= -2;
		}
		if (isAccountNonLocked()) {
			code *= -3;
		}
		if (isCredentialsNonExpired()) {
			code *= -5;
		}
		if (isEnabled()) {
			code *= -7;
		}
		return code;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof UserDetailsImpl))
			return false;
		UserDetailsImpl rhs = (UserDetailsImpl) object;
		return new EqualsBuilder().appendSuper(super.equals(object)).append(this.id, rhs.id).append(this.enabled,
				rhs.enabled).append(this.username, rhs.username).append(this.authorities, rhs.authorities).append(
				this.accountNonExpired, rhs.accountNonExpired).append(this.password, rhs.password).append(
				this.credentialsNonExpired, rhs.credentialsNonExpired).append(this.accountNonLocked,
				rhs.accountNonLocked).isEquals();
	}

}
