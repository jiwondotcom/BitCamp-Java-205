<%@page import="java.sql.SQLException"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// 사용자가 전달하는 부서번호 받기 -> 실행 -> 결과
	String deptno = request.getParameter("deptno");
	/* out.println(deptno); */
	
	int resultCnt = 0;
	
	// 전달받은 부서번호로 부서정보를 가져온다.
	// 1.드라이버 로드 : 서블릿클래스 Loader에서 드라이버 로드
	// Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. DB 연결
	Connection conn = null;
	DeptDao dao = DeptDao.getInstance();
	
	try {
		conn = ConnectionProvider.getConnection();
		
		resultCnt = dao.deleteDept(conn, Integer.parseInt(deptno));
		
	} catch(SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
/*
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// jdbcUrl
	conn = ConnectionProvider.getConnection();
	
	Dept dept = null;
	
	String sqlDelete = "delete from dept where deptno=?";
	pstmt = conn.prepareStatement(sqlDelete);
	pstmt.setInt(1, Integer.parseInt(deptno));

	
	resultCnt = pstmt.executeUpdate();
*/
	

	// 확인
	// out.println(dept);
	

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
