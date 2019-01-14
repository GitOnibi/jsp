<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ include file="dbTest.jsp" %>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	String query = "SELECT * FROM test1";
	
	rs = stmt.executeQuery(query);
	while(rs.next()) {
		if( id.equals(rs.getString("id")) && pw.equals(rs.getString("pw")) ) {
			session.setAttribute("id", id);
			break;
		}
	}
%>
<script>
	location.href="ex04_login.jsp";
</script>