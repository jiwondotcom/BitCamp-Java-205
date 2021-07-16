<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%

	// 사용자가 전달한 데이터의 한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	request.setAttribute("id", id);
	request.setAttribute("pw", pw);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Facebook에 로그인하신 것을 환영합니다!</title>
<link rel="stylesheet" href="css/facebookLogin_result.css">
</head>
<body>
	<div class = "all_wrap">
	<h1>Facebook에 로그인하신 것을 환영합니다!</h1>
	<hr>
	<!-- 데이터를 처리할 위치로 전송 : input 요소에 *** name 속성 *** 을 반드시 정의해주어야 한다! -->
		<table border = "1">
			<tr>
				<td>아이디</td>
				<td><%= id %></td>
			</tr>
			
			<tr>
				<td>패스워드</td>
				<td>
				<%= pw %>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<jsp:include page="facebookLogin_view.jsp"/>
				</td>
			</tr>
		</table>
		</div>
</body>
</html>