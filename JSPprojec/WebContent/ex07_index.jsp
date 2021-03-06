<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="arr" value="<%= new int[]{10,20,30,40,50} %>" />
<c:forEach items="${ arr }" var="i" varStatus="stat" begin="0" end="4">
	index : ${ stat.index } &nbsp;/&nbsp; element : ${ i } &nbsp;/&nbsp; count : ${ stat.count }<br /><br />
</c:forEach>
<c:forTokens items="some-test-text-awesome" delims="-" var="name">
	${ name }
</c:forTokens>
<%-- ${ paramValuses.ck } --%>
<c:redirect url="ex06_sub1.jsp">
	<c:param name="name" value="Onigawara" />
	<c:param name="age" value="33" />
	<c:param name="gender" value="남" />
	<c:param name="tall" value="173" />
	<c:param name="weight" value="63" />
</c:redirect>