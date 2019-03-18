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
				<input type="text" name="id" id="id" />
				<label for="user_pw">패스워드</label>
				<input type="text" name="pw" id="pw" />
				<input type="submit" value="로그인"/><a href="goto_join.do">회원가입</a>
			</form>
		</div>
	</div>
</body>
</html>