package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.xml.bind.v2.runtime.output.Encoded;


@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration//IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();//di해서 사용만하면됨. AuthService 에서 사용
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	//	super.configure(http); 이걸 삭제시 기존시큐리티가 가지고있는 기능이 비활성화된다.
		http.csrf().disable();//
		http.authorizeRequests()
			.antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**").authenticated()//해당주소로 시작하게되면 인증이필요하고 
			.anyRequest().permitAll() //그게아닌 모든요청은 허용하겠다.
			.and()
			.formLogin()//form 테그로 로그인.  
			.loginPage("/auth/signin")
			.defaultSuccessUrl("/");//로그인이정상적이면 / 로 이동 .
	}
}
  