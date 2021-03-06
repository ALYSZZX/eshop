<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.eshop.utils.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	application.setAttribute("imgurl", Common.IMG_SERVER_URL);
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="oscache" uri="http://www.opensymphony.com/oscache"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>res/css/commons.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>res/css/animate.min.css"/>
<title>网上商城</title>
</head>
<body>

		<jsp:include page="head.jsp" flush="true"/>
		<oscache:cache time="5">
		<!-- 侧栏显示 -->
		<div class="his">
	    	<div id="hisdiv2" class="hisdiv2">
		    	<div class="histext"><p>为您推荐</p></div>
		    	<div class="container">
					<c:forEach items="${historylist}" var="goods">
						<div class="row">
							<div class="col-sm-12" style="margin-top:10px;">
								<div class="cp wow fadeIn" data-wow-delay="1s">
									  <a href="html/${goods.goods_id }.html" class="btn btn-primary" target="_blank"> 
									   	<img src="${imgurl }${goods.goods_url }" style="width: 100px;height: 100px;">
									  </a>
									  <h5 class="title">${goods.goods_name }</h5>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="row">
							<div class="col-sm-12" style="margin-top:10px;">
								<div class="cp wow fadeIn" data-wow-delay="1s">
									<h5>后台客服1QQ:12345670</h5>
									<h5>后台客服2QQ:12345671</h5>
									<h5>后台客服3QQ:12345672</h5>
								</div>
							</div>
					</div>
			   </div>
	    	</div>
		</div>
		<div class="indexleft">
			<div class="classic">
				<ul class="classul">
					<li class="classui"><a href="front/classiclist.shtml?classic=10" target="_blank">家用电器</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=20" target="_blank">数码3C</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=30" target="_blank">电脑办公</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=40" target="_blank">男女服饰</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=50" target="_blank">鞋靴箱包</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=60" target="_blank">食品烟酒</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=70" target="_blank">图书音像</a></li>
					<li class="classui"><a href="front/classiclist.shtml?classic=80" target="_blank">户外运动</a></li>
				</ul>
			</div>
		</div>
		<div class="indexright">
	    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="<%=basePath%>res/assert/lenovo.jpg" alt="..." style="height:600px;width: 1200px;margin-left: 20%;">
				<div class="carousel-caption">联想,汇聚世界的力量</div>
			</div>
			<div class="item">
				<img src="<%=basePath%>res/assert/cloth.jpg" alt="..." style="height:600px;width: 1200px;margin-left: 20%;">
				<div class="carousel-caption">T恤放肆购</div>
			</div>
			<div class="item">
				<img src="<%=basePath%>res/assert/xm5sad.jpg" alt="小米最新款，小米5s，你值得拥有" style="height:600px;width: 1200px;margin-left: 20%;">
				<div class="carousel-caption">小米黑科技</div>
			</div>
		</div>
			<!-- Controls 
			<a class="left carousel-control" href="#carousel-example-generic"  data-slide="prev"> 
				<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#carousel-example-generic"  data-slide="next">
				<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a> -->
	</div>
	</div>
	<div class="clear"></div>
	<div id="goods">
		<div class="container">
			<div class="row">
				<c:forEach items="${goodslist }" var="goods">
					<div class="col-sm-3" style="margin-top:20px;">
						<div class="cp wow fadeIn" data-wow-delay="1s">
						    <img src="${imgurl }${goods.goods_url }" style="width: 250px;height: 250px;">
						    <h4 class="title">${goods.goods_name }</h4>
						     <p class="desc">库存 : ${goods.goods_count }</p>
						    <p class="price">￥${goods.goods_price }</p>
						   <!--  <a href="html/${goods.goods_id }.html" class="btn btn-primary" target="_blank">点击查看</a>
						    -->
						     <a href="javascript:void(0)" class="btn btn-primary" target="_blank" id="getHtml" onclick="getHtml(${goods.goods_id});">点击查看</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	</oscache:cache>
	<div id="foot">
		<jsp:include page="footer.jsp" flush="true"/>
	</div>
	<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>res/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	window.onscroll=function(){ 
	    var t=document.documentElement.scrollTop||document.body.scrollTop;  
	    var div2=document.getElementById("hisdiv2"); 
	    if(t>= 100){ 
	        div2.className = "hisdiv2_1";
	    }else{
	        div2.className = "hisdiv2";
	    } 
	}
	
	function getHtml(goodsId){
		var uri = "http://localhost:8080/eshop/front/history/"+goodsId+".shtml";
		$.ajax({
	        url: uri, 
	        type: "get",
	        cache:false, 
	        contentType:"application/json",
	        dataType:"text",
	        data: {goodsId:goodsId},
	        success: function(data){
	        	var el = document.createElement("a");
	        	document.body.appendChild(el);
	        	el.href = "html/"+data+".html"; //url 是你得到的连接
	        	el.target = '_blank'; //指定在新窗口打开
	        	el.click();
	        	document.body.removeChild(el);
	        },
	        error:function(XMLHttpRequest, textStatus, errorThrown){
	            alert(XMLHttpRequest.status);
	        }
	    });  
	};
	</script>
</body>
</html>