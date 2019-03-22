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
				<form action="mob_insert.dev" method="POST">
					<span>코드</span>
					<input type="text" name="mob_code" class="ins_"/>
					<span>이름</span>
					<input type="text" name="mob_name" class="ins_"/>
					<span>레벨</span>
					<input type="text" name="mob_lv" class="ins_"/>
					<span>완력</span>
					<input type="text" name="mob_str" class="ins_"/><br />
					<span>민첩</span>
					<input type="text" name="mob_dex" class="ins_"/>
					<span>속성</span>
					<select name="mob_prop" class="ins_">
						<option value="1">곤충</option>
						<option value="2">네크로파지</option>
						<option value="3">악령</option>
						<option value="4">뱀파이어</option>
						<option value="5">드라코니드</option>
						<option value="6">오그로이드</option>
						<option value="7">정령</option>
						<option value="8">잔존생물</option>
						<option value="9">야수</option>
						<option value="10">잡종</option>
						<option value="11">저주받은존재</option>
						<option value="12">인간</option>
					</select>
					<span>옵션1</span>
					<input type="text" name="mob_opt1" class="ins_"/>
					<span>옵션2</span>
					<input type="text" name="mob_opt2" class="ins_"/>
					<span>옵션3</span>
					<input type="text" name="mob_opt3" class="ins_"/><br />
					<span>옵션4</span>
					<input type="text" name="mob_opt4" class="ins_"/><br />
					<span>옵션5</span>
					<input type="text" name="mob_opt5" class="ins_"/><br />
					<span>스킬1</span>
					<input type="text" name="mob_sk1" class="ins_"/>
					<span>스킬2</span>
					<input type="text" name="mob_sk2" class="ins_"/>
					<span>스킬3</span>
					<input type="text" name="mob_sk3" class="ins_"/><br />
					<span>스킬4</span>
					<input type="text" name="mob_sk4" class="ins_"/><br />
					<span>스킬5</span>
					<input type="text" name="mob_sk5" class="ins_"/><br />
					<span>설명</span>
					<textarea rows="4" cols="50" name="mob_sub" class="ins_"></textarea><br />
					<span>공격력</span>
					<input type="text" name="mob_atk" class="ins_"/>
					<span>방어력</span>
					<input type="text" name="mob_def" class="ins_"/>
					<span>체력</span>
					<input type="text" name="mob_hp" class="ins_"/>
					<input type="submit" value="등록"/>
				</form>
			</div>
			<div class="modify">
				<h3>수정하기</h3>
				<button class="closeBtn">닫기</button>
				<form action="mob_modify.dev" method="POST">
					<span>코드</span>
					<input type="text" name="mob_code" class="mod_" readonly="readonly"/>
					<span>이름</span>
					<input type="text" name="mob_name" class="mod_"/>
					<span>레벨</span>
					<input type="text" name="mob_lv" class="mod_"/>
					<span>완력</span>
					<input type="text" name="mob_str" class="mod_"/><br />
					<span>민첩</span>
					<input type="text" name="mob_dex" class="mod_"/>
					<span>속성</span>
					<select name="mob_prop" class="mod_">
						<option value="1">곤충</option>
						<option value="2">네크로파지</option>
						<option value="3">악령</option>
						<option value="4">뱀파이어</option>
						<option value="5">드라코니드</option>
						<option value="6">오그로이드</option>
						<option value="7">정령</option>
						<option value="8">잔존생물</option>
						<option value="9">야수</option>
						<option value="10">잡종</option>
						<option value="11">저주받은존재</option>
						<option value="12">인간</option>
					</select>
					<span>옵션1</span>
					<input type="text" name="mob_opt1" class="mod_"/>
					<span>옵션2</span>
					<input type="text" name="mob_opt2" class="mod_"/>
					<span>옵션3</span>
					<input type="text" name="mob_opt3" class="mod_"/><br />
					<span>옵션4</span>
					<input type="text" name="mob_opt4" class="mod_"/><br />
					<span>옵션5</span>
					<input type="text" name="mob_opt5" class="mod_"/><br />
					<span>스킬1</span>
					<input type="text" name="mob_sk1" class="mod_"/>
					<span>스킬2</span>
					<input type="text" name="mob_sk2" class="mod_"/>
					<span>스킬3</span>
					<input type="text" name="mob_sk3" class="mod_"/><br />
					<span>스킬4</span>
					<input type="text" name="mob_sk4" class="mod_"/><br />
					<span>스킬5</span>
					<input type="text" name="mob_sk5" class="mod_"/><br />
					<span>설명</span>
					<textarea rows="4" cols="50" name="mob_sub" class="mod_"></textarea><br />
					<span>공격력</span>
					<input type="text" name="mob_atk" class="mod_"/>
					<span>방어력</span>
					<input type="text" name="mob_def" class="mod_"/>
					<span>체력</span>
					<input type="text" name="mob_hp" class="mod_"/>
					<input type="submit" value="수정"/>
				</form>
			</div>
			<table border="1px">
				<tr>
					<td>코드</td>
					<td>이름</td>
					<td>레벨</td>
					<td>완력</td>
					<td>민첩</td>
					<td>속성</td>
					<td>옵션1	</td>
					<td>옵션2	</td>
					<td>옵션3	</td>
					<td>옵션4	</td>
					<td>옵션5	</td>
					<td>스킬1	</td>
					<td>스킬2	</td>
					<td>스킬3	</td>
					<td>스킬4	</td>
					<td>스킬5	</td>
					<td>설명</td>
					<td>공격력</td>
					<td>방어력</td>
					<td>체력</td>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${list}" var="row">
				<tr class="r_${row.mob_code}">
					<td>${row.mob_code}</td>
					<td>${row.mob_name}</td>
					<td>${row.mob_lv}</td>
					<td>${row.mob_str}</td>
					<td>${row.mob_dex}</td>
					<c:if test="${row.mob_prop == 1}"><td>곤충</td></c:if>      
					<c:if test="${row.mob_prop == 2}"><td>네크로파지</td></c:if>
					<c:if test="${row.mob_prop == 3}"><td>악령</td></c:if>      
					<c:if test="${row.mob_prop == 4}"><td>뱀파이어</td></c:if>     
					<c:if test="${row.mob_prop == 5}"><td>드라코니드</td></c:if>
					<c:if test="${row.mob_prop == 6}"><td>오그로이드</td></c:if>
					<c:if test="${row.mob_prop == 7}"><td>정령</td></c:if>      
					<c:if test="${row.mob_prop == 8}"><td>잔존생물</td></c:if>   
					<c:if test="${row.mob_prop == 9}"><td>야수</td></c:if>      
					<c:if test="${row.mob_prop == 10}"><td>잡종</td></c:if>     
					<c:if test="${row.mob_prop == 11}"><td>저주받은존재</td></c:if>
					<c:if test="${row.mob_prop == 12}"><td>인간</td></c:if>
					<td>${row.mob_opt1}</td>
					<td>${row.mob_opt2}</td>
					<td>${row.mob_opt3}</td>
					<td>${row.mob_opt4}</td>
					<td>${row.mob_opt5}</td>
					<td>${row.mob_sk1}</td>
					<td>${row.mob_sk2}</td>
					<td>${row.mob_sk3}</td>
					<td>${row.mob_sk4}</td>
					<td>${row.mob_sk5}</td>
					<td>${row.mob_sub}</td>
					<td>${row.mob_atk}</td>
					<td>${row.mob_def}</td>
					<td>${row.mob_hp}</td>
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