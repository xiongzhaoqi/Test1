<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'updateyuangong.jsp' starting page</title>

  </head>
  
  <body style="background-image: url(../images/aa7225fd148b65a5b801a07e.jpg)">
  <center>
    <form action="QueryServlet2?flag=xiugai&eid=<%=request.getParameter("eid") %>" method="post">
    	<table>
    		<tr>
    			<td colspan="2">修改员工信息页面</td>
    		</tr>
    		<tr>
    			<td>员工id</td>
    			<td><input type="text" name="eid" value="<%=request.getParameter("eid") %>"/></td>
    		</tr>
    		<tr>
    			<td>姓名</td>
    			<td><input type="text" name="sex"/>
    			</td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td><select name="sex">
    			       <option name="man">男</option>
    			       <option name="woman">女</option>
    			    </select>
    			
    			</td>
    		</tr>
    		<tr>
    			<td>部门</td>
    			<td><input type="text" name="department" value="<%=request.getParameter("depart") %>"/></td>
    		</tr>
    		<tr>
    			<td>职位</td>
    			<td>
    			  <select name="position">
    			  <option value="manager">经理</option>
    			  <option value="employee">员工</option></select>
    			</td>
    		</tr>
    		<tr>
    			<td>入职时间</td>
    			<td><input type="text" name="employedtime"/></td>
    		</tr>
    		<tr>
    			<td>联系方式</td>
    			<td><input type="text" name="telphone"/></td>
    		</tr>
    		<tr>
    			<td>密码</td>
    			<td><input type="text" name="password"/></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="确认修改"/></td>
    		</tr>
    	</table>
    </form>
    </center>
  </body>
</html>
