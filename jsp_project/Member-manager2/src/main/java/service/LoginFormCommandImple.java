package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormCommandImple implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/loginForm.jsp";
	}
 
}
