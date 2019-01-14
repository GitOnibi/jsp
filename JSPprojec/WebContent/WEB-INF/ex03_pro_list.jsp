<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ page import="JSPprojec.Product, java.util.*" %>
<%
	//Product pr01 = (Product)session.getAttribute("list");
	ArrayList<Product> list = (ArrayList)session.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
제품번호 : <%=pr01.getProNum() %><br />
제품이름 : <%=pr01.getProName() %><br />
제품색상 : <%=pr01.getProCol() %><br />
제품주문 : <%=pr01.getProCnt() %><br />
제품가격 : <%=pr01.getProPri() %><br />
--%>
<%
	for(int i = 0; i < list.size(); i++) {
		out.print("제품번호 : " + list.get(i).getProNum() + "<br />");
		out.print("제품이름 : " + list.get(i).getProName() + "<br />");
		out.print("제품색상 : " + list.get(i).getProCol() + "<br />");
		out.print("제품주문 : " + list.get(i).getProCnt() + "<br />");
		out.print("제품가격 : " + list.get(i).getProPri() + "<br />");
		out.print("=============================================<br />");
	}
%>
</body>
</html>