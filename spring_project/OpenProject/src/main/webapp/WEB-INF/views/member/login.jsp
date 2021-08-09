<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   

<!-- 로그인 정보가 존재하지 않을 경우 (null일 경우) -->
<%-- <c:if test = "${loginInfo eq null}"> --%>
<c:if test = "${not loginChk}"> 
	<script>
		alert("아이디 또는 비밀번호가 일치하지 않습니다.")
		history.go(-1); /* 바로 전단계로 돌아간다 */
	</script>
</c:if>

   
<c:if test = "${loginChk}"> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>로그인 페이지</title>

<%@ include file = "/WEB-INF/views/frame/metaheader.jsp" %>

<link rel = "stylesheet" href = "/op/css/default.css">
<script src = "https://code.jquery.com/jquery-1.12.4.min.js"></script>

</head>
<body>

<%@ include file = "/WEB-INF/views/frame/header.jsp" %>
<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>

	<div id="content">
		<h2>Login</h2>
		<hr>
		<h2>
			${loginInfo}
		</h2>
	</div>


</body>
</html>

</c:if>