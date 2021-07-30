package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.util.ConnectionProvider;
import member.util.JdbcUtil;

public class MemberListViewService implements Command {

	public void viewMemberList(HttpServletRequest request) {
		
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
		
		try {
			conn = ConnectionProvider.getConnection();
			request.setAttribute("mList",dao.getMemberList(conn));
			
		} catch(SQLException e) {
			e.printStackTrace();		
		} catch(Exception e) {
			e.printStackTrace();		
		} finally {
			JdbcUtil.close(conn);
		}
	
	}
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		viewMemberList(request);
		return "/WEB-INF/views/membrList_view.jsp";
	
	}

}
