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
<title>用户登录</title>
</head>
<body style="background-color: #F5F5F5;">
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<a href="#">
					<img alt="" src="<%=basePath %>res/assert/logo-min.png" width="100px" height="100px">
				</a>
			</div>
		</div>
	</div>
	<form action="<%=basePath %>front/login.shtml" method="post">
	<div id="message">
	<div class="container">
		<div class="row">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<label class="tlabel">EShop,让购物更快捷</label>
				<p class="logininfo" style="color:green;">${info }</p>
				<p class="logininfo" style="color:red;">${logininfo }</p>
			</div>
			<div class="col-sm-2"></div>
		</div><hr>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<input type="text" name="userPhone" placeholder="请输入账号(手机号) " class="inp"/>
				<input type="password" name="userPw" placeholder="请输入密码" class="inp"/><br/>
				<input type="submit" class="btn btn-info" style="margin-top: 20px;margin-left: 50px;" value="立即登录"/>
				<a href ="<%=basePath %>front/loadreg.shtml" class="btn btn-success" style="margin-top: 20px;margin-left: 20px;">立即注册</a>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<hr>
	</div>
	</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
