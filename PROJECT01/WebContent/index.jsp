<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function join_write() {
		location.href = "join.do";
	}
</script>
</head>
<body>
	<form action="" method="post">
		아이디 : <input type="text" name="id"/><br />
		패스워드 : <input type="text" name="password"/><br />
		<input type="submit" value="로그인"/><input type="button" onclick="join_write()" value="회원가입"/>
	</form>
</body>
</html>