package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DBManager;
import com.example.demo.vo.MemberVo;

@RestController
public class MemberController {


	
	@GetMapping("/insert")
	public String insertMember() {
	
		return "hello";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "관리자";
	}
}
