<%@ tag body-content = "scriptless" pageEncoding="UTF-8" %>
<%@ tag trimDirectiveWhitespaces="true" %>

<%
	HttpSession ss = request.getSession(false); // false 로 명시적으로 null을 리턴
	if(ss != null && ss.getAttribute("user") != null) {
%>
<jsp:doBody />
<%
	}
%>