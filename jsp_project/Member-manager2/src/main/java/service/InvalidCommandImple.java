package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InvalidCommandImple implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		return "/index.jsp";
	}
 
}
