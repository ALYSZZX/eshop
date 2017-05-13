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
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/goodsinfo_add.css" />
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/bootstrap.css" />

<script type="text/javascript" src = "<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src = "<%=basePath%>res/js/jquery-form.js"></script>
<script type="text/javascript" src = "<%=basePath%>res/ckeditor/ckeditor.js"></script>
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

<title>添加商品</title>
</head>
<body>
<hr>
	<form action="<%=basePath%>goods/add.do" id="goodsform" method="post" enctype="multipart/form-data">
		<div class="addform">
		<div class="goodsup">
			<div id="pp"><p>基本信息</p></div>
			<div class="text">
				<div id="baseg">
					<lable>商品名称</lable>
					<p class="form-control-static">${goods.goods_name}</p>
				</div>
				<div id="baseg">
					<lable>商品价格</lable>
					<p class="form-control-static">${goods.goods_price}</p>
				</div>
				<div id="baseg">
					<lable>商品库存</lable>
					<p class="form-control-static">${goods.goods_count}</p>
				</div>
				<div id="baseg">
					<lable>商品类别</lable>
					<p class="form-control-static">${goods.goods_type}</p>
				</div>
				<div id="baseg">
					<lable>上传图片大小(150*150px)</lable>
				</div>
				<div class="clear"></div>
			</div>
				<div class="rimg">
					<img id="eshopping" alt="" src="${imgurl}${goods.goods_url }" width="140px" height="140px">
				</div>
			<div class="clear"></div>
		</div>
		<div class="goodsdown">
		  	 <div id="pp"><p>商品详情</p></div>
				<div id="baset">
					 ${goods.goods_desc}
				</div>
			<div class="subres">
				<a class="btn btn-success" href="<%=basePath%>goods/loadupdate.do?goodsId=${goods.goods_id}">修改商品</a>
				<a class="btn btn-warning" href="<%=basePath%>goods/list.do">返回上一级</a>
			</div>
			<div class="clear"></div>
		</div>
		</div>
	</form>
</body>
</html>