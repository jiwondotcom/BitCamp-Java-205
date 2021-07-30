package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberRegFormCommandImple implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		return "/WEB-INF/views/member_regForm.jsp";
	}
 
}
