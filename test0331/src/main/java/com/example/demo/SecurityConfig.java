package com.example.demo;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.authorizeRequests()
		.mvcMatchers("/","/info","/member/**").permitAll()
		.mvcMatchers("/admin").hasRole("ADMIN")  //인가
		.anyRequest().authenticated();		//인증
//		.and()
//		.formLogin()
//		.and()
//		.httpBasic();
		
		http.formLogin().loginPage("/login.html");
		http.httpBasic();
		
		http.logout().logoutUrl("/");
	}

	
	
//	
//	//{noop}  <--- 스프링 5.0이후 제공하는 패스워드 인코딩   암호화 되어서 저장함.  암호화 되지 않았음.
//	//시스템이 제공하는 유저가 아닌 사용자가 유저정보 설정하기
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
////		super.configure(auth);
//		auth.inMemoryAuthentication()
//		.withUser("tiger").password("{noop}tiger").roles("USER").and()						//  {noop} 암호화 사용하지 않아요!   스프링 시큐리티가 패스워드 인코딩 됨으로 하지 않겠다고 설절
//		.withUser("admin").password("{noop}admin").roles("ADMIN").and();
//	
//	}
	
	
	
	
}	
