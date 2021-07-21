<%@page import="jdbc.util.ConnectionProvider"%>
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
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	// 2. DB 연결
	Connection conn = null;
	MemberDao dao = null;
	
	// jdbcUrl
	/* String jdbcUrl = "jdbc:mysql://localhost:3306/member?serverTimezone=UTC";
    String user = "root";
    String pw = "1234";

    conn = DriverManager.getConnection(jdbcUrl, user, pw); */
    
    conn = ConnectionProvider.getConnection();

	






%>