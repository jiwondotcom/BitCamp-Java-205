<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<%
	// 1. 사용자가 입력한 데이터를 받고.
	// 2. DB 처리 : 새로운 데이터 insert
	// 3. dept_list.jsp 페이지로 이동
	// (0send redirect / java script location 이동 : 두가지 방법으로 처리해본다.)

	
	
	// 사용자가 입력한 데이터의 한글 처리 (우선)
	request.setCharacterEncoding("UTF-8");
	

	// 사용자가 입력한 데이터를 받는다.
	// 부서번호, 부서이름, 지역
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	
	// DB처리 : 새로운 데이터를 insert
	
	// 데이터베이스 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 연결
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String jdbcUrl = "jdbc:mysql://localhost:3306/project?serverTimezone=UTC";
	String user = "bit";
	String pw = "bit";
	
	conn = DriverManager.getConnection(jdbcUrl, user, pw);
	
	
	// PreparedStatement 생성
	String sqlInsert = "insert into dept values(?, ?, ?)";
	pstmt = conn.prepareStatement(sqlInsert);
	pstmt.setInt(1, Integer.parseInt(deptno));	
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	

	// insert 처리 -> int 결과
	int resultCnt = pstmt.executeUpdate();
	
	out.println(resultCnt);
	
	// insert 처리 후(새로운 부서정보 등록 후) -> dept_list.jsp 페이지로 이동
	

	
	
	
	


	
	
	
	
	
	
	
	


%>