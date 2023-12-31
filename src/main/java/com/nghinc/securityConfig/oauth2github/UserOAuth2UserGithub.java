package com.nghinc.securityConfig.oauth2github;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class UserOAuth2UserGithub implements OAuth2User {

	private OAuth2User user;

	public UserOAuth2UserGithub(OAuth2User user) {
		this.user = user;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return user.getAttributes();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return user.getAuthorities();
	}

	@Override
	public String getName() {
		return user.getAttribute("name");
	}
 public String getFullName() {
	 return user.getAttribute("name");
 }
}
