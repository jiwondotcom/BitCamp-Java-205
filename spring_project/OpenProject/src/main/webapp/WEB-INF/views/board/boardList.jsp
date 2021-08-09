<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    

<c:if test = "${loginInfo eq null}"> 
<!-- 로그인 정보가 없을 때 -->
	<script>
		alert('로그인 후 사용이 가능합니다.');
		location.href = '../member/login';
	</script>
</c:if>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Open Project</title>

<%@ include file = "/WEB-INF/views/frame/metaheader.jsp" %>

</head>
<body>
<%@ include file = "/WEB-INF/views/frame/header.jsp" %>
<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>

	<div id = "content">
		<h1>Content : 게시판 리스트</h1>
		<h2>${loginInfo}</h2>
	</div>


</body>
</html>