<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, com.model.member.Member_bean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id	= (String)session.getAttribute("id");
	if(id != null) {
		out.println(id + "님 반갑습니다 <a href='Control_Servlet?cmd=logout'>[로그아웃]</a><br />");
	}
	List<Member_bean> list = new ArrayList<Member_bean>();
	list = (List)session.getAttribute("list");
%>
	<c:choose>
		<c:when test="${ list.get(0).dept != null }">
			<c:forEach items="${ list }" var="row">
				학번 : ${ row.num }<br />
				아이디 : ${ row.id }<br />
				이름 : ${ row.name }<br />
				학과 : ${ row.dept }<br />
				수강1 : ${ row.sub1 }<br />
				수강2 : ${ row.sub2 }<br />
				수강3 : ${ row.sub3 }<br />
				수강4 : ${ row.sub4 }<br />
				수강5 : ${ row.sub5 }<br />
			</c:forEach>
			<a href="input.jsp">[학과정보 수정]</a>
		</c:when>
		<c:otherwise>
			학과정보가 없습니다<br />
			<a href="input.jsp">[학과정보 입력]</a>
		</c:otherwise>
	</c:choose>

</body>
</html>