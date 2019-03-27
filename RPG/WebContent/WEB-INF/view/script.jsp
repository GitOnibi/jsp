<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var insert = document.querySelector(".insert");
	var modify = document.querySelector(".modify");


	function show_insert() {
		modify.classList.remove("on");
		insert.classList.add("on");
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