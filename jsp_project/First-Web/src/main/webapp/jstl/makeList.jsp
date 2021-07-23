<%@page import="member.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <% 
    List<Member> members = new ArrayList<Member>();
    members.add(new Member("jiwon1", "11111", "지원1"));
    members.add(new Member("jiwon2", "11112", null));
    members.add(new Member("jiwon3", "12343", "지원3"));
    members.add(new Member("jiwon4", "12344", "지원4"));
    members.add(new Member("jiwon5", "12345", null));
    members.add(new Member("jiwon6", "12346", null));
    members.add(new Member("jiwon7", "12347", "지원7"));
    members.add(new Member("jiwon8", "12348", null));
    members.add(new Member("jiwon9", "12349", "지원9"));
    members.add(new Member("jiwon0", "12340", "지원0"));
    %>
    
    
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

</body>
</html>