<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="l" tagdir="/WEB-INF/tags" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LSAR_RPG</title>
<link rel="stylesheet" type="text/css" href=sty.css>

</head>
<body>
<l:not_login>
	<script>
	location.href="mem_check.do";
	</script>
</l:not_login>	
<l:has_login>
	<div id=main>
		<div >
			<%@include file="inc/top.jsp"%>
		</div>
		<div id=cont>
			<div id=left>
				<%@include file="inc/left.jsp"%>
			</div>
			<div id=center>
				<%@include file="inc/center.jsp"%>
			</div>
		</div>
	</div>
</l:has_login>
</body>
</html>