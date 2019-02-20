<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Control_Servlet" method="POST">
		<input type="hidden" name="cmd" value="input"/>
		학과 : <select name="dept">
			<option value="">학과선택</option>
			<option value="컴퓨터공학과">컴퓨터공학</option>
			<option value="전기전자학과">전기전자학과</option>
			<option value="정보통신학과">정보통신학과</option>
		</select>
		<br />
		과목1 : <input type="text" name="sub1"/><br />
		과목2 : <input type="text" name="sub2"/><br />
		과목3 : <input type="text" name="sub3"/><br />
		과목4 : <input type="text" name="sub4"/><br />
		과목5 : <input type="text" name="sub5"/><br />
		<input type="submit" value="신청하기"/>
	</form>
</body>
</html>