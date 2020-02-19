<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cms后台登录</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/cms.css" rel="stylesheet">
</head>
<input type="button" value="添加收藏" onclick="check()"/>

<body>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">收藏文章名</th>
      <th scope="col">收藏地址</th>
      <th scope="col">所属用户</th>
      <th scope="col">添加时间</th>
    </tr>
  </thead>
  <tbody>
    <!-- 收藏列表循环遍历 -->
    <c:forEach items="${listDomainBytime}" var="p">
     <tr>
      <th scope="col">${p.text }</th>
      <th scope="col">${p.url }</th>
      <th scope="col">${p.userid }</th>
      <th scope="col">${p.created }</th>
      <th scope="col">
      <input type="button" value="删除" onclick="dele(${p.id })"/>
      </th>
    </tr>
    
    
    
    
    </c:forEach>
  </tbody>
</table>
<div class="alert alert-danger" role="alert" style="display: none"></div>
 <div class="modal" tabindex="-1" role="dialog" id="checkModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">收藏添加</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      <div class="modal-body">
        <form id="checkForm">
        	<input type="hidden" id="id" name="id">
        	<div class="form-check">
			  <input class="form-check-input" type="text" name="text" >
			  <label class="form-check-label" for="exampleRadios1">
			    	文章文本
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="text" name="url">
			  <label class="form-check-label" for="exampleRadios1">
			    	文章地址
			  </label>
			</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="toCheck();">提交添加</button>
      </div>
</div>
</div>
</div>
</div>







<%-- 		<div style="text-align: center;">
			<jsp:include page="<%=request.getContextPath()%>/common/page.jsp"></jsp:include>
		</div>		 --%>
<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript">
		function gotoPage(pageNum){
			
		/* 	
			if(channelId==''){
				
				if(key!=""){
					
					window.location.href="/hot/"+pageNum+".html?key="+key;
					
				}else if(key==""){

					window.location.href="/hot/"+pageNum+".html"
				}
	
			}else{
				window.location.href="/"+channelId+"/"+cateId+"/"+pageNum+".html"
			} */
		}
		function dele(ids){
			alert("进入删除方法"+ids)
			location="deleDomainbyid?ids="+ids;

			
		}
 		function check(){
 			alert("进入模态框展示添加收藏地址")
			$('#checkModal').modal('show');
			
		}
		function toCheck(){
			var data = $('#checkForm').serialize();
			console.log("data:"+data);
			$.post("/user/add",data,function(res){
				$('#checkModal').modal('hide');
				$('.alert').html("添加成功");
				$('.alert').show();
				query();
			});
		} 
		
	</script>
</body>
</html>