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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/userinfo_list.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/jquery.validator.css" />

<script type="text/javascript" src = "<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
function validate_required(field)
{
with (field)
  {
  if (value==null||value=="")
    {return false}
  else {return true}
  }
}
function validate_Phone(field){
	with (field)
	  {
	  if (field.length!=11)
	    {return false}
	  else {return true}
	  }
}
function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(userName)==false)
    {$("#nameinfo").text("用户姓名不能为空！");userName.focus();return false;}
  if (validate_required(userPhone)==false)
    {$("#errorinfo").text("手机号码不能为空！");userPhone.focus();return false;}
  if (validate_required(userPw)==false)
    {$("#pwinfo").text("密码不能为空！");userPw.focus();return false;}
  return true;
  }
}
</script>

<title>添加用户</title>
</head>
<body>
	<form action="<%=basePath%>user/add.do" method="post" onsubmit="return validate_form(this)">
	<div class="basem">
		<div id="pp"><p>基本信息</p></div>
		<div>
			<div id="basev">
				<lable>用户姓名</lable>
				<input type="text" name="userName"  placeholder="请输入您的姓名"  />
				<span id ="nameinfo" style="color:red"></span>
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
				<input type="text" name="userPhone" id="userPhone" placeholder="请输入您的手机号码"  />
				<span id ="errorinfo" style="color:red"></span>
			</div>
			<div id="basev">
				<lable>用户密码</lable>
				<input type="password" name="userPw" placeholder="请输入您的密码" />
				<span id ="pwinfo" style="color:red"></span>
			</div>
		</div>
	</div>
	<div class="subres">
		<input type="submit" value="保存用户" style="background-color:#FF6100;">
		<input type="reset" value="重置信息" style="background-color:#00FF00;">
	</div>
	</form>
	<script type="text/javascript">
	    $(function(){
	    	$("#userPhone").blur(function(){
	    		//ajax
	    		if($(this).val().length==11){
	    		    $.post("<%=basePath%>user/userAjax.do",{userPhone : $(this).val()},function(str){
	    		 	    $("#errorinfo").html(str);
	    			},"json");
	    		}else{
	    			$("#errorinfo").text("手机号码格式错误！");
	    			userPhone.focus();
	    		}
	    		
	    	});
	    });
	</script>
</body>
</html>