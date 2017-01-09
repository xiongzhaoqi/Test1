<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%@page import="org.softedu.file.bean.Employe"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<script type="text/javascript" src="./js/login.js">
</script>
		<title>My JSP 'updateyuangong.jsp' starting page</title>
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

		<div class="main"
			style="padding-top: 40px; background-image: url(images/aa7225fd148b65a5b801a07e.jpg)">
			<form name="form1" action="query?flag=insert" method="post">
				<table>
					<tr>
						<td colspan="2">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font color="blue">添加员工信息页面</font>
						</td>
					</tr>
					<tr>
						<td>
							员工id:
						</td>
						<td>
							<input type="text" name="eid" id="eid" />
						</td>
					</tr>
					<tr>
						<td>
							姓名:
						</td>
						<td>
							<input type="text" name="name" />
						</td>
					</tr>
					<tr>
						<td>
							性别:
						</td>
						<td>
							<select name="sex">
								<option>
									male
								</option>
								<option>
									female
								</option>
							</select>
						</td>
					</tr>
					<%
						if (e.getPosition().equals("boss")) {
					%>
					<tr>
						<td>
							部门:
						</td>
						<td>
							<select name="department">
								<option>
									xueshubu
								</option>
								<option>
									shichangbu
								</option>
								<option>
									qiyefazhanbu
								</option>
								<option>
									caiwubu
								</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							职位:
						</td>
						<td>
							<select name="position">
								<option>
									manager
								</option>
								<option>
									employee
								</option>
							</select>
						</td>
					</tr>
					<%
						} else {
					%>
					<tr>
						<td>
							部门:
						</td>
						<td>
							<input type="text" name="department"
								value="<%=e.getDepartment()%>" />
						</td>
					</tr>
					<tr>
						<td>
							职位:
						</td>
						<td>
							<select name="position">
								<option>
									employee
								</option>
							</select>
						</td>
					</tr>
					<%
						}
					%>
					<tr>
						<td>
							入职时间:
						</td>
						<td>
							<input type="text" name="employedtime" />
						</td>
					</tr>
					<tr>
						<td>
							联系方式:
						</td>
						<td>
							<input type="text" name="telphone" />
						</td>
					</tr>
					<tr>
						<td>
							密码:
						</td>
						<td>
							<input type="text" name="password" />
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="添加" onclick="return check3()" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
