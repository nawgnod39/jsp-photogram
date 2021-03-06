package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//jpa , 즉 자바로 데이터를 영구적으로 저장(db)할수있는 api를 제공
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity//DB에 테이블을 생성해줌 
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//번호증가전략이 데이터베이스를 따라감. 마이에스큐엘은 오토인크리먼트 전략을 씀 
	private int id;
	
	@Column(length = 20 , unique = true)//아이디 중복 방지를 위함.
	private String username;
	@Column(nullable = false)//null 불가능  
	private String password;
	@Column(nullable = false)//null 불가능  
	private String name;
	private String website;
	private String bio;//자기소개
	@Column(nullable = false)//null 불가능  
	private String email;
	private String phone;
	private String gender;
	private String profileImageUrl;//작성자 사진
	private String role; //권한
	
	private LocalDateTime createDate;//DB에넣으려면 필요함.
	
	@PrePersist//디비에 인설트되기전에 실행된다. 
	public void createDate() {
		this.createDate =LocalDateTime.now();
	}
	
	//orm 을 쓰고있음 
}
