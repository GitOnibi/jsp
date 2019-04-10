<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	${epath = pageContext.request.contextPath; ''}
	<a href="${epath}/디렉토리명/***.do">이동</a>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<jsp:include page="gnb.jsp" />
		</header>
		<div id="contents">
			<div>
				<h1>게시판</h1>
				<table border="1px">
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>조회수</th>
					</tr>
					<c:choose>
					<c:when test="${notice_page.total == 0}" >
					<tr>
						<td colspan="4">글이 없습니다.</td>
					</tr>
					</c:when>
					<c:otherwise>
					<c:forEach items="${notice_page.cont}" var="row">
					<tr>
						<td>${row.number}</td>
						<td>
							<a href="notice_read.do?no=${row.number}&page_no=${notice_page.curpage}">${row.title}</a>
						</td>
						<td>${row.user_id}</td>
						<td>${row.read_cnt}</td>
					</tr>
					</c:forEach>
					</c:otherwise>
					</c:choose>
					<tr>
						<td colspan="4">
							<c:if test="${notice_page.startpage > 5}">
							<a href="main_board.do?page_no=${notice_page.startpage - 5}">&nbsp;&lt;&lt;이전&nbsp;</a>
							</c:if>
							<c:forEach var="pn" begin="${notice_page.startpage}" end="${notice_page.endpage}">
							<a href="main_board.do?page_no=${pn}">&nbsp;&nbsp;${pn}&nbsp;&nbsp;</a>
							</c:forEach>
							<c:if test="${notice_page.endpage < notice_page.totalpage}">
							<a href="main_board.do?page_no=${notice_page.startpage + 5}">&nbsp;다음&gt;&gt;&nbsp;</a>
							</c:if>
						</td>
					</tr>
				</table>
				<c:if test="${sessionScope.user_id != null}">
					<a href="goto_write.do">글쓰기</a>
				</c:if>
			</div>
		</div>
		<div id="footer">
		
		</div>
	</div>
</body>
</html>