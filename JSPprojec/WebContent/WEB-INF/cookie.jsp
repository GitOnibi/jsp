<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.net.URLEncoder"%>
<%
	// Cookie cookie = new Cookie( "author", URLEncoder.encode("용지혁", "UTF-8") ); 초기 인코딩
	Cookie cookie = new Cookie("author", "용지혁"); // 인스탄스 생성
	response.addCookie(cookie);
%>
<%--
	response.addCookie(cookie); // 클라이언트쪽에 쿠키를 추가
	out.println( cookie.getName() ); // 쿠키의 이름을 가져옴
	
	cookie.setMaxAge(-1); // 웹브라우저 종료와 함게 쿠키 삭제 (초 단위)
	out.println( cookie.getMaxAge() ); // 유효시간을 가져옴
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<a href="./cookie_read.jsp">쿠키 읽기 페이지로 이동</a>
</body>
</html>