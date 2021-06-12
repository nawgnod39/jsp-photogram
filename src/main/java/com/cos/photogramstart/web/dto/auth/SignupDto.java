package com.cos.photogramstart.web.dto.auth;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data//getter setter 만들어주는 어노테이션
public class SignupDto {//req 하기위한 class , 통신을위한 데이터를 담아두는곳 , 
	//username ,password,email,name 데이터  
	
	@Max(20)
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String email;
	@NotBlank
	private String name;
	
//이걸 authcontroller 에서 받아옴 
	
	
	public User toEntity() {//user에담기 좋은 방법은 함수를 만들기. 
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}
