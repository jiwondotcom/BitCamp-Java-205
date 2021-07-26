<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	session.setAttribute("userName", request.getParameter("userID"));
	response.sendRedirect("/member/mypage/myPage.jsp");


%>
