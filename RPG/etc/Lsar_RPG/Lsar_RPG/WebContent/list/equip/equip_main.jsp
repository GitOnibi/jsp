<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.transform"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
<tr>
<th>번호</th>
<th width=80>장비명</th>
<th width=120>장비 타입</th>
<th width=80>옵션1</th>
<th width=80>옵션2</th>
<th width=80>옵션3</th>
<th width=80>옵션4</th>
</tr>
 	<c:forEach items="${item }" var="list" varStatus="st">
 		<tr>
 			<td>${st.index+1 }	</td>
 			<td>${list.equip_name }</td>
 			<td>${transform.itemtype_f(list.equip_type) }</td>
 			<td>${transform.itemop_f(list.equip_type,1) }/${list.option1}</td>
 			<td>${transform.itemop_f(list.equip_type,2) }/${list.option2 }</td>
 			<td>${transform.itemop_f(list.equip_type,3) }/${list.option3 }</td>
 			<td>${transform.itemop_f(list.equip_type,4) }/${list.option4 }</td>
 		<td><a href="equip_mng.ls?cd=${list.num }&us=${list.using }">${list.using }</a></td>
 		</tr>
 	</c:forEach>
 </table>