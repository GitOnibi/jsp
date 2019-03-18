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
			<p>가입이 정상적으로 완료되었습니다. 다시 로그인 해 주세요!</p>
			<a href="goto_login.do">로그인</a><br />
		</div>
	</div>
</body>
</html>