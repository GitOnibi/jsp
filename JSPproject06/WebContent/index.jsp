<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id = request.getParameter("id");
	if(id != null) {
		out.println(id);
	} else {
		out.println("비었어");
	}
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		* {margin:0; padding:0;}
		a {text-decoration:none;}
		li {list-style:none;}
		
		#wrap {
			width:100%;
			height:100%;
		}
		#header {
			width:100%;
			height:auto;
		}
		#login {
			width:20%;
			float:left;
		}
		#loginForem {
			display:block;
			width:100%;
		}
		#gnbWrap {
			width:80%;
			float:left;
		}
		#gnb {
			width:100%;
			overflow:hidden;
		}
		#gnb li {
			width:25%;
			float:left;
		}
	</style>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<div id="login">
				<jsp:include page="loginForm.jsp" />
			</div>
			<nav id="gnbWrap">
				<ul id="gnb">
					<li><a href="index.jsp">home</a></li>
					<li><a href="index.jsp?cmd='board'">게시판</a></li>
					<li><a href="index.jsp?cmd='reference'">자료실</a></li>
					<li><a href="index.jsp?cmd='service'">고객센터</a></li>
				</ul>
			</nav>
		</header>
		<div id="contentsWrap">
			
		</div>
	</div>
</body>
</html>