<%@ tag body-content = "scriptless" pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%
	HttpSession ss = request.getSession();
	if(ss == null || ss.getAttribute("user") == null) {
%>
<jsp:doBody />
<%
	}
%>