<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String uri = request.getRequestURI();
String[] words = uri.split("/");
String reqStr = words[words.length - 1].replaceAll(".jsp", "");
%>
<c:set var="reqStr" value="<%=reqStr%>" />

<nav id="gnbWrap">
	<ul class="gnb">
		<li>
			<a href="main_map_world.do" class="${reqStr == 'main_map_world' ? 'on' : ''}">세계지도</a>
		</li>
		<li>
			<a href="main_map_detail.do" class="${reqStr == 'main_map_detail' ? 'on' : ''}">전투</a>
		</li>
		<li>
			<a href="main_inventory.do" class="${reqStr == 'main_inventory' ? 'on' : ''}">인벤토리</a>
		</li>
		<li>
			<a href="main_journal.do" class="${reqStr == 'main_journal' ? 'on' : ''}">퀘스트</a>
		</li>
		<li>
			<a href="main_dictionary.do" class="${reqStr == 'main_dictionary' ? 'on' : ''}">도감</a>
		</li>
		<li>
			<a href="main_board.do" class="${reqStr == 'main_board' ? 'on' : ''}">게시판</a>
		</li>
	</ul>
</nav>