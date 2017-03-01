<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <pg:page export="first,last">
    	当前<label>${first }-${last }</label>共<label>${total }</label>项
    </pg:page>
    <pg:first export="pageUrl" unless="current">
    	<c:if test="${pageUrl!=null}" >
    		<a href="${pageUrl }" class="first">首页</a>
    	</c:if>
    </pg:first>
    <pg:prev export="pageUrl" ifnull="${true }">
    	<c:if test="${pageUrl!=null }" >
    		<a href="${pageUrl }" class="prev" title="上一页">上一页</a>
    	</c:if>
    </pg:prev>
    <pg:pages>
    	<c:choose>
    		<c:when test="${pageNumber eq currentPageNumber }">
    			<font color="red">${pageNumber }</font>
    		</c:when>
    		<c:otherwise>
    			<a href="${pageUrl }">${pageNumber }</a>
    		</c:otherwise>
    	</c:choose>
    </pg:pages>
    <pg:next export="pageUrl" ifnull="${true }">
    	<c:if test="${pageUrl!=null }" >
    		<a href="${pageUrl}" class="next">下一页</a>
    	</c:if>
    </pg:next>
    <pg:last >
    	<a href="${pageUrl}">尾页</a> 
    </pg:last>
    
</body>
</html>