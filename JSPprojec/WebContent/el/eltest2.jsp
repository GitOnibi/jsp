<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.test.score, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="elfn" uri="../WEB-INF/tlds/el_func.tld" %>
<fmt:requestEncoding value="UTF-8"/>

<%
	score p1 = new score();
	request.setAttribute("p1", p1);

%>
${ p1.setName("용지혁") }
${ p1.setKor(30) }
${ p1.setEng(50) }
${ p1.setMat(90) }
이름 : ${ p1.getName() } / 평균 : ${ p1.avg() }<br />
<br />
<%
	List<Integer> arr = Arrays.asList(10, 20, 30, 40, 50);
	request.setAttribute("arr", arr);
%>
${ elfn:sum(arr) }<br />
<br />
<c:set var="big" value="0" />
${ big = (a, b) -> a < b ? true : false;'' }
${ big(3, 4) }<br />
${ total = (num) -> num == 10 ? 10 : num + total(num + 1);'' }
${ total(1) }<br />

${ avg = (a, b, c) -> (a + b + c) / 3;'' }
${ avg(10, 20, 30) }