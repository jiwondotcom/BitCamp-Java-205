<%@page import="java.util.List"%>
<%@page import="member.domain.Member"%>
<%@page import="member.domain.LoginInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">

<c:if test="${result eq null}">
	<script>
		alert('로그인이 필요한 페이지입니다. \n로그인 후 다시 이용해주세요.');
		location.href = "loginForm.do";
	</script>
</c:if>

</head>
<style>
	
.allWrap {
		padding : 10px 20px;
}
	
#btn {
	margin-top : 8px;
	margin-right : 5px;
	padding : 5px;
}
	
.table {
	border : 1px solid #AAA;
	width : 300px;
}
	
</style>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

<div class = "allWrap"> 

		<h2>My Page</h2>
		<hr>

			<table class = "table" border = "1">
				<tr>
					<th>프로필 이미지</th>
					<td>
						<img src = "<c:url value = "/upload/${result.userPhoto}"/>" style = "height: 100px">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${result.userName}</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td>${result.userID}</td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td>${result.regDate}</td>
				</tr>
				</table>
					
				<%-- <button onclick = "location.href = 'member_editForm.jsp?index=${loginInfo.index}';" id = "btn">내정보 수정</button>
				<input type = "button" onclick = "javascript:delMember('${loginInfo.index}');" id = "btn" value = "회원 탈퇴"> --%>
				
				<button onclick = "editForm.do?mid=${result.userID}" id = "btn">내정보 수정</button>
				<input type = "button" onclick = "javascript:delMember('${loginInfo.index}');" id = "btn" value = "회원 탈퇴">

</div>
</body>
<script>

	function delMember(index) {
		if (confirm ('정말 탈퇴하시겠습니까?')) {
			location.href = 'deleteMember.do';
	}
}

</script>
</html>