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
				<h1>${nt.title}</h1>
				<hr />
				<p>${cont[0].content}</p>
				<hr />
				<p>조회수 : ${nt.read_cnt} / 작성자 : ${nt.user_id} / 최초작성일 : ${nt.regdate} / 최종수정일 : ${nt.moddate}</p>
				<hr />
				<a href="main_board.do">목록</a><a href="goto_modify.do?no=${cont[0].number}">수정</a>
			</div>
		</div>
		<div id="footer">
		
		</div>
	</div>
</body>
</html>