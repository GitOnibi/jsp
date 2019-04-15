<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function d_check(){
	var ids =document.getElementById("id").value;
	location.href="idcheck.do?id="+ids;
}
</script>
</head>
<body>
<form action="enter.do" method="post">
<table>
	<tr>
		<td>아이디 : </td>
		<td>
			<input type=text name=id id=id>
			<input type=button value="중복체크" onclick='d_check()'>
			<c:if test="${err.id ==true}">아이디를 입력하세요!</c:if>

			<c:if test="${!empty err.dup }">
			<c:choose>
				<c:when test="${err.dup }">
					사용중인 아이디
				</c:when>
				<c:otherwise>
					사용 가능 한 아이디
				</c:otherwise>
			</c:choose>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td><input type=text name=pw>
		<c:if test="${err.password==true }">암호를 입력하세요!</c:if>
		</td>
	</tr>
	<tr>
		<td>비밀번호확인 : </td>
		<td><input type=text name=pw_cmp>
		<c:if test="${err.Cmp_pw==true}">확인을 입력하세요!</c:if>
		<c:if test="${err.NotMatch==true}">암호가 일치하지않습니다.</c:if>
		</td>
	</tr>
	<tr>
		<td>EMAIL : </td>
		<td><input type=text name=email></td>
	</tr>
</table>
<input type=submit value="등록">

</form>
</body>
</html>