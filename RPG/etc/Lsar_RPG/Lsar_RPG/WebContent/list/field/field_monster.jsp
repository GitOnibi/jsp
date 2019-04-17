<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.transform"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
var sel="";
function select_mon(no){
	sel=no;
}
function at(){
	var i=document.getElementById("no");
	var f=document.getElementById("f");
	i.setAttribute("value",sel);
	f.submit();
}
</script>
<form action="hunter.ls" method=post id=f>
<input type=hidden name=no id=no>
 	<c:forEach items="${list }" var="mon" varStatus="st">
 		<c:if test="${st.index/5==0 }"><div></c:if>
 			<div style="float:left; width:150px; text-align:center;">
 			<p onclick="select_mon(${mon.num})">	${mon.mon_name } </p>
 				${mon.level }.lv &nbsp;
 				${transform.skill_f(mon.kind) }
 			</div>
 		<c:if test="${st.index%5==4 || st.last }"></div></c:if>
 	</c:forEach><br><br>
 <div style="clear:both;"><br>	<input type=number name=num value=1 size=3>
 	<input type=button value="전투" onclick="at()">
 	</div>
 </form>
 	<br>
 	<div>
   몬스터출현
   </div><div>
   몬스터출현
   </div>