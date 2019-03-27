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
				<button onclick="closeParent(event);">닫기</button>
				<form action="item_insert.dev" method="POST" id="insFrm">
					<span>코드</span>
					<input type="text" name="item_code" class="ins_"/>
					<span>이름</span>
					<input type="text" name="item_name" class="ins_"/>
					<span>공격력</span>
					<input type="text" name="item_atk" class="ins_"/>
					<span>방어력</span>
					<input type="text" name="item_def" class="ins_"/><br />
					<span>설명</span>
					<textarea rows="4" cols="50" name="item_sub" class="ins_"></textarea><br />
					<span>장착속성</span>
					<select name="item_prop" class="ins_">
						<option value="0">없음</option>
						<option value="1">무기</option>
						<option value="2">갑옷</option>
						<option value="3">장갑</option>
						<option value="4">신발</option>
						<option value="5">보조</option>
					</select>
					<span>가격</span>
					<input type="text" name="item_price" class="ins_"/>
					<input type="button" value="등록" onclick="do_insert(event);"/>
				</form>
			</div>
			<div class="modify">
				<h3>수정하기</h3>
				<button onclick="closeParent(event);">닫기</button>
				<form action="item_modify.dev" method="POST" id="modFrm">
					<span>코드</span>
					<input type="text" name="item_code" class="mod_" readonly/>
					<span>이름</span>
					<input type="text" name="item_name" class="mod_"/>
					<span>공격력</span>
					<input type="text" name="item_atk" class="mod_"/>
					<span>방어력</span>
					<input type="text" name="item_def" class="mod_"/><br />
					<span>설명</span>
					<textarea rows="4" cols="50" name="item_sub" class="mod_"></textarea><br />
					<span>장착속성</span>
					<select name="item_prop" class="mod_">
						<option value="0">없음</option>
						<option value="1">무기</option>
						<option value="2">갑옷</option>
						<option value="3">장갑</option>
						<option value="4">신발</option>
						<option value="5">보조</option>
					</select>
					<span>가격</span>
					<input type="text" name="item_price" class="mod_"/>
					<input type="button" value="수정"  onclick="do_modify(event);"/>
				</form>
			</div>
			<div>
				<table border="1px" class="data_tbl">
					<tr>
						<th>코드</th>
						<th>이름</th>
						<th>공격력</th>
						<th>방어력</th>
						<th>설명</th>
						<th>장착위치</th>
						<th>가격</th>
						<th>수정</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${list}" var="row">
					<tr>
						<form action="item_delete.dev" method="POST" id="li_${row.item_code}">
						<td><input type="text" value="${row.item_code}" name="item_code" readonly class="li_${row.item_code}"/></td>
						<td><input type="text" value="${row.item_name}" name="item_name" readonly class="li_${row.item_code}"/></td>
						<td><input type="text" value="${row.item_atk}" name="item_atk" readonly class="li_${row.item_code}"/></td>
						<td><input type="text" value="${row.item_def}" name="item_def" readonly class="li_${row.item_code}"/></td>
						<td><textarea name="item_sub" readonly class="li_${row.item_code}">${row.item_sub}</textarea></td>
						<td>
							<select name="item_prop" class="li_${row.item_code}">
								<c:if test="${row.item_prop == 0}"><option value="${row.item_prop}">없음</option></c:if>
								<c:if test="${row.item_prop == 1}"><option value="${row.item_prop}">무기</option></c:if>
								<c:if test="${row.item_prop == 2}"><option value="${row.item_prop}">갑옷</option></c:if>
								<c:if test="${row.item_prop == 3}"><option value="${row.item_prop}">장갑</option></c:if>
								<c:if test="${row.item_prop == 4}"><option value="${row.item_prop}">신발</option></c:if>
								<c:if test="${row.item_prop == 5}"><option value="${row.item_prop}">보조</option></c:if>
							</select>
						</td>
						<td><input type="text" value="${row.item_price}" name="item_price" readonly class="li_${row.item_code}"/></td>
						<td><input type="button" value="수정" onclick="show_modify(event, '${row.item_code}');"/></td>
						<td><input type="button" value="삭제" onclick="do_delete(event, '#li_${row.item_code}');"/></td>
						</form>
					</tr>
					</c:forEach>
					</table>
				</div>
			</div>
		<footer id="footer">
			<jsp:include page="dev_script.jsp" />
		</footer>
	</div>
</body>
</html>