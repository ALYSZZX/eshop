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
<body style="text-align: center;">
	<h4>收货人信息</h4>
	<table class="table" >
		<tr>
			<th style="text-align: center;">收货人编号</th>
			<th style="text-align: center;">所属用户</th>
			<th style="text-align: center;">收货人姓名</th>
			<th style="text-align: center;">收货人地址</th>
			<th style="text-align: center;">邮编</th>
			<th style="text-align: center;">电话号码</th>
			<th style="text-align: center;">操作</th>
		</tr>
		<c:forEach items="${list}" var="ccm">
			<tr>
				<td>${ccm.consignee_id }</td>
				<td>${ccm.user_id }</td>
				<td>${ccm.consignee_name }</td>
				<td>${ccm.consignee_address }</td>
				<td>${ccm.consignee_code }</td>
				<td>${ccm.consignee_phone}</td>
				<td>
				<a href="javascript:void(0)" onclick="del('${ccm.consignee_id}')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr/>
	<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		 function del(consigneeId){
			  if(confirm("你确定要删除吗?")){
			    	 window.location="<%=basePath %>consignee/delete.do?consigneeId="+consignee_id;
			    }
		}
	</script>
</body>
</html>