package com.cos.blog.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cos.blog.entity.RoleType;
import com.cos.blog.entity.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void signUp(User user){
		String rawPassword = user.getPassword(); //패스워드 원문
		String encPassword = encoder.encode(rawPassword); //패스워드 해쉬화
		user.setPassword(encPassword); //패스워드 해쉬화 setting
		user.setRole(RoleType.USER); 
		userRepository.save(user);
	}
	
	/*
	@Transactional(readOnly = true)
	public User signIn(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
	*/
}
