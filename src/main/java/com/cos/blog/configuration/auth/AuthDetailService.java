package com.cos.blog.configuration.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cos.blog.entity.User;
import com.cos.blog.repository.UserRepository;

@Service
public class AuthDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 유저를 찾을 수 없습니다.");
				});
		
		return new AuthDetail(principal); //시큐리티 세션에 유저 정보를 저장한다.
	}

}
