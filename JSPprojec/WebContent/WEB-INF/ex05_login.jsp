<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(session.getAttribute("id") == null) {
%>
	<form action="./ex05_login_check.jsp" id="loginFrm" method="get">
		아이디 : <input type="text" name="id" id="idInput"/><br />
		패스워드 : <input type="text" name="pw" id="pwInput" /><br />
		<input type="submit" value="로그인"/>
		<a href="./ex04_signIn.jsp">회원가입</a>
	</form>
<%
	} else {
%>
	<%=session.getAttribute("id") %> 님 반갑습니다.
	<a href="./ex05_login_check.jsp">로그아웃</a>
<%
	//session.invalidate();
	}
%>

</body>
</html>