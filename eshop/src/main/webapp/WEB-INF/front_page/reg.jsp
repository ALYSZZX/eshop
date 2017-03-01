<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath %>res/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath %>res/css/commons.css">
<title>用户注册</title>
</head>
<body style="background-color: #F5F5F5;width: 100%;margin: 0px;">
	<section id="logo">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<a href="#">
					<img alt="" src="<%=basePath %>res/assert/logo-min.png" class="logoimg" >
				</a>
			</div>
			<div class="col-sm-3"></div>
		</div>
	</section>
	<form action="<%=basePath %>front/reg.shtml" method="post">
	<section id="message">
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<label class="tlabel">网上商城账号注册</label>
			</div>
			<div class="col-sm-3"></div>
		</div><hr>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<input type="text" name="userPhone" placeholder="请输入账号(手机号) " class="inp"/>
				<input type="text" name="userName" placeholder="请输入姓名" class="inp"/>
				<input type="password" name="userPw" placeholder="请输入密码" class="inp"/><br/>
				<input type="submit" class="btn btn-info" style="margin-top: 20px;margin-left: 80px;" value="立即注册"/>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<hr>
	</section>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>