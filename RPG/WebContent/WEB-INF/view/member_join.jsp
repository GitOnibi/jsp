<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<div id="contents">
			<form action="member_join.do" method="POST">
				<label for="user_id">아이디</label>
				<input type="text" name="user_id" id="user_id" /><a href="member_check.do">중복체크</a><br />
				<label for="user_pw">패스워드</label>
				<input type="text" name="user_pw" id="user_pw" /><br />
				<label for="user_pw">패스워드확인</label>
				<input type="text" name="user_pw2" id="user_pw2" /><br /><br />
				<input type="submit" value="가입하기"/>
			</form>
		</div>
	</div>
</body>
</html>