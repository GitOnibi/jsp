<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.do" method="post">
		아이디 : 		<input type="text" 		name="id"/><input type="button" onclick="" value="중복확인"/><br />
		패스워드 : 	<input type="password" 	name="pw"/><br />
		패스워드확인 : 	<input type="password" 	name="pw_cnf"/><br />
		이름 : 		<input type="text" 		name="name"/><br />
		생일 : 		<input type="text" 		name="birth"/><br />
		<input type="submit" value="가입하기"/>
	</form>
</body>
</html>