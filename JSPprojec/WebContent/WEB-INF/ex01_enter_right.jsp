<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="JSPprojec.Info" %>
<%
	int		num		= Integer.parseInt(request.getParameter("num"));
	String	name	= request.getParameter("name");
	String	p_num	= request.getParameter("p_num");
%>
<%-- 방법1
	<jsp:useBean id="prt" class="JSPprojec.Info" scope="request" />
	<%
		prt.setNum(num);
		prt.setName(name);
		prt.setP_num(p_num);
	%>
	<%=prt.getNum() %>
	<%=prt.getName() %>
	<%=prt.getP_num() %>
--%>
<%-- 방법2
	<jsp:useBean id="prt" class="JSPprojec.Info" scope="request">
		<jsp:setProperty name="prt" property="num" value="<%=num %>">
		<jsp:setProperty name="prt" property="name" value="<%=name %>">
		<jsp:setProperty name="prt" property="p_num" value="<%=p_num %>">
	</jsp:useBean>
	번호 : <jsp:getProperty name="prt" property="num" value="<%=num %>">
	이름 : <jsp:getProperty name="prt" property="name" value="<%=name %>">
	품번 : <jsp:getProperty name="prt" property="p_num" value="<%=p_num %>">
	<jsp:forward page="./ex01_conRight.jsp">
 --%>
<%-- 방법 3 --%>
	<%
		// 보낼때 객체에 리퀘스트 객체에 Attribute 로 담아서 보낸다
		Info info = new Info(num, name, p_num);
		request.setAttribute("prt", info);
		// 받을때
		// Info prt = (Info)request.getAttribute("s");
		
	%>
	<jsp:forward page="./ex01_conRight.jsp?select=1" />