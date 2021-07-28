<%@page import="member.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
   	<% 
   		List<Member> list = (List<Member>) request.getAttribute("result");
   	%>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
</head>
<style>

	.allWrap {
		padding : 10px 20px;
	}
	
	td, th {
		text-align : center;
		padding : 5px 10px;
	}

	button {
		margin-bottom : 15px;
	}

</style>
<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>

<div class = "allWrap">
	<h2>회원 리스트</h2>
	<hr>
	
	<!-- <button onclick = "location.href = 'member_regForm.jsp';">회원 등록</button> -->
	
	<table border = 1>
		<tr>
			<th>회원번호</th>
			<th>프로필사진</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>회원 이름</th>
			<th>가입 날짜</th>
			<!-- <th>관리</th> -->
			<!-- <th> : 표의 라벨링 기능 -->
		</tr>
	


	<c:if test = "${mList != null}">
		<c:forEach items = "${mList}" var = "member">
			<tr>
				<td>${member.index}</td>
				<td><img src = "<c:url value = "/upload/${member.userPhoto}"/>" height="40"></td>
				<td>${member.userID}</td>
				<td>${member.userPW}</td>
				<td>${member.userName}</td>
				<td>${member.regDate}</td>
			<%-- <td>
					<a href = "member_editForm.jsp?index=${member.index}">수정</a> |
					<a href = "javascript:delMember('${member.index}')">삭제</a>
				 </td> --%>
			</tr>		
		</c:forEach>
	</c:if>
	
	</table>	
</div>	
	
<%--
	<%
	if (list != null) {
		for(int i = 0; i < list.size(); i++) {
			%>
			
			<tr>
				<td><%= list.get(i).getIndex() %></td>
				<td><%= list.get(i).getUserID() %></td>
				<td><%= list.get(i).getUserPW() %></td>
				<td><%= list.get(i).getUserName() %></td>
				<td><%= list.get(i).getRegDate() %></td>
				<td>
					<a href = "member_editForm.jsp?index=<%=list.get(i).getIndex()%>">수정</a> |
					<a href = "javascript:delMember(<%=list.get(i).getIndex()%>)">삭제</a>
					<!-- 자바스크립트 함수 호출 -->
				</td>
			</tr>
			
	<%  
			
		}
	}

%>
--%>
	
</body>
<script>

	function delMember(index) {
		if (confirm ('정말 삭제하시겠습니까?')) {
			location.href = 'member_deleteForm.jsp?index=' + index;
		}
	}
	
</script>
</html>
