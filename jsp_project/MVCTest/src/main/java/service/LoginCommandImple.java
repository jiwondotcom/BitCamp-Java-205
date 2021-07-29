package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class LoginCommandImple implements Command {
	
	@Override
	public String getPage(HttpServletRequest request) {

		// 핵심처리
		request.setAttribute("result", "로그인페이지 입니다.");
		
		return "/WEB-INF/views/login.jsp";
	}

}
