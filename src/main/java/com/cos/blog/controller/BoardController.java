package com.cos.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cos.blog.configuration.auth.AuthDetail;
import com.cos.blog.configuration.auth.AuthDetailService;

@Controller
public class BoardController {

	@GetMapping({"","/"})
	public String index() {
		//System.out.println("로그인된 유저 ID: ");
		return "index";
	}
	
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	
}
