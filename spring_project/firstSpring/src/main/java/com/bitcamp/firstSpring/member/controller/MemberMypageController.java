package com.bitcamp.firstSpring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberMypageController {

	@RequestMapping("/member/mypage/{id}") // {변수}
	public String mypage(
			
			@PathVariable("id") String uid,
			Model model
			
			) {
		
		System.out.println(uid);
		
		model.addAttribute("userID", uid);
		
		return "member/mypage";
	}
	
	
}
