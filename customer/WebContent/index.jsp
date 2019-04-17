<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
	<header id="header">
		<jsp:include page="/interface/gnb.jsp" />
	</header>
	<div class="page">
		<div id="left">
			<jsp:include page="/interface/sidebar.jsp" />
		</div>
		<div id="right">
			<jsp:include page="/interface/contents.jsp" />
		</div>
	</div>
	<footer id="footer">
	
	</footer>
</body>
</html>