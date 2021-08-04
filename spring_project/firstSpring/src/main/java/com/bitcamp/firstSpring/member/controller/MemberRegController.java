package com.bitcamp.firstSpring.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.firstSpring.member.domain.MemberRegRequest;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String getRegForm() {
		return "member/regForm";
	}		
		
	
	@RequestMapping(method = RequestMethod.POST)	
	public String memberReg(
			
				@RequestParam(value = "userID", required = false) String userID,
				@RequestParam(value = "userPW", required = false) String userPW,
				@RequestParam(value = "userName", required = false)String userName,
				HttpServletRequest request,
				@ModelAttribute("regRequest") MemberRegRequest regRequest,
				Model model
				
			
			) {
		
		
		model.addAttribute("userID", userID);
		model.addAttribute("userPW", userPW);
		model.addAttribute("userName", userName);
		
		model.addAttribute("userID", request.getParameter("userID"));
		model.addAttribute("userPW", request.getParameter("userPW"));
		model.addAttribute("userName", request.getParameter("userName"));
			
		
		// 회원가입을 위한 Service 객체를 이용한 핵심 처리
		
		return "member/memberReg";
		
	}
		
	

}
