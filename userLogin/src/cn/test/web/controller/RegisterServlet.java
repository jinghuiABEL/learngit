package cn.test.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.test.damain.User;
import cn.test.exception.UserExistException;
import cn.test.service.impl.BusinessServiceImpl;
import cn.test.utils.WebUtils;
import cn.test.web.formbean.RegisterForm;
         //处理注册请求
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1.对表单合法性进行校验
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b=form.validate();
		//2.如果校验失败，则跳回注册页面
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
			
		}
		//3.如校验合法，则找service对注册请求处理
		User user=new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		
		BusinessServiceImpl service =new BusinessServiceImpl();
		try {
			service.register(user);
			//6.如果service处理成功，则跳回到网站的全局消息界面，并且为用户提示注册 成功的消息
			request.setAttribute("message", "恭喜您注册成功");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
			
		} catch (UserExistException e) {
			//4.如果service处理不成功，用户已经存在，则跳回注册页面，显示注册用户已经存在
			form.getErrors().put("username", "你注册的用户名已经存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			//5.如果service处理不成功，原因是其他原因，则跳回到网站的全局消息界面，为用户显示友好错误消息。
			request.setAttribute("message", "服务器发生未知的错误");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();
			return;
		}
		
		
		
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  doGet(request, response);
	}

}
