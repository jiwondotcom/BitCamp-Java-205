<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 1. 사용자가 입력한 데이터를 받은 후
	// 2. DB 처리 : 새로운 데이터 edit(수정)
	// 3. member_list.jsp 페이지로 이동
	
	
	// 0. 사용자가 입력한 데이터의 한글 처리 (우선)
	request.setCharacterEncoding("UTF-8");

	
	// 1. 사용자가 입력한 데이터를 받는다.
	// 비밀번호, 이름
	String userPW = request.getParameter("userpw");
	String userName = request.getParameter("username");
	


%>