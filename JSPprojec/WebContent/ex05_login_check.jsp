<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
	<c:choose>
		<c:when test="${ sessionscope.id != null }">
			<c:set var="id" value="null" scope="session" />
		</c:when>
		<c:otherwise>
			<sql:query var="rs" dataSource="jdbc/OracleDB">
				SELECT * FROM test1 WHERE id=?
				<sql:param value="${ param.id }"/>
			</sql:query>
			<c:forEach items="${ rs.rows }" var="row">
				<c:set var="id" value="${ row.id }" />
				<c:choose>
					<c:when test="${param.pw == row.pw}">
						<c:set var="id" value="${param.id}" scope="session" />
						<c:redirect url="ex05_login.jsp" />
					</c:when>
					<c:otherwise>
						<script type="text/javascript">
							alert("아이디 또는 패스워드가 일치하지 않습니다");
						</script>
						<c:redirect url="ex04_login.jsp" />
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<c:redirect url="ex05_login.jsp" />