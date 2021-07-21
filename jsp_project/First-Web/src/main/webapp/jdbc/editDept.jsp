<%@page import="dept.dao.DeptDao"%>
<%@page import="java.sql.SQLException"%>
<%@page import="dept.domain.Dept"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<%
	// 1. 사용자가 입력한 데이터를 받고.
	// 2. DB 처리 : 새로운 데이터 edit(수정)
	// 3. dept_list.jsp 페이지로 이동
	// (send redirect / java script location 이동 : 두가지 방법으로 처리해본다.)

	
	
	// 사용자가 입력한 데이터의 한글 처리 (우선)
	request.setCharacterEncoding("UTF-8");
	

	// 사용자가 입력한 데이터를 받는다.
	// 부서번호, 부서이름, 지역
	String deptno = request.getParameter("deptno");
	String dname = request.getParameter("dname");
	String loc = request.getParameter("loc");
	
	
	int resultCnt = 0;
	
	
	// DB처리 : 새로운 데이터를 edit(수정)
	
	// 1.드라이버 로드 : 서블릿클래스 Loader에서 드라이버 로드
	// Class.forName("com.mysql.cj.jdbc.Driver");

	// 연결
	Connection conn = null;
	DeptDao dao = null;
	
	try {
		conn = ConnectionProvider.getConnection();
		dao = DeptDao.getInstance();
		
		resultCnt = dao.updateDept(conn, new Dept(Integer.parseInt(deptno), dname, loc));
		
	
	} catch(SQLException e) {
		e.printStackTrace();
	} finally { 
		JdbcUtil.close(conn);
	}
	
	
	
	// (2) 자바스크립트 location 이동 처리
	// int resultCnt값이 1이 나왔을 때 -> 페이지 이동
		
	if(resultCnt > 0) {
		%>
		<script>
			alert('수정되었습니다.');
			location.href = "dept_list.jsp";
		</script>
		<%
		
	} else {
		%>
		<script>
			alert('해당 데이터를 찾지 못했습니다.');
			location.href = "dept_list.jsp";
		</script>
		<%
	}
%>
