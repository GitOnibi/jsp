<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="connect" method="GET">
		<input type="hidden" name="type" value="insert"/>
		이름 : <input type="text" name="name"/><br />
		아이디 : <input type="text" name="id"/><br />
		패스워드 : <input type="text" name="pw"/><br />
		<input type="submit" />
	</form>
</body>
</html>