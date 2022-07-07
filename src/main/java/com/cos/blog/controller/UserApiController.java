package com.cos.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.entity.User;

@RestController
public class UserApiController {
	
	@PostMapping("/api/user")
	public int save(@RequestBody User user) {
		System.out.println("save 함수 호출");
		return 1;
	}

}
