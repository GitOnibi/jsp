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
			<jsp:include page="gnb.jsp" />
		</header>
		<div id="contents">
			<div>
				<h1>소지아이템</h1>
				<table border="1px">
					<tr>
						<c:forEach items="${inven_list}" var="row">
						<td>${row.item_name}</td>
						</c:forEach>
					</tr>
				</table>
			</div>
			<div class="insert on">
				<h1>착용중 아이템</h1>
				<table border="1px" class="data_tbl">
					<tr>
						<th>무기</th>
						<th>갑옷</th>
						<th>장갑</th>
						<th>신발</th>
						<th>보조1</th>
						<th>보조2</th>
						<th>보조3</th>
						<th>스킬1</th>
						<th>스킬2</th>
						<th>장비변경</th>
					</tr>
					<tr>
						<c:forEach items="${equip_list}" var="row">
						<td>
							<select name="weapon" class="li_${row.char_name}">
								<c:if test="${row.weapon_code == 0}"><option value="0">없음</option></c:if>
								<option value="${row.weapon_code}">${row.weapon_name}</option>
							</select>
						</td>
						<td>
							<select name="amor" class="li_${row.char_name}">
								<c:if test="${row.amor_code == 0}"><option value="0">없음</option></c:if>
								<option value="${row.amor_code}">${row.amor_name}</option>
							</select>
						</td>
						<td>
							<select name="gloves" class="li_${row.char_name}">
								<c:if test="${row.gloves == 0}"><option value="0">없음</option></c:if>
								<option value="${row.gloves}">${row.item_name}</option>
							</select>
							<input type="text" value="${row.gloves}" name="gloves" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="text" value="${row.boots}" name="boots" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="text" value="${row.sub1}" name="sub1" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="text" value="${row.sub2}" name="sub2" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="text" value="${row.sub3}" name="sub3" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="text" value="0" name="sk1" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="text" value="0" name="sk2" readonly class="li_${row.char_name}"/>
						</td>
						<td>
							<input type="button" value="장비변경" onclick="show_modify(event, '${row.char_name}');"/>
						</td>
						</c:forEach>
					</tr>
				</table>
			</div>
			<div class="modify">
				<h1>착용가능 아이템</h1>
				<table border="1px" class="data_tbl">
					<tr>
						<th>무기</th>
						<th>갑옷</th>
						<th>장갑</th>
						<th>신발</th>
						<th>보조1</th>
						<th>보조2</th>
						<th>보조3</th>
						<th>스킬1</th>
						<th>스킬2</th>
						<th>장비적용</th>
					</tr>
					<tr>
						<form action="equip_modify.do" method="POST" id="modFrm">
						<td>
							<select name="weapon" class="mod_">
							<c:forEach items="${weapon_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="amor" class="mod_">
							<c:forEach items="${amor_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="gloves" class="mod_">
							<c:forEach items="${gloves_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="boots" class="mod_">
							<c:forEach items="${boots_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="sub1" class="mod_">
							<c:forEach items="${sub_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="sub2" class="mod_">
							<c:forEach items="${sub_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="sub3" class="mod_">
							<c:forEach items="${sub_list}" var="row">
								<option value="0">없음</option>
								<option value="${row.item_code}">${row.item_name}</option>
							</c:forEach>
							</select>
						</td>
						<td>
							<select name="sk1" class="mod_">
								<option value="0">없음</option>
							</select>
						</td>
						<td>
							<select name="sk2" class="mod_">
								<option value="0">없음</option>
							</select>
						</td>
						<td><input type="button" value="장비적용" onclick="do_modify(event)"/></td>
						</form>
					</tr>
				</table>
			</div>
		</div>
		<div id="footer">
			<jsp:include page="script.jsp" />
		</div>
	</div>
</body>
</html>