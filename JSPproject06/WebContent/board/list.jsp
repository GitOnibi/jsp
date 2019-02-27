<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin:0; padding:0;}
	html, body{width:100%; height:100%;}
	a {text-decoration:none;}
	ul {list-style:none;}
	#hd {clear:both;width:100%;}
	.gnb {clear:both; over-flow:hidden; width:100%;}
	.gnb li {float:left; width:25%; text-align:center;}
	
	#member{with:25%; float:left; border:1px solid #efefef; box-sizing:border-box; height:600px;}
	
	#content{width:75%; float:right; border:1px solid #efefef; box-sizing:border-box; height:600px;}
</style>
</head>
<body>
	<div id="wrap">
		<header id="hd">
			<jsp:include page="../gnb.jsp" />
		</header>
		<div id="member">
			<jsp:include page="/member/loginForm.jsp" />
		</div>
		<div id="contents">
		<%
			if( msg != null) {
				out.println(msg);
			} else {
				out.println("msg 비어있음");
			}
		%>
		</div>
	</div>
</body>
</html>