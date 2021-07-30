package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.EditInfo;
import member.domain.Member;
import member.util.ConnectionProvider;

public class MemberEditService implements Command {

	public int editMember(HttpServletRequest request) {
		
		Member member = new Member();

		// 1. 사용자가 입력한 데이터를 받는다.
		  String index = request.getParameter("index");
		  String userID = request.getParameter("userID");
		  String userPW = request.getParameter("userPW");
		  String userName = request.getParameter("userName");
		 		
		int resultCnt = 0;
		 
		Connection conn = null;
		
		// EditInfo editinfo = (EditInfo) request.getSession().getAttribute("index");
		
		
	try {
		conn = ConnectionProvider.getConnection();
		
		member = MemberDao.getInstance().selectByIndex(conn, Integer.parseInt(index));

		member.setUserID(request.getParameter("userID"));
		member.setUserPW(request.getParameter("userPW"));
		member.setUserName(request.getParameter("userName"));
		
		resultCnt = MemberDao.getInstance().updateMember(conn, new EditInfo(Integer.parseInt(index), userID, userPW, userName));
		// member.setIndex(request.getParameter("index"));
		
		request.getSession().setAttribute("member", member);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return resultCnt;
}
	
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
	
		int resultCnt = editMember(request);
		request.setAttribute("result", resultCnt);
		
		return "/WEB-INF/views/editMember.jsp";
	
	}

}
