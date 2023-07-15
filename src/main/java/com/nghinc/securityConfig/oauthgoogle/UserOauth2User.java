//package com.nghinc.securityConfig.oauthgoogle;
//
//import java.util.Collection;
//import java.util.Map;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//
//public class UserOauth2User implements OAuth2User{
//
//	private OAuth2User oauth2User;
//	
//
//	
//
//	public UserOauth2User(OAuth2User oauth2User) {
//		super();
//		this.oauth2User = oauth2User;
//	}
//
//	@Override
//	public Map<String, Object> getAttributes() {
//		return  oauth2User.getAttributes();
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//	return oauth2User.getAuthorities();
//	}
//
//	@Override
//	public String getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
////	@Override
////	public String getName() {
////		return oauth2User.getAttribute("name");
////	}
////
////	public String getfullName() {
////		return oauth2User.getAttribute("fullName");
////	}
//}
