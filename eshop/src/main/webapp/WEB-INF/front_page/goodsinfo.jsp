<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.eshop.utils.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    application.setAttribute("imgurl", Common.IMG_SERVER_URL);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>res/css/commons.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>res/css/animate.min.css"/>
<title>商品详细信息</title>
</head>
<body>
<jsp:include page="head.jsp" flush="true"></jsp:include>
<section id="goodsinfo">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<img alt="" src="${imgurl }${goods.goods_url}" height="400px" width="400px">
				</div>
				<div class="col-sm-6">
					<h1>${goods.goods_name }</h1>
					<p class="desc">${goods.goods_name }</p><hr/>
					<p class="price">￥${goods.goods_price }</p><hr/>
					<a class="btn btn-warning btn-lg">加入购物车</a>
					<a class="btn btn-success btn-lg">直接购买</a>
				</div>
			</div>
		</div>
</section>
<section id ="goodsdesc">
	<hr/>
	<p class="desctitle">详情描述</p>
	<hr/>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				${goods.goods_desc}
			</div>
		</div>
	</div>
</section>
<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>