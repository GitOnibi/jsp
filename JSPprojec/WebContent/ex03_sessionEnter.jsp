<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ page import="JSPprojec.Product, java.util.*" %>
<%
	String proNum	= request.getParameter("proNum");
	String proName	= request.getParameter("proName");
	String proCol	= request.getParameter("proCol");
	String proCnt	= request.getParameter("proCnt");
	String proPri	= request.getParameter("proPri");
	
	Product pr = new Product(proNum, proName, proCol, proCnt, proPri);
	// session.setAttribute("list", pr);
	
	ArrayList<Product> list = new ArrayList<Product>();
	try {
		list = (ArrayList)session.getAttribute("list");
	}catch(Exception e) {
		e.printStackTrace();
	}
	list.add(pr);
	
	session.setAttribute("list", list);
%>
<jsp:forward page="ex03_index.jsp" />