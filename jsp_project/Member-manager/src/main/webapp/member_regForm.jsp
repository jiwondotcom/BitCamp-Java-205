<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel = "stylesheet" href = "<c:url value='/css/default.css'/>">
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

.display_none {
	display : none;
}

.color_blue {
	color : blue;
}

.color_red {
	color : red;
}

</style>

<script src = "http://code.jquery.com/jquery-1.12.4.min"></script>
<script>

	$(document).ready(function (){
		
		$('#userID').focusin(fucntion(){
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');
			
			$(this).val('');
		});
		
		$('#userID').focusout(funciton(){
			// ajax 비동기 통신 > ID를 서버로 보내고 사용 가능 유무의 응답 코드를 전달받는다. -> 화면에 메시지 출력
		
			$ajax ({
				url : 'idcheck.jsp',
				type : 'post',
				data : {
						mid : $(this).val()
				},
				beforeSend : function(){
					
				},
				success : function(){
					// data :  Y / N 형식으로
					if (data == 'Y') { // 사용 가능한 ID
						$('#msg').html('멋진 아이디네요!');
						$('#msg').addClass('color_blue');
					}
				}
			});
			
		});
	
	});

</script>

<body>

<%@ include file = "/WEB-INF/frame/header.jsp" %>
<%@ include file = "/WEB-INF/frame/nav.jsp" %>


<div class = "allWrap">
	<h2>회원 정보 등록</h2>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<form action = "regMember.jsp" method = "post" enctype = "multipart/form-data">
	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type = "text" name = "userID" required>
				<span id = "msg" class = "display_none"></span>
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "userPW" minlength = '4' required ></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name = "userName" required></td>
		</tr>
			<tr>
			<td>사진</td>
			<td><input type = "file" name = "photo" required></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "submit" value = "등록" id = "btn">
				<input type = "reset" value = "초기화" id = "btn">
				<input type = "button" value = "이전으로" onclick = "location.href = 'index.jsp';" id = "btn">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>