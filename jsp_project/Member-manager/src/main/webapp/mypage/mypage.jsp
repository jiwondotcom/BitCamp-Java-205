<%@page import="member.domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<%
	
	LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");

	if(loginInfo == null) {
		%>
		<script>
			alert('로그인이 필요한 페이지입니다. \n로그인 후 다시 이용해주세요.');
			location.href = '<%= request.getContextPath() %>/loginForm.jsp';
		</script>
		<%
	} else {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
</head>
<style>
	
	.allWrap {
		padding : 10px 20px;
	}
	
</style>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

<div class = "allWrap"> 

	<div>
		<h2>My Page</h2>
		<hr>
		<h3><c:out value = "${loginInfo}"/></h3>
		<%-- <%= loginInfo %> --%>
	</div>
</div>
</body>
</html>
	<% 
	}
%>