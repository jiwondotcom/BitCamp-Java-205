<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project : 회원가입</title>

<%@ include file = "/WEB-INF/views/frame/metaheader.jsp" %>

<style>

#lodingImg {
	height: 25px;
}

.display_none {
	display: none;
}

.color_blue {
	color: blue;
}

.color_red {
	color: red;
}
</style>


<script>
	
	$(document).ready(function() {

		$('#userID').focusin(function() {
			$('#msg').addClass('display_none');
			$('#msg').removeClass('color_blue');
			$('#msg').removeClass('color_red');

			$(this).val('');
		});

		$('#userID').focusout(function() {
			// ajax 비동기 통신 > id를 서버로 보내고 사용 가능 유무의 응답 코드를 받는다 -> 화면에 메시지 출력

			    
			$.ajax({
				url : '<c:url value = "/member/idCheck"/>',
				type : 'post',
				data : {
					mid : $(this).val()
				},
				beforeSend : function() {
					$('#loadingImg').removeClass('display_none');
				},
				success : function(data) {
					// data : Y / N
					if (data == 'Y') {
						$('#msg').html('멋진 아이디네요!');
						$('#msg').addClass('color_blue');
						$('#msg').removeClass('display_none');
					} else {
						$('#msg').html('이미 사용하고 있는 아이디입니다.');
						$('#msg').addClass('color_red');
						$('#msg').removeClass('display_none');
					}
				},
				error : function(request, status, error) {
					alert('서버 통신에 문제가 발생했습니다. \n다시 실행해주세요.');
					console.log(request);
					console.log(status);
					console.log(error);
				},
				complete : function() {
					$('#loadingImg').addClass('display_none');
				}
			});

		});

	});
</script>

</head>
<body>

<%@ include file = "/WEB-INF/views/frame/header.jsp" %>
<%@ include file = "/WEB-INF/views/frame/nav.jsp" %>

<div id = "content">
	<h2>회원가입</h2>
	<hr>
	
	<!-- 그리드 맞추는 용도의 테이블 생성 -->
	<!-- required : 필수 입력 (공백 불가) -->
	<form method = "post" enctype = "multipart/form-data"> 

	<table>
		<tr>
			<td>아이디</td>
			<td>
				<input type = "text" name = "userID" id = "userID" required>
				<span id = "msg" class = "display_none"></span>
				<img id = "loadingImg" class = "display_none" alt = "loading" src = "<c:url value = "/images/loading.gif"/>">
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
			<td><input type = "file" name = "userPhoto"></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type = "reset" value = "초기화" id = "btn">
			</td>
		</tr>
	</table>
	</form>
	
	<div>
		ajax로 회원 가입 
		<input type="button" value="회원가입" id="btnReg1">
	</div>
	<div>
		ajax로 Json 전송 회원 가입
		<input type="button" value="회원가입" id="btnReg2">
	</div>

	
</div>


<script>
		$(document).ready(function() {
			$('#btnReg1').click(function() {
				var photoFile = $('#userPhoto');
				var file1 = photoFile[0].files[0];
				//console.log(file1);
				var formData = new FormData();
				formData.append("userID", $('#userID').val());
				formData.append("userPW", $('#userPW').val());
				formData.append("userName", $('#userName').val());
				formData.append("userPhoto", file1);
				console.log(formData);
				$.ajax({
					url : '/op/members/reg1',
					type : 'post',
					data : formData,
					enctype : 'multipart/form-data',
					processData : false,
					contentType : false,
					cache : false,
					success : function(data) {
						console.log(data);
						if(data==1){
							alert('회원가입이 되었습니다.');
						}
					}
				});
			});
			
			
			$('#btnReg2').click(function() {
				var userid = $('#userID').val();
				var pw = $('#userPW').val();
				var username = $('#userName').val();
				var member = {
						userID: userID,
						userPW: userPw,
						userName: userName
				}
				
				console.log(JSON.stringify(member));
				
				$.ajax({
					url : '/op/members/reg2',
					type : 'post',
					data : JSON.stringify(member),
					dataType : 'json',
					contentType : 'application/json',
					success : function(data) {
						console.log(data);
						if(data==1){
							alert('회원가입이 되었습니다.');
						}
					}
				});
			});
		});
	</script>


</body>
</html>