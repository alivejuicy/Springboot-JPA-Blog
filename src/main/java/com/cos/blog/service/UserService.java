package com.cos.blog.service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.entity.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void signUp(User user){
		userRepository.save(user);
	}
	
	/*
	@Transactional(readOnly = true)
	public User signIn(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
	}
	*/
}
