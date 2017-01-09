package org.softedu.file.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softedu.file.dao.FileDao;

@SuppressWarnings("serial")
public class DeptServlet extends HttpServlet {
	public DeptServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String position = request.getParameter("position");
		String dept = request.getParameter("dept");
		FileDao deptdao=new FileDao();
		if ("boss".equals(position)) {
			response
					.sendRedirect("../resource_jsp/departmentinner.jsp?position=boss");
		} else if ("manager".equals(position)) {
				List list = deptdao.deptSelect(dept);
                FileDao bdao=new FileDao();
                List list1=bdao.deptSelect("dongshihui");
                request.setAttribute("list1",list1);
				request.setAttribute("list", list);
				request.getRequestDispatcher(
						"../resource_jsp/deptsource.jsp?position=manager")
						.forward(request, response);
		}
	}

	public void init() throws ServletException {

	}

}
