<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user = (User)session.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<div id="footer">
		
		</div>
		<div id="contents">
			<button onclick="show_insert();">케릭터생성</button>
			<div class="insert">
				<h3>케릭터생성</h3>
				<button onclick="closeParent(event);">취소</button>
				<form action="character_create.do" method="POST" id="insFrm">
					<span>케릭터 이름</span>
					<input type="text" name="char_name"/>
					<input type="hidden" name="user_id" value="${user.getUser_id() }"/>
					<input type="hidden" name="char_lv" value="1" readonly="readonly"/>
					<input type="hidden" name="char_str" value="10" readonly="readonly"/>
					<input type="hidden" name="char_dex" value="10" readonly="readonly"/>
					<input type="hidden" name="char_hp" value="100" readonly="readonly"/>
					<input type="hidden" name="char_atk" value="10" readonly="readonly"/>
					<input type="hidden" name="char_def" value="0" readonly="readonly"/>
					<input type="hidden" name="char_agi" value="1" readonly="readonly"/>
					<input type="hidden" name="char_crt" value="1" readonly="readonly"/>
					<input type="hidden" name="char_exp" value="0" readonly="readonly"/>
					<input type="button" value="등록" onclick="do_submit(event);"/>
				</form>
			</div>
			<c:forEach items="${list}" var="row">
				<div style="border:1px solid #cfcfcf;margin:5px;">
					<p>Lv ${row.char_lv} ${row.char_name}(<%=user.getUser_id()%>)</p>
					<form action="intro.do" method="POST">
						<input type="hidden" name="user_id" value="<%=user.getUser_id()%>"/>
						<input type="hidden" name="char_name" value="${row.char_name}"/>
						<input type="button" value="접속" onclick="do_submit(event);"/>
					</form>
					<form action="character_delete.do" method="POST">
						<input type="hidden" name="user_id" value="<%=user.getUser_id()%>"/>
						<input type="hidden" name="char_name" value="${row.char_name}"/>
						<input type="button" value="삭제" onclick="do_submit(event);"/>
					</form>
				</div>
			</c:forEach>
			<hr />

		</div>
		<div id="footer">
			<jsp:include page="script.jsp" />
		</div>
	</div>
</body>
</html>