package com.cos.photogramstart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service //ioc 와 트랜잭션 관리를 해줌 
public class AuthService {

	
	private final UserRepository userRepository;

	
	@Transactional//write(insert,update, Delete)
	public User 회원가입(User user) {//받아야 할 정보가 User 
		
		//회원가입 진행 , 진행하기위해선 repository를 실행 ,컨트롤러에서 회원가입을 요청해야함. 요청할때 서비스를 DI 해서 불러옴.
		User userEntity= userRepository.save(user);//save가되면 save가 된 객체 user를 리턴을 해주는데 그걸 userEntity 에 담음
		
		return userEntity;
	}
}
