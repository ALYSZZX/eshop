<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>res/css/commons.css">
<title>订单管理</title>
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
			<td><a href="adminorder/cancelorder.shtml?orderId=${om.order_id}" class="btn btn-danger btn-sm" style="display:${om.order_state<'1'?'block':'none'};  float:left;">取消订单 </a>
			<a href="adminorder/confirmreceipt.shtml?orderId=${om.order_id}" class="btn btn-success btn-sm" style="display:${om.order_state=='1'?'block':'none'};  float:left;">确认收货  </a>
			<a href="adminorder/confirmreceipt.shtml?orderId=${om.order_id}" class="btn btn-danger btn-sm" style="display:${om.order_state=='2'?'block':'none'};  float:left;">申请退货  </a>
			<a href="javascript:void(0)" class="btn btn-info btn-sm" onclick="load('adminorder/detailslist.shtml?orderId=${om.order_id}');" style="float:left">查看详情</a></td>
		</tr>
			</c:forEach>
	</table>
	<div align="center" style="padding: 10px; font-size: 20px">
		<pg:pager items="${total}" url="adminorder/queryOrder.shtml" maxIndexPages="10" export="currentPageNumber=pageNumber" scope="request">
				<!--<pg:param name="user.userName" value="${user.userName}" />-->
				<jsp:include page="../../res/jsp/pager_tag.jsp" flush="true" />
		</pg:pager>
	</div>
</body>
</html>