package com.bitcamp.op;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController {

	@RequestMapping("/index")
	public void index() {
	}

	@RequestMapping("/")
	public String index1() {
		System.out.println("/ 진입");
		return "redirect:/index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login() {
		
		// 사용자가 입력한 ID와 PW를 서비스에 전달 -> 로그인 처리
		
		return "member/login";
	}
	
}
