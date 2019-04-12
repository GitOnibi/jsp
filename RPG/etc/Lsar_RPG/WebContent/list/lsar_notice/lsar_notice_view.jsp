<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function listBack(){
	history.back();
}
</script>
</head>
<body>
<form action="notice_md.do" method="post">
<input type=hidden name=no value=${data.nt.num }>
	<table>
		<tr>
			<td width=80>작성자</td>
			<td width=150 align=left>${data.nt_data.writer }</td>
		</tr>
		<tr>
			<td width=80>제목</td>
			<td width=150 align=left>${data.nt_data.title}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${data.nc_data.content }</td>
		</tr>
		<tr>
			<td colspan=2>
			<input type=button value="목록" onclick="listBack()">
			<input type=submit value="수정"></td>
		</tr>
	</table>
	
</form>
</body>
</html>