package org.softedu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softedu.file.bean.Depart;
import org.softedu.file.bean.Employe;
import org.softedu.file.dao.DepartDao;
import org.softedu.file.dao.EmployeDao;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();

		int eid=0;
		String password=null;
		
		EmployeDao ed = new EmployeDao();
		DepartDao dd = new DepartDao();
		String flag = request.getParameter("flag");
		eid=Integer.parseInt(request.getParameter("id"));
		if ("login".equals(flag)) {
			eid= Integer.parseInt(request.getParameter("id"));
			password = request.getParameter("password");
		}
		
		if (password != null && eid != 0) {
			boolean log = false;

			log = ed.login(eid, password);
			if (log) {
				
				List<Employe> list = ed.sel(eid);
				Iterator<Employe> it = list.iterator();
				Employe e = it.next();
				request.getSession().setAttribute("e", e);
			
				// String position=it.next().getPosition();
				// String department=it.next().getDepartment();
				if ("employee".equals(e.getPosition())) {
					List<Depart> list2 = dd.sel(e.getDepartment());
					request.setAttribute("list2", list2);
					if("xueshubu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "学术部门");
					}else if("caiwubu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "财务部门");
					}else if("qiyebu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "企业部门");
					}else if("shichangbu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "市场部门");
					}
					request.getRequestDispatcher("jsp/employe.jsp").forward(
							request, response);
				} else if ("boss".equals(e.getPosition())) {
					request.getRequestDispatcher("jsp/boss.jsp").forward(
							request, response);
				} else if ("manager".equals(e.getPosition())) {
					List<Depart> list2 = dd.sel(e.getDepartment());
					if("xueshubu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "学术部门");
					}else if("caiwubu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "财务部门");
					}else if("qiyebu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "企业部门");
					}else if("shichangbu".equals(e.getDepartment())){
						request.getSession().setAttribute("depart", "市场部门");
					}
					request.setAttribute("list2", list2);
					//request.getSession().setAttribute("department", e.getDepartment());
					request.getRequestDispatcher("jsp/manager.jsp").forward(
							request, response);
				}

			} else {
				response.sendRedirect("login.jsp");
			}
		} else if ("employee".equals(flag)) {
			List<Employe> list = ed.sel(eid);
			Iterator<Employe> it = list.iterator();
			Employe e = it.next();
			List<Depart> list2 = dd.sel(e.getDepartment());
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("jsp/employe.jsp").forward(request,
					response);
		} else if ("manager".equals(flag)) {
			List<Employe> list = ed.sel(eid);
			Iterator<Employe> it = list.iterator();
			Employe e = it.next();
			List<Depart> list2 = dd.sel(e.getDepartment());
			//System.out.println(e.getDepartment());
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("jsp/manager.jsp").forward(request,
					response);
		}else if("boss".equals(flag)){
			response.sendRedirect("jsp/boss.jsp");
		}else if ("info".equals(flag)) {
			List<Employe> list = ed.sel(eid);
			Iterator<Employe> it = list.iterator();
			Employe e = it.next();
			list = ed.sel(e.getDepartment());
			request.setAttribute("result", list);
			request.getRequestDispatcher("jsp/departinfo.jsp").forward(request,
					response);
		}

	}

	public void init() throws ServletException {
	}

}
