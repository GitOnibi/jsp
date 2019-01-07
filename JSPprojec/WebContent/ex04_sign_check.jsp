<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="dbTest.jsp" %>
<%
	String name		= request.getParameter("name");
	String id		= request.getParameter("id");
	String pw		= request.getParameter("pw");
	String birth	= request.getParameter("bitrh");
	String addr		= request.getParameter("addr");
	
	int num			= 0;
	String numQuery = "SELECT num FROM test1";
	rs				= stmt.executeQuery(numQuery);
	while(rs.next()) {
		int n	= Integer.parseInt(rs.getString("num"));
		num		= num < n ? n : num;
	}
	num += 1;
	
	String	query	=	"INSERT INTO TEST1(num, name, id, pw, birth, addr)";
			query	+=	" VALUES(" + num + ",'" + name + "','" + id + "','" + pw + "'," + birth + ",'" + addr + "')";
	
	stmt.executeQuery(query);
%>
<jsp:forward page="ex04_login.jsp" />