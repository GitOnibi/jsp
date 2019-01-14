<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ex05_sign_check.jsp" id="signInFrm" method="get">
		이름 : <input type="text" name="name" id="name"/><br />
		아이디 : <input type="text" name="id" id="id" /><br />
		패스워드 : <input type="text" name="pw" id="pw"/><br />
		생년월일 : <input type="text" name="birth" id="birth"/><br />
		주소 : <input type="text" name="addr" id="addr"/><br />
		<input type="submit" value="가입하기" />
	</form>
</body>
</html>