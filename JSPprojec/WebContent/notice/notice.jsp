<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<sql:query var="rs" dataSource="jdbc/OracleDB">
	SELECT * FROM board
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="row" items="${ rs.rows }">
				<tr>
					<td>${ row.idx }</td>
					<td><a href="read.jsp?idx=${ row.idx }&hit=${ row.hit }">${ row.title }</a></td>
					<td>${ row.name }</td>
					<td>${ row.hit }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<a href="write_form.jsp?mode=write">글쓰기</a>
</body>
</html>