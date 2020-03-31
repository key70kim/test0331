package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.vo.MemberVo;


//db를 통해 사용자 인증을 위한 클래스

@Service
public class MemberService implements UserDetailsService {

//	@Autowired
//	private MemberDdao dao			어떤db가 와도 관계없음.
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		System.out.println("사용자 로그인 처리");
		MemberVo member = DBManager.selectMember(username);
		if(member == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder()
				.username(member.getId())
				.password(member.getPwd())
				.roles(member.getRole())
				.build();
	}

}
