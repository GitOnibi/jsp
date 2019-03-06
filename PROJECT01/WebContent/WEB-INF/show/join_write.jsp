<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join us!</title>
<script type="text/javascript">
	funtion check() {
		location.href = "join.do";
	}
</script>
</head>
<body>
	<form action="join.do" method="post">
		아이디 : <input type="text" name="id"/><input type="button" value="중복체크" onclick="check()"/>
		<c:if test="${ err.id }" >아이디를 입력하세요!</c:if>
		<c:if test="${ err.dup }" >이미 사용중인 아이디 입니다!</c:if>
		<br />
		패스워드 : 	<input type="password" 	name="pw"/>
		<c:if test="${ err.password }" >패스워드를 입력하세요!</c:if><br />
		패스워드확인 : 	<input type="password" 	name="pw_cnf"/>
		<c:if test="${ err.cnf_pw }" >패스워드확인을 입력하세요</c:if>
		<c:if test="${ err.NotMatch }" >패스워드가 일치하지 않습니다</c:if>
		<br />
		이름 : 		<input type="text" 		name="name"/>
		<c:if test="${ err.name }" >이름을 입력하세요!</c:if><br />
		생일 : 		<input type="text" 		name="birth"/><br />
		<input type="submit" value="가입하기"/>
	</form>
</body>
</html>