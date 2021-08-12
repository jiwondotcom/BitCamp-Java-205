package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public String loginForm(
			
			/* null값이 들어올수도 있다 -> required = false 처리 */
			@RequestHeader(value = "referer", required = false) String redirectUri,
			Model model
			
			) {
	
		model.addAttribute("redirectUri", redirectUri);
		
		return "member/loginForm";
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public String login(
				
				/* 매개변수는 따로 클래스 처리를 하기도 한다. */
				/* null값이 들어와도 상관없을 경우엔 required = false 처리한다. */
				@RequestParam("userID") String userID,
				@RequestParam("userPW") String userPW,
				@RequestParam(value = "redirectUri", required = false) String redirectUri,
				@RequestParam(value = "reID", required = false) String reID,
			
				HttpSession session,
				HttpServletResponse response,
				Model model
			
				) {
		
		
		// 사용자가 입력한 ID와 PW를 서비스에 전달 -> 로그인 처리
		boolean loginChk = loginService.login(userID, userPW, reID, session, response);
		model.addAttribute("loginChk", loginChk);
		
		String view = "member/login";
		
		if(redirectUri != null && loginChk) { // loginChk = true
			view = "redirect:" + redirectUri;
		}
		
		
		return view;
	}
	
}
