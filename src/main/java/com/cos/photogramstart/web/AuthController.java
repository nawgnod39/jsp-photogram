package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.web.dto.auth.SignupDto;

@Controller//인증을 위한 컨트롤러 IoC 에등록, 파일을 리턴하는 컨트롤러 
public class AuthController {

	
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);


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
	public String siginup(SignupDto signupDto) {//key= value  xwww방식 으로 데이터를 받아줌 
		log.info(signupDto.toString()); //잘 받아옴, 이제 데이터베이스에 인서트하기위해서는 model 이 필요함 ,따라서 유저 모델생성 
		
		return "auth/signin";
	}
}
