<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="sty.css">
<script>
function enter(){
	location.href="enter.do";
}
</script>
</head>
<body>
<div id=lg_form>
<form action="login.do" method="post">
<table border=1 >
	<tr class="lg_tb">
		<td>아 이 디 : </td>
		<td><input type=text name=lsar_id></td>
	</tr>
	<tr class="lg_tb">
		<td>비밀번호 : </td>
		<td><input type=text name=lsar_pw></td>
	</tr>
	<tr>
		<td colspan=2>
			<input type=submit value="로그인">
			<input type=button value="국민등록" onclick="enter()">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>