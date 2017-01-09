package org.softedu.file.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softedu.file.dao.FileDao;

@SuppressWarnings("serial")
public class RightsServlet extends HttpServlet {

	public RightsServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		@SuppressWarnings("unused")
		PrintWriter out = response.getWriter();
		String dept=request.getParameter("dept");
		String position=request.getParameter("position");
		FileDao deptdao=new FileDao();
		if("boss".equals(position)){
			if("shichangbu".equals(dept)){
				List list=deptdao.deptSelect(dept);
				
				request.setAttribute("list",list);
				request.getRequestDispatcher("../resource_jsp/marketdepartmentresource.jsp").forward(request, response);
			}else if("qiyefazhanbu".equals(dept)){
				List list=deptdao.deptSelect(dept);
				request.setAttribute("list",list);
				request.getRequestDispatcher("../resource_jsp/developdepartmentresource.jsp").forward(request, response);
			}else if("caiwubu".equals(dept)){
				List list=deptdao.deptSelect(dept);
				request.setAttribute("list",list);
				request.getRequestDispatcher("../resource_jsp/financedepartmentresource.jsp").forward(request, response);
			}else if("xueshubu".equals(dept)){
				List list=deptdao.deptSelect(dept);
				request.setAttribute("list",list);
				request.getRequestDispatcher("../resource_jsp/academicdepartmentresource.jsp").forward(request, response);
			}else if("dongshihui".equals(dept)){
				List list=deptdao.deptSelect(dept);
				request.setAttribute("list",list);
				request.getRequestDispatcher("../resource_jsp/bosssource.jsp").forward(request, response);
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	public void init() throws ServletException {
		
	}

}
