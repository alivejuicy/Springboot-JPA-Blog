package com.cos.blog.configuration.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.entity.User;

//스프링 시큐리티는 로그인 요청을 가로채서 로그인을 진행해준다.
// 완료되면 UserDetails 타입의 오브젝트를 스프링 시큐리티 고유 세션 저장소에 저장해줌.
public class AuthDetail implements UserDetails {

	private User user;

	public AuthDetail(User user){
		this.user = user; // composition
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getUsername();
	}

	// 계정이 만료되었는지 여부 확인
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(() -> {
			return "ROLE_" + user.getRole();
		});
		return collectors;
	}

}
