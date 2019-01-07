<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%
	// 자바빈 인스탄스를 생성하여 저장 할 수 있음
	session.setAttribute("id", "admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session</title>
</head>
<body>
	<span>session.getId() : </span><%=session.getId() %><br />
	<span>session.getLastAccessedTime() : </span><%=session.getLastAccessedTime() %><br />
	<span>session.getAttribute("id") : </span><%=session.getAttribute("id") %><br />
	<%
		session.setMaxInactiveInterval(3600); // 세션이 살아있는 시간을 설정 초 단위
		
		session.invalidate(); // 세션파괴
		
		HttpSession make = request.getSession(); // HttpSession 인스탄스 생성
		// List list = new List();
		// list.add(id);
		// List list = (List)maek.getAttribute("id");
	%>
</body>
</html>