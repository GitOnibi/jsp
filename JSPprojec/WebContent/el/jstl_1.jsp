<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>


<%-- 해당 국가의 시간을 가져옴 --%>
<fmt:timeZone value="Korea/Seoul">
	<fmt:formatDate value="<%=new Date() %>" /><br />
</fmt:timeZone>

<%-- 시간을 변수처럼 사용 --%>
<fmt:setTimeZone value="Korea/Seoul" var="local"/>

<%--
한국 <br />
<fmt:setLocale value="ko_KR"/>
<fmt:bundle basename="com.test.my">
	<fmt:message key="name" /> <br />
	<fmt:message key="age" >
		<fmt:param value="32" /> <br />
	</fmt:message>
	<fmt:message key="national"/> <br />
</fmt:bundle>
 <br />
미국 <br />
<fmt:setLocale value="en_US"/>
<fmt:bundle basename="com.test.my">
	<fmt:message key="name"/> <br />
	<fmt:message key="age" >
		<fmt:param value="31" /> <br />
	</fmt:message>
	<fmt:message key="national"/> <br />
</fmt:bundle>
<br /><br /><br />
--%>


<fmt:bundle basename="com.test.fmtTest" prefix="intro.">
	<fmt:message key="name" /><br />
	<fmt:message key="age" /><br />
	<fmt:message key="national" /><br />
</fmt:bundle>
<fmt:setLocale value="ko_KR"/>
<fmt:formatNumber value="123456789" type="currency" /><br />
<fmt:setLocale value="en_US"/>
<fmt:formatNumber value="123456789" type="currency" /><br />
<fmt:setLocale value="ko_KR"/>
<fmt:formatNumber value="123456789" type="number" maxIntegerDigits="3" /><br />
<fmt:formatNumber value="123456789" type="number" minIntegerDigits="3" /><br />
<fmt:formatNumber value="123.456789" type="number" maxFractionDigits="3" /><br />
<fmt:formatNumber value="123.456789" type="number" minFractionDigits="3" /><br />
<fmt:formatNumber value="0.5" type="percent" /><br />
<fmt:formatNumber value="123456789" type="number" pattern="#,###E0" /><br />
<fmt:formatNumber value="123456789" type="currency" currencySymbol="@" /><br /><br /><br />

<c:set var="now" value="<%=new Date() %>" />
date : <fmt:formatDate type="date" value="${ now }"/><br />
date : <fmt:formatDate type="date" pattern="yy/mm/dd" value="${ now }"/><br />
time : <fmt:formatDate type="time" value="${ now }"/><br />
time : <fmt:formatDate type="time" pattern="ss/mm/hh" value="${ now }"/><br />
both : <fmt:formatDate type="both" value="${ now }" dateStyle="short" timeStyle="short"/><br />
both : <fmt:formatDate type="both" value="${ now }" dateStyle="medium" timeStyle="medium"/><br />
both : <fmt:formatDate type="both" value="${ now }" dateStyle="long" timeStyle="long"/><br />