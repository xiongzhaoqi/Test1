package org.softedu.file.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.softedu.file.bean.FileInfo;
import org.softedu.file.dao.FileDao;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {

	public DownloadServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String flag = request.getParameter("flag");
		FileDao filedao = new FileDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		FileInfo files = filedao.selectByid(id);
		String path =files.getPath();
		String fileName =files.getFile_name();
		if ("download".equals(flag)) {
			
			File file = new File(path + fileName);
			if (file.exists()) {
				OutputStream o = response.getOutputStream();
				byte b[] = new byte[1024];
				File fileLoad = new File(path + fileName);
				response.setHeader("Content-disposition",
						"attachment;filename=" + fileName);
				response.setContentType(files.getContent_type());

				long fileLength = fileLoad.length();
				String length = String.valueOf(fileLength);
				response.setHeader("Content_Length", length);
				FileInputStream in = new FileInputStream(fileLoad);
				int n = 0;
				while ((n = in.read(b)) != -1) {
					o.write(b, 0, n);
				}
			} else {
				filedao.fileDel(id);
				response.sendRedirect("../servlet/FileServlet?position=boss");
			}
		} else if ("del".equals(flag)) {
			filedao.fileDel(id);
			File file=new File(path+fileName);
			if (file.exists()) {
				file.delete();
			}
			response.sendRedirect("../servlet/FileServlet?position=boss");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {

	}

}
