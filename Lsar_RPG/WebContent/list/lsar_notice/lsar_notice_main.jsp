<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="notice_wr.do">글쓰기</a>

<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
	<c:if test="${notice_page.getTotal()==0 }">
		<tr>
			<td colspan=4>글 없음</td>
		</tr>
	</c:if>
	<c:forEach items="${notice_page.cont }" var="row">
		<tr>
			<td>${row.number }</td>
			<td>
				<a href="notice_read.do?no=${row.number }&page_no=${notice_page.curpage}">
					${row.title }
				</a>
			</td>
			<td>${row.writer }</td>
			<td>${row.read_cnt }</td>
		<tr>
	</c:forEach>
	<tr>
		<td colspan=4>
			<c:if test="${notice_page.startpage > 5 }">
				<a href="inn.do?page_no=${notice_page.startpage-5 }">[이전]</a>
			</c:if>
			<c:forEach var="pN" begin="${notice_page.startpage }" end="${notice_page.endpage }">
				<a href="inn.do?page_no=${pN }">[${pN }]</a>
			</c:forEach>
			<c:if test="${notice_page.endpage < notice_page.totalpage }">
				<a href="inn.do?page_no=${notice_page.startpage+5 }">[다음]</a>
			</c:if>
		</td>
	</tr>
</table>



${epath = pageContext.request.contextPath ; '' }
</body>
</html>


