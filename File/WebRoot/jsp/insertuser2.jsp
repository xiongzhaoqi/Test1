<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%@page import="org.softedu.file.bean.Employe"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>My JSP 'updateyuangong.jsp' starting page</title>
		<link href="../css/bossyuangong.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/login.js"></script>
	</head>

	<body>
		<%
			Employe e = (Employe) session.getAttribute("e");
		%>
		<div class="header">
			<div id="logo">
				<img src="../images/logo.jpg" style="width: 1000px; height: 100px" />
			</div>
			<div id="menu">
				<div id="b">
					您好，今天是<%=DateUtil.dateManager()%>
				</div>
				<div id="a">
					<a href="../LoginServlet?flag=<%=e.getPosition()%>&id=<%=e.getEid()%>">部门信息</a>
				</div>
				<div id="a">
					<a
						href="../servlet/FileServlet?flag=upload&eid=<%=e.getEid()%>&position=<%=e.getPosition()%>">资源库</a>
				</div>
			</div>
		</div>
		<div class="main"
			style="padding-top: 40px; background-image: url(../images/aa7225fd148b65a5b801a07e.jpg)">
			<form action="QueryServlet2?flag=insert" method="post">
				<center>
					<table>
						<tr>
							<td colspan="2">
								添加员工信息页面
							</td>
						</tr>
						<tr>
							<td>
								员工id
							</td>
							<td>
								<input type="text" name="eid" id="eid"/>
							</td>
						</tr>
						<tr>
							<td>
								姓名
							</td>
							<td>
								<input type="text" name="name" id="name"/>
							</td>
						</tr>
						<tr>
							<td>
								性别
							</td>
							<td>
								<select name="sex">
									<option value="man">
										男
									</option>
									<option value="woman">
										女
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								部门
							</td>
							<td>
								<input type="text"
									value="<%=request.getParameter("department")%>"
									name="department" />
							</td>
						</tr>
						<tr>
							<td>
								职位
							</td>
							<td>
								<select name="position">

									<option value="manager">
										经理
									</option>
									<option value="employee">
										员工
									</option>

								</select>
							</td>
						</tr>
						<tr>
							<td>
								入职时间
							</td>
							<td>
								<input type="text" name="employedtime" />
							</td>
						</tr>
						<tr>
							<td>
								联系方式
							</td>
							<td>
								<input type="text" name="telphone" />
							</td>
						</tr>
						<tr>
							<td>
								密码
							</td>
							<td>
								<input type="text" name="password" id="password" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" value="添加" onclick="return check3()"/>
							</td>
						</tr>

					</table>
				</center>
			</form>
		</div>
	</body>
</html>
