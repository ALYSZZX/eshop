<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.eshop.core.bean.UserInfo"%>
<div class="head1">
	<div class="webtitle">网上商城</div>
	<div class="headmenu">
		<a href="front/list.shtml">首页</a> 
		<% UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
			if(userInfo !=null){
		%>
		<a href="#">欢迎您,<%=userInfo.getUserName() %></a>
		<a href="adminorder/showorder.shtml">我的订单</a>
		<%}else{ %>
			<a href="front/loadlogin.shtml">用户登录</a> 
			<a href="front/loadreg.shtml">用户注册</a> 
		<%} %>
		<a href="front/showcar.shtml"> <span class="glyphicon glyphicon-shopping-cart"
			aria-hidden="true"></span>购物车
		</a>
	</div>
	<div class="clear"></div>
</div>
