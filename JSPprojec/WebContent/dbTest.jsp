<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.sql.*"%>
<%
	String url				= "jdbc:oracle:thin:@localhost:1521:orcl";
	String user				= "onigawara";
	String password			= "dbwls12";
	Connection conn			= null;
	Statement stmt			= null;
	PreparedStatement ptmt	= null;
	ResultSet rs			= null;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	stmt = conn.createStatement();
	
%>