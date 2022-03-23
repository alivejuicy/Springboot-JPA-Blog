package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 -> 응답 @Controller /  데이터를 응답하는 컨트롤 @RestController

@RestController 
public class HttpControllerTest {
	
	//select 요청, 인터넷 브라우저 요청은 Get요청으로만 할 수 있음을 기억하자.
	@GetMapping("/http/get")
	
	public String getTest(Member m) {
		return "get 요청 = "+ m.getId()+","+ m.getEmail()+","+m.getUsername();
	}

	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
		return "post 요청"+ m.getId()+","+ m.getEmail()+","+m.getUsername();
	}
	
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청"+ m.getId()+","+ m.getEmail()+","+m.getUsername();
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
