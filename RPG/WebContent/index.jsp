<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<div id="contents">
			<form action="member_login.do" method="POST">
				<label for="user_id">아이디</label>
				<input type="text" name="user_id" id="user_id" />
				<label for="user_pw">패스워드</label>
				<input type="text" name="user_pw" id="user_pw" />
				<input type="submit" value="로그인" class="btn_m"/><a href="member_join.jsp" class="btn_m">회원가입</a>
			</form>
		</div>
	</div>
</body>
</html>