<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<table border="1px">
				<tr>
					무기 / 갑옷 / 장갑 / 신발  / 보조
					<c:forEach items="${inven_list}" var="row">
					<td>${row.item_name}</td>
					</c:forEach>
				</tr>
			</table>
			<div>
				<c:forEach items="${equip_list}" var="row">
				<span>무기</span><span>${row.weapon}</span><br />
				<span>갑옷</span><span>${row.amor}</span><br />
				<span>장갑</span><span>${row.grove}</span><br />
				<span>신발</span><span>${row.boots}</span><br />
				<span>보조1</span><span>${row.sub1}</span><br />
				<span>보조2</span><span>${row.sub2}</span><br />
				<span>보조3</span><span>${row.sub3}</span><br />
				<span>보조4</span><span>${row.sub4}</span><br />
				<span>보조5</span><span>${row.sub5}</span>
				</c:forEach>
			</div>

		</div>
		<div id="footer">
			<jsp:include page="script.jsp" />
		</div>
	</div>
</body>
</html>