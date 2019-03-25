<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<jsp:include page="dev_gnb.jsp" />
		</header>
		<div id="contents">
			<table border="1px">
				<tr>
					<th>아이디</th>
					<th>패스워드</th>
					<th>가입일</th>
					<th>이메일</th>
				</tr>
				<c:forEach items="${list}" var="row">
				<tr>
					<td>${row.user_id}</td>
					<td>${row.user_pw}</td>
					<td>${row.ndate}</td>
					<td>${row.user_email}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>