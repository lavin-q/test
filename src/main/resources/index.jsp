<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>第一个例子</title>
    <script src="${pageContext.request.contextPath }/webjars/jquery/2.1.4/jquery.js"></script>
    <script src="${pageContext.request.contextPath }/webjarslocator/jquery/jquery.js"></script>
</head>

<body>
<h1>${name}:你好，欢迎访问该网页</h1>
<shiro:hasPermission name="user:list"><!-- 这个a标签是可以看见的 -->
<a href="${pageContext.request.contextPath }/user/list" target="_blank">跳转到用户列表(有权限)</a>
</shiro:hasPermission>
<br/>
<shiro:hasPermission name="user:add"><!-- 这个a标签是看不见的 -->
<a href="${pageContext.request.contextPath }/user/add" target="_blank">跳转到新增用户列表(无权限)</a>
</shiro:hasPermission>
</body>
</html>