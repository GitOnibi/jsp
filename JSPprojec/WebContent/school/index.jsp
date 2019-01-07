<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/schoolCss.css" />
<title>Insert title here</title>
</head>
<body>
	<h1>성적조회 시스템</h1>
	<form action="score_search.jsp" method="GET">
		이름 : <input type="text" name="stu_name" id="stu_name"/><br />
		학번 : <input type="text" name="stu_num" id="stu_num"/><br />
		<input type="submit" value="조회"/>
	</form>
	<div class="btnWrap">
		<a href="score_input.jsp" class="btn">성적입력</a>
		<a href="stu_input.jsp" class="btn">학생입력</a>
	</div>
</body>
</html>