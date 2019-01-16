<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>

<%
	List<Long> values = Arrays.asList(1L, 2L, 3L, 4L);
	request.setAttribute("val", values);
%>

${ val[2] }<br />

<c:set var="people" value="${ {'name' : '용지혁', 'age' : 33} }" />
${ people.name }<br />
${ people.age }<br />
<br />
<c:set var="eng" value="${ {'A', 'B', 'C' } }" />
${ eng }<br />
${ eng = {'E', 'F', 'G'} }<br />
${ eng }<br />
<br />
<c:set var="people" value="${ [ {'name' : '용지혁', 'age' : 33}, {'name' : '김미애', 'age' : 33}, {'name' : '김민진', 'age' : 53} ] }" />
${ people[0].name } : ${ people[0].age }<br />
<br />
${ 20 + 10 ; 40 + 50 }<br />
<br />
<c:set var="num" value="1000" />
${ num }<br/>
${ num = 10 }<br />
${ num }<br />
<br />