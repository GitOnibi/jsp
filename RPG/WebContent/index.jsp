<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user	= (User)session.getAttribute("user");
	String id	= (String)user.getId();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
		
		</header>
		<div id="contents">
			<c:choose>
				<c:when test="${ id != null }">
					${ id } 님 반갑습니다.
					<a href="">게임시작</a>
					<a href="">로그아웃</a>
				</c:when>
				<c:otherwise>
					<form action="login.do">
						아이디 : <input type="text" name="id"/>
						패스워드 : <input type="text" name="pw"/>
						<input type="submit" value="로그인"/><input type="button" value="회원가입"/>
					</form>
				</c:otherwise>
			</c:choose>
		</div>
		<div id="footer">
		
		</div>
	</div>
</body>
</html>