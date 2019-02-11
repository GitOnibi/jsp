<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${ sessionScope.id != null }">
			<p>${ sessionScope.id } 님 반갑습니다.</p>
			<a href="Login_logout.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			${ str }
			<form action="Login_check.do" method="POST">
				<input type="hidden" name="cmd" value="login"/>
				아이디 : <input type="text" name="id"/><br />
				패스워드 : <input type="text" name="pw"/>
				<input type="submit" value="로그인"/>
			</form>
			<a href="signIn.jsp">회원가입</a>
		</c:otherwise>
	</c:choose>
</body>
</html>