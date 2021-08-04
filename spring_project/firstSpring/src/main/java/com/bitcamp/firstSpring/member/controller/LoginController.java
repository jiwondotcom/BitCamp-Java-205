package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/login") // 기본 경로를 먼저 잡아준다.
public class LoginController {

	// @RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(/* @RequestParam("page") int page */) {
		
		// System.out.println(page + 1);
		
		return "member/loginForm"; 	// /WEB-INF/views/member/loginForm.jsp
	}
	
	
	// @RequestMapping(value = "/member/login", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public String login(
						
					@RequestParam("userID") String userID,
					@RequestParam("userPW") String userPW,
					HttpServletRequest request,
					LoginRequest loginRequest
						
					) {
		
		System.out.println(userID + " : " + userPW);
		
		String uID = request.getParameter("userID");
		String uPW = request.getParameter("userPW");
		
		System.out.println(uID + " : " + uPW);
		System.out.println(loginRequest);
		
		return "member/login";		// /WEB-INF/views/member/login.jsp
	}
	
	/*
	@RequestMapping("/member/loginForm")
	public String getLoginForm() {
		return "member/loginForm"; //	
	}
	*/
}
