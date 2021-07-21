<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.ConnectionProvider2"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// 사용자가 전달하는 회원번호 전달 받기
	String index = request.getParameter("index");

	// 전달받은 회원번호로 회원정보를 가져온다. -> 처리 -> Member -> 공유
	// 1. 드라이버 로드
	// Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	// 2. DB 연결
	Connection conn = null;
	MemberDao dao = null;
	
	try {
		conn = ConnectionProvider2.getConnection();
		dao = MemberDao.getInstance();

    	request.setAttribute("index", dao.selectByIndex (conn, Integer.parseInt(index)));
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
 
%>

<jsp:forward page = "editForm_view.jsp"/>
