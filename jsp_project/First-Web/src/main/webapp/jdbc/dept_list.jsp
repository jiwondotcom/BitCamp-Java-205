<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// dept_list.jsp -> 요청을 받고 처리

	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	
	// 2. DB 연결
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	// jdbcUrl
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	
	// 3. Statement객체 생성
	stmt = conn.createStatement();
	
	// sql 
	String sqlSelect = "select * from dept";
	
	
	// 4. ResultSet
	rs = stmt.executeQuery(sqlSelect);
	
	// 5. List<Dept> 생성 : 결과
	// 6. 결과데이터를 request의 속성에 저장 -> 데이터를 공유(전달)

%>

    <jsp:forward page = "List_view.jsp"/>
