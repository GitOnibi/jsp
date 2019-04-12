<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
/* ----- common ----- */
	function closeParent(event) {
		event.target.parentNode.classList.remove("on");
	}
	
	function do_submit(event) {
		if(confirm(event.target.value + " 하시겠습니까?")) {
				event.target.parentNode.submit();
		} else {
			return false;
		}
	}
	
	var msg = "${msg}";
	if(msg) { alert(msg); }


/* ----- insert & modify ----- */
	var insert = document.querySelector(".insert");
	var modify = document.querySelector(".modify");


	function show_insert() {
		insert.classList.add("on");
		modify.classList.remove("on");
	}
	
	function do_insert(event) {
		if(confirm(event.target.value + " 하시겠습니까?")) {
			var form = document.querySelector("#insFrm");
			var inss = document.querySelectorAll(".ins_");
			inss.forEach(function(item, index) {
				if(item.value == null || item.value == "") {
					item.value = 0;
				}
			});
			form.submit();
		} else {
			return false;
		}
	}
	
	function show_modify(event, str) {
		insert.classList.remove("on");
		modify.classList.add("on");
		var mods = document.querySelectorAll(".mod_");
		var vals = document.querySelectorAll(".li_" + str);
		for(i = 0; i < vals.length; i++) {
			mods[i].value = vals[i].value;
		}
	}
	
	function do_modify(event) {
		if(confirm(event.target.value + " 하시겠습니까?")) {
			var form = document.querySelector("#modFrm");
			var mods = document.querySelectorAll(".mod_");
			mods.forEach(function(item, index) {
				if(item.value == null || item.value == "") {
					item.value = 0;
				}
			});
			form.submit();
		} else {
			return false;
		}
	}
	
	function equip_dup_ck(event) {
		var mods = document.querySelectorAll(".mod_");
		var temp = new Array();
		for(i = 0; i < mods.length; i++) {
			if(mods[i].value != 0) {
				temp.push(mods[i].value);
			}
		}
		for(j = 0; j < temp.length - 1; j++) {
			for(k = j + 1; k < temp.length; k++) {
				if(temp[j] == temp[k]) {
					alert("중복하여 착용할 수 업습니다");
					return false;
				}
			}
		}
		do_modify(event);
	}

/* ----- battle ----- */	
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
	</c:forEach>
	
	var attack = function(attacker, defender) {
		defender.hp -= (attacker.atk - defender.def) > 0 ? attacker.atk - defender.def : 1;
		result.innerHTML += "<p>" + attacker.name + " 가 " + defender.name + " 에게 " + ((attacker.atk - defender.def) < 0 ? 1 : (attacker.atk - defender.def)) + " 데미지를 입혔습니다. " + defender.name + " 의 체력이 " + (defender.hp < 0 ? 0 : defender.hp) + " 남았습니다.</p>";
		if(defender.hp <= 0) {
			if(defender.name == "${sessionScope.char_name}") {
				result.innerHTML += "<p>" + attacker.name + " 을(를) 이길 수 없습니다.</p>";
				defender.hp = 0;
				attacker.code = 0;
				update(defender, attacker);
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
			alert("체력이 낮아 전투를 계속할 수 없습니다.");
			return false;
		}
		if(player.hp < player.fhp / 5) {
			if(!confirm("체력이 너무 낮습니다. 전투를 계속하시겠습니까?")) {
				return false;
			}
		}
		result.innerHTML = "";
		while(player.hp >= 0 && mob.hp >= 0) {
			if(player.hp <= 0) {
				result.innerHTML += "<p>전투가 어렵습니다. 후퇴합니다.</p>";
				player.hp = 0;
				mob.code=0;
				update(player, mob);
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
	
/* ----- restoration ----- */
	function do_res() {
		if(confirm("50골드를 지불하고 치료받으시겠습니까?")) {
			location.href = "restoration.do";
		}
	}
</script>