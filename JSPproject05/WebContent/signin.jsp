<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
	if(msg != null) {
		out.println(msg);
	}
%>
	<form action="Control_Servlet" method="POST">
		<input type="hidden" name="cmd" value="signin"/>
		사용할 id : <input type="text" name="id"/><br />
		사용할 pw : <input type="text" name="pw"/><br />
		이름 : <input type="text" name="name" /><br />
		<input type="submit" value="가입하기"/>
	</form>
	<a href="index.jsp">돌아가기</a>
</body>
</html>