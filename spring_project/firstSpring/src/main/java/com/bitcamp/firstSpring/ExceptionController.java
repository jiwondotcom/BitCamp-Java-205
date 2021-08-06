package com.bitcamp.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {

	private String str;
	
	
	@RequestMapping("error/error")
	public String getPage() {
		
		System.out.println(str.charAt(0));
		
		return "index";
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public String HandleNullPointerException(NullPointerException e) {
		e.printStackTrace(); // 오류에 대한 흔적 남기기
		return "error/nullPointer";
	}
	
}
