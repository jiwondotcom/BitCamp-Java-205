<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BlogExmaple</title>
    
    <!-- css파일 불러오기 / 절대경로 사용 -->
    <!-- http://localhost:8080/First-Web/blogPage/css/blogPage.css -->
    <link rel="stylesheet" href="/First-Web/blogPage/css/blogPage.css">
    <!-- 외부 웹 폰트 불러오기 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@500&display=swap">
</head>
<body>
    <!-- 전체 -->
    <!-- 페이지 영역 부분 & 전체 페이지 Border 처리 -->
    <div id = "all_wrap">

    <!-- 헤더 시작-->
	<%@ include file="blogPage_include/header.jsp" %>
    <!-- 헤더 끝 -->

    <!-- 네비게이션 시작 -->
	<%@ include file="blogPage_include/nav.jsp" %>
    <!-- 네비게이션 끝 -->


    <!-- 컨텐츠 영역 전체 div -->
    <div id = "contents" class = "div_align_center">
        <!-- 섹션의 시작 -->
		<%@ include file="blogPage_include/section.jsp" %>
        <!-- 섹션의 끝 -->

        <!-- aside : 사이드 바 시작 -->
		<%@ include file="blogPage_include/aside.jsp" %>
        <!-- aside : 사이드 바 끝 -->
    </div>
    <!-- 컨텐츠영역 div 끝 -->


    <!-- footer 시작 -->
		<%@ include file="blogPage_include/footer.jsp" %>
    <!-- footer 끝 -->
</div>
</body>
</html>