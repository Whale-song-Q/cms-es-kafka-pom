<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
  	<form class="form-inline" id="queryForm">
	  <input type="hidden" name="pageNum" value="${pageInfo.pageNum }">
	</form>
<table class="table">
  <thead>
    <tr>
      <th scope="col"><input type="checkbox" value="" id="chkALL" name="chkALL"></th>
      <th scope="col">#</th>
      <th scope="col">连接名称</th>
      <th scope="col">链接地址</th>
      <th scope="col">链接创建时间</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${listLink }" var="l">
       <tr>
	      <th><input type="checkbox" value="${l.id }" name="chk_list"></th>
	      <th scope="row">${l.id }</th>
	      <td>${l.text }</td>
	      <td>${l.url }</td>
	      <td>${l.created}</td>
	    </tr>
   	</c:forEach>
   	<tr>
   	<td><button type="button" class="btn btn-primary" onclick="check()">批量删除</button></td>
   	</tr>
  </tbody>
</table>

<jsp:include page="../common/page.jsp"></jsp:include>
<script src="/public/js/checkbox.js"></script>
<script type="text/javascript">
function query(){
	var params = $("form").serialize();
	reload(params);
}
function gotoPage(pageNo){
	$("[name=pageNum]").val(pageNo);
	query();
}
function check() {
	var ids=$("[name=chk_list]:checked").map(function(){
		
		return this.value;
		
	}).get().join();
	if(confirm("确定要删除下标为"+ids+"的链接么？")){
		$.post("/admin/link/deleAll",{ids:ids},function(obj){
			if(obj){
				alert("删除成功！")
				reload();
			}else{
				
				alert("删除成功！")
			}
			
		},"json")
		
		}
	
}
</script>



