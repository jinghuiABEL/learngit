<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>     
       <title>注册界面</title>  
 </head>
  
<body>
     <form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
          <tr>
               <td>
                      <div><label>用户名:</label><input id="username" name="username" type="text" value="${ form.username }"></div>
                      <span class="message" >${form.errors.username}</span>
               </td>         
          </tr>
          <tr>
               <td>
                     <div><label>密&nbsp码:</label><input id="pass" name="password" type="password"/></div>
                     <span class="message" >${form.errors.password}</span>
              </td>
          </tr>
          <tr>
              <td>
                      <div><label>邮&nbsp箱:</label><input id="email" name="email" data-ideal="required email" type="email"/></div>
                      <span class="message" >${form.errors.email}</span>
              </td>
         </tr>
         <tr>
               <td>
                       <div><label>出生日期:</label><input name="date" class="datepicker" data-ideal="date" type="text" placeholder="年/月/日"/></div>
                      <span class="message" >${form.errors.birthday}</span>
               </td>
        </tr>
                    <button type="submit">注册</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button id="reset" type="button">重置</button>
      </form>
 </body>
</html>