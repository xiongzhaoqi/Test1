<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%@page import="org.softedu.file.bean.Employe"%>
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
				<a href="servlet/FileServlet?flag=upload&eid=<%=e.getEid()%>&position=<%=e.getPosition()%>">资源库</a>
			</div>
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
			<a href="servlet/RightsServlet?dept=caiwubu&position=boss">财务部资源信息管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="servlet/RightsServlet?dept=xueshubu&position=boss">学术部资源信息管理</a>
		</div>
		<div>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div align="center">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="servlet/RightsServlet?dept=shichangbu&position=boss">市场部资源信息管理</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="servlet/RightsServlet?dept=qiyefazhanbu&position=boss">企业发展部资源信息管理</a>
		</div>
		<p>
			<div align="center">
				<a href="servlet/RightsServlet?dept=dongshihui&position=boss">董事会资源</a>
			</div>
		</p>
		<div align="center">
			<!-- <form action="resource_jsp/bossmanager.jsp" method="post">
				<input type="submit" name="button" value="返回上一页">
			</form> -->
		</div>
	</body>
</html>
