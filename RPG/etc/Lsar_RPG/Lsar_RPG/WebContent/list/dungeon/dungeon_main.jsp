<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
   function text_copy(val){
       var IE=(document.all)?true:false;
      	if(IE){
     	  window.clipboardData.setData("Text", val);
 	 	 }
   }
   function text(){
	   document.frm.copy.value=  window.clipboardData.getData("Text");
   }
</script>
<input type="text" id="txtBox"/>
<button onclick="text_copy(txtBox.value)">텍스트 복사</button>
<button onclick="text()">클립보드 붙여넣기</button>
<form name=frm>
<input type="text" name="copy"/>
</form>


</body>
</html>