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
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/login.css">
<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
<title>后台登录</title>
</head>
<body class="mainbody">
	<div class="container">
		<div class="head">
		  <div class="head_logo">
		 	 <a href="//www.baidu.com">
		  		<img src="<%=basePath%>res/assert/logo-min.png" alt="购物商场" width="170" height="80"> 
		 	 </a>
		 	 <div id="welcome">
		 		 <p>欢迎登录</p>
		 	 </div>
		 	 <div class="clear"></div>
		</div>
		
		</div>
		<div class="body">
			<div class="title">
		   		<p>商城后台管理系统</p>
		   	</div>
		   	<form action="back/login.do" method="post">
		   	<div class="loginbox">
		   		      <b>账号登录</b>
		   	     <div class="user">
		   	    		<label class="text">用户名:</label> 
		   	    		<input type="text" name="userName" placeholder="请输入账号!" class="itext" id="userName">
		   	     </div>
		   	       <div class="pw">
		   	     		<label class="text">密&nbsp码:</label>
		   	     		<input type="password" name="userPw" placeholder="请输入密码!" class="itext" id ="userPw">
		   	     </div>
		   	     <div class="sub">
		   	     		<input type="submit" value="登录" onclick="checkValue();">
		   	     </div>
		   	</div>
		   	 <div class="clear"></div>
		</form>
		</div>
		<div class="footer">
		<div class="links">
            <a rel="nofollow" target="_blank" href="">
                关于我们
            </a>
            |
            <a rel="nofollow" target="_blank" href="">
                联系我们
            </a>
            |
            <a rel="nofollow" target="_blank" href="">
                人才招聘
            </a>
            |
            <a rel="nofollow" target="_blank" href="">
                商家入驻
            </a>
            |
            <a rel="nofollow" target="_blank" href="">
                广告服务
            </a>
            |
            <a rel="nofollow" target="_blank" href="">
                手机商城
            </a>
            |
            <a target="_blank" href="">
                友情链接
            </a>
            |
            <a target="_blank" href="">
                销售联盟
            </a>
            |
            <a href="" target="_blank">
                商城社区
            </a>
            |
            <a href="" target="_blank">
                商城公益
            </a>
            |
            <a target="_blank" href="" clstag="pageclick|keycount|20150112ABD|9">English Site</a>
        </div>
        <div class="copyright">
            Copyright&nbsp;©&nbsp;2000-2016&nbsp;&nbsp;商城shop.com&nbsp;版权所有
        </div>
		</div>
	</div>
	<script type="text/javascript">
	 function checkValue(){
		var name = $("#userName").val();
		var pw = $("#userPw").val();
		if(name !="" &&name !=undefined && pw !="" &&pw !=undefined){
			return true;
		}
		alert("账号或密码不能为空!");
		return false;
	}
	</script>
</body>
</html>