package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member { //서버 프로그래밍에서 자바에서는 변수를 private로 선언한다.
	private int id;
	private String username;
	private String password;
	private String email;
}
