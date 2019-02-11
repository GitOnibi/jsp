<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Login_check.do" method="POST">
		<input type="hidden" name="cmd" value="signin"/>
		사용할 아이디 : <input type="text" name="id"/><br />
		사용할 패스워드 : <input type="text" name="pw"/>
		<input type="submit" value="가입하기"/>
	</form>
</body>
</html>