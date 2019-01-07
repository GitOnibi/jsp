<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="JSPprojec.Order" %>
<%
	String select = request.getParameter("select");
	Order order = new Order();
	if( (Order)request.getAttribute("order") != null ) {
		order = (Order)request.getAttribute("order");
	}
	out.println( "의자수량 " + order.getChairNum() + "<br />");
	out.println( "의자가격 " + order.getChairPrice() + "<br />");
	out.println( "책상수량 " + order.getDeskNum() + "<br />");
	out.println( "책상가격 " + order.getDeskPrice() + "<br />");
	out.println( "총 가격 " + order.getTotal() + "<br />");
%>
<section id="conLeft">
	conLeft 기본내용<br /><br />
	conLeft 기본내용<br /><br />
	conLeft 기본내용<br /><br />
	conLeft 기본내용<br /><br />
	conLeft 기본내용<br /><br />
	conLeft 기본내용<br /><br />
</section>
<%
	if(select.equals("1")) {
%>
	<form action="ex01_enter_left.jsp" method="GET">
		의자수량 : <input type="text" id="chairNum" name="chairNum"/><br />
		의자가격 : <input type="text" id="chairPrice" name="chairPrice" /><br />
		책상수량 : <input type="text" id="deskNum" name="deskNum" /><br />
		책상가격 : <input type="text" id="deskPrice" name="deskPrice" /><br />
		<input type="submit" value="제출"/>
	</form>
	
<%
	}
%>
