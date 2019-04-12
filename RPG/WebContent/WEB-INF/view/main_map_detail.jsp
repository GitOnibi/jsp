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
			<%@ include file="gnb.jsp" %>
			<%@ include file="char_info.jsp" %>
		</header>
		<div id="contents">
			<div>	
				<ul>
					<c:forEach items="${mob_list}" var="row" varStatus="st">
					<li>
						<p>Lv.${row.mob_lv} ${row.mob_name}</p>
						<p>HP : ${row.mob_hp } / ATK : ${row.mob_atk} / DEF : ${row.mob_def}</p>
						<button onclick="battle(p1, m${st.index + 1});">공격</button>
					</li>
					</c:forEach>
				</ul>
			</div>	
			<div id="result">${log}</div>
		</div>
		<div id="footer">
			<%@ include file="script.jsp" %>
		</div>
	</div>
</body>
</html>