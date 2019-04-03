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
			<jsp:include page="gnb.jsp" />
		</header>
		<div id="contents">
			<div>
				<c:forEach items="${cont}" var="row">
				<p>${row.content}</p>
				</c:forEach>
				<hr />
				<a href="main_board.do">목록</a>
			</div>
		</div>
		<div id="footer">
		
		</div>
	</div>
</body>
</html>