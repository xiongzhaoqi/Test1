<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.softedu.file.bean.FileInfo"%>
<%@page import="org.softedu.file.util.PageBean"%>
<%@page import="org.softedu.file.dao.FileDao"%>
<%@page import="org.softedu.file.util.Pagination"%>
<%@page import="org.softedu.file.bean.Employe"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/resource.css" rel="stylesheet" type="text/css" />
	</head>

	<body class="body" bgcolor="#E3E3E3">
		<%
			Employe e = (Employe) session.getAttribute("e");
		%>
		<div class="header">
			<div>
				<img src="image/1.jpg" width="980px" height="85px" />
			</div>
			<div class="body1">
				您好，今天是<%=DateUtil.dateManager()%>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="LoginServlet?flag=<%=e.getPosition()%>&id=<%=e.getEid()%>">部门信息</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="changepassword.jsp">修改密码</a>
			</div>
		</div>
		<div class="body2">
			<div class="bodyleft">
				<div class="title">
					<font color="#0066FF">资源管理</font>
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<table border="1" width="700px" align="center"
					style="border-collapse: collapse">
					<tr bgcolor="gray">
						<th>
							文件名称
						</th>
						<th>
							上传员工号
						</th>
						<th>
							部门名称
						</th>
						<th>
							上传日期
						</th>
					</tr>
					<%
						request.setCharacterEncoding("utf-8");
						response.setCharacterEncoding("utf-8");
						int pageNum = 10;
						int currPage;
						String url = "resource_jsp/allemployee.jsp";
						PageBean pagebean = new PageBean();
						FileDao filedao = new FileDao();
						List list = new ArrayList();
						if (request.getParameter("pages") == null) {
							currPage = 0;
						} else {
							currPage = new Integer(request.getParameter("pages"))
									.intValue();
						}

						pagebean.setPageNum(pageNum);
						pagebean.setCurrPage(currPage);
						list = filedao.queryAllFileuploads(pagebean);
						int i = 1;
						if (list.size() != 0) {
							Iterator it = list.iterator();
							while (it.hasNext()) {
								i++;
								FileInfo fileinfo = new FileInfo();
								fileinfo = (FileInfo) it.next();
								if (i % 2 == 0) {
					%>
					<tr>
						<td>
							<%=fileinfo.getFile_name()%>
						</td>
						<td>
							<%=fileinfo.getEid()%>
						</td>
						<td>
							<%=fileinfo.getDepartment()%>
						</td>
						<td>
							<%=fileinfo.getUploadstime()%>
						</td>
					</tr>
					<%
						} else {
					%>

					<tr>
						<td>
							<%=fileinfo.getFile_name()%>
						</td>
						<td>
							<%=fileinfo.getEid()%>
						</td>
						<td>
							<%=fileinfo.getDepartment()%>
						</td>
						<td>
							<%=fileinfo.getUploadstime()%>
						</td>
					</tr>

					<%
						}
							}
						}
					%>
				</table>
				<p align=center>
					<%=Pagination.getPaginationScript(pagebean.getCurrPage(),
					pagebean.getPageNum(), pagebean.getRecordNum(), url)%>
				</p>
			</div>
			<div class="bodyright">
				<div class="title">
					<font color="#0066FF">功能区</font>
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div align="center">
					<form action="resource_jsp/upload.jsp?eid=<%=e.getEid()%>"
						method="post">
						<input type="submit" name="button" value="上传资料">
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
