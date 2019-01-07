<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="JSPprojec.Order" %>
<%
	int	chairNum	= Integer.parseInt(request.getParameter("chairNum"));
	int	chairPrice	= Integer.parseInt(request.getParameter("chairPrice"));
	int	deskNum		= Integer.parseInt(request.getParameter("deskNum"));
	int	deskPrice	= Integer.parseInt(request.getParameter("deskPrice"));
%>
	<%
		// 보낼때 객체에 리퀘스트 객체에 Attribute 로 담아서 보낸다
		Order order = new Order(chairNum, chairPrice, deskNum, deskPrice);
		request.setAttribute("order", order);		
	%>
	<jsp:forward page="./ex01_conLeft.jsp?select=1" />