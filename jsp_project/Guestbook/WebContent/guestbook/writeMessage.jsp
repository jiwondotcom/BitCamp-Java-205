<%@page import="guest.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Encoding 필터 처리 예정 -->
<% 
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id = "messageRequest" class = "guest.domain.MessageRequest"/>
<jsp:setProperty property = "*" name = "messageRequest"/>

<%

	int result = WriteMessageService.getInstance().writeMessage(messageRequest);

	request.setAttribute("result", result);

%>

<jsp:forward page = "write_view.jsp"/>