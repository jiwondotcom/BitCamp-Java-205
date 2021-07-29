<%@page import="service.IdCheckService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page trimDirectiveWhitespaces="true" %>

<%
	String userID = request.getParameter("mid");
	request.setAttribute("result", IdCheckService.getInstance().idCheck(userID));
%>

${result}
