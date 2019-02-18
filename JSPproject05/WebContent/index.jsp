<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null) {
		out.println(msg);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Login_CTL" method="GET">
		<input type="hidden" name="cmd" value="login"/>
		id : <input type="text" name="id"/><br />
		pw : <input type="text" name="pw"/>
		<input type="submit" value="로그인"/>
	</form>
	<a href="signin.jsp">회원가입</a>
</body>
</html>