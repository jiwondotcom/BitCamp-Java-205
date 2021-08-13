<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>로그인 페이지</title>

<%@ include file = "/WEB-INF/views/frame/metaheader.jsp" %>

</head>
<body>

<%@ include file = "/WEB-INF/views/frame/header.jsp" %>
<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>

	<div id="content">
		<h2>Login</h2>
		<hr>

		<form method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userID"
						value="${cookie.reID.value}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="userPW"></td>
				</tr>
				<tr>
					<th></th>
					<td>
						
						<input type="checkbox" name="reID" value="on"
						${cookie.reID.value ne null ? 'checked':''}> 아이디 기억하기
						
						<input type = "hidden" name = "redirectUri" value = "${redirectUri ne null ? redirectUri : ''}">
							
					</td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" id="btn" value="로그인"> <input
						type="button" id="btn" value="이전으로"
						onclick="location.href='index.do';"></td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>