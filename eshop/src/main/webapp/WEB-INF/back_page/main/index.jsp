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
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/back_index.css">
<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function () {
    $("#userm").click(function () {
    	 $("#userm1").toggle();
    	 $("#userm2").toggle();
    });
    
    $("#goodsm").click(function () {
        $("#goodsm1").toggle();
        $("#goodsm2").toggle();
        $("#goodsm3").toggle();
    });
    
    $("#orderm").click(function () {
        $("#orderm1").toggle();
        $("#orderm2").toggle();
    });
    $("a").click(function(){
    	$("a").each(function(){
    		$(this).css("color","blue");
    	});
    	$(this).css("color","black");
    });
});
</script>
<title>商城后台管理系统</title>
</head>
<body>
  <div class="body">
	<div class ="head">
	  <div class ="index_head">
		<div id="title">商城后台管理系统</div>
		<div id="exit">
			<p>欢迎您，管理员</p>
			<a href="login_back.jsp">退出</a>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	  </div>
	</div>
	<div class ="index_body">
		<div class="menu">
			<dl> 
   				<dt class="user"><a href="javascript:void(0);" id="userm" >●用户管理</a></dt> 
				<dd><a href="user/list.do" id="userm1" target="boom">○用户信息</a></dd> 
				<dd><a href="www.baidu.com" id="userm2" target="boom">○收货地址</a></dd> 
			</dl> 
			<dl> 
				<dt class="goods"><a href="javascript:void(0);" id="goodsm">●商品管理</a></dt> 
				<dd><a href="goods/list.do" id="goodsm3" target="boom">○商品信息</a></dd>
				<dd><a href="goods/loadadd.do" id="goodsm1" target="boom">○添加商品</a></dd>
				<dd><a href="www.baidu.com" id="goodsm2" target="boom">○上架商品</a></dd>
			</dl> 
			<dl> 
				<dt class="order"><a href="javascript:void(0);" id="orderm">●订单管理</a></dt> 
				<dd><a href="www.baidu.com" id="orderm1" target="boom">○已完成订单</a></dd> 
				<dd><a href="www.baidu.com" id="orderm2" target="boom">○未完成订单</a></dd> 
			</dl> 
		</div>
		<div class="boom">
		    <div class="boom2">
		        <iframe name="boom" width="100%" height="100%" frameborder="no" src="#"></iframe>
		    </div>
		</div>
		<div class="clear"></div>
	</div>
	
	<div class ="footer">
	  <div class="footer2">
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
	</div>
  </div>
</body>
</html>