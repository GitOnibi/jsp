<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT * FROM SCHOOL_STUDENT WHERE STU_NUM = ?
	<sql:param value="${ param.stu_num }"/>
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="score_check.jsp" method="GET">
		학번 : <input type="number" name="stu_num" id="stu_num" value="${ param.stu_num }"/><br />
		이름 : <input type="text" name="stu_name" id="stu_name"/><br />
		<c:forEach var="stu" items="${ rs.rows }" varStatus="stat">
			과목코드 : <input type="text" name="sub_num" id="sub_num" value="${ stu.SUB_NUM }"/><br />
			점수 : <input type="number" name="sub_score" id="sub_score"/><br />
		</c:forEach>
		<input type="submit" value="입력"/>
	</form>
</body>
</html>