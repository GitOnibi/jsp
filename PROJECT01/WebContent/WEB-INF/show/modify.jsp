<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="modify.do" method="POST">
		바꿀이름 : <input type="text" name="name"/><br />
		바꿀생일 : <input type="text" name="birth"/>
		<input type="submit" value="변경하기"/>
	</form>
</body>
</html>