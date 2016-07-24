<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>首页</title>
	
  </head>
  
  <body>
       <c:if test="${user!=null }">
                欢迎您：${user.username } <a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
       </c:if>
       <c:if test="${user==null }">
	         <a href="${pageContext.request.contextPath }/servlet/RegisterUIServlet">注册</a>
	         <a href="${pageContext.request.contextPath }/servlet/LoginUIServlet">登录</a>
      </c:if>
  </body>
</html>
