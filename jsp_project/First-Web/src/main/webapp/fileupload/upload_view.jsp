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

	<h1>파일 업로드</h1>
	
	<h3>
		<c:if test="${title ne null}">
			Title : ${title} <br>
		</c:if>
	</h3>
	
	<c:if test="${photo ne null}">
		<img src = "<c:url value = "/upload/${photo}"/>">
	</c:if>

</body>
</html>