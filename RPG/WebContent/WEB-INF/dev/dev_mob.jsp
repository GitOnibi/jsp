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
				<form action="mob_insert.dev" method="POST" id="insFrm">
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
					<span>체력</span>
					<input type="text" name="mob_hp" class="ins_"/>
					<span>속성</span>
					<select name="mob_prop" class="ins_">
						<option value="0">없음</option>
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
					<span>공격력</span>
					<input type="text" name="mob_atk" class="ins_"/>
					<span>방어력</span>
					<input type="text" name="mob_def" class="ins_"/>
					<span>설명</span>
					<textarea rows="4" cols="50" name="mob_sub" class="ins_"></textarea><br />
					<span>스킬1</span>
					<input type="text" name="mob_sk1" class="ins_"/>
					<span>스킬2</span>
					<input type="text" name="mob_sk2" class="ins_"/>
					<span>스킬3</span>
					<input type="text" name="mob_sk3" class="ins_"/><br />
					<span>경험치</span>
					<input type="text" name="mob_exp" class="ins_"/>
					<input type="button" value="등록" onclick="do_insert(event);"/>
				</form>
			</div>
			<div class="modify">
				<h3>수정하기</h3>
				<button onclick="closeParent(event);">닫기</button>
				<form action="mob_modify.dev" method="POST" id="modFrm">
					<span>코드</span>
					<input type="text" name="mob_code" class="mod_" readonly/>
					<span>이름</span>
					<input type="text" name="mob_name" class="mod_"/>
					<span>레벨</span>
					<input type="text" name="mob_lv" class="mod_"/>
					<span>완력</span>
					<input type="text" name="mob_str" class="mod_"/><br />
					<span>민첩</span>
					<input type="text" name="mob_dex" class="mod_"/>
					<span>체력</span>
					<input type="text" name="mob_hp" class="mod_"/>
					<span>속성</span>
					<select name="mob_prop" class="mod_">
						<option value="0">없음</option>
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
					<span>공격력</span>
					<input type="text" name="mob_atk" class="mod_"/>
					<span>방어력</span>
					<input type="text" name="mob_def" class="mod_"/>
					<span>설명</span>
					<textarea rows="4" cols="50" name="mob_sub" class="mod_"></textarea><br />
					<span>스킬1</span>
					<input type="text" name="mob_sk1" class="mod_"/>
					<span>스킬2</span>
					<input type="text" name="mob_sk2" class="mod_"/>
					<span>스킬3</span>
					<input type="text" name="mob_sk3" class="mod_"/><br />
					<span>경험치</span>
					<input type="text" name="mob_exp" class="mod_"/>
					<input type="button" value="수정" onclick="do_modify(event);"/>
				</form>
			</div>
			<table border="1px" class="data_tbl">
				<tr>
					<th>코드</th>
					<th>이름</th>
					<th>레벨</th>
					<th>완력</th>
					<th>민첩</th>
					<th>체력</th>
					<th>속성</th>
					<th>공격력</th>
					<th>방어력</th>
					<th>설명</th>
					<th>스킬1	</th>
					<th>스킬2	</th>
					<th>스킬3	</th>
					<th>경험치</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${list}" var="row">
				<tr>
					<form action="mob_delete.dev" method="POST" id="li_${row.mob_code}">
					<td><input type="text" value="${row.mob_code}" name="mob_code" readonly class="li_${row.mob_code}"/></td>
					<td><input type="text" value="${row.mob_name}" name="mob_name" readonly class="li_${row.mob_code}"/></td>
					<td><input type="text" value="${row.mob_lv}" name="mob_lv" readonly class="li_${row.mob_code}"/></td>
					<td><input type="text" value="${row.mob_str}" name="mob_str" readonly class="li_${row.mob_code}"/></td>
					<td><input type="text" value="${row.mob_dex}" name="mob_dex" readonly class="li_${row.mob_code}"/></td>
					<td><input type="text" value="${row.mob_hp}" name="mob_hp" readonly class="li_${row.mob_code}" /></td>
					<td>
						<select name="mob_prop" class="li_${row.mob_code}">
							<c:if test="${row.mob_prop == 0}"><option value="0">없음</option></c:if>
							<c:if test="${row.mob_prop == 1}"><option value="1">곤충</option></c:if>      
							<c:if test="${row.mob_prop == 2}"><option value="2">네크로파지</option></c:if>
							<c:if test="${row.mob_prop == 3}"><option value="3">악령</option></c:if>      
							<c:if test="${row.mob_prop == 4}"><option value="4">뱀파이어</option></c:if>     
							<c:if test="${row.mob_prop == 5}"><option value="5">드라코니드</option></c:if>
							<c:if test="${row.mob_prop == 6}"><option value="6">오그로이드</option></c:if>
							<c:if test="${row.mob_prop == 7}"><option value="7">정령</option></c:if>      
							<c:if test="${row.mob_prop == 8}"><option value="8">잔존생물</option></c:if>   
							<c:if test="${row.mob_prop == 9}"><option value="9">야수</option></c:if>      
							<c:if test="${row.mob_prop == 10}"><option value="10">잡종</option></c:if>     
							<c:if test="${row.mob_prop == 11}"><option value="11">저주받은존재</option></c:if>
							<c:if test="${row.mob_prop == 12}"><option value="12">인간</option></c:if>
						</select>
					</td>
					<td><input type="text" value="${row.mob_atk}" name="mob_atk" readonly class="li_${row.mob_code}" /></td>
					<td><input type="text" value="${row.mob_def}" name="mob_def" readonly class="li_${row.mob_code}" /></td>
					<td><textarea name="mob_sub" readonly class="li_${row.mob_code}">${row.mob_sub}</textarea></td>
					<td><input type="text" value="${row.mob_sk1}" name="mob_sk1" readonly class="li_${row.mob_code}" /></td>
					<td><input type="text" value="${row.mob_sk2}" name="mob_sk2" readonly class="li_${row.mob_code}" /></td>
					<td><input type="text" value="${row.mob_sk3}" name="mob_sk3" readonly class="li_${row.mob_code}" /></td>
					<td><input type="text" value="${row.mob_exp}" name="mob_exp" readonly class="li_${row.mob_code}"/></td>
					<td><input type="button" value="수정" onclick="show_modify(event, '${row.mob_code}');"/></td>
					<td><input type="button" value="삭제" onclick="do_delete(event, '#li_${row.mob_code}');"/></td>
					</form>
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