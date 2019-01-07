<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="lotto.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int number = 1000;
%>
<jsp:include page="login.jsp" flush="false">
	<jsp:param name="name11" value="1111" />
	<jsp:param name="name22" value="<%=number %>" />
</jsp:include>

<jsp:forward page="forward.jsp" >
	<jsp:param name="nn" value="11" />
</jsp:forward>
</body>
</html>