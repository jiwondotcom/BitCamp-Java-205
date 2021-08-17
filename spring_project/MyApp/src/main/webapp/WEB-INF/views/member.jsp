<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
<style>

	#memberlist {
		overflow: hidden;
	}
	
	div.card {
		float: left;
		width: 28%;
		padding: 10px;
		border: 1px solid #AAA;
		border-radius: 5px;
		margin: 5px;
	}
	
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

<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
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
				url : 'http://localhost:8080/op/member/idCheck',
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

		
	$('#submit').click(function(){
			
			var photoFile = $('#photo');
			var file1 = photoFile[0].files[0];
			//console.log(file1);
			var formData = new FormData();
			formData.append("memberid", $('#memberid').val());
			formData.append("password", $('#password').val());
			formData.append("membername", $('#membername').val());
			formData.append("photo", file1);
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
					if(data == 1){
						alert('회원가입이 되었습니다.');
					}
				}
			});
			
			
			
		});
			
			
			
			
		});
		
		
		memberList();
		
	});

	
	function memberList() {
		
		$.ajax({
			url : 'http://localhost:8080/op/members',
			type : 'GET',
			success : function(data) {
				// console.log(data);
				$.each(data, function(index, item){
					console.log(index, item);
					
					var html = '<div class = "card">';
					html += "index : " + item.index + "<br>";
					html += "아이디 : " + item.userID + "<br>";
					html += "이름 : " + item.userName + "<br>";
					html += "사진 : " + item.userPhoto + "<br>";
					html += "등록일 : " + item.regDate + "<br>";
					html += "</div>"
					
					$('#memberlist').append(html);
					
				});
			}
			
			
		});
		
		
	}

</script>
</head>
<body>

	<div id="menu">
		<span id = "regBtn">회원가입</span>
	</div>

	<div>
		<h1>회원가입</h1>
		<hr>
		
		<table>
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "userID" id = "userID" required>
					<span id = "msg" class = "display_none"></span>
					<img id = "loadingImg" class = "display_none" alt = "loading"
					src = "http://localhost:8080/op//images/loading.gif"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="userPW" minlength='4' required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName" required></td>
			</tr>
			<tr>
				<td>사진</td>
				<td><input type="file" name="userPhoto"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="등록" id="submit"> <input
					type="reset" value="초기화" id="btn"> <input type="button"
					value="이전으로" id="btn"></td>
			</tr>
		</table>

	</div>
	

	<h1>회원 리스트</h1>
	<hr>
	<div id="memberlist"></div>




</body>
</html>