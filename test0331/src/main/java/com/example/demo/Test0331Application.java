package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.vo.MemberVo;

@SpringBootApplication
public class Test0331Application {

	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	public static void main(String[] args) {
	;
		
		DBManager.insertMember(new MemberVo("tiger", 	PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("tiger"), "홍길동", "member"));
		DBManager.insertMember(new MemberVo("admin", 	PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("1234"), "관리자", "ADMIN"));
		System.out.println("회원추가함");
		SpringApplication.run(Test0331Application.class, args);
	}

}
