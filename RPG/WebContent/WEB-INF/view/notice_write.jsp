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
				<h1>글쓰기</h1>
				<form action="notice_write.do" method="POST">
					작성자: <input type="text" name="user_id" value="${sessionScope.user_id}" readonly/><br />
					제목 : <input type="text" name="title"/><br />
					내용 : <textarea name="cont"></textarea><br />
					<input type="submit" value="작성하기"/>
				</form>
			</div>
		</div>
		<div id="footer">
		
		</div>
	</div>
</body>
</html>