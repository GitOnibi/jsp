<%@ tag body-content="scriptless" pageEncoding="utf-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>

<%
	HttpSession hsession=request.getSession(false);
	if(hsession!=null && hsession.getAttribute("User")!=null){
%>
<jsp:doBody/>
<%
	}

%>