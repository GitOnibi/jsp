<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	</head>
<body>
	<form action="ex06_sub1.jsp" method="get">
		이름 : <input type="text" name="name" id="name"/><br />
		나이 : <input type="text" name="age" id="age" /><br />
		성별 : <input type="text" name="gender" id="gender"/><br />
		키 : <input type="text" name="tall" id="tall"/><br />
		몸무게 : <input type="text" name="weight" id="weight"/><br />
		<input type="submit" value="제출" />
	</form>
</body>
</html>
