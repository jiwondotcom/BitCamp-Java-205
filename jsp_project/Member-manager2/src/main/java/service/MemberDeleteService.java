package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.Member;
import member.util.ConnectionProvider;

public class MemberDeleteService implements Command {

	public int deleteMember(HttpServletRequest request) {
		
		Member member = new Member();
		Connection conn = null;
		
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			member = (Member) request.getSession().getAttribute("member");
			
			resultCnt = MemberDao.getInstance().deleteMember(conn, member.getIndex());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return resultCnt;
	}
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		int result = deleteMember(request);
		request.setAttribute("result", result);
		
		return "WEB-INF/views/deleteMember.jsp";
	}

}
