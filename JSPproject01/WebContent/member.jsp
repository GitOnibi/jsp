<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>

<%
	String num		= request.getParameter("num");
	String name		= request.getParameter("name");
	String age		= request.getParameter("age");
	String addr		= request.getParameter("addr");
	String gender	= request.getParameter("gender");
	
	Connection	conn	= null;
	Statement	stmt	= null;
	ResultSet	rs		= null;
	
	try {
		String driver	= "jdbc:apache:commons:dbcp:jsptest";
		String sql		= "INSERT INTO member(num, name, age, addr, gender) VALUES('" + num + "', '" + name + "', '" + age + "', '" + addr + "', '" + gender + "')";
		conn			= DriverManager.getConnection(driver);
		stmt			= conn.createStatement();
		stmt.executeQuery(sql);
	} catch (Exception e) {
		e.printStackTrace();
	}
%>