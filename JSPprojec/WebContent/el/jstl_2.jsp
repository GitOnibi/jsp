<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>

<c:set var="str" value="How much is it? Buddy" />
원본텍스트 : ${ str }<br />
문자열의 길이 : ${ fn:length(str) }<br />
much의 위치 : ${ fn:indexOf(str, "much") }<br />
문자열 변경 : ${ fn:replace(str, "much is it", "old are you") }<br />
원본은 그대로 : ${ str }<br />
대문자로 : ${ fn:toUpperCase(str) }<br />
소문자로 : ${ fn:toLowerCase(str) }<br />
포함여부 : ${ fn:contains(str, "mu") }