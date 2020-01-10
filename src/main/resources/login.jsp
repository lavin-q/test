<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Login</title>
</head>

<body>
<h1>登录页面----${error}</h1>
<form:form action="${pageContext.request.contextPath }/login"
           method="post">
    用户名：<input type="text" name="userName">
    <br />
    密码：<input type="passwordParam" name="password"/>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>