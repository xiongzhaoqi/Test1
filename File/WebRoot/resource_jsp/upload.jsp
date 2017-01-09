<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.softedu.file.bean.Employe"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%@page contentType="text/html;charset=utf-8"%>
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

	<body bgcolor="#E3E3E3">
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
				<a href="LoginServlet?flag=<%=e.getPosition()%>&id=<%=e.getEid()%>">部门信息</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a
					href="servlet/FileServlet?flag=upload&eid=<%=e.getEid()%>&position=<%=e.getPosition()%>">资源库</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="body2">
			<div class="bodyleft2">
				<div class="title">
					<font color="#0066FF">操作区</font>
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
				<hr />
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<table align="center">
					<form
						action="servlet/FileServlet?flag=upload&eid=<%=e.getEid()%>&position=<%=e.getPosition()%>"
						method="post" enctype="multipart/form-data">
						<input type="file" name="file" />
						<input type="submit" value="上传" />
					</form>
				</table>
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<hr />
				<div>
					&nbsp;&nbsp;
				</div>
				<marquee scrollAmount=4 width=500>
					<a style="color: green">欢迎您在此上传资料，真诚希望您多多对本企业提出您宝贵的意见和方案!!!</a>
				</marquee>
				<div>
					&nbsp;&nbsp;
				</div>
				<hr />
			</div>
			<div class="bodyright2">
				<div class="title">
					<font color="#0066FF">特别提示：</font>
				</div>
				、
				<div>
					&nbsp;&nbsp;
				</div>
				<div>
					&nbsp;&nbsp;
				</div>
				<div class="font">
					请上传资料的全体员工注意以下事项：
				</div>
				<br />
				<marquee onMouseOver=this.stop() onMouseOut=this.start()
					scrollamount=2 scrolldelay=7 direction=up width=270 height=150>
					<ul class="font2">
						<li>
							不要上传与企业无关紧要的东西
						</li>
						<li>
							不要上传恶搞的资料
						</li>
						<li>
							不要上传没有营养的垃圾文件
						</li>
						<li>
							不要上传企业机密或是不宜在公众公开的资料
						</li>
						<li>
							......
						</li>
					</ul>
				</marquee>
			</div>
	</body>
</html>
