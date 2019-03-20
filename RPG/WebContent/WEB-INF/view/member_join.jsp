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
			<form action="member_join.do" method="POST">
				<label for="user_id">아이디</label>
				<input type="text" name="user_id" /><a href="member_check.do">중복체크</a><br />
				<label for="user_pw">패스워드</label>
				<input type="password" name="user_pw" /><br />
				<label for="user_pw_cnf">패스워드확인</label>
				<input type="password" name="user_pw_cnf" /><br /><br />
				<label for="user_email">이메일</label>
				<input type="text" name="user_email" /><br /><br />
				<input type="submit" value="가입하기"/><a href="member_login.do">돌아가기</a>
			</form>
		</div>
	</div>
</body>
</html>