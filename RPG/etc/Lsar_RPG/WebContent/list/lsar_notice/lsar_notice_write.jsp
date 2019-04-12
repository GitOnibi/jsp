<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="notice_wr.do" method="post">
	<table>
		<tr>
			<td width=80>제목</td>
			<td width=150 align=left><input type=text name=title></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea rows=10 cols=20 name=cont></textarea></td>
		</tr>
		<tr>
			<td colspan=2><input type=submit value="등록"></td>
		</tr>
	</table>
	
</form>
</body>
</html>