<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<c:forEach begin="1" end="123" step="1" var="x" varStatus="stat">
	<sql:update var="rs" dataSource="jdbc/OracleDB">
		INSERT INTO board(idx, name, pw, email, title, content, ref, step, b_order, hit)
		 VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0, 0)
		<sql:param value="${ x }" />
		<sql:param value="${ '이름' }${ x }" />
		<sql:param value="${ 11 }" />
		<sql:param value="${ '이름' }${ x }${ '@mail.com' }" />
		<sql:param value="${ '제목' }${ x }" />
		<sql:param value="${ '내용내용내용내용내용' }${ x }" />
		<sql:param value="${ x }" />
	</sql:update>
</c:forEach>
<c:redirect url="notice_1.jsp" />