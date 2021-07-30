package service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.Member;
import member.util.ConnectionProvider;
import member.util.CookieBox;

public class LoginService implements Command {

	boolean loginChk = false;
	
	String userID;
	String userPW;
	String reID;
	
	public boolean login(HttpServletRequest request, HttpServletResponse response) {
		
		userID = request.getParameter("userID");
		userPW = request.getParameter("userPW");
		reID = request.getParameter("reID");
		CookieCheck(response);
		
		Connection conn = null;
		
		if(userID != null && userPW != null && userID.trim().length() > 2 && userPW.trim().length() > 3) {
			
			try {
				
				conn = ConnectionProvider.getConnection();
				Member member = MemberDao.getInstance().selectByIdPw(conn, userID, userPW);
				
				if(member != null) {
					// 회원의 정보를 Session 객체 저장
					request.getSession().setAttribute("member", member);
					request.getSession().setAttribute("loginInfo", member.toLoginInfo());
					loginChk = true;
				} 
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return loginChk;
		
	}
	
	
	private void CookieCheck(HttpServletResponse response) {
		
		// ID 저장을 위한 쿠키 설정
		// reID 값의 유무 체크
		if(reID != null && reID.equals("on")) {
			// 쿠키 저장 : 사용자의 ID를 저장
			try {
				response.addCookie(CookieBox.makeCookie("reID", userID, "/", 60*60*24*365));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} else {
			// 쿠키값을 저장하지 않는다.
			try {
				response.addCookie(CookieBox.makeCookie("reID", userID, "/", 0));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		loginChk = login(request, response);
		request.setAttribute("loginChk", loginChk);
		return "/WEB-INF/views/login.jsp";
	
	}

}
