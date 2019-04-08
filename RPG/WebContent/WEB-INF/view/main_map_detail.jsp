<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<title>Insert title here</title>
<style>
	#battle {
		border:1px solid #000;
	}
</style>
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
					</tr>
					<tr>
						<c:forEach items="${char_info}" var="row">
						<td>Lv.${row.char_lv} ${row.char_name}(${row.user_id})</td>
						<td class="p_hp">
							${row.char_hp}
						</td>
						<td class="p_atk">
							${row.char_atk + stat_list[0]}
						</td>
						<td class="p_def">
							${row.char_def + stat_list[1]}
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
					<li>
						<p>고블린</p>
						<button onclick="battle(p1, m1);">공격</button>
					</li>
					<li>
						<p>오크</p>
						<button onclick="battle(p1, m2);">공격</button>
					</li>
					<li>
						<p>오크메이지</p>
						<button onclick="battle(p1, m3);">공격</button>
					</li>
				</ul>
			</div>	
			<div id="result"></div>
		</div>
		<div id="footer">
		
		</div>
	</div>
	<script type="text/javascript">
		var result = document.querySelector("#result");
		var player = function(name, hp, atk, def) {
			this.name = name;
			this.hp = hp;
			this.atk = atk;
			this.def = def;
		}
		
		var p_name = "${sessionScope.char_name}";
		var p_hp = document.querySelector(".p_hp").innerHTML;
		var p_atk = document.querySelector(".p_atk").innerHTML;
		var p_def = document.querySelector(".p_def").innerHTML;
		var p1 = new player(p_name, p_hp, p_atk, p_def);
		console.log(p_hp);
		console.log(p_atk);
		console.log(p_def);
		
		var m1 = new player('고블린', 50, 10, 5);
		var m2 = new player('오크', 60, 15, 5);
		var m3 = new player('오크메이지', 70, 20, 5);
		
		var init = function(a, b) {
			a.hp = 100;
			b.hp = 50;
		}
		
		var attack = function(a, b) {
			b.hp -= a.atk - b.def;
			result.innerHTML += "<p>" + a.name + " 가 " + b.name + " 에게 " + (a.atk - b.def) + " 데미지를 입혔습니다. " + b.name + " 의 체력이 " + b.hp + " 남았습니다.</p>";
		}
		
		var battle = function(a, b) {
			if(a.hp < b.hp) {
				if(!confirm("체력이 낮습니다. 전투를 계속하시겠습니까?")) {
					return false;
				}
			}
			if(a.hp < 0) {
				alert("체력이 낮아 전투를 계속할 수 없습니다");
				return false;
			}
			result.innerHTML = "";
			while(a.hp >= 0 || b.hp >= 0) {
				attack(a, b);
				attack(b, a);
				if(a.hp <= 0) {
					result.innerHTML += a.name + " 가 패배하였습니다.";
					break;
				}
				if(b.hp <= 0) {
					result.innerHTML += a.name + " 가 승리하였습니다.";
					break;
				}
			}
		}
 	</script>
</body>
</html>