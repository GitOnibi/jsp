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
 			<div class="char_status">
				<h1>케릭터</h1>
				<table border="1px" class="data_tbl">
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
					</tr>
				</table>
			</div>
			<div>	
				<ul>
					<c:forEach items="${mob_list}" var="row" varStatus="st">
					<li>
						<p>Lv.${row.mob_lv} ${row.mob_name}</p>
						<p>HP : ${row.mob_hp } / ATK : ${row.mob_atk} / DEF : ${row.mob_def}</p>
						<button onclick="battle(p1, m${st.index + 1});">공격</button>
					</li>
					</c:forEach>
				</ul>
			</div>	
			<div id="result">${log}</div>
		</div>
		<div id="footer">
		
		</div>
	</div>
	<script type="text/javascript">
		var result = document.querySelector("#result");
		var player = function(name, hp, fhp, atk, def, exp, code) {
			this.name = name;
			this.hp = hp;
			this.fhp = fhp;
			this.atk = atk;
			this.def = def;
			this.exp = exp;
			this.code = code;
		}

		var p1 = new player(
				"${sessionScope.char_name}",
				"${char_info[0].char_hp}",
				"${char_info[0].char_hp}",
				"${char_info[0].char_atk + stat_list[0]}",
				"${char_info[0].char_def + stat_list[1]}",
				0,
				0
		);
		
		var attack = function(attacker, defender) {
			defender.hp -= (attacker.atk - defender.def) > 0 ? attacker.atk - defender.def : 1;
			result.innerHTML += "<p>" + attacker.name + " 가 " + defender.name + " 에게 " + ((attacker.atk - defender.def) < 0 ? 1 : (attacker.atk - defender.def)) + " 데미지를 입혔습니다. " + defender.name + " 의 체력이 " + (defender.hp < 0 ? 0 : defender.hp) + " 남았습니다.</p>";
			if(defender.hp <= 0) {
				if(defender.name == "${sessionScope.char_name}") {
					result.innerHTML += "<p>" + attacker.name + " 을(를) 이길 수 없습니다.</p>";
				} else {
					result.innerHTML += "<p>" + defender.name + " 을(를) 처치했습니다.</p>";
				}
			}
		}
		
		var reset = function(target) {
			target.hp = target.fhp;
		}
		
		var battle = function(player, mob) {
			if(player.hp <= 1) {
				alert("체력이 낮아 전투를 계속할 수 없습니다");
				return false;
			}
			if(player.hp < parseInt(player.fhp / 5)) {
				if(!confirm("체력이 너무 낮습니다. 전투를 계속하시겠습니까?")) {
					return false;
				}
			}
			result.innerHTML = "";
			while(player.hp >= 0 && mob.hp >= 0) {
				if(player.hp <= 0) {
					result.innerHTML += "<p>전투가 어렵습니다. 후퇴합니다.</p>";
					break;
				} else {
					attack(player, mob);
				}
				if(mob.hp <= 0) {
					result.innerHTML += "<p>" + player.name + " 가 승리하였습니다. " + mob.exp + " 의 경험치를 획득하였습니다.</p>";
					update(player, mob);
					reset(mob);
					break;
				} else {
					attack(mob, player);
				}
			}
		}
		
		var update = function(player, mob) {
			var body = document.querySelector("body");
			var form = document.createElement("form");
			var ip1 = document.createElement("input");
			var ip2 = document.createElement("input");
			var ip3 = document.createElement("textarea");
			form.setAttribute("action", "character_update.do");
			form.setAttribute("method", "POST");
			form.setAttribute("id", "pfrm");
			ip1.setAttribute("type", "text");
			ip1.setAttribute("name", "hp");
			ip1.setAttribute("value", player.hp < 0 ? 0 : player.hp);
			ip2.setAttribute("type", "text");
			ip2.setAttribute("name", "code");
			ip2.setAttribute("value", mob.code);
			ip3.setAttribute("name", "log");
			ip3.innerHTML = result.innerHTML;
			form.appendChild(ip1);
			form.appendChild(ip2);
			form.appendChild(ip3);
			body.appendChild(form);
			document.querySelector("#pfrm").submit();
		}

		<c:forEach items="${mob_list}" var="row" varStatus="st">
		var m${st.index + 1} = new player(
				"${row.mob_name}",
				"${row.mob_hp}",
				"${row.mob_hp}",
				"${row.mob_atk}",
				"${row.mob_def}",
				"${row.mob_exp}",
				"${row.mob_code}"
		);
		console.log(m${st.index + 1});
		</c:forEach>
		
		var msg = "${msg}";
		if(msg) {
			alert("${msg}");
		}
 	</script>
</body>
</html>