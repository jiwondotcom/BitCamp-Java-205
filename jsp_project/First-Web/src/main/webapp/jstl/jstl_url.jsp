<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
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
	
	<h3>
	
		<c:url value = "/index.jsp" var = "urlIndex"/>
		${urlIndex}
		
		<br>
		<c:url value = "index.jsp"/><br>
		
		<!-- 절대경로로 이동 -->
		<a href = "<c:url value = "/index.jsp"/>">홈으로 가기</a>
		
		<br>
		<br>
		
		<!-- url뒤에 type & index 추가 -->
		<!-- index.jsp?type=main&index=1 -->
		<c:url value = "/index.jsp" var = "homeUrl">
			<!-- 꺽쇠 안에 / => 마감태그없이 단일태그로 사용 가능 -->
			<!-- /c:param : 생략 가능 -->
			<c:param name = "type" value = "main"/>main
			<c:param name = "index">1</c:param>
		</c:url>

		<a href = "${homeUrl}">${homeUrl}</a>
	
	</h3>

</body>
</html>