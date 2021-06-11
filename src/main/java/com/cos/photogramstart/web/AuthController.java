package com.cos.photogramstart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor //final이걸려있는 것에 대한 모든 생성자를 만들어줌.  DI 할때 사용
@Controller//인증을 위한 컨트롤러 IoC 에등록, 파일을 리턴하는 컨트롤러 
public class AuthController {

	
	
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);

	 //컨트롤러에서 회원가입을 요청해야함. 요청할때 서비스를 DI 해서 불러옴.,객체 생성하기 위해선 생성자를 만들고 실행시켜야함. 
	private final AuthService authService;//자바에서는 전역변수에 final을쓰면 무조건 생성자가 실행되거나 초기화를 해줘야함 그래서 어노테이션 써줌

	
	/*
	 * public AuthController(AuthService authService) {//AuthController 의 생성자 ,객체를
	 * 생성하기위해 생성자를 만듦. this.authService=authService; // TODO Auto-generated
	 * constructor stub }
	 */
	
	
	
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
		//User 오브젝트에 <--SingupDto의 데이터를 넣을거임.
		User user =signupDto.toEntity(); //user 에 sign up DB정보를 넣고 build 패턴을 이용해서 user 에 담음
		User userEntity=authService.회원가입(user);
	//	User userEntity= userRepository.save(user);
		System.out.println(userEntity);
		log.info(user.toString());
		return "auth/signin";
	}
}
