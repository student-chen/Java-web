<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>

  </head>
  
  <body bgcolor="#8dd8f8" >
  <br/><br/><br/><br/><br/><br/><br/>
  <div style="text-align: center; color: rgb(128, 128, 64);"><font size="4"><strong>留言处理中，请稍后.....</strong></font></div> 
    <table align="center"><tr><td><img src="image/bar.gif"/></td></tr></table>
    <%
      request.setCharacterEncoding("utf-8");
      String action=request.getParameter("action");
      String mid=request.getParameter("mid");
      response.setHeader("refresh","0;URL=msg_slt?action="+action+"&mid="+mid+"") ;
    %>
  </body>
</html>
