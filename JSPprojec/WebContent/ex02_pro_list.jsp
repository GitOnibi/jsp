<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="JSPprojec.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookie = request.getCookies();
	for(int i = 0; i < cookie.length; i++) {
		out.println( cookie[i].getName() + " : " );
		out.println( cookie[i].getValue() + "<br />" );
	}
%>
</body>
</html>