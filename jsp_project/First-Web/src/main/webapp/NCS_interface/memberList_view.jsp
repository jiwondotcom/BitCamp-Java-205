<%@page import="member.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   	<% 
   		List<Member> list = (List<Member>) request.getAttribute("result");
   	%>
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<style>

	td, th {
	text-align : center;
	padding : 5px 10px;
	}

	button {
	margin-bottom : 15px;
	}

</style>
<script>
</script>
<body>


	<h1>회원 리스트</h1>
	<hr>
	
	<button onclick = "location.href = 'member_regForm.jsp';">회원 등록</button>
	
	<table border = 1>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>회원 이름</th>
			<th>가입 날짜</th>
			<th>관리</th>
			<!-- <th> : 표의 라벨링 기능 -->
		</tr>
	
<%
	if (list != null) {
		for(int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td><%= list.get(i).getUserID() %></td>
				<td><%= list.get(i).getUserPW() %></td>
				<td><%= list.get(i).getUserName() %></td>
				<td><%= list.get(i).getRegDate() %></td>
				<td>
					<a href = "#">수정</a> |
					<a href = "#">삭제</a>
				</td>
			</tr>
			<% /* 자바스크립트 함수 호출 끝  */
			
		}
	}

%>
	</table>
	
</body>
<script>
/*
 * 삭제 스크립트 추후 추가예정
 */
</script>
</html>