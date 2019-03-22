<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<header id="header">
			<jsp:include page="dev_gnb.jsp" />
		</header>
		<div id="contents">
			<button onclick="show_insert();">신규등록</button>
			<div class="insert">
				<h3>신규등록</h3>
				<button class="closeBtn">닫기</button>
				<form action="item_insert.dev" method="POST">
					<span>코드</span>
					<input type="text" name="item_code" class="ins_"/>
					<span>이름</span>
					<input type="text" name="item_name" class="ins_"/>
					<span>공격력</span>
					<input type="text" name="item_atk" class="ins_"/>
					<span>방어력</span>
					<input type="text" name="item_def" class="ins_"/><br />
					<span>옵션1</span>
					<input type="text" name="item_opt1" class="ins_"/>
					<span>옵션2</span>
					<input type="text" name="item_opt2" class="ins_"/>
					<span>옵션3</span>
					<input type="text" name="item_opt3" class="ins_"/>
					<span>옵션4</span>
					<input type="text" name="item_opt4" class="ins_"/>
					<span>옵션5</span>
					<input type="text" name="item_opt5" class="ins_"/><br />
					<span>설명</span>
					<textarea rows="4" cols="50" name="item_sub" class="ins_"></textarea><br />
					<span>장착속성</span>
					<select name="item_prop" class="ins_">
						<option value="1">무기</option>
						<option value="2">갑옷</option>
						<option value="3">장갑</option>
						<option value="4">신발</option>
						<option value="5">보조</option>
					</select>
					<span>가격</span>
					<input type="text" name="item_price" class="ins_"/>
					<input type="submit" value="등록"/>
				</form>
			</div>
			<div class="modify">
				<h3>수정하기</h3>
				<button class="closeBtn">닫기</button>
				<form action="item_modify.dev" method="POST">
					<span>코드</span>
					<input type="text" name="item_code" class="mod_" readonly="readonly"/>
					<span>이름</span>
					<input type="text" name="item_name" class="mod_"/>
					<span>공격력</span>
					<input type="text" name="item_atk" class="mod_"/>
					<span>방어력</span>
					<input type="text" name="item_def" class="mod_"/><br />
					<span>옵션1</span>
					<input type="text" name="item_opt1" class="mod_"/>
					<span>옵션2</span>
					<input type="text" name="item_opt2" class="mod_"/>
					<span>옵션3</span>
					<input type="text" name="item_opt3" class="mod_"/>
					<span>옵션4</span>
					<input type="text" name="item_opt4" class="mod_"/>
					<span>옵션5</span>
					<input type="text" name="item_opt5" class="mod_"/><br />
					<span>설명</span>
					<textarea rows="4" cols="50" name="item_sub" class="mod_"></textarea><br />
					<span>장착속성</span>
					<select name="item_prop" class="mod_">
						<option value="1">무기</option>
						<option value="2">갑옷</option>
						<option value="3">장갑</option>
						<option value="4">신발</option>
						<option value="5">보조</option>
					</select>
					<span>가격</span>
					<input type="text" name="item_price" class="mod_"/>
					<input type="submit" value="수정"/>
				</form>
			</div>
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
					<th>장착위치</th>
					<th>가격</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${list}" var="row">
				<tr class="r_${row.item_code}">
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
					<c:if test="${row.item_prop == 1}"><td>무기</td></c:if>
					<c:if test="${row.item_prop == 2}"><td>갑옷</td></c:if>
					<c:if test="${row.item_prop == 3}"><td>장갑</td></c:if>
					<c:if test="${row.item_prop == 4}"><td>신발</td></c:if>
					<c:if test="${row.item_prop == 5}"><td>보조</td></c:if>
					<td>${row.item_price}</td>
					<td><button class="modifyBtn">수정</button></td>
					<td><button class="deleteBtn">삭제</button></td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<footer id="footer">
			<jsp:include page="dev_script.jsp" />
		</footer>
	</div>
</body>
</html>