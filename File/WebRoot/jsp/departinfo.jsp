<%@ page language="java" import="java.util.*,org.softedu.file.bean.*"
	pageEncoding="utf-8"%>
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
		<link href="css/bossyuangong.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body >
  <div style="background-image: url('./image/departinfo.jpg'); width: 819px; height: 596px">
  <center>

	</head>

	<body>
		<table border="1px" cellspacing="0" bordercolor="#000" style="margin-top: 200px">
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
				Employe e = (Employe) session.getAttribute("e");

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
				<a href="jsp/updateyuangong2.jsp?eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">修改</a>
				<a href="jsp/QueryServlet2?flag=shanchu&eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">删除</a>
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
				<a href="jsp/updateyuangong2.jsp?eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">修改</a>
				<a href="jsp/QueryServlet2?flag=shanchu&eid=<%=em.getEid()%>&depart=<%=em.getDepartment()%>">删除</a>
				</td>
			</tr>
			<%
				}
					}
				}
			%>

		</table>

		<div style="margin-top: 10px">
			<a href="jsp/insertuser2.jsp?department=<%=session.getAttribute("department")%>">添加用户</a>
		</div>
		<div style="margin-top: 10px">
		<a href="LoginServlet?flag=manager&id=<%=session.getAttribute("id") %>">返回</a>
       </div>
		


   </center>
  </div>
	</body>

</html>
