package service;

import javax.servlet.http.HttpServletRequest;

public class GreetingCommandImple implements Command {
	
	@Override
	public String getPage(HttpServletRequest request) {
		
		// 핵심처리
		request.setAttribute("result", "안녕하세요");
		
		return "/WEB-INF/views/greeting.jsp";
	}

}
