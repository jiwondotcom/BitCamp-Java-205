<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isErrorPage = "true" %>

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

	<h1>NullPointerException 에러가 발생하였습니다.<br>
	 	메인페이지로 이동해주세요. </h1>
	<h3>
		<%= exception.getMessage() %> <br>
		<%= exception.getClass().getName().equals("java.lang.ArithmeticException") %>
	</h3>

<%--
	<p>
		<% exception.printStackTrace();
	</p>
--%>
	
</body>
</html>