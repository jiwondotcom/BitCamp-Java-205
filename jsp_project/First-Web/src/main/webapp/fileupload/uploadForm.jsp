<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
</style>
<script>
</script>
<body>

	<h1>파일 업로드</h1>
	
	<!-- 
	필수1 : Form tag 속성 method = "post" 여야 한다.
	필수2 : Form tag 속성 enctype = "multipart/form-data" 여야 한다.
	필수3 : input type = "file" 있어야 한다.
	 -->
	
	<form action = "upload.jsp" method = "post" enctype = "multipart/form-data">
	
		제목 <input type = "text" name = "title"> <br>
		제목2 <input type = "text" name = "title2"> <br>
		파일1 <input type = "file" name = "photo"> <br>
		파일2 <input type = "file" name = "file"> <br>
		<input type = "submit">
	
	</form>
	
	
</body>
</html>