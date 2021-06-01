package com.cos.photogramstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//인증을 위한 컨트롤러 IoC 에등록, 파일을 리턴하는 컨트롤러 
public class AuthController {


	@GetMapping("/auth/signin")
	public String sigininForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String siginupForm() {
		return "auth/signup";
	}
	
	//회원가입ㅌ버튼 누르면 
	@PostMapping("/auth/signup")
	public String siginup() {
		return "auth/signin";
	}
}
