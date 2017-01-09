<%@ page language="java"
	import="java.util.*,org.softedu.file.bean.*,org.softedu.file.dao.*,org.softedu.file.util.DateUtil"
	pageEncoding="utf-8"%>
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

		<link rel="stylesheet" style="text/css" href="css/info.css">
	</head>

	<body>
	<%
		Employe e=(Employe)session.getAttribute("e");
	%>
		<div class="body">
			<div style="border: 500px 20px; margin-left: 50px; margin-top: 85px;">
			    <a class="head2">今天是<%=DateUtil.dateManager() %></a>
				<a class="head2" href="query?flag=showall&id=<%=e.getEid()%>">查看员工信息</a>
		        <a class="head2" href="resource_jsp/bossmanager.jsp">资源管理</a>
				<a class="head2" href="./changepassword.jsp?id=<%=e.getEid()%>">修改密码</a>
			</div>
			<div class="left">
				<%
					String department = request.getParameter("department");
					if (department == null) {
						department = "xueshubu";
						DepartDao dd = new DepartDao();
						List<Depart> list = dd.sel(department);
						Iterator<Depart> it = list.iterator();
						while (it.hasNext()) {
							Depart d = it.next();
				%>
				<center>
					简介(<%=d.getDepartment()%>)
				</center>
				<br><%=d.getInfo()%><br />
				<br />
				&nbsp;&nbsp;&nbsp;负责人：<%=d.getManager()%>
				<br />
				<%
					}
					} else if (department != null) {

						List<Depart> list = (List) request.getAttribute("result");
						Iterator<Depart> it = list.iterator();
						while (it.hasNext()) {
							Depart d = it.next();
				%>
				<center>
					简介(<%=d.getDepartment()%>)
				</center>
				<br><%=d.getInfo()%><br />
				<br />
				&nbsp;&nbsp;&nbsp;负责人：<%=d.getManager()%>
				<br />
				<%
					}
					}
				%>
			</div>
			<div class="right">
				<a class="bodyr" href="Servlet?department=xueshubu">学术部门</a>
				<br />
				<br />
				<a class="bodyr" href="Servlet?department=caiwubu">财务部门</a>
				<br />
				<br />
				<a class="bodyr" href="Servlet?department=qiyebu">企业部门</a>
				<br />
				<br />
				<a class="bodyr" href="Servlet?department=shichangbu">市场部门</a>
			</div>

		</div>
	</body>
</html>
