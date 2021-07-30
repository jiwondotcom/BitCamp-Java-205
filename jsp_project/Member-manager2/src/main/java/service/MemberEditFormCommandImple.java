package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberEditFormCommandImple implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		String index = request.getParameter("index");
		request.setAttribute("index", index);
		return "/WEB-INF/views/editForm_view.jsp";
	}
 
}
