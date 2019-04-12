<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.attack"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="field_sel.ls?no=${mon.f_num }">이전</a>
${attack.mon(mon,User,num) }
공격중
</body>
</html>