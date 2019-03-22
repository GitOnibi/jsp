<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var insert = document.querySelector(".insert");
	var modify = document.querySelector(".modify");
	
	// close button
	var cbtn = document.querySelectorAll(".closeBtn");
	cbtn.forEach(function(item, index) {
		item.addEventListener("click", function() {
			item.parentNode.classList.remove("on");
		});
	});
	
	// modify
	var mBtn = document.querySelectorAll(".modifyBtn");
	var mods = document.querySelectorAll(".mod_");
	mBtn.forEach(function(item, index) {
		item.addEventListener("click", function() {
			insert.classList.remove("on");
			modify.classList.add("on");
			var tar = item.parentNode.parentNode.className;
			var el = document.querySelectorAll("." + tar + " td");
			for(i = 0; i < el.length - 2; i++) {
				if(i == 10 ) {
					continue;
				} else {
					mods[i].value = el[i].innerHTML;
				}
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
				location.href = "item_delete.dev?item_code=" + el[0].innerHTML;
			} else {
				alert("취소되었습니다");
			}
		});
	});
	
	
	function show_insert() {
		modify.classList.remove("on");
		insert.classList.add("on");
	}
	
	function item_insert() {
		var code = document
	}
		
	var msg = "${msg}";
	if(msg) { alert(msg); }
</script>