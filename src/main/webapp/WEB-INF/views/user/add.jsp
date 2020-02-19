<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/user/add" method="post">
	<table >
		<tr>
		    <td></td>
		    <td>
		    <input type="hidden" name="id"/>
		    </td>
		</tr>
		  <tr>
		    <td>收藏文本</td>
		    <td>
		    <input type="text" name="text"/>
		    <td/>
		  </tr>
		  <tr>
		    <td>收藏文章地址</td>
		   <td> <input type="text" name="url"/></td>
		  </tr>
		  <tr>
		    <td></td>
		    <td><input type="hidden" name="url" value="${userid}"/></td>
		  </tr>		
		   <tr>
		    <td></td>
		    <td><input type="hidden" name="created" value="2020-2-18"/></td>
		  </tr>
			  <tr>
		    <td></td>
		    <td><input type="button" value="提交"/></td>
		  </tr>
	</table>
</form>


</body>
</html>