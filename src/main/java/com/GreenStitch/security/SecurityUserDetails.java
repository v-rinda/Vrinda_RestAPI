package com.GreenStitch.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.GreenStitch.model.UserData;

public class SecurityUserDetails implements UserDetails {

	private final UserData userData;

	public SecurityUserDetails(UserData user) {
		this.userData = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();

		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userData.getRole());
		authorities.add(simpleGrantedAuthority);
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		return userData.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public String getUsername() {
		return userData.getEmail();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
