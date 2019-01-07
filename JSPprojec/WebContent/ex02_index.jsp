<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="JSPprojec.Product" %>
<%
	Product pro = new Product();
	if( (Product)request.getAttribute("pro") != null ) {
		pro = (Product)request.getAttribute("pro");
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./ex02_pro_reg.jsp">제품등록</a><br />
	<a href="./ex02_pro_list.jsp">제품목록</a>
</body>
</html>