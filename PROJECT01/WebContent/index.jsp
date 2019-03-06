<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	User user = (User)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function join_write() {
		location.href = "join.do";
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${ user != null }">
			${user.id } 님 반갑습니다! <a href="logout.do">로그아웃</a>
		</c:when>
		<c:otherwise>
			<form action="login.do" method="post">
				아이디 : <input type="text" name="id"/><br />
				패스워드 : <input type="text" name="password"/><br />
				<input type="submit" value="로그인"/><input type="button" onclick="join_write()" value="회원가입"/>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>