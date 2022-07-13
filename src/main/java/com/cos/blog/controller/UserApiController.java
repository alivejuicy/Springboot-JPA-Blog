package com.cos.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.entity.RoleType;
import com.cos.blog.entity.User;
import com.cos.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("save 함수 호출");
		//DB에 insert 구현
		user.setRole(RoleType.USER);
		userService.signUp(user);
		return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(),1);
	}

}
