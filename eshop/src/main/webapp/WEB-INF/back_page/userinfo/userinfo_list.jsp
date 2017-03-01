<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
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
<link type="text/css" rel="stylesheet" href="<%=basePath%>res/css/bootstrap.min.css">
<script type="text/javascript" src="<%=basePath%>res/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>res/js/bootstrap.min.js"></script>
<title>用户管理</title>
</head>
<body>
		<form action="<%=basePath%>user/list.do" method="post">
			<div class="query">
				<div id="inp">
					<lable>姓名:</lable><input type="text" name="userName" placeholder="请输入姓名" />
				</div>
				<div id="sub">
		     		<input type="submit" value="查询">
		     		<a href="<%=basePath%>user/loadadd.do">添加用户</a>
		            <!-- Button trigger modal -->
		     	</div>
		    </div>
		 </form>
		<input type="button" value="导入用户信息" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" />
		<div id="clear"></div>
			<table border="1px" width="1000px">
					<tr height="50px">
						<th>用户编号</th>
						<th>用户姓名</th>
						<th>用户性别</th>
						<th>电话号码</th>
						<th>密码</th>
						<th>用户类型</th>
						<th>操作</th>
					</tr>
				<c:forEach items="${list }" var="user">
					<tr height="40px">
						<th>${user.userId }</th>
						<th>${user.userName }</th>
						<th>${user.userSex }</th>
						<th>${user.userPhone }</th>
						<th>${user.userPw }</th>
						<th>${user.userType }</th>
						<th>
						   <a href="<%=basePath %>user/loadupdate.do?userId=${user.userId}">修改</a>
                           <a href="javascript:void(0)" onclick="del('${user.userId}')">删除</a>
                        </th>
					</tr>
				</c:forEach>
			</table>
			<div align="center" style="padding: 10px; font-size:20px">
				<pg:pager items="${total}" url="user/list.do" 
								maxIndexPages="10" export="currentPageNumber=pageNumber" scope="request">
					<pg:param name="user.userName" value="${user.userName}"/>
					<jsp:include page="../../../res/jsp/pager_tag.jsp" flush="true"/>
				</pg:pager>
			</div>
			
			<!-- Modal -->
			<form action="<%=basePath %>user/imuser.do" method="post" enctype="multipart/form-data">
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				        <h4 class="modal-title" id="myModalLabel">用户信息--Excel导入</h4>
				      </div>
				      <div class="modal-body">
				        <input type="file" name="upfile">
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				        <button type="submit" class="btn btn-primary">导入数据</button>
				      </div>
				    </div>
				  </div>
				</div>
			</form>
			<!-- Excel导入结束 -->
			
			<script type="text/javascript">
			    function del(userId){
			    	if(confirm("你确定要删除吗?")){
			    	    window.location="<%=basePath %>user/delete.do?userId="+userId;
			    	}
			    }
			</script>
			
			
</body>
</html>