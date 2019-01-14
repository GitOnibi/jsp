<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	String name		= request.getParameter("name");
	String value	= request.getParameter("value");
	
	if(name != null && value != null) {
		application.setAttribute(name, value);
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(name != null && value != null) {
%>
application 기본속성 : <%=name %> = <%=value %>
<%
	} else {
%>
application 기본속성 : 설정 안함
<%
	}
%>
</body>
</html>