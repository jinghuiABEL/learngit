package cn.test.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.test.damain.User;
import cn.test.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {
   //处理登录请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          String username= request.getParameter("username");
        String password= request.getParameter("password");
        BusinessServiceImpl service =new BusinessServiceImpl();
       User user= service.login(username, password);
       if (user!=null) {
    	   request.getSession().setAttribute("user",user);
    	   //让用户登录成功后跳转
    	   response.sendRedirect(request.getContextPath()+"/index.jsp");
    	   return;
		
	 } request.setAttribute("message", "对不起登录失败");
	   request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doGet(request, response);
	}

}
