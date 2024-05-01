package org.zerock.security.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.zerock.domain.MemberVO;

import lombok.Getter;

//public class CustomUser extends User{
//
//	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
//		super(username, password, authorities);
//	}
//
//}
public class CustomUser implements UserDetails{
	
	private MemberVO memberVO;
	
//	public CustomUser(String username, String password, Collection<E>) {
//	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
	
}
