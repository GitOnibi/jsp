<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT * FROM SCHOOL_SCORE WHERE STU_NUM = ?
	<sql:param value="${ param.stu_num }" />
</sql:query>
<c:forEach var="row" items="${ rs.rows }" varStatus="stat">
	과목 : ${ row.SUB_NUM } / 득점 : ${ row.SUB_SCORE }	<br />
</c:forEach>