<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>     
       <title>登录界面</title>  
  </head>
  
<body>
<form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
 用户名：<input type="text" name="username"/>
 密码：<input type="password" name="password"/>
 <input type="submit"   value="登录">
 
 </body>
</html>