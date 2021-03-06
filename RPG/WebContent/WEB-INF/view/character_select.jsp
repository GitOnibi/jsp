<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bean.User" %>
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
		<div id="header">
		
		</div>
		<div id="contents">
			<button onclick="show_insert();">케릭터생성</button>
			<div class="insert">
				<h3>케릭터생성</h3>
				<button onclick="closeParent(event);">취소</button>
				<form action="character_create.do" method="POST" id="insFrm">
					<span>케릭터 이름</span>
					<input type="text" name="char_name"/>
					<input type="button" value="등록" onclick="do_submit(event);"/>
				</form>
			</div>
			<c:forEach items="${list}" var="row">
				<div style="border:1px solid #cfcfcf;margin:5px;">
					<p>Lv.${row.char_lv} ${row.char_name}(${user_id})</p>
					<form action="intro.do" method="POST">
						<input type="hidden" name="user_id" value="${user_id}"/>
						<input type="hidden" name="char_name" value="${row.char_name}"/>
						<input type="button" value="접속" onclick="do_submit(event);"/>
					</form>
					<form action="character_delete.do" method="POST">
						<input type="hidden" name="user_id" value="${user_id}"/>
						<input type="hidden" name="char_name" value="${row.char_name}"/>
						<input type="button" value="삭제" onclick="do_submit(event);"/>
					</form>
				</div>
			</c:forEach>
			<hr />
		</div>
		<div id="footer">
			<%@ include file="script.jsp" %>
		</div>
	</div>
</body>
</html>