<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	if(id != null) { %>
	<%=id %> 님이 로그인<br/>
	
<%		if(id.equals("admin")) { %>
			<button>제품등록</button><button>제품변경</button>
<%		}else { %>
			<button>제품조회</button><button>제품주문</button>
<%		} %>
	<a href="login_ok.jsp">logout</a>
<%	} else { %>
	<form action="login_ok.jsp" method="post">
		id : <input type="text" name="id" /><br />
		pw : <input type="password" name="pw" /><br />
		<input type="submit" value="login"/>
	</form>
<%	} %>


</body>
</html>