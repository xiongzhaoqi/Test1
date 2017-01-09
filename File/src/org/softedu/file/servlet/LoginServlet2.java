package org.softedu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.softedu.file.bean.User;
import org.softedu.file.dao.UserDao;

@SuppressWarnings("serial")
public class LoginServlet2 extends HttpServlet {

	public LoginServlet2() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		UserDao userdao = new UserDao();
		String flag = request.getParameter("flag");
		if ("login".equals(flag)) {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			User user=userdao.selAll(Integer.parseInt(id), password);
			request.getSession().setAttribute("user", user);
			boolean f = userdao.login(Integer.parseInt(id), password);
			if (true == f) {
				
			} else {
				response.sendRedirect("../login.jsp");
			}
		}
	}

	public void init() throws ServletException {
	}

}
