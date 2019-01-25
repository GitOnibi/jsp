<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, com.jdbc.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<%
	List<Member> list = new ArrayList<Member>();
	Connection	conn	= null;
	Statement	stmt	= null;
	ResultSet	rs		= null;


	String driver	= "jdbc:apache:commons:dbcp:jsptest";
	String sql		= "SELECT * FROM member";
	try {
		conn			= DriverManager.getConnection(driver);
		stmt			= conn.createStatement();
		rs				= stmt.executeQuery(sql);
	} catch(Exception e) {
		out.println(e);
	}
	while(rs.next()) {
		Member temp = new Member();
		temp.setNum( rs.getInt("num")	);
		temp.setName( rs.getString("name")	);
		temp.setAge( rs.getInt("age")	);
		temp.setAddr( rs.getString("addr")	);
		temp.setGender( rs.getString("gender"));
		list.add(temp);
	}
%>
<%=list.get(0).getNum() %>
<%=list.get(0).getName() %>
<%=list.get(0).getAge() %>
<%=list.get(0).getAddr() %>
<%=list.get(0).getGender() %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>