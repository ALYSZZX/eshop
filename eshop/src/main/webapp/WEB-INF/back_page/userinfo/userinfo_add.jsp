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
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/userinfo_list.css">
<title>添加用户</title>
</head>
<body>
	<form action="user/add.do" method="post">
	<div class="basem">
		<div id="pp"><p>基本信息</p></div>
		<div>
			<div id="basev">
				<lable>用户姓名</lable>
				<input type="text" name="userName" placeholder="请输入您的姓名"/>
			</div>
			<div  id="basev">
				<lable>用户性别</lable>
				<select name="userSex">
					<option>保密</option>
					<option>男</option>
					<option>女</option>
				</select>
			</div>
			<div id="basev">
				<lable>用户类型</lable>
				<select name="userType">
					<option>普通用户</option>
					<option>管理员</option>
				</select>
			</div>
		</div>
	</div>
	<div class="countm">
		<div id="pp"><p>账号信息</p></div>
		<div >
			<div id="basev">
				<lable>手机号码</lable>
				<input type="text" name="userPhone" placeholder="请输入您的手机号码"/>
			</div>
			<div id="basev">
				<lable>用户密码</lable>
				<input type="password" name="userPw" placeholder="请输入您的密码"/>
			</div>
		</div>
	</div>
	<div class="subres">
		<input type="submit" value="保存用户" style="background-color:#FF6100;">
		<input type="reset" value="重置信息" style="background-color:#00FF00;">
	</div>
	</form>
</body>
</html>