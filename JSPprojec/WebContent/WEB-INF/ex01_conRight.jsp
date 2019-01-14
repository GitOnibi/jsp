<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="JSPprojec.Info" %>
<%
	String select = request.getParameter("select");
	Info prt = new Info();
	if( (Info)request.getAttribute("prt") != null ) {
		prt = (Info)request.getAttribute("prt");
	}
	out.println("순번" + prt.getNum());
	out.println("이름" + prt.getName());
	out.println("품번" + prt.getP_num());
%>
	<section id="conRight">

<%--	
	<jsp:useBean id="prt" class="JSPprojec.Info" scope="request">
		<jsp:setProperty name="prt" property="num" value="${param.prt.getNum()}" />
	</jsp:useBean>
 --%>
	
	</section>
<%
if(select.equals("1")) {
%>
	<form action="./ex01_enter_right.jsp" method="GET">
		순번 : <input type="text" name="num" /><br />
		이름 : <input type="text" name="name" /><br />
		품번 : <input type="text" name="p_num" /><br />
		<input type="submit" value="등록"/>
	</form>
<%
}
%>