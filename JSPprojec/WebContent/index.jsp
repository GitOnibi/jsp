<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%--
<%@ page session="true" buffer autoflush="true" errorPage="./404.jsp"%>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="" />
</head>
<body>
	<form action="sub1.jsp" method="get">
		id : <input type="text" id="id" name="id" /><br />
		pw : <input type="text" id="pw" name="pw" /><br />
		email : <input type="text" id="email" name="email" /><br />
		addr : <input type="text" id="addr" name="addr" /><br />
		
		<input type="checkbox" name="ck" value="1" />
		<input type="checkbox" name="ck" value="2" />
		<input type="checkbox" name="ck" value="3" />
		<input type="checkbox" name="ck" value="4" />
		<input type="submit" value="submit"/>
	</form>
</body>
</html>