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

<title>商品修改</title>
</head>
<body>
	<form action="<%=basePath%>goods/update.do" id="goodsform" method="post" enctype="multipart/form-data">
		<input type="hidden" name="goodsId" value="${goods.goods_id }">
		<div class="addform">
		<div class="goodsup">
			<div id="pp"><p>基本信息</p></div>
			<div class="text">
				<div id="baseg">
					<lable>商品名称</lable>
					<input type="text" name="goodsName"   value="${goods.goods_name } "/>
					<span id ="nameinfo" style="color:red"></span>
				</div>
				<div id="baseg">
					<lable>商品价格</lable>
					<input type="text" name="goodsPrice"   value="${goods.goods_price }" />
					<span id ="nameinfo" style="color:red"></span>
				</div>
				<div class="clear"></div>
				<div id="baseg">
					<lable>商品库存</lable>
					<input type="text" name="goodsCount"   value="${goods.goods_count }" />
					<span id ="nameinfo" style="color:red"></span>
				</div>
				<div id="baseg">
					<lable>商品类型</lable>
					<input type="text" name="goodsType"  value="${goods.goods_type } "/>
					<span id ="nameinfo" style="color:red"></span>
				</div>
				<div id="baseg">
					<lable>商品图片</lable>
					<input type="file" name="shopimg" onchange="uploadImg()"/>
					<input type="hidden" name="goodsUrl" id="goodsUrl"/>
				</div>
				<div id="baseg">
					<lable>上传图片大小(150*150px)</lable>
				</div>
			</div>
				<div class="rimg">
					<img id="eshopping" alt="" src="${imgurl }${goods.goods_url }"  width="140px" height="140px">
				</div>
			<div class="clear"></div>
		</div>
		<div class="goodsdown">
		  	 <div id="pp"><p>商品详情</p></div>
				<div id="baset">
					<textarea class ="ckeditor" id="goodsDesc" name="goodsDesc">${goods.goods_desc}</textarea>
				</div>
			<div class="subres">
				<input type="submit" value="保存商品" style="background-color:#FF6100;">
				<input type="reset" value="重置信息" style="background-color:#00FF00;">
			</div>
			<div class="clear"></div>
		</div>
		</div>
	</form>
	<script type="text/javascript">	
	    var info = "${info}";
	    if(info.length>1){
	    	alert(info);
	    }
	    function uploadImg(){
	    	var options={
	    			url:"goods/upload.do",
	    			dataType:"json",
	    			type:"post",
	    			success:function(data){
	    				$("#goodsUrl").val(data.path);
	    				$("#eshopping").attr("src",data.url);	
	    			}
	    	};
	    	$("#goodsform").ajaxSubmit(options);
	    }
	    
	</script>
	
</body>
</html>