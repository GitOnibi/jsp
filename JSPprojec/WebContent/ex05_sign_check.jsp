<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
 <%--
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:orcl" user="onigawara" password="dbwls12" />
 --%>
<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT max(num) AS mNum FROM test1
</sql:query>
<c:forEach items="${ rs.rows }" var="row" varStatus="stat">
	<c:set var="num" value="${ row.mNum + 1 }" />
</c:forEach>
<sql:update var="rs" dataSource="jdbc/OracleDB">
	INSERT INTO test1(num, name, id, pw, birth, addr)
	 VALUES(?, ?, ?, ?, ?, ?)
	<sql:param value="${ num }" />
	<sql:param value="${ param.name }" />
	<sql:param value="${ param.id }" />
	<sql:param value="${ param.pw }" />
	<sql:param value="${ param.birth }" />
	<sql:param value="${ param.addr }" />
</sql:update>
<c:redirect url="ex04_login.jsp" />