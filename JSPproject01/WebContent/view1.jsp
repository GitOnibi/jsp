<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	int[] arr = new int[10];	
	arr = (int[])request.getAttribute("ranArray");
	
	for(int i = 0; i < 10; i++) {
		out.println(arr[i] + "<br />");
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>