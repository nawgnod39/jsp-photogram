package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service //ioc 와 트랜잭션 관리를 해줌 
public class AuthService {

	
	private final UserRepository userRepository;

	
	public User 회원가입(User user) {
		
		//회원가입 진행 , 진행하기위해선 repository를 실행 ,컨트롤러에서 회원가입을 요청해야함. 요청할때 서비스를 DI 해서 불러옴.
		User userEntity= userRepository.save(user);
		
		return userEntity;
	}
}
