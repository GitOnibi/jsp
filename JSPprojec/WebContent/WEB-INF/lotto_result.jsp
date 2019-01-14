<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String state	= request.getParameter("state");
	String cnt		= request.getParameter("cnt");
	int cntNum		= Integer.parseInt(cnt);
	String bonus	= request.getParameter("bonus");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="result">
	<%
		switch(cntNum) {
			case 6 :
				out.println("1등");
				break;
			case 5 :
				if( bonus.equals("1") ) {
					out.println("2등");
				} else {
					out.println("3등");
				}
				break;
			case 4 :
				out.println("4등");
				break;
			case 3 :
				out.println("5등");
				break;
			case 2 :
				out.println("꽝!");
				break;
			case 1 :
				out.println("꽝!");
				break;
			case 0 :
				out.println("꽝!");
				break;
		}
	%>
	</div>
</body>
</html>