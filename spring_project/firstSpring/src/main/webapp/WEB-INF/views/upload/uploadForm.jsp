<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>파일 업로드 : report 제출</h1>
	<hr>
	
	<h3>@RequestParam 이용한 파일 업로드</h3>
	
	<form action="upload1"
		  method = "post"
		  enctype = "multipart/form-data">
	
	학번1 : <input type = "text" name = "sno"> <br>
	이름1 : <input type = "text" name = "sname"> <br>
	파일1 : <input type = "file" name = "report"> <br>
	<input type = "submit" value = "제출">
	
	</form>
	
	<hr>

	<h3>MultipartHttpServletRequest 이용한 파일 업로드</h3>
	
	<form action="upload2"
		  method = "post"
		  enctype = "multipart/form-data">
	
	학번2 : <input type = "text" name = "sno"> <br>
	이름2 : <input type = "text" name = "sname"> <br>
	파일2 : <input type = "file" name = "report"> <br>
	<input type = "submit" value = "제출">
	
	</form>
	
	<hr>
	
	<h3>Command 객체를 이용한 파일 업로드</h3>
	
	<form action="upload3"
		  method = "post"
		  enctype = "multipart/form-data">
	
	학번3 : <input type = "text" name = "sno"> <br>
	이름3 : <input type = "text" name = "sname"> <br>
	파일3 : <input type = "file" name = "report"> <br>
	<input type = "submit" value = "제출">
	
	</form>
	
	

</body>
</html>