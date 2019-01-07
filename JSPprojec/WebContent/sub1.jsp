<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id 		= request.getParameter("id");
	String pw 		= request.getParameter("pw");
	String email 	= request.getParameter("email");
	String addr 	= request.getParameter("addr");
	String[] ck		= request.getParameterValues("ck");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="border-collapse:collapse;">
		<tr>
			<th>id</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>pw</th>
			<td><%=pw %></td>
		</tr>
		<tr>
			<th>email</th>
			<td><%=email %></td>
		</tr>
		<tr>
			<th>addr</th>
			<td><%=addr %></td>
		</tr>
		<tr>
			<th>ck</th>
			<td>
			<% for(int i = 0; i < ck.length; i++) { %>
				<span><%=ck[i] %></span>
			<% } %>
			</td>
		</tr>
	</table>
</body>
</html>
<%
	// response.sendRedirect("./sub2.html");
%>