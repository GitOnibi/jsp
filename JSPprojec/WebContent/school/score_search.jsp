<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<% request.setCharacterEncoding("UTF-8"); %>
<c:choose>
	<c:when test="${ param.stu_name == '' || param.stu_num == '' }">
		<script type="text/javascript">
			alert("잘못된 입력입니다");
			window.location.href = "index.jsp";
		</script>
	</c:when>
	<c:otherwise>
		<sql:query var="rs1" dataSource="jdbc/OracleDB">
			SELECT * FROM SCHOOL_STUDENT WHERE stu_num = ? AND stu_name = ? AND rownum = 1
			<sql:param value="${ param.stu_num }" />
			<sql:param value="${ param.stu_name }" />
		</sql:query>
		<c:forEach var="row" items="${ rs1.rows }" varStatus="stat">
			학과 : ${ row.dep_name }<br />
			이름 : ${ row.stu_name }<br />
		</c:forEach>
		<sql:query var="rs2" dataSource="jdbc/OracleDB">
			SELECT * FROM SCHOOL_SCORE WHERE stu_num = ?
			<sql:param value="${ param.stu_num }" />
		</sql:query>
		<c:forEach var="row" items="${ rs2.rows }" varStatus="stat">
			과목 : ${ row.sub_name }(${ row.sub_num }) / 점수 : ${ row.sub_score }<br />
			<c:set var="sum" value="${ sum + row.sub_score }" />
			<c:set var="cnt" value="${ stat.index + 1 }" />
		</c:forEach>
		<c:set var="avg" value="${ sum / cnt }" />
		<c:choose>
			<c:when test="${ avg >= 95 }">
				<c:set var="grd" value="${ 'A' }" />
			</c:when>
			<c:when test="${ avg >= 85 }">
				<c:set var="grd" value="${ 'B' }" />
			</c:when>
			<c:when test="${ avg >= 75 }">
				<c:set var="grd" value="${ 'C' }" />
			</c:when>
			<c:when test="${ avg >= 65 }">
				<c:set var="grd" value="${ 'D' }" />
			</c:when>
			<c:when test="${ avg >= 55 }">
				<c:set var="grd" value="${ 'E' }" />
			</c:when>
			<c:otherwise>
				<c:set var="grd" value="${ 'F' }" />
			</c:otherwise>
		</c:choose>
		평점 : <c:out value="${ grd } (${ avg })" />
	</c:otherwise>
</c:choose>