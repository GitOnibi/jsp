<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<sql:update var="rs" dataSource="jdbc/OracleDB">
	UPDATE board SET hit = hit+1 WHERE idx = ?
	<sql:param value="${ param.idx}" />
</sql:update>
<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT MAX(idx) AS mIdx FROM board
</sql:query>
<c:forEach var="row" items="${ rs.rows }">
	<c:set var="idx" value="${ row.mIdx + 1 }" />
</c:forEach>

<c:set var="ref" value="${ param.ref }" />
<c:set var="step" value="${ param.step + 1 }" />
<c:set var="b_order" value="${ param.b_order}" />

<c:set var="re_name" value="${ param.re_name }" />
<c:set var="re_pw" value="${ param.re_pw }" />
<c:set var="re_email" value="${ param.re_email }" />
<c:set var="re_title" value="${ param.re_title }" />
<c:set var="re_content" value="${ param.re_content }" />

<sql:update var="rs" dataSource="jdbc/OracleDB">
	UPDATE board SET b_order = b_order + 1 WHERE ref = ? and b_order >= ?
	<sql:param value="${ ref }" />
	<sql:param value="${ b_order }" />
</sql:update>

<sql:update var="rs" dataSource="jdbc/OracleDB">
	INSERT INTO board(idx, name, pw, email, title, content, ref, step, b_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
	<sql:param value="${ idx }" />
	<sql:param value="${ param.re_name }" />
	<sql:param value="${ param.re_pw }" />
	<sql:param value="${ param.re_email }" />
	<sql:param value="${ param.re_title }" />
	<sql:param value="${ param.re_content }" />
	<sql:param value="${ ref }" />
	<sql:param value="${ step }" />
	<sql:param value="${ b_order }" />
</sql:update>
<c:redirect url="notice.jsp" />