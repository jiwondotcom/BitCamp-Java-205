<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 로그인</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="content">
		<h2>회원 리스트</h2>
		<hr>

		<table class="border">
			<tr>
				<th>INDEX</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>사진</th>
				<th>가입일</th>
				<th>관리</th>
			</tr>
			
			<c:forEach items="${memberList}" var="member" >
			<tr>
				<td>${member.index}</td>
				<td>${member.userID}</td>
				<td>${member.userPW}</td>
				<td>${member.userName}</td>
				<td>${member.userPhoto}</td>
				<td><fmt:formatDate value="${member.date}" type="both"/></td>
				<td>
					<a class="border" href="edit?idx=${member.index}">수정</a> 
					<a class="border" href="delete?idx=${member.index}">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>

	</div>


</body>
</html>