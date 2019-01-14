<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="JSPprojec.Product" %>
<%
	String proNum	= request.getParameter("proNum");
	String proName	= request.getParameter("proName");
	String proCol	= request.getParameter("proCol");
	String proCnt	= request.getParameter("proCnt");
	String proPri	= request.getParameter("proPri");
	
	Product pro = new Product(proNum, proName, proCol, proCnt, proPri);
	
	Cookie proC_01_1 = new Cookie("proNum", proNum);
	response.addCookie(proC_01_1);
	Cookie proC_01_2 = new Cookie("proName", proName);
	response.addCookie(proC_01_2);
	Cookie proC_01_3 = new Cookie("proCol", proCol);
	response.addCookie(proC_01_3);
	Cookie proC_01_4 = new Cookie("proCnt", proCnt);
	response.addCookie(proC_01_4);
	Cookie proC_01_5 = new Cookie("proPri", proPri);
	response.addCookie(proC_01_5);
	
	request.setAttribute("pro", pro);
%>
<jsp:forward page="ex02_index.jsp" />