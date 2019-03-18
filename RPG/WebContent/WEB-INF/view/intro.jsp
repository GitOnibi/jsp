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
			<p>${sessionScope.id} 는 모험을 시작 하는데...</p>
			<br /><br />
			<a href="main_inventory.do">시작하기</a>
		</div>
	</div>
</body>
</html>