package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.LoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm() {
		return "member/loginForm";
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public String login(
				
				/* 매개변수는 따로 클래스 처리를 하기도 한다. */
				@RequestParam("userID") String userID,
				@RequestParam("userPW") String userPW,
				@RequestParam("reID") String reID,
				HttpSession session,
				HttpServletResponse response
			
				) {
		
		
		// 사용자가 입력한 ID와 PW를 서비스에 전달 -> 로그인 처리
		
		return "member/login";
	}
	
}
