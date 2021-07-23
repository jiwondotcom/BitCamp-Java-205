<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setAttribute("name", "짱구");
    	session.setAttribute("name", "짱아");
    	application.setAttribute("name", "지원");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<script>
</script>
<body>

	표현식 : <%= request.getAttribute("name") %> <br>
	표현언어1 : ${requestScope.name}
	
	<br><br>
	내장객체의 표현식이 생략되었을 때의 규칙 <br>
	1. pageScope ->
	2. requestScope ->
	3. sessionScope ->
	4.applicationScope
	의 속성을 순서대로 찾는다.
	<br><br>
	
	표현언어2 : ${name} <br>
	표현언어3 : ${sessionScope.name} <br>
	표현언어4 : ${applicationScope.name} <br>
	
	<hr>
	param.code : <%= request.getParameter("code") %> <br>
	param.code : ${param.code} <br>
	
	<hr>
	(표현식 표현) pageContext : 
	<%= pageContext.getRequest().getServletContext().getContextPath() %>
	<br>
	${pageContext.request.requestURL} <br>
	${pageContext.request.requestURI} <br>
	${pageContext.request.contextPath} <br>
	<%= request.getContextPath() %> <br>
	
	<br>
	${true} / ${false} / ${100}	/ ${'황짱구'} / ${null}${'null'}
	<!-- (null이 들어왔을땐 아무것도 출력하지 않는다.) -->
	
	
	
	
	
</body>
</html>