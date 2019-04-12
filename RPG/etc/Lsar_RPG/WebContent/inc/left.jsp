<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.number_f"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="total" value="${User.sword+User.spell+User.divine }"/>
<c:set var="sword" value="${User.sword/total*100 }"/>
<c:set var="spell" value="${User.spell/total*100 }"/>
<c:set var="divine"  value="${User.divine/total*100 }"/>

<br><p><a href="mem_check.do">첫화면</a></p>
<p><a href="logout.do">로그아웃</a></p><br>

<div class=u_info>
<table>
	<tr>
		<td class="u_title">${User.id }&nbsp;</td>
		<td class="u_cont"> LV.${User.level}</td>
	</tr>
	<tr>
		<td class="u_title">국가 :</td>
		<td class="u_cont"> ${User.national}</td>
	</tr>
	<tr>
		<td class="u_title">등급 : </td>
		<td class="u_cont">${User.rank}</td>
	</tr>
	<tr>
		<td class="u_title">검술 : </td>
		<td class="u_cont">${number_f.num(sword,"#.##")}%</td>
	</tr>
	<tr>
		<td class="u_title">마법 : </td>
		<td class="u_cont">${number_f.num(spell,"#.##")}%</td>
	</tr>
	<tr>
		<td class="u_title">신성 : </td>
		<td class="u_cont">${number_f.num(divine,"#.##")}%</td>
	</tr>
	<tr><td height=20></td></tr>
	<tr>
		<td class="u_title">HP : </td>
		<td class="u_cont">${User.hp }</td>
	</tr>
	<tr>
		<td class="u_title">MP : </td>
		<td class="u_cont">${User.mp }</td>
	</tr>
	<tr>
		<td class="u_title">DP : </td>
		<td class="u_cont">${User.dp }</td>
	</tr>
	<tr>
		<td class="u_title">피로도 : </td>
		<td class="u_cont">${User.fatigue}</td>
	</tr>
	<tr>
		<td class="u_title">현재위치 : </td>
		<td class="u_cont">${User.fatigue}%</td>
	</tr>
</table>
</div>