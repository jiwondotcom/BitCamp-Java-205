<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<%
		/* 형변환 해주어야 한다. */
		String userName = (String)session.getAttribute("userName");
	
		if(userName == null) {
			out.println("로그인 상태 아님!");
		}
	%>
	
	<h1>세션의 속성에 저장된 userName : <%= session.getAttribute("userName") %></h1>
	<h3><a href = "Logout.jsp">로그아웃</a></h3>
</body>
</html>