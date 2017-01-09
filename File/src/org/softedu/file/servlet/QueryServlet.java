package org.softedu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.softedu.file.bean.Employe;
import org.softedu.file.bean.User;
import org.softedu.file.dao.EmployeDao;
import org.softedu.file.dao.UserDao;
import org.softedu.file.util.PageBean;

@SuppressWarnings("serial")
public class QueryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = resp.getWriter();
		String flag = null;
		flag = req.getParameter("flag");
		List list = new ArrayList();
		UserDao userdao = new UserDao();
		PageBean pagebean = new PageBean();
		HttpSession session = req.getSession();
		int pageNum = 5;
		int currPage;
		@SuppressWarnings("unused")
		String url = "./bossyuangong.jsp";
		if (req.getParameter("pages") == null) {
			currPage = 0;
		} else {
			currPage = new Integer(req.getParameter("pages")).intValue();
		}
		pagebean.setPageNum(pageNum);
		pagebean.setCurrPage(currPage);
		if (flag.equals("showxueshu")) {
			list = userdao.queryXueShuUsers();
			session.setAttribute("list", list);
			session.setAttribute("pageNum", pagebean.getPageNum());
			session.setAttribute("currentPage", pagebean.getCurrPage());
			resp.sendRedirect("./bossyuangong.jsp");
		} else if (flag.equals("showqiye")) {
			list = userdao.queryQiYeUsers();
			session.setAttribute("list", list);
			session.setAttribute("pageNum", pagebean.getPageNum());
			session.setAttribute("currentPage", pagebean.getCurrPage());
			resp.sendRedirect("./bossyuangong.jsp");
		} else if (flag.equals("showshichang")) {
			list = userdao.queryShiChangUsers();
			session.setAttribute("pageNum", pagebean.getPageNum());
			session.setAttribute("currentPage", pagebean.getCurrPage());
			session.setAttribute("list", list);
			resp.sendRedirect("./bossyuangong.jsp");
		} else if (flag.equals("showcaiwu")) {
			list = userdao.queryCaiWuUsers();
			session.setAttribute("pageNum", pagebean.getPageNum());
			session.setAttribute("currentPage", pagebean.getCurrPage());
			session.setAttribute("list", list);
			resp.sendRedirect("./bossyuangong.jsp");
		} else if (flag.equals("showall")) {
			list = userdao.queryAllUsers(pagebean);
			session.setAttribute("list", list);
			session.setAttribute("pagebean", pagebean);
			req.getRequestDispatcher("./bossyuangong.jsp").forward(req, resp);
		}

		else if (flag.equals("change")) {
			String newPassword = req.getParameter("textpassword");
			int id1 = Integer.parseInt(req.getParameter("id"));
			String oldPassword = req.getParameter("oldpassword");
			if (userdao.changePassword(id1, newPassword, oldPassword))
			// resp.sendRedirect("./login.jsp");
			{
				req.setAttribute("id", id1);
				req.getRequestDispatcher("./login.jsp").forward(req, resp);
			} else
				req.getRequestDispatcher("./changepassword.jsp").forward(req,
						resp);
		}

		else if (flag.equals("xiugai")) {
			int eid = Integer.parseInt(req.getParameter("eid"));
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String department = req.getParameter("department");
			String position = req.getParameter("position");
			String employedtime = req.getParameter("employedtime");
			String telphone = req.getParameter("telphone");
			String password = req.getParameter("password");
			userdao.update(eid, name, sex, department, position, employedtime,
					telphone, password);
			resp.sendRedirect("./bossyuangong.jsp");
		} else if (flag.equals("shanchu")) {
			int eid = Integer.parseInt(req.getParameter("eid"));
			userdao.del(eid);
			list = userdao.queryAllUsers(pagebean);
			session.setAttribute("list", list);
			session.setAttribute("pagebean", pagebean);
			req.getRequestDispatcher("./bossyuangong.jsp").forward(req, resp);
		} else if (flag.equals("insert")) {
			User user = new User();
			int eid = Integer.parseInt(req.getParameter("eid"));
			String name = req.getParameter("name");
			String sex = req.getParameter("sex");
			String department = req.getParameter("department");
			String position = req.getParameter("position");
			String employedtime = req.getParameter("employedtime");
			String telphone = req.getParameter("telphone");
			String password = req.getParameter("password");
			user.setEid(eid);
			user.setName(name);
			user.setSex(sex);
			user.setDepartment(department);
			user.setPosition(position);
			user.setEmployedtime(employedtime);
			user.setTelphone(telphone);
			user.setPassword(password);
			boolean b = userdao.insert(user);
			if (b)
				resp.sendRedirect("./bossyuangong.jsp");
//		}else if("xueshubu".equals(flag)||"caiwubu".equals(flag)||"qiyebu".equals(flag)||"shichangbu".equals(flag)){
//			EmployeDao ed=new EmployeDao();
//			List<Employe> list2=new ArrayList<Employe>();
//			int eid=Integer.parseInt(req.getParameter("eid"));
//			list2=ed.sel(flag);}
		} else if ("xueshubu".equals(flag) || "caiwubu".equals(flag)
				|| "qiyebu".equals(flag) || "shichangbu".equals(flag)) {
			EmployeDao ed = new EmployeDao();
			List<Employe> list2 = new ArrayList<Employe>();
			list2 = ed.sel(flag);
			int eid=Integer.parseInt(req.getParameter("eid"));
			session.setAttribute("id", eid);
			session.setAttribute("department", flag);
			session.setAttribute("list2", list2);
			session.setAttribute("pageNum", pagebean.getPageNum());
			session.setAttribute("currentPage", pagebean.getCurrPage());
			resp.sendRedirect("jsp/departinfo.jsp");
		}
	}
}
