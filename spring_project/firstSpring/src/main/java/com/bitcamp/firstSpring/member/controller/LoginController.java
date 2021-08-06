package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.LoginInfo;
import com.bitcamp.firstSpring.member.domain.LoginRequest;

// 기본 경로를 먼저 잡아준다. 
@Controller
@RequestMapping("/member/login") // 브라우저에서 사용하는 URL 경로(context 경로 뒤 부터 등록) => http://localhostL8080/mvc/member/login
public class LoginController {

	// @RequestMapping(value = "/member/login", method = RequestMethod.GET)
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm(
			
				@RequestParam(value = "page", defaultValue = "1") int page
			
				) {
		
		System.out.println(page);
		
		return "member/loginForm"; 	// /WEB-INF/views/member/loginForm.jsp => 응답을 만들어줄 jsp 경로
	}
	
	
	// @RequestMapping(value = "/member/login", method = RequestMethod.POST)
	@RequestMapping(method = RequestMethod.POST)
	public String login(
						
					@RequestParam("userID") String userID,
					@RequestParam("userPW") String userPW,
					HttpServletRequest request,
					@ModelAttribute("loginReq") LoginRequest loginRequest,
					Model model
						
					) {
		
		// 사용자의 파라미터 데이터를 받는 방법
		// 1. HttpServletRequest 이용
		// 2. @RequestParm("param name")
		// 3. 커맨드 객체(Beans) 이용
		
		System.out.println(userID + " : " + userPW);
		
		
		// view에 전달할 데이터 저장 : Model 객체를 이용 (String 매개변수로 받아준다.)
		model.addAttribute("userID", userID);
		model.addAttribute("userPW", userPW);
		
		
		String uID = request.getParameter("userID");
		String uPW = request.getParameter("userPW");
		
		System.out.println(uID + " : " + uPW);
		
		
		model.addAttribute("uID", uID);
		model.addAttribute("uPW", uPW);
		
		System.out.println(loginRequest);
		
		// 세션의 속성에 loginInfo 등록
		request.getSession(false).setAttribute("loginInfo", new LoginInfo());
		
		
		
		
		
		return "member/login";		// /WEB-INF/views/member/login.jsp
	
	
	}
	
	
}
