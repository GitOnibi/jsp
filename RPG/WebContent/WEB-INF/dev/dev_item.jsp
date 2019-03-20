<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reset.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" />
<title>Insert title here</title>
<script type="text/javascript">
	function insert() {
		var item_insert = document.querySelector(".item_insert");
		item_insert.classList.toggle("on");
	}
</script>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<jsp:include page="dev_title.jsp" />
			<jsp:include page="dev_gnb.jsp" />
		</header>
		<div id="contents">
			<button onclick="insert();">신규등록</button>
			<table border="1px">
				<tr>
					<th>코드</th>
					<th>이름</th>
					<th>공격력</th>
					<th>방어력</th>
					<th>옵션1</th>
					<th>옵션2</th>
					<th>옵션3</th>
					<th>옵션4</th>
					<th>옵션5</th>
					<th>설명</th>
					<th>장착속성</th>
					<th>가격</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${list}" var="row">
				<tr>
					<td>${row.item_code}</td>
					<td>${row.item_name}</td>
					<td>${row.item_atk}</td>
					<td>${row.item_def}</td>
					<td>${row.item_opt1}</td>
					<td>${row.item_opt2}</td>
					<td>${row.item_opt3}</td>
					<td>${row.item_opt4}</td>
					<td>${row.item_opt5}</td>
					<td>${row.item_sub}</td>
					<td>${row.item_prop}</td>
					<td>${row.item_price}</td>
					<td><button onclick="">수정</button></td>
					<td><button onclick="">삭제</button></td>
				</tr>
				</c:forEach>
			</table>
			<div class="item_insert">
				<form action="item_insert.dev" method="POST">
					<label for="item_code">코드</label><input type="text" name="item_code" id="item_code"/>
					<label for="item_name">이름</label><input type="text" name="item_name" id="item_name"/>
					<label for="item_atk">공격력</label><input type="text" name="item_atk" id="item_atk"/>
					<label for="item_def">방어력</label><input type="text" name="item_def" id="item_def"/><br />
					<label for="item_opt1">옵션1</label><input type="text" name="item_opt1" id="item_opt1"/>
					<label for="item_opt2">옵션2</label><input type="text" name="item_opt2" id="item_opt2"/>
					<label for="item_opt3">옵션3</label><input type="text" name="item_opt3" id="item_opt3"/>
					<label for="item_opt4">옵션4</label><input type="text" name="item_opt4" id="item_opt4"/>
					<label for="item_opt5">옵션5</label><input type="text" name="item_opt5" id="item_opt5"/><br />
					<label for="item_sub">설명</label><textarea rows="4" cols="50" name="item_sub" id="item_sub"></textarea><br />
					<label for="item_prop">장착속성</label><input type="text" name="item_prop" id="item_prop"/>
					<label for="item_price">가격</label><input type="text" name="item_price" id="item_price"/>
					<input type="submit" value="등록"/>
				</form>
				<button onclick="insert();">취소</button>
			</div>
		</div>
	</div>
</body>
</html>