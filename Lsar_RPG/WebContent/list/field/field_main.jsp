<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
 	<c:forEach items="${field }" var="list" varStatus="st">
 		<c:if test="${st.index/3==0 }"><tr></c:if>
 			<td width=100>국가 : ${list.national}
 			
 			<c:forEach items="${list.name }" var="named">
 				<br><a href="field_sel.ls?no=${named.field_num }">${named.field_name}</a>
 			</c:forEach>
 			</td>
 		<c:if test="${st.index%3==2 }"></tr></c:if>
 	</c:forEach>
 </table>