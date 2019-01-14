<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/reset.css" />
<title>Insert title here</title>
<style type="text/css">
	#wrap {
		width:80%;
		height:100%;
		margin:0 auto;		
	}
	
	#header {
		width:100%;
		height:100px;
		overflow:hidden;
	}
		#login {
			width:20%;
			height:100%;
			float:left;
		}
		#loginForm {
			display:block;
			width:100%;
			height:100%;
			box-sizing:border-box;
			padding:20px;
		}
		#loginForm label {
			display:block;
			float:left;
			width:20%;
			height:20px;
		}
		#id, #pw, #loginSubmit {
			display:block;
			width:80%;
			height:20px;
			float:left;
			box-sizing:border-box;
		}
		#loginSubmit {
			width:100%;
		}
		#gnbWrap {
			width:80%;
			height:100%;
			float:right;
		}
		#gnbUl {
			width:100%;
			height:100%;
		}
		.gnbLi {
			float:left;
			width:33.33%;
			height:100%;
			line-height:100px;
			text-align:center;
		}
	
	#contents {
		width:100%;
		height:600px;
	}
	#conLeft {
		width:60%;
		height:100%;
		float:left;
	}
	#conRight {
		width:40%;
		height:100%;
		float:right;
	}
</style>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<%@ include file="./ex01_login.jsp" %>
			<%@ include file="./ex01_gnbWrap.jsp" %>
		</header>
		<div id="contents">
			<jsp:include page="./ex01_conLeft.jsp">
				<jsp:param name="select" value="0" />
			</jsp:include>
			<jsp:include page="./ex01_conRight.jsp">
				<jsp:param name="select" value="0" />
			</jsp:include>
		</div>
	</div>
</body>
</html>