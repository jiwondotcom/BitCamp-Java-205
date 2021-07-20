<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	// dept_list.jsp -> 요청을 받고 처리

	// 1. 드라이버 로드
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	// 2. DB 연결
	Connection
	// 3. Statement객체 생성
	// 4. ResultSet
	// 5. List<Dept> 생성 : 결과
	// 6. 결과데이터를 request의 속성에 저장 -> 데이터를 공유(전달)

%>

    <jsp:forward page = "List_view.jsp"/>
