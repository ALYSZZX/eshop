<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.eshop.utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"	href="<%=basePath%>res/css/userinfo_list.css">
<link type="text/css" rel="stylesheet"	href="<%=basePath%>res/css/bootstrap.min.css">
<title>后台订单管理</title>
</head>
<body>
	<h4>订单管理</h4>
	<hr/>
	<table class="table">
		<tr>
			<th>订单编号</th>
			<th>订单时间</th>
			<th>购买人</th>
			<th>收货人</th>
			<th>总金额</th>
			<th>订单状态</th>
			<th>操作</th>
		</tr>
			<c:forEach items="${list}" var="om">
		<tr>
			<td>${om.order_id }</td>
			<td>${om.order_time }</td>
			<td>${om.user_name }</td>
			<td>${om.consignee_name }</td>
			<td>${om.order_total }</td>
			<td>${om.order_state=='0'?'等待商家确认':'' }
			${om.order_state=='1'?'已确认,等待发货':'' }
			${om.order_state=='2'?'已签收':'' }
			${om.order_state=='3'?'已取消':'' }</td>
			<td><a href="order/confirmorder.do?orderId=${om.order_id}" class="btn btn-success btn-sm"
			 style="display:${om.order_state=='0'?'block':'none'}; float:left;">确认订单</a>
			 <a href="order/cancelorder.do?orderId=${om.order_id}" class="btn btn-info btn-sm" 
			 style="display:${om.order_state<'2'?'block':'none'}; float:left;">取消订单 </a>
			 <a href="adminorder/confirmreceipt.shtml?orderId=${om.order_id}" class="btn btn-danger btn-sm" style="display:${om.order_state=='2'?'block':'none'};  float:left;">确认退货  </a>
			<button type="button" class="btn btn-warning btn-sm" style="float:left" data-toggle="popover" title="订单详情"  data-content="" onclick="show('order/orderdetail.do?orderId=${om.order_id}')">查看详情</button></td>
		</tr>
			</c:forEach>
	</table>
	<div align="center" style="padding: 10px; font-size: 20px">
		<pg:pager items="${total}" url="order/list.do" maxIndexPages="10" export="currentPageNumber=pageNumber" scope="request">
				<!--<pg:param name="user.userName" value="${user.userName}" />-->
				<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
		</pg:pager>
	</div>
	<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>res/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>res/js/popover.js"></script>
	<script type="text/javascript" >
	$(function () {
		  var show=function(uri){
			 
		 	 $('[data-toggle="popover"]').popover();
		  }
		})
	
	</script>
</body>
</html>