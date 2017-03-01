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
<link rel ="stylesheet" href="<%=basePath%>res/css/bootstrap.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row" align="center" style="margin-top:50px;">
				<img src="<%=basePath%>res/assert/404.jpg">
		</div>
	</div>
</body>
</html>