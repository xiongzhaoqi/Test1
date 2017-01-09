<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="org.softedu.file.bean.Employe"%>
<%@page import="org.softedu.file.util.DateUtil"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'changepassword.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="css/changepassword.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="./js/login.js">
</script>
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
				<div id="c">
					您好，今天是<%=DateUtil.dateManager()%>
				</div>
				<div id="a">
					<a href="LoginServlet?flag=<%=e.getPosition()%>&id=<%=e.getEid()%>">部门信息</a>
				</div>
				<div id="a">
					<a
						href="servlet/FileServlet?flag=upload&eid=<%=e.getEid()%>&position=<%=e.getPosition()%>">资源库</a>
				</div>

			</div>
		</div>

		<div class="main">
			<div class="textpassword">
				<form action="query?flag=change&id=<%=request.getParameter("id")%>"
					method="post">
					请输入旧密码：
					<input type="password" name="oldpassword" id="oldpassword" />
					<br />
					请输入新密码：
					<input type="password" name="textpassword" id="textpassword" />
					<br />
					&nbsp;&nbsp;&nbsp;&nbsp;再输入一次：
					<input type="password" name="second" id="second" />
					<br />
					&nbsp;&nbsp; 提交：
					<input type="submit" value="提交新密码" onclick="return check1()"
						style="width: 100px;" />
				</form>
			</div>
		</div>
	</body>
</html>
