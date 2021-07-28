<%@page import="service.MemberRegService"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="member.util.ConnectionProvider"%>
<%@page import="member.domain.Member"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	int result = MemberRegService.getInstance().regMember(request);
	// request.setAttribute("result", result);
%>

<jsp:forward page = "reg_view.jsp"/>