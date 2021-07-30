package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.util.ConnectionProvider;

public class IdCheckService implements Command {
	
	String result;
	
	public String idCheck(HttpServletRequest request) {
		
		int cnt = 0;
		String userID = request.getParameter("mid");
		
		Connection conn = null;
		MemberDao dao = null;
		 
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			cnt = dao.selectByID(conn, userID);
			
			//result = cnt > 0 ? "N" : "Y";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		result = cnt > 0 ? "N" : "Y";
		
		return result;
	}

	
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		idCheck(request);
		request.setAttribute("result", result);
		return "WEB-INF/views/idcheck.jsp";
	}
	
}