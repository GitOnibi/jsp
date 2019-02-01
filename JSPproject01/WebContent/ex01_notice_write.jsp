<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.jdbc.Notice" %>
<%
	Notice data = (Notice)request.getAttribute("data");
%>
<%=data.getNum() %>
<%=data.getWriter() %>
<%=data.getTitle() %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>