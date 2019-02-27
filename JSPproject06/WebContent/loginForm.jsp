<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String loginCheck = (String)session.getAttribute("loginCheck");
	String id = (String)session.getAttribute("id");
	if(loginCheck != null) {
		if(loginCheck.equals("true")) {
%>
		<%=id %>님 반갑습니다 <a href="Member_CTL?cmd=logout">로그아웃</a>
<%
		} 
	} else {
%>
		<form action="Member_CTL">
			<input type="hidden" name="cmd" value="login"/>
			아이디 : <input type="text" name="id"/><br />
			패스워드 : <input type="text" name="pw"/><br />
			<input type="submit" value="로그인" />
		</form>
<%
		}	
%>