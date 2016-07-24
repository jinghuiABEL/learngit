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
         //����ע������
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1.�Ա��Ϸ��Խ���У��
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		boolean b=form.validate();
		//2.���У��ʧ�ܣ�������ע��ҳ��
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
			
		}
		//3.��У��Ϸ�������service��ע��������
		User user=new User();
		WebUtils.copyBean(form, user);
		user.setId(WebUtils.generateID());
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		
		BusinessServiceImpl service =new BusinessServiceImpl();
		try {
			service.register(user);
			//6.���service����ɹ��������ص���վ��ȫ����Ϣ���棬����Ϊ�û���ʾע�� �ɹ�����Ϣ
			request.setAttribute("message", "��ϲ��ע��ɹ�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
			
		} catch (UserExistException e) {
			//4.���service�����ɹ����û��Ѿ����ڣ�������ע��ҳ�棬��ʾע���û��Ѿ�����
			form.getErrors().put("username", "��ע����û����Ѿ�����");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			//5.���service�����ɹ���ԭ��������ԭ�������ص���վ��ȫ����Ϣ���棬Ϊ�û���ʾ�Ѻô�����Ϣ��
			request.setAttribute("message", "����������δ֪�Ĵ���");
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
