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
			<%@ include file="gnb.jsp" %>
			<%@ include file="char_info.jsp" %>
		</header>
		<div id="contents">
			<div class="ueser_inven">
				<h1>상인</h1>
				<table border="1px">
					<tr>
						<c:forEach items="${npc_inven_list1}" var="row">
						<td>
							<div class="hoverable">
								<a href="" class="hoverTarget icon_${row.item_prop}"></a>
								<div class="hoverBox" style="z-index:100;">
									<p>
										<c:if test="${row.item_prop == 0}">기타</c:if>
										<c:if test="${row.item_prop == 1}">무기</c:if>
										<c:if test="${row.item_prop == 2}">갑옷</c:if>
										<c:if test="${row.item_prop == 3}">장갑</c:if>
										<c:if test="${row.item_prop == 4}">신발</c:if>
										<c:if test="${row.item_prop == 5}">보조장비</c:if>
									</p>
									<p>${row.item_name} (${row.item_price} 골드)</p>
									<c:if test="${row.item_atk != 0}"><p>공격력 : ${row.item_atk}</p></c:if>
									<c:if test="${row.item_def != 0}"><p>방어력 : ${row.item_def}</p></c:if>
									<p>설명 : ${row.item_sub}</p>
									<form action="item_buy.do" method="POST">
										<input type="hidden" name="item_code" value="${row.item_code}"/>
										<input type="hidden" name="item_price" value="${row.item_price}"/>
										<input type="submit" value="구매"/>
									</form>
								</div>
							</div>
						</td>
						</c:forEach>
					</tr>
				</table>
			</div>
			<div class="ueser_inven">
				<h1>대장장이</h1>
				<table border="1px">
					<tr>
						<c:forEach items="${npc_inven_list2}" var="row">
						<td>
							<div class="hoverable">
								<a href="" class="hoverTarget icon_${row.item_prop}"></a>
								<div class="hoverBox" style="z-index:100;">
									<p>
										<c:if test="${row.item_prop == 0}">기타</c:if>
										<c:if test="${row.item_prop == 1}">무기</c:if>
										<c:if test="${row.item_prop == 2}">갑옷</c:if>
										<c:if test="${row.item_prop == 3}">장갑</c:if>
										<c:if test="${row.item_prop == 4}">신발</c:if>
										<c:if test="${row.item_prop == 5}">보조장비</c:if>
									</p>
									<p>${row.item_name} (${row.item_price} 골드)</p>
									<c:if test="${row.item_atk != 0}"><p>공격력 : ${row.item_atk}</p></c:if>
									<c:if test="${row.item_def != 0}"><p>방어력 : ${row.item_def}</p></c:if>
									<p>설명 : ${row.item_sub}</p>
									<form action="item_buy.do" method="POST">
										<input type="hidden" name="item_code" value="${row.item_code}"/>
										<input type="hidden" name="item_price" value="${row.item_price}"/>
										<input type="submit" value="구매"/>
									</form>
								</div>
							</div>
						</td>
						</c:forEach>
					</tr>
				</table>
			</div>
			<div class="EventWrap">
				<button>의뢰게시판</button>
			</div>
			<div class="EventWrap">
				<h1>병원</h1>
				<button onclick="do_res()">치료</button>
			</div>
		</div>
		<div id="footer">
			<%@ include file="script.jsp" %>
		</div>
	</div>
</body>
</html>