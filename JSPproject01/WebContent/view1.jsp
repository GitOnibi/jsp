<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
	int[] arr = new int[10];	
	arr = (int[])request.getAttribute("ranArray");
	
	int cnt = (int)request.getAttribute("cnt");
	
	for(int i = 0; i < 10; i++) {
		out.println(arr[i] + "<br />");
	}
	out.println("cnt : " + cnt);
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