package com.cos.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.entity.Board;

@RestController
public class BoardApiController {
	
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board){
		
		//return ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
}
