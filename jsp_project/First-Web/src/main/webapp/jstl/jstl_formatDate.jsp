<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	request 방식 : 
<%
	/* 현재 시간을 가져온다. */
	request.setAttribute("now", new java.util.Date());
%>

	<hr>

	default : ${now} <br>

<!-- 전체 timeZone 설정 -> fmt:timeZone 으로 감싸준다. -->	
<%-- <fmt:timeZone value = "HongKong"> --%>
	<h3> 날짜 포맷팅 </h3>
	<fmt:formatDate value = "${now}"/> <br>
	<fmt:formatDate value = "${now}" type = "date"/> <br>
	<!-- 0000년 0월 00일 금요일 -->
	<fmt:formatDate value = "${now}" type = "date" dateStyle = "full"/> <br>
	<!-- 00.00.00. -->
	<fmt:formatDate value = "${now}" type = "date" dateStyle = "short"/> <br>


	<h3>시간 포맷팅</h3>
	<fmt:formatDate value = "${now}" type = "time"/> <br>
	<!-- 오후/오전 00시 00분 00초 (국가명) 표준시 -->
	<fmt:formatDate value = "${now}" type = "time" timeStyle = "full"/> <br>
	<!-- 오전/오후 00:00 -->
	<fmt:formatDate value = "${now}" type = "time" timeStyle = "short"/> <br>


	<h3>both</h3>
	<fmt:formatDate value = "${now}" type = "both"/> <br>
	<fmt:formatDate value = "${now}" type = "both" dateStyle = "short" timeStyle = "short"/> <br>
	<fmt:formatDate value = "${now}" type = "both" dateStyle = "full" timeStyle = "full"/> <br>
	
	
	<h3>패턴</h3>
	<!-- z : 타임존(TimeZone) -->
	<!-- a : 오전 / 오후 -->
	<fmt:formatDate value = "${now}" pattern = "z a h:mm"/> <br>
	<fmt:formatDate value = "${now}" pattern = "hh:mm:ss"/> <br>
	<fmt:formatDate value = "${now}" pattern = "yyyy-MM-dd a h:mm"/> <br>
	<!-- DB, MySQL 등 형식 -->
	<fmt:formatDate value = "${now}" pattern = "yyyy.MM.dd. h:mm"/> <br>
	<fmt:formatDate value = "${now}" pattern = "yyyy.MM.dd. h:mm" timeZone = "HongKong"/> <br>
<%-- </fmt:timeZone> --%>
	
	
	
	
</body>
</html>