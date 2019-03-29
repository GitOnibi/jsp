<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
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
</script>