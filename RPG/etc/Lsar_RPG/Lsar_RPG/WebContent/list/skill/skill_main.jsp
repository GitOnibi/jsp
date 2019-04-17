<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.transform"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fieldset>
<legend>등록된 스킬</legend>
<table>
	<tr class=skill_title>
		<th width=100>이름</th>
		<th width=60>타입</th>
		<th width=60>속성</th>
		<th width=50>공격</th>
		<th width=50>방어</th>
		<th width=50>공격업</th>
		<th width=50>방어업</th>
		<th width=50>장착</th>
	</tr>
	<c:forEach items="${skill }" var="list">
		<tr class=skill_t>
			<td>${list.getName() }</td>
			<td>${transform.skill_f(list.getType()) }</td>
			<td>${transform.skill_f(list.getKind()) }</td>
			<td>${list.getOption1() }</td>
			<td>${list.getOption2() }</td>
			<td>${list.getOption3() }</td>
			<td>${list.getOption4() }</td>
			<td><a href="skill_mng.ls?cd=${list.getCode() }&us=${list.getUsing() }">${list.getUsing() }</a></td>
		</tr>
	</c:forEach>
</table>
</fieldset>
<!-- <a href="skill_mng.ls">스킬 관리</a> -->



