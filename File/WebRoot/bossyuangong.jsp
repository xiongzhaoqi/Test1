<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.softedu.file.bean.User"%>
<%@page import="org.softedu.file.util.PageBean"%>
<%@page import="org.softedu.file.dao.UserDao"%>
<%@page import="org.softedu.file.util.Pagination"%>
<%@page import="org.softedu.file.util.DateUtil"%>
<%@page import="org.softedu.file.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>无标题文档</title>
		<link href="css/bossyuangong.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="header">
			<div id="logo">
				<img src="images/logo.jpg" style="width: 1000px; height: 100px" />
			</div>
			<div id="menu">
				<div id="b">
					您好，今天是<%=DateUtil.dateManager()%>
				</div>
				<div id="a">
					<a href="jsp/boss.jsp">查看部门信息</a>
				</div>
				<div id="a">
					<a href="./changepassword.jsp?id=<%= request.getParameter("id") %>">修改密码</a>
				</div>
			</div>
		</div>

		<div class="main">
			<div class="left">
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
						
						List list=(List)session.getAttribute("list");
						PageBean pagebean=(PageBean)session.getAttribute("pagebean");
						
						//String url="query?flag=showall";
						 String url="query";
						 String flag="showall";
						//int pageNum=(Integer)session.getAttribute("pageNum");
						//int currentPage=(Integer)session.getAttribute("currentPage");
							int i = 1;
							if (list!=null) {
								Iterator it = list.iterator();
								while (it!=null && it.hasNext()) {
									i++;
									User user = new User();
									user = (User) it.next();
									if (i % 2 == 0) {
						%>
						<tr height="30px" bgcolor="">
							<td width="70"><%=user.getEid()%></td>
							<td width="90"><%=user.getName()%></td>
							<td width="90"><%=user.getSex()%></td>
							<td width="90"><%=user.getPosition()%></td>
							<td width="90"><%=user.getEmployedtime()%></td>
							<td width="90"><%=user.getTelphone()%></td>
							<td width="110"><a href="./updateyuangong.jsp?eid=<%=user.getEid() %>">修改</a><a href="query?flag=shanchu&eid=<%=user.getEid() %>">删除</a></td>
						</tr>
						<%
							} else {
						%>
						<tr height="30px" bgcolor="#9999FF">
							<td width="70"><%=user.getEid()%></td>
							<td width="90"><%=user.getName()%></td>
							<td width="90"><%=user.getSex()%></td>
							<td width="90"><%=user.getPosition()%></td>
							<td width="90"><%=user.getEmployedtime()%></td>
							<td width="90"><%=user.getTelphone()%></td>
							<td width="110"><a href="./updateyuangong.jsp?eid=<%=user.getEid() %>">修改</a><a href="query?flag=shanchu&eid=<%=user.getEid() %>">删除</a></td>
						</tr>
						<%
							}
								}
							}
						%>

					</table>
					<table>
			<p align=center><%=Pagination1.getPaginationScript1(pagebean.getCurrPage(),
					pagebean.getPageNum(), pagebean.getRecordNum(), url,flag) %></p>
			</table>
					<div><a href="./insertuser.jsp">添加用户</a></div>
				</div>
			</div>
			<div class="right">
				<div id="title">
					功能区
				</div>
				<div id="text">
					<ul>
						<li>
							<a href="query?flag=showxueshu">学术部门</a>
						</li>
						<li>
							<a href="query?flag=showcaiwu">财务部门</a>
						</li>
						<li>
							<a href="query?flag=showqiye">企业部门</a>
						</li>
						<li>
							<a href="query?flag=showshichang">市场部门</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</body>
</html>
