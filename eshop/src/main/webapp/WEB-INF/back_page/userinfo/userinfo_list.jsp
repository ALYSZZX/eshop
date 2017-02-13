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
<title>用户管理</title>
</head>
<body>
		<form action="user/list.do" method="post">
			<div class="query">
				<div id="inp">
					<lable>姓名:</lable><input type="text" name="userName" placeholder="请输入姓名" />
				</div>
				<div id="sub">
		     		<input type="submit" value="查询">
		     		<a href="user/loadadd.do">添加用户</a>
		     	</div>
		     	<div id="clear"></div>
		    </div>
		 </form>
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
						<th><a href="">修改&nbsp&nbsp</a>删除</th>
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
</body>
</html>