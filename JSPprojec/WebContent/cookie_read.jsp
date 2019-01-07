<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookie = request.getCookies(); // 현제 브라우저에 저장된 모든 쿠키를 가져옴
	
	for(int i = 0; i < cookie.length; i++) {
		if(cookie[i].getName().equals("author")) {
			out.println( URLDecoder.decode(cookie[i].getValue(), "UTF-8") ); // 한글 깨질 시 디코딩
			out.println( cookie[i].getName() + " : " );
			out.println( cookie[i].getValue() + "<br />" );
		}
	}
%>
</body>
</html>