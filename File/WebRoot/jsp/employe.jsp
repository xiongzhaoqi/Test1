<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="org.softedu.file.bean.Depart"%>
<%@page import="org.softedu.file.bean.Employe"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <link rel="stylesheet" style="text/css" href="css/info.css">


  </head>
  
  <body>
  <%Employe e=(Employe)session.getAttribute("e"); %>
  <div class="body">
   <div style="border:400px 20px; margin-left: 440px;margin-top: 85px;">
    <a class="employehead1" href="resource_jsp/upload.jsp?eid=<%=e.getEid()%>">上传文件</a>
    <a class="employehead2" href="changepassword.jsp?id=<%=Integer.parseInt(request.getParameter("id"))%>">修改密码</a>
   </div>
      <div class="left">
      <%
       List<Depart> list=(List)request.getAttribute("list2");
       Iterator<Depart> it=list.iterator();
     while (it.hasNext()){
     Depart d=it.next();
     session.setAttribute("d",d.getDepartment());
     %>
    <center>简介(<%=d.getDepartment()%>)</center> <br><%=d.getInfo() %>
    <br/><br/>
   &nbsp;&nbsp;&nbsp;负责人：<%=d.getManager() %>  <br/>  
     <%} %>  
   </div>
   
   <div class="right">
     <a class="bodyr" href="LoginServlet?flag=employee&id=<%=Integer.parseInt(request.getParameter("id")) %>"><%=session.getAttribute("depart")%></a>
   </div>
   </div>
  </body>
</html>
