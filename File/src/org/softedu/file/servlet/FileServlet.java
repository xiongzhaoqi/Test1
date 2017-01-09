package org.softedu.file.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softedu.file.bean.FileInfo;
import org.softedu.file.bean.User;
import org.softedu.file.dao.FileDao;
import org.softedu.file.dao.UserDao;
import org.softedu.file.util.FileUtil;

@SuppressWarnings("serial")
public class FileServlet extends HttpServlet {
	public FileServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String position = request.getParameter("position");
		if ("boss".equals(position)) {
			FileDao filedao = new FileDao();
			List list = filedao.fileSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("../resource_jsp/bossmanager.jsp")
					.forward(request, response);
		} else if ("manager".equals(position)) {
			FileDao filedao = new FileDao();
			List list = filedao.fileSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("../resource_jsp/bossmanager.jsp")
					.forward(request, response);
		} else {
			FileDao filedao = new FileDao();
			List list = filedao.fileSelect();
			request.setAttribute("list", list);
			request.getRequestDispatcher("../resource_jsp/allemployee.jsp")
					.forward(request, response);
		}

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charSet=utf-8");
		
		String flag = request.getParameter("flag");
		int eid = Integer.parseInt(request.getParameter("eid"));
		UserDao udao = new UserDao();
		FileDao filedao = new FileDao();
		if ("upload".equals(flag)) {
			Date now = new Date();
			FileUtil fileUtile = new FileUtil();
			SimpleDateFormat df = new SimpleDateFormat(("yyyyMMddHHmm"));
			String tempPathStr = request.getRealPath("/file_temp");
			String realFilePathStr = request.getRealPath("/file_upload/");
			String realFileName = df.format(now);
			String fileType[] = fileUtile.upload(request, tempPathStr,
					realFilePathStr, realFileName);

			User user = new User();
			FileInfo files = new FileInfo();
			if (null == user) {
				response.sendRedirect("../resource_jsp/fail.html");
			} else {
				user.setEid(eid);
				user = udao.eidSelect(eid);
				files.setEid(eid);
				files.setDepartment(user.getDepartment());
				files.setName(user.getName());
				files.setPosition(user.getPosition());

				// files.setFile_id(1);
				files.setPath(realFilePathStr + "\\");
				
				String name=fileType[2]+fileType[0];
				
				byte[] names = name.getBytes("iso-8859-1");
				String namess = new String(names,"utf-8");
				files.setFile_name(namess);
				
				
				files.setContent_type(fileType[1]);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
				Date time = new Date();
				String nowtime = sdf.format(time);
				files.setUploadstime(nowtime);
				int i = filedao.fileInsert(files);
				if ("fileIsNull".equals(fileType[0])
						|| "uploadFalse".equals(fileType[0]) || i <= 0) {
					response.sendRedirect("../resource_jsp/fail.html");
				} else {
					String position = request.getParameter("position");
					if ("boss".equals(position) || "manager".equals(position)) {
						List list = filedao.fileSelect();
						request.setAttribute("list", list);
						request.getRequestDispatcher(
								"../resource_jsp/bossmanager.jsp").forward(
								request, response);
					} else {
						List list = filedao.fileSelect();
						request.setAttribute("list", list);
						request.getRequestDispatcher(
								"../resource_jsp/allemployee.jsp").forward(
								request, response);
					}

				}
			}
		}
	}

	public void init() throws ServletException {

	}

}
