<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="right_section">
	<!-- 로그인 박스 시작 -->
	<div>
		<form action="facebookLogin_result.jsp" method="post" class="loginbox">
			<input type=text id="id" placeholder="이메일 또는 전화번호" name="id"></input>
			<input type=password id="pw" placeholder="비밀번호" name="pw"></input> <input
				type=submit id="loginbtn" value="로그인" style='cursor: pointer'></input>
				<a href="#" class="forgetpw_text">비밀번호를 잊으셨나요?</a> <input
			type="button" id="joinbtn" value="새 계정 만들기" style='cursor: pointer'></input>
		</form>
		
	</div>
	<!-- 로그인 박스 끝 -->
	<div id="createpage">
		<p class="fontweight_400">
			유명인, 밴드, 비즈니스를 위한 <a href="#" class="fontweight_800"
				id="createpage_msg">페이지 만들기</a>
		</p>
	</div>
</div>