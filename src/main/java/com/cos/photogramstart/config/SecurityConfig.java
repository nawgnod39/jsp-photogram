package com.cos.photogramstart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity // 해당 파일로 시큐리티를 활성화
@Configuration//IoC 등록
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
	//	super.configure(http); 이걸 삭제시 기존시큐리티가 가지고있는 기능이 비활성화된다.
		http.csrf().disable();//
		http.authorizeRequests()
			.antMatchers("/","/user/**","/image/**","/subscribe/**","/comment/**").authenticated()//해당주소로 시작하게되면 인증이필요하고 
			.anyRequest().permitAll() //그게아닌 모든요청은 허용하겠다.
			.and()
			.formLogin()
			.loginPage("/auth/signin")
			.defaultSuccessUrl("/");
	}
}
  