<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>res/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath%>res/css/commons.css">
<title>购物车</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<hr/>
	<section id="nav">
	<div class="container">
		<div class="col-sm-1"></div>
		<div class="col-sm-3">
			<a class="btn btn-primary">第一步 我的购物车</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-default">第二步 填写核对订单信息</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-default">第三步 成功提交订单</a>
		</div>
		<div class="col-sm-1"></div>
	</div>
	</section>
	<hr/>
	
	<form action="<%=basePath %>adminorder/orderCheck.shtml" method="post" id="f1">
	<section id="shopcar">
		<div class="container">
		<table class="table">
			<tr>
				<th width="6%">全选&nbsp;<input type="checkbox" id="all" onclick="checkboxall(this)"></th>
				<th	width="50%">商品</th>
				<th>单价(元)</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
			</tr>
			<%Map<Integer,Map> cars = (Map<Integer,Map>)session.getAttribute("cars");
			if(cars!=null){
				Set<Integer> sets= cars.keySet();
				if(sets.size()>0){
				for(Integer id :sets){
					Map map=cars.get(id);
			%>
			<tr>
				<td>
					<input type="hidden" name="goodsDescs" value="<%=map.get("goods_id")%>,<%=map.get("goods_name")%>,<%=map.get("goods_price")%>,<%=map.get("goods_url")%>">
					<input type="checkbox" name="goodsIds" id="goodsIds" value="<%=map.get("goods_id")%>">
				</td>
				<td>
					<a href="html/<%=map.get("goods_id")%>.html">
						<img src="${imgurl }<%=map.get("goods_url")%>" width="100px" height="100px">
						<%=map.get("goods_name") %>
					</a>
				</td>
				<td>￥<%=map.get("goods_price") %></td>
				<td><input type="text" name="orderNumber" value="1" onchange="total(<%=map.get("goods_price")%>,this.value,<%=map.get("goods_id")%>);"></td>
				<td>￥<span class="total" id="total<%=map.get("goods_id")%>"><%=map.get("goods_price") %></span></td> 
				<td><a href="javascript:void(0)" onclick="del1('<%=map.get("goods_id")%>')">删除</a></td>
			</tr>
			<%}}}else{%>
				<tr>
					<td colspan="6">
						<h1>购物车里空荡荡的，什么也没有！</h1><br>
						<a href="front/list.shtml">请选择商品</a>
					</td>
				</tr>
			<%} %>
		</table>
		</div>
		<hr/>
		<div class="carfooter" style="display:${cars==null?'none':'block'}">
			<div class="row">
				<div class="col-sm-6">
					<a href="javascript:void(0)" onclick="del()">批量删除选中商品</a>
				</div>
				<div class="col-sm-6" align="right">
				<%if(cars!=null){
					Set<Integer> sets = cars.keySet();
				%>
				已选中
				<span style="color:red;"><%=sets.size() %></span>
				<%} %>件商品,总价:￥
				<span class="price" style="color:red;"></span>
				<input type="submit"class="btn btn-danger" value="去结算">
				<a class="btn btn-info"href="front/list.shtml">继续购物</a>
				</div>
			</div>
		</div>
	</section>	
	</form>
	<hr/>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript">
		function total(price,num,id){
			var tal = "#total"+id;
			$(tal).html(price*num);
			init();
		}
		function init(){
			var sum=0;
			
			$(".total").each(function(){
				sum = sum+parseFloat($(this).text());
			});
			
			$(".price").html(sum);
		}
		init();
		
		function checkboxall(che){
			var ids= document.getElementsByName("goodsIds");
			for(var i=0;i<ids.length;i++){
				ids[i].checked =che.checked;
			}
		}
		
		function del(){
			var bool = false;
			var ids = document.getElementsByName("goodsIds");
			for(var i = 0;i<ids.length;i++){
				if(ids[i].checked==true){
					bool=true;
				}
			}
			if(bool){
				if(confirm("您确定删除商品吗？")){
				var form=document.getElementById("f1");
					form.action="front/deleteGoods.shtml";
					form.submit();//提交表单
				}
			}else{
				alert("请选中要删除的商品！");
			}
		}
		function del1(id){
			var ids = document.getElementsByName("goodsIds");
			for(var i = 0;i<ids.length;i++){
				if(ids[i].value==id){
					ids[i].checked=true;
				}
			}
			var form=document.getElementById("f1");
				form.action="front/deleteGoods.shtml";
				form.submit();//提交表单
		}
		
	</script>
	
</body>
</html>