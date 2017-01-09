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

		<title>My JSP 'showinfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="css/resource.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<div class="header">
			<div>
				<img src="image/1.jpg" width="980px" height="85px" />
			</div>
			<div class="body1">
				您好，今天是<%=DateUtil.dateManager()%>
			</div>
		</div>
		<table border="1">
			<tr>
				<td>
					员工号
				</td>
				<td>
					姓名
				</td>
				<td>
					性别
				</td>
				<td>
					部门
				</td>
				<td>
					职位
				</td>
				<td>
					时期
				</td>
				<td>
					联系方式
				</td>
				<td>
					密码
				</td>
			</tr>
			<%
				List<Employe> list = (List) request.getAttribute("result");
				Iterator<Employe> it = list.iterator();
				while (it.hasNext()) {
					Employe em = it.next();
			%>
			<tr>
				<td><%=em.getEid()%></td>
				<td><%=em.getName()%></td>
				<td><%=em.getSex()%></td>
				<td><%=em.getDepartment()%></td>
				<td><%=em.getPosition()%></td>
				<td><%=em.getEmployedtime()%></td>
				<td><%=em.getTelphone()%></td>
				<td><%=em.getPassword()%></td>
			</tr>

			<%
				}
			%>
			<div>
				<a href="">返回</a>
			</div>
		</table>
	</body>
</html>
