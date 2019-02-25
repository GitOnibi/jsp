<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String id = (String)session.getAttribute("id");
	if(id == null) {
%>
	<form action="Member_control" id="loginForm" method="POST">
	<input type="hidden" name="cmd" value="login"/>
	아이디 : <input type="text" name="user_id"/><br />
	패스워드 : <input type="text" name="user_pw"/><br />
	<input type="submit" value="로그인"/>
	</form>
<%
	} else {
%>
	<%=id %>님 반갑습니다.
	<a href="index.jsp?cmd=logout">로그아웃</a>
<%
	}
%>
