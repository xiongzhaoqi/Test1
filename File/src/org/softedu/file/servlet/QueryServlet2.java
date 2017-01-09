package org.softedu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.softedu.file.bean.Depart;
import org.softedu.file.bean.Employe;
import org.softedu.file.bean.User;
import org.softedu.file.dao.DepartDao;
import org.softedu.file.dao.EmployeDao;
import org.softedu.file.dao.UserDao;
import org.softedu.file.util.PageBean;

@SuppressWarnings("serial")
public class QueryServlet2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryServlet2() {
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
		String flag = null;
		flag = request.getParameter("flag");
		//List<Employe> list = new ArrayList<Employe>();
		String depart=request.getParameter("depart");
		EmployeDao ed=new EmployeDao();
		UserDao userdao = new UserDao();
		PageBean pagebean = new PageBean();
		HttpSession session = request.getSession();
		

		int pageNum = 5;
		int currPage;
		@SuppressWarnings("unused")
		String url = "./bossyuangong.jsp";

		if (request.getParameter("pages") == null) {
			currPage = 0;
		} else {
			currPage = new Integer(request.getParameter("pages")).intValue();
		}

		pagebean.setPageNum(pageNum);
		pagebean.setCurrPage(currPage);
		
		if ("xiugai".equals(flag)){
			int eid = Integer.parseInt(request.getParameter("eid"));
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String department = request.getParameter("department");
			String position = request.getParameter("position");
			String employedtime = request.getParameter("employedtime");
			String telphone = request.getParameter("telphone");
			String password = request.getParameter("password");
			userdao.update(eid, name, sex, department, position, employedtime,
					telphone, password);
			
			List<Employe> list = ed.sel(eid);
			Iterator<Employe> it = list.iterator();
			Employe em = it.next();
			List<Employe> list2=ed.sel(em.getDepartment());
			session.setAttribute("list2", list2);
			response.sendRedirect("departinfo.jsp");
		}else if("insert".equals(flag)){
			User user = new User();
			int eid = Integer.parseInt(request.getParameter("eid"));
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String department = request.getParameter("department");
			String position = request.getParameter("position");
			String employedtime = request.getParameter("employedtime");
			String telphone = request.getParameter("telphone");
			String password = request.getParameter("password");
			user.setEid(eid);
			user.setName(name);
			user.setSex(sex);
			user.setDepartment(department);
			user.setPosition(position);
			user.setEmployedtime(employedtime);
			user.setTelphone(telphone);
			user.setPassword(password);
			boolean b = userdao.insert(user);
			if (b){
				List<Employe> list = ed.sel(eid);
				Iterator<Employe> it = list.iterator();
				Employe em = it.next();
				List<Employe> list2=ed.sel(em.getDepartment());
				session.setAttribute("list2", list2);
				response.sendRedirect("departinfo.jsp");
			}
				
			
		}else if (flag.equals("shanchu")) {
			int eid = Integer.parseInt(request.getParameter("eid"));
			userdao.del(eid);
			//List<Employe> list2=new ArrayList<Employe>();
			//list2=ed.sel(flag);
			//session.setAttribute("list2", list2);
			//response.sendRedirect("departinfo.jsp");
			//List<Employe> list = ed.sel(depart);
			//Iterator<Employe> it = list.iterator();
			//Employe em = it.next();
			List<Employe> list2=ed.sel(depart);
			session.setAttribute("list2", list2);
			response.sendRedirect("departinfo.jsp");
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
