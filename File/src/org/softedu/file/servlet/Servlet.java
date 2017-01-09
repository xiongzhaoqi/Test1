package org.softedu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Servlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		String info=request.getParameter("info");
		String department=request.getParameter("department");
		EmployeDao em=new EmployeDao();
		DepartDao dd=new DepartDao();
		if (department!=null && info==null){
			List<Depart> list=new ArrayList<Depart>();
			list=dd.sel(department);
			request.setAttribute("result", list);
			request.getRequestDispatcher("jsp/boss.jsp").forward(request, response);
		}
		else if(department!=null && info!=null){
			List<Employe> list=new ArrayList<Employe>();
			list=em.sel(department);
			request.setAttribute("result", list);
			request.getRequestDispatcher("jsp/showinfo.jsp").forward(request, response);
		}
		

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
