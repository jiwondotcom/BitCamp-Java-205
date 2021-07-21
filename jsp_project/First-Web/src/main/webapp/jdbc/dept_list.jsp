<%@page import="java.sql.SQLException"%>
<%@page import="jdbc.util.JdbcUtil"%>
<%@page import="dept.dao.DeptDao"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="dept.domain.Dept"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// dept_list.jsp -> 요청을 받고 처리 -> 결과 데이터를 객체 속성에 저장 -> view를 지정
	
	// 1.드라이버 로드 : 서블릿클래스 Loader에서 드라이버 로드
	// Class.forName("com.mysql.cj.jdbc.Driver");

	
	// 2. DB 연결
	Connection conn = null;
	DeptDao dao = DeptDao.getInstance();
	// Statement stmt = null;
	// ResultSet rs = null;
	
	try {
		// jdbcUrl
		conn = ConnectionProvider.getConnection();
		
		// 6. 결과데이터를 request의 속성에 저장 -> 데이터를 공유(전달)
		request.setAttribute("result", dao.getDeptList(conn));
	
	} catch(SQLException e) {
		e.printStackTrace();		
	} catch(Exception e) {
		e.printStackTrace();		
	} finally {
		JdbcUtil.close(conn);
	}
	
	
/* 	
	// 3. Statement객체 생성
	stmt = conn.createStatement();
	
	// sql 
	String sqlSelect = "select * from dept";
	
	
	// 4. ResultSet
	rs = stmt.executeQuery(sqlSelect);
	
	
	// 5. List<Dept> 생성 : 결과
	List<Dept> deptList = new ArrayList<Dept>();
	
	while(rs.next()) {
		// List 에 객체 추가
		deptList.add(new Dept(rs.getInt("deptno"),
							  rs.getString("dname"),
							  rs.getString("loc")));
	} // 객체 add메소드 끝
	
	out.println(deptList);
	// 중간 확인(출력)
*/

	
%>

    <!-- view의 역할만 수행하는 페이지로 이동 -->
    <jsp:forward page = "List_view.jsp"/>

    
    
    