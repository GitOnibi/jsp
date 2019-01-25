<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection	conn	= null;
	Statement	stmt	= null;
	ResultSet	rs		= null;
	
	try {
		String driver	= "jdbc:apache:commons:dbcp:jsptest";
		String sql		= "SELECT * FROM SCHOOL_STUDENT";
		conn			= DriverManager.getConnection(driver);
		stmt			= conn.createStatement();
		rs				= stmt.executeQuery(sql);
		
		while(rs.next()) {
%>
			이름 : <%=rs.getString("stu_name") %><br />
			학과 : <%=rs.getString("dep_name") %><br />
			학번 : <%=rs.getString("stu_num") %><br /><br />
<%
		}
	} catch(Exception e) {
		out.println(e);
		e.printStackTrace();
	}
%>
</body>
</html>