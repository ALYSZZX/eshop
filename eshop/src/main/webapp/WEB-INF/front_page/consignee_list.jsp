<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>res/css/commons.css">
<title>收货人管理</title>
</head>
<body>
	<h4>收货人信息</h4>
	<hr />
	<table class="table">
		<tr>
			<th>收货人编号</th>
			<th>收货人姓名</th>
			<th>收货人地址</th>
			<th>邮编</th>
			<th>电话号码</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="ccm">
			<tr>
				<td>${ccm.consignee_id }</td>
				<td>${ccm.consignee_name }</td>
				<td>${ccm.consignee_address }</td>
				<td>${ccm.consignee_code }</td>
				<td>${ccm.consignee_phone}</td>
				<td>
				<a href="javascript:void(0)" onclick="update(${ccm.consignee_id},'${ccm.consignee_name}','${ccm.consignee_address}','${ccm.consignee_code}','${ccm.consignee_phone}')">修改</a>
				<a href="adminconsignee/delete.shtml?consigneeId=${ccm.consignee_id }">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
		<div align="center" style="color:red">${info }</div>
	<hr/>
	<div class="row">
		<div class="col-sm-10">
			<form action="" method="post" id="f1">
			<div class="form-group">
				<label for="consignee_id">收货人编号</label>
				<input type="text" class="form-control" name ="consigneeId" id="consignee_id" placehoder="请输入收货人编号" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="consignee_name">收货人姓名</label>
				<input type="text" class="form-control"  name="consigneeName" id="consignee_name" placehoder="请输入收货人姓名" >
			</div>
			<div class="form-group">
				<label for="consignee_address">收货人地址</label>
				<input type="text" class="form-control" name="consigneeAddress" id="consignee_address" placehoder="请输入收货人地址" >
			</div>
			<div class="form-group">
				<label for="consignee_code">邮编</label>
				<input type="text" class="form-control" name="consigneeCode" id="consignee_code" placehoder="请输入邮编" >
			</div>
			<div class="form-group">
				<label for="consignee_phone">收货人电话</label>
				<input type="text" class="form-control" name="consigneePhone" id="consignee_phone" placehoder="请输入收货人电话" >
			</div>
			<button type="button" id="add" class="btn btn-success">添加收货人</button>
			<button type="button" id="update" class="btn btn-info">修改收货人</button>
			</form> 
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//添加
			$("#add").click(function(){
				var f1 = $("#f1");
				f1.attr("action","adminconsignee/add.shtml");
				f1.submit();
			});
		//修改
			$("#update").click(function(){
				var f1 = $("#f1");
				f1.attr("action","adminconsignee/update.shtml");
				f1.submit();
			});
		});
		
		function update(id,name,address,code,phone){
			$("#consignee_id").val(id);
			$("#consignee_name").val(name);
			$("#consignee_address").val(address);
			$("#consignee_code").val(code);
			$("#consignee_phone").val(phone);
		};
	</script>
</body>
</html>