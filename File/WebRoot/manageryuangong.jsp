<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.softedu.file.bean.User"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%@page import="org.softedu.file.bean.Employe"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<link href="css/bossyuangong.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<%
			Employe e = (Employe) session.getAttribute("e");
		%>
		<div class="header">
			<div id="logo">
				<img src="images/logo.jpg" style="width: 1000px; height: 100px" />
			</div>
			<div id="menu">
				<div id="b">
					您好，今天是<%=DateUtil.dateManager()%></div>
				<div id="a">
					<a class="head2" href="resource_jsp/bossmanager.jsp">资源管理</a>
				</div>
				
				<div id="a">
					<a class="head2" href="changepassword.jsp?id=<%=e.getEid()%>">修改密码</a>
				</div>
			</div>
		</div>
		<div class="main">
			<div class="left" style="width:1000px">
				<div id="title">
					员工信息表
				</div>
				<div id="text">
					<table border="1px" cellspacing="0" bordercolor="#000">
						<tr height="30px" bgcolor="#9999FF">
							<td width="70">
								员工号
							</td>
							<td width="90">
								姓名
							</td>
							<td width="90">
								性别
							</td>
							<td width="90">
								职位
							</td>
							<td width="90">
								入职时间
							</td>
							<td width="90">
								电话
							</td>
							<td width="110">
								操作
							</td>
						</tr>
						<%
							List<Employe> list = (List) session.getAttribute("list2");
							int pageNum = (Integer) session.getAttribute("pageNum");
							int currentPage = (Integer) session.getAttribute("currentPage");
							int i = 1;
							if (list != null) {
								Iterator<Employe> it = list.iterator();
								while (it != null && it.hasNext()) {
									i++;
									Employe em = new Employe();
									em = it.next();
									if (i % 2 == 0) {
						%>
						<tr height="30px" bgcolor="">
							<td width="70"><%=em.getEid()%></td>
							<td width="90"><%=em.getName()%></td>
							<td width="90"><%=em.getSex()%></td>
							<td width="90"><%=em.getPosition()%></td>
							<td width="90"><%=em.getEmployedtime()%></td>
							<td width="90"><%=em.getTelphone()%></td>
							<td width="110">
								<a
									href="jsp/updateyuangong2.jsp?eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">修改</a><a
									href="jsp/QueryServlet2?flag=shanchu&eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">删除</a>
							</td>
						</tr>
						<%
							} else {
						%>
						<tr height="30px" bgcolor="#9999FF">
							<td width="70"><%=em.getEid()%></td>
							<td width="90"><%=em.getName()%></td>
							<td width="90"><%=em.getSex()%></td>
							<td width="90"><%=em.getPosition()%></td>
							<td width="90"><%=em.getEmployedtime()%></td>
							<td width="90"><%=em.getTelphone()%></td>
							<td width="110">
								<a
									href="jsp/updateyuangong2.jsp?eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">修改</a><a
									href="jsp/QueryServlet2?flag=shanchu&eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">删除</a>
							</td>
						</tr>
						<%
							}
								}
							}
						%>

					</table>

					<div>
						<a href="insertuser.jsp">添加用户</a>
					</div>
					<a
						href="jsp/QueryServlet2?flag=main&depart=<%=session.getAttribute("department")%>&eid=<%=session.getAttribute("eid")%>">返回</a>
				</div>
			</div>

		</div>
	</body>
</html>
