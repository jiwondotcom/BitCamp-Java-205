package com.bitcamp.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class memberController {

	@RequestMapping("/member")
	public String page() {
		
		return "member";
	}
	
	
	
}
