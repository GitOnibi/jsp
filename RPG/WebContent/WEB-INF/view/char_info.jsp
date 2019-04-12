<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="char_status">
	<h1>케릭터</h1>
	<table border="1px">
		<tr>
			<th>이름</th>
			<th>체력</th>
			<th>공격력</th>
			<th>방어력</th>
			<th>완력</th>
			<th>민첩</th>
			<th>회피율</th>
			<th>치명타율</th>
			<th>경험치</th>
			<th>골드</th>
		</tr>
		<tr>
			<c:forEach items="${char_info}" var="row">
			<td>Lv.${row.char_lv} ${row.char_name}(${row.user_id})</td>
			<td>
				${row.char_hp}
			</td>
			<td>
				${row.char_atk} + ${stat_list[0]}
			</td>
			<td>
				${row.char_def} + ${stat_list[1]}
			</td>
			<td>
				${row.char_str}
			</td>
			<td>
				${row.char_dex}
			</td>
			<td>
				${row.char_agi}
			</td>
			<td>
				${row.char_crt}
			</td>
			<td>
				${row.char_exp}
			</td>
			<td>
				${row.char_money}
			</td>
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
				<select name="equip_code" class="li_${sessionScope.char_name}">
				<c:choose>
				<c:when test="${row.item_code == 0 || row.item_code == null}">
					<option value="0">없음</option>
				</c:when>
				<c:otherwise>
					<option value="${row.item_code}">${row.item_name}</option>
				</c:otherwise>
				</c:choose>
				</select>
			</td>
			</c:forEach>
			<td>
				<input type="button" value="장비변경" onclick="show_modify(event, '${sessionScope.char_name}');"/>
			</td>
		</tr>
	</table>
</div>
<div class="modify">
	<h1>착용가능 아이템</h1>
	<form action="equip_modify.do" method="POST" id="modFrm">
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
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${weapon_list}" var="row">
					<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${amor_list}" var="row">
						<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${gloves_list}" var="row">
					<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${boots_list}" var="row">
					<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${sub_list}" var="row">
					<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${sub_list}" var="row">
					<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
					<c:forEach items="${sub_list}" var="row">
					<option value="${row.item_code}">${row.item_name}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
				</select>
			</td>
			<td>
				<select name="modify_code" class="mod_">
					<option value="0">없음</option>
				</select>
			</td>
			<td>
				<input type="button" value="장비적용" onclick="equip_dup_ck(event);"/>
			</td>
		</tr>
	</table>
	<input type="hidden" name="reqStr" value="${reqStr}"/>
	</form>
</div>