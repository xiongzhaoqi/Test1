<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.softedu.file.bean.FileInfo"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bosssource.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/resource.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body bgcolor="#E3E3E3">
  <div class="header">
			<div>
				<img src="image/1.jpg" width="980px" height="85px" />
			</div>
			<div class="body1">
				您好，今天是<%=DateUtil.dateManager() %>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="query?flag=showall">查看部门员工信息</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="./changepassword.jsp">修改密码</a>
			</div>
		</div>
		<div>
			<div class="title">
				<font color="#0066FF">资源管理</font>
			</div>
			<div>
				&nbsp;&nbsp;
			</div>
			<br>
			<div>
				&nbsp;&nbsp;
			</div>
			<div>
				&nbsp;&nbsp;
			</div>
			<table border="1" width="700px" align="center"  style="border-collapse: collapse">
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
					<th></th>
					<th></th>
				</tr>
				<%
					List list = (List) request.getAttribute("list");
					for (int i = 0; i <= list.size() - 1; i++) {
						FileInfo files = (FileInfo) list.get(i);
				%>
				<tr>
					<td><%=files.getFile_name()%></td>
					<td><%=files.getEid()%></td>
					<td><%=files.getDepartment()%></td>
					<td><%=files.getUploadstime()%></td>
					<td>
						<a href="servlet/DownloadServlet?flag=del&id=<%=files.getFile_id()%>">删除</a>
					</td>
					<td>
						<a href="servlet/DownloadServlet?flag=download&id=<%=files.getFile_id()%>">下载</a>
					</td>
				</tr>
				<%
				}
				%>
			</table>
			<form action="resource_jsp/departmentinner.jsp" method="post">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="button" value="返回">
		</div>
		</div>
  </body>
</html>
