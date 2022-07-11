package com.cos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cos.blog.entity.User;
import com.cos.blog.repository.UserRepository;

public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public int signUp(User user){
		try {
			 userRepository.save(user);
			 return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입"+e.getMessage());
			// TODO: handle exception
		} 
		return -1;
		
	}
}
