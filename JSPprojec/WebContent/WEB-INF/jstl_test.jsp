<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="JSPprojec.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!-- core, xml , fmt, sql, functions -->
<%
	Product list = new Product();
	list.setProName("abcd");
%>
<c:set target="<%=list %>" property="proName" value="abcd" />
<c:set var="li" value="<%=list %>" />
<c:set target="${li}" property="proNum" value="123" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${li.proNum}
	<%=list.getProName() %>
	<c:set var="age" value="32" />
	${age}
</body>
</html>