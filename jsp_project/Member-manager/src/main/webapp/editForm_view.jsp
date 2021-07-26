<%@page import="member.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
    <%
    	// object 형변환
    	Member member = (Member)request.getAttribute("index");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 : 내정보 수정</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
</head>
<style>

	.allWrap {
		padding : 10px 20px;
	}
	
</style>
<script type="text/javascript">
window.onload = function() {
	today = new Date();
	console.log("today.toISOString() >>>" + today.toISOString());
	today = today.toISOString().slice(0, 10);
	console.log("today >>>> " + today);
	bir = document.getElementById("today");
	bir.value = today;
}
</script>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

<div class = "allWrap">
	<h2>회원 정보 수정</h2>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<!-- readonly : 읽기 전용 (수정 불가) -->
	<form action = "editMember.jsp" method = "post">
	<table>
		<tr>
			<td>회원번호</td>
			<td><input type="number" name="index" value = "<%= member.getIndex() %>" readonly></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userID" value = "<%= member.getUserID() %>" ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="userPW" value = "<%= member.getUserPW() %>" minlength = '4'></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="userName" value = "<%= member.getUserName() %>"></td>
		</tr>


		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "수정">
				<input type = "reset" value = "초기화">
				<input type = "button" value = "이전으로" onclick = "location.href='mypage.jsp';">
			</td>
		</tr>
		
	</table>
		
		
	</form>

</div>
</body>
</html>