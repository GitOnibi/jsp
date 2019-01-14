<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT * FROM board WHERE idx=?
	<sql:param value="${ param.idx }" />
</sql:query>
<c:forEach var="row" items="${ rs.rows }">
	<c:set var="right_pw" value="${ row.pw }" />
</c:forEach>
<c:choose>
	<c:when test="${ param.pw == right_pw }">
		<sql:update var="rs" dataSource="jdbc/OracleDB">
			UPDATE board SET name = ?, email = ?, title = ?, content = ? WHERE idx = ?
			<sql:param value="${ param.name }" />
			<sql:param value="${ param.email }" />
			<sql:param value="${ param.title }" />
			<sql:param value="${ param.content }" />
			<sql:param value="${ param.idx }" />
		</sql:update>
		<c:redirect url="notice.jsp"/>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("패스워드가 일치하지 않습니다");
			location.href = "notice.jsp";	
		</script>
	</c:otherwise>
</c:choose>