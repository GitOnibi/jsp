<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%
	if(session.getAttribute("id") != null) {
		session.invalidate();
	} else {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		if(id != null && pw != null) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
		} else {
			session.invalidate();
		}
	}
%>
<jsp:forward page="./login.jsp" />