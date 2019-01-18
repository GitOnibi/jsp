<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:set var="list" value="<%=Arrays.asList(1, 2, 3, 4, 5) %>" />
<c:set var="sum" value="${ list.stream().sum() }" />
${ sum }<br />

<c:forEach var="values" items="${ list }">
	<c:set var="sum" value="${ sum + values }" />
</c:forEach>
${ sum }<br />

${ arr = [1,3,4,6,7,9,2,8,5];'' }
${ arr.stream().filter(x -> x % 3 == 0).map(x -> x * 2).toList() }

<%-- ${map.entrySet().stream()} --%>