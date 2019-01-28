<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<form action="Student" method="GET">
		학과명 : <input type="text" name="dep_name"/><br />
		학생이름 : <input type="text" name="stu_name"/><br />
		첫번째 성적 : <input type="text" name="score1"/><br />
		두번째 성적 : <input type="text" name="score2"/><br />
		세번째 성적 : <input type="text" name="score3"/><br />
		<input type="submit" value="제출"/>
	</form>
</body>
</html>