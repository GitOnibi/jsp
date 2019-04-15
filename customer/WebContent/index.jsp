<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
		<jsp:include page="/interface/gnb.jsp" />
	</header>
	<div class="page">
		<div id="left">
			<jsp:include page="/interface/lnb.jsp" />
		</div>
		<div id="right">
			<jsp:include page="/interface/contents.jsp" />
		</div>
	</div>
	<footer id="footer">
	
	</footer>
</body>
</html>