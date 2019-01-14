<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT MAX(idx) AS mIdx, max(ref) as mRef FROM board
</sql:query>
<c:forEach var="row" items="${ rs.rows }">
	<c:set var="idx" value="${ row.mIdx + 1 }"/>
	<c:set var="ref" value="${ row.mRef + 1 }"/>
</c:forEach>
<c:if test="${ empty idx}">
	<c:set var="idx" value="${ 1 }" />
</c:if>
<c:forEach begin="1" end="30" step="1" var="x" varStatus="stat">
	<sql:update var="rs" dataSource="jdbc/OracleDB">
		INSERT INTO board(idx, name, pw, email, title, content, ref, step, b_order, hit)
		 VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0, 0)
		<sql:param value="${ x }" />
		<sql:param value="${ '이름0' }${ x }" />
		<sql:param value="${ 11 }" />
		<sql:param value="${ '이름0' }${ x }${ '@mail.com' }" />
		<sql:param value="${ '제목0' }${ x }" />
		<sql:param value="${ '내용내용내용내용내용0' }${ x }" />
		<sql:param value="${ null }" />
	</sql:update>
</c:forEach>
<c:redirect url="notice.jsp" />