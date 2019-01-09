<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="stu_check.jsp" method="GET">
		이름 : <input type="text" name="stu_name" id="stu_name"/><br />
		학과 : <input type="text" name="dep_name" id="dep_name"/><br />
		학번 : <input type="number" name="stu_num" id="stu_num"/><br />
		수강과목 : <br />
		<input type="checkbox" name="dep_ck" value="1"/> 컴퓨터이론<br />
		<input type="checkbox" name="dep_ck" value="2"/> C++<br />
		<input type="checkbox" name="dep_ck" value="3"/> 정보통신<br /><br />
		<input type="submit" value="입력"/>
	</form>
</body>
</html>