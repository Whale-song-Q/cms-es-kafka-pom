<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/js/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/public/js/bootstrap.min.js"></script>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/public/js/cms.js"></script>
<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
<script type="text/javascript">
</script>	
<div class="form-group" style="margin-top: 200px;margin-left: 200px">
	
<form id="addComplain" name="articleComplain">

 <input  type="hidden" name="carticleid" id="articleid" value="${articleid}" >
	<label for="inputEmail3" class="col-sm-2 col-form-label">请选择投诉属性</label>
	<div class="form-check col-2">
		  <input class="form-check-input" type="radio" name="ctype" id="carticleid" value="1" >
		  <label class="form-check-label" for="exampleRadios1">
		   政治敏感
		  </label>
    </div>
    	<div class="form-check col-2">
		  <input class="form-check-input" type="radio" name="ctype" id="carticleid" value="2" >
		  <label class="form-check-label" for="exampleRadios1">
		   辱骂
		  </label>
    </div>
    	<div class="form-check col-2">
		  <input class="form-check-input" type="radio" name="ctype" id="carticleid" value="3" >
		  <label class="form-check-label" for="exampleRadios1">
		   涉嫌违规
		  </label>
    </div>
    	<div class="form-check col-2">
		  <input class="form-check-input" type="radio" name="ctype" id="carticleid" value="4" >
		  <label class="form-check-label" for="exampleRadios1">
		   涉嫌集资
		  </label>
    </div>
<label for="inputEmail3" class="col-sm-2 col-form-label">请描述投诉内容！</label>	
	<div class="form-group row">

		<div class="col-sm-6">
			<input type="text" name="some"  class="form-control" placeholder="请输入投诉内容">
		</div>
	</div>
	
		<div class="form-group row">
		<div class="col-sm-10">
			<button type="button" class="btn btn-primary" onclick="save()">提交投诉</button>
		</div>
	</div>
	
	</form>
</div>
<script type="text/javascript">

function save() {
	var param=$("[name=articleComplain]").serialize();
	alert(param);
		 $.post("/article/articleComplain",param,function(obj){
				if(obj>0){
					alert("投诉成功");
		 			location="/"
					
				}else{
					
					alert("投诉失败");
				}
				
			},"json")


	
	
}

</script>	
	