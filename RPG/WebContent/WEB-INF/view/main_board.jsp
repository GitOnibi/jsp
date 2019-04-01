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
						<th>최조작성일</th>
						<th>최종수정일</th>
						<th>조회수</th>
					</tr>
					<tr>
						<c:forEach items="${content_list}" var="row">
						<td>${row.number}</td>
						<td>${row.user_id}</td>
						<td>${row.title}</td>
						<td>${row.regdate}</td>
						<td>${row.moddate}</td>
						<td>${row.read_cnt}</td>
						</c:forEach>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer">
		
		</div>
	</div>
</body>
</html>