<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id		= null;
	String pw		= null;
	try {
		id			= request.getParameter("id");
		pw			= request.getParameter("pw");
	} catch(Exception e) {
		id			= null;
		pw			= null;
		e.printStackTrace();
	}
	
	
	String[] ids	= {"admin", "hicuri", "onigawara"};
	String[] pws	= {"ad1234", "hi1234", "oni1234"};
	
	int i,
		idx = 2;
	String[] send 	= {"login.jsp?logged=yes&id=" + id, "login.jsp"};
	
	if(id != null) {
		for(i = 0; i < ids.length; i++) {
			if( id.equals(ids[i]) && pw.equals(pws[i]) ) {
				idx = 0;
			}
		}
	}
	if(idx == 2) {
		idx = 1;
	}
	response.sendRedirect(send[idx]);
%>