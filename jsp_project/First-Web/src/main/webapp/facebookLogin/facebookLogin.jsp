<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Facebook - 로그인 또는 가입</title>
    <link rel="stylesheet" href="css/facebookLogin_Page.css">
    </head>
    
    <body>
        <!-- 전체 wrap 영억 시작-->
        <div class="all_wrap">
            <!-- 메인페이지 영역 -->
            <div class="main">
        
                <!-- 좌측 섹션 (로고) -->
                <%@ include file="include/left_section.jsp" %>
                <!-- 좌측 섹션 끝 -->
        
        
                <!-- 우측 섹션(로그인) -->
                <%@ include file="include/right_section.jsp" %>
                <!-- 우측 섹션(로그인) 끝 -->
        
            </div>
            <!-- 메인페이지 영역 끝 -->
        
        
        
            <!-- 푸터 시작 -->
			<%@ include file="include/footer.jsp" %>
            <!-- 푸터 영역 끝 -->
        </div>
        <!-- 전체 wrap 영역의 끝 -->
    </body>
</html>