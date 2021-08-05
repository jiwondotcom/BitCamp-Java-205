package com.bitcamp.firstSpring;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CookieController {

	
		// 쿠키를 생성해주는 요청 처리
		@RequestMapping(value = "/cookie/make0")
		public String makeCookie(HttpServletResponse response) {
			
			Cookie c = new Cookie("userName", "jiwon");
			response.addCookie(c);
			

			
			
			return "cookie/make";
		}
	
	
}
