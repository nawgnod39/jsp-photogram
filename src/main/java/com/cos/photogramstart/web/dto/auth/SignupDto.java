package com.cos.photogramstart.web.dto.auth;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.cos.photogramstart.domain.user.User;

import lombok.Data;

@Data//getter setter 만들어주는 어노테이션
public class SignupDto {//req 하기위한 class , 통신을위한 데이터를 담아두는곳 , 
	//username ,password,email,name 데이터  
	
	private String username;
	private String password;
	private String email;
	private String name;
	
//이걸 authcontroller 에서 받아옴 
	
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.name(name)
				.build();
	}
}
