<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="cn.eshop.utils.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
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
<link type="text/css" rel="stylesheet"	href="<%=basePath%>res/css/userinfo_list.css">
<link type="text/css" rel="stylesheet"	href="<%=basePath%>res/css/bootstrap.min.css">
<script type="text/javascript"	src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript"	src="<%=basePath%>res/js/bootstrap.min.js"></script>
<title>商品管理</title>
</head>
<body>
	<div class="container">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<form action="<%=basePath%>goods/list.do" method="post" class="form-inline" style="margin-top: 10px;">
				<lable class="btn btn-danger btn-lg">商品名称:</lable>
				<input type="text" name="goodsName" placeholder="请输入名称" class="form-control" style="width: 200px;height: 46px;font-size: 25px;"/> 
				<input	type="submit" value="查询" class="btn btn-success btn-lg" style="width:111px;"> 
				<a href="<%=basePath%>goods/loadadd.do" class="btn btn-info btn-lg" style="width:111px;">添加商品</a>
			</form>
		</div>
	</div>
	</div>
	<hr>
	<div class="alert alert-danger alert-dismissible" role="alert" style="margin:0px;display:${info==''?'none':'block'};">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close" >
			<span aria-hidden="true">&times;</span>
				<b>${info }</b>
		</button>
	</div>
	<div class="container">
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<table class="table">
				<tr>
					<th>商品编号</th>
					<th>商品名称</th>
					<th>商品库存</th>
					<th>商品图片</th>
					<th>商品价格</th>
					<th>商品状态</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${list }" var="goods">
					<tr>
						<th>${goods.goods_id }</th>
						<th><a href="<%=basePath %>goods/goodsinfo.do?goodsId=${goods.goods_id}">${goods.goods_name }</a></th>
						<th>${goods.goods_count }</th>
						<th><img src="${imgurl}${goods.goods_url}" height="50" width="100" /></th>
						<th>${goods.goods_price }</th>
						<th>${goods.goods_state=='-1'?'未上架':'' }
							${goods.goods_state=='1'?'销售中':'' }
							${goods.goods_state=='0'?'已下架':'' }</th>
						<th><a
							href="<%=basePath %>goods/loadupdate.do?goodsId=${goods.goods_id}">修改</a>
							<a href="javascript:void(0)"
							style="display:${goods.goods_state=='1'?'block':'none'};"
							onclick="del('${goods.goods_id}')">下架</a> <a
							href="<%=basePath %>goods/upgoods.do?goodsId=${goods.goods_id }"
							style="display:${goods.goods_state =='-1'?'block':'none'};">上架</a>
							<a
							href="<%=basePath %>goods/upgoods.do?goodsId=${goods.goods_id }"
							style="display:${goods.goods_state =='0'?'block':'none'};">上架</a>
						</th>
					</tr>
				</c:forEach>
			</table>
			<div align="center" style="padding: 10px; font-size: 20px">
				<pg:pager items="${total}" url="goods/list.do" maxIndexPages="10"
					export="currentPageNumber=pageNumber" scope="request">
					<pg:param name="goods.goodsName" value="${goods.goods_name}" />
					<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true" />
				</pg:pager>
			</div>
		</div>
	</div>
	</div>
	<script type="text/javascript">
			    function del(Id){
			    	if(confirm("你确定要下架吗?")){
			    	    window.location="<%=basePath %>goods/delete.do?goodsId="+Id;
			    	}
			    }
	</script>
</body>
</html>