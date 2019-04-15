<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type=text/javascript >
function send_q(q_num,t_code,cnt){
	var f=document.getElementById("f");
	var i=document.createElement("input");
	i.setAttribute("type","hidden");
	i.setAttribute("name","q_num");
	i.setAttribute("value",q_num);
	var k=document.createElement("input");
	k.setAttribute("type","hidden");
	k.setAttribute("name","t_code");
	k.setAttribute("value",t_code);
	var j=document.createElement("input");
	j.setAttribute("type","hidden");
	j.setAttribute("name","cnt");
	j.setAttribute("value",cnt);
	f.appendChild(i);
	f.appendChild(k);
	f.appendChild(j);
	f.submit();
}
function recp(no,cnt){
	var f=document.getElementById("f");
	var i=document.createElement("input");
	i.setAttribute("type","hidden");
	i.setAttribute("name","q_num");
	i.setAttribute("value",no);
	f.appendChild(i);
	var k=document.createElement("input");
	k.setAttribute("type","hidden");
	k.setAttribute("name","cnt");
	k.setAttribute("value",cnt);
	f.appendChild(k);
	f.submit();
}
</script>
<form action="quest_accept.ls" method="post" id="f">
<p>진행중 임무</p>
<table>
<tr>
<th>번호</th>
<th width=80>임무레벨</th>
<th width=120>임무명</th>
<th width=350>수집</th>
<th width=100>수집현황</th>
</tr>
<c:forEach var="my" items="${my_q }" varStatus="cn">
	<tr>
	<td>	${cn.index+1 }</td>
	<td>	${my.q_level }</td>
	<td>	${my.title }</td>
	<c:forEach var="mon" items="${mon }">
		<c:if test="${mon.key eq my.type_code }">
			<td>${mon.value }	</td>
		</c:if>
	</c:forEach>
	<td>	${my.q_count }/${my.achive }</td>
	<td><input type=button value="수령" onclick="recp(${my.num},${my.achive })"></td>
	</tr>
</c:forEach>
</table>
<p>----------수락 가능 임무------------</p>
<table>
<tr>
<th>번호</th>
<th width=80>임무레벨</th>
<th width=120>임무명</th>
<th width=350>내용</th>
<th width=80>수집</th>
<th width=100>수집내용</th>
</tr>
<c:forEach var="q_num" items="${ quest}" varStatus="cn">
	<c:forEach var="my" items="${my_q }">
		<c:if test="${my.num!=q_num.value.num }">
			<tr><td>${cn.index+1 }</td>
			<td>${q_num.value.q_level }</td>
			<td>${q_num.value.title }</td>
			<td>${q_num.value.cont}</td>
			<c:forEach var="mon" items="${mon }">
				<c:if test="${mon.key eq q_num.value.type_code }">
					<td>${mon.value }	</td>
				</c:if>
			</c:forEach>
			<td>${q_num.value.q_count}</td>
			<td><input type=button value="수락" onclick="send_q(${q_num.value.num},${q_num.value.type_code },${q_num.value.q_count })"></td>
			</tr>
		</c:if>
	</c:forEach>
</c:forEach>
</table>
</form>
퀘스트