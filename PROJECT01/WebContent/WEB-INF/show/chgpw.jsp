<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="changePw.do" method="POST">
		기존 패스워드 : <input type="text" name="pw"/>
		<c:if test="${err.pw}">패스워드를 입력하세요</c:if>
		<c:if test="${err.notmacth}">암호가 일치하지 않습니다</c:if>
		<br />
		변경할 패스워드 : <input type="text" name="npw"/>
		<c:if test="${err.npw}">변경할 패스워드를 입력하세요</c:if>
		<br />
		<input type="submit" value="변경하기"/>
	</form>
</body>
</html>