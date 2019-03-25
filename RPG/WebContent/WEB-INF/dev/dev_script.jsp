<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var insert = document.querySelector(".insert");
	var modify = document.querySelector(".modify");
	var mods = document.querySelectorAll(".mod_");
	var inss = document.querySelectorAll(".ins_");
	
	// close button
	var cbtn = document.querySelectorAll(".closeBtn");
	cbtn.forEach(function(item, index) {
		item.addEventListener("click", function() {
			item.parentNode.classList.remove("on");
		});
	});
	
	// modify
	var mBtn = document.querySelectorAll(".modifyBtn");
	mBtn.forEach(function(item, index) {
		item.addEventListener("click", function() {
			insert.classList.remove("on");
			modify.classList.add("on");
			var tar = item.parentNode.parentNode.className;
			var el = document.querySelectorAll("." + tar + " td");
			for(i = 0; i < el.length - 2; i++) {
				mods[i].value = el[i].innerHTML;
			}
			
		});
	});
	
	// delete
	var dBtn = document.querySelectorAll(".deleteBtn");
	dBtn.forEach(function(item, index) {
		item.addEventListener("click", function() {
			insert.classList.remove("on");
			modify.classList.remove("on");
			var tar = item.parentNode.parentNode.className;
			var el = document.querySelectorAll("." + tar + " td");
			if(confirm(tar + " 행을 삭제 하시겠습니까?")) {
				var form = document.createElement("form");
				form.setAttribute("charset", "UTF-8");
				form.setAttribute("method", "POST");
				form.setAttribute("action", el[0].className + "_delete.dev");
				
				var child = document.createElement("input");
				child.setAttribute("type", "hidden");
				child.setAttribute("name", el[0].className + "_code");
				child.setAttribute("value", el[0].innerHTML);
				
				form.appendChild(child);
				document.body.appendChild(form);
				form.submit();
			} else {
				alert("취소되었습니다");
			}
		});
	});
	
	
	function show_insert() {
		modify.classList.remove("on");
		insert.classList.add("on");
	}
	
	function do_insert() {
		inss.forEach(function(item, index) {
			if(item.value == "" || item.value == null) { item.value = 0; }
		});
		document.querySelector("#insFrm").submit();
	}
	
	function do_modify() {
		mods.forEach(function(item, index) {
			if(item.value == "" || item.value == null) { item.value = 0;}
		});
		document.querySelector("#modFrm").submit();
	}
	
	var msg = "${msg}";
	if(msg) { alert(msg); }
</script>