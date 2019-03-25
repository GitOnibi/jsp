<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var insert = document.querySelector(".insert");

	// close button
	var cbtn = document.querySelectorAll(".closeBtn");
	cbtn.forEach(function(item, index) {
		item.addEventListener("click", function() {
			item.parentNode.classList.remove("on");
		});
	});

	function show_insert() {
		insert.classList.toggle("on");
	}
	
	function char_connect(event) {
		if(confirm("해당 케릭터로 접속하시겠습니까?")) {
			event.target.parentNode.submit();
		} else {
			return false;
		}
	}
	
	function char_delete(event) {
		if(confirm("해당 케릭터를 삭제하시겠습니까?")) {
			event.target.parentNode.submit();
		} else {
			return false;
		}
	}
	
	var msg = "${msg}";
	if(msg) { alert(msg); }
</script>