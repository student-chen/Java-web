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
	<link rel="stylesheet" type="text/css" href="image/mystyle1.css">
	 <%
      request.setCharacterEncoding("utf-8");
      String tid=(String)session.getAttribute("id");
    %>
  </head>
  <body>
    <table width="1024" height="611" bgcolor="#1fa0eb" align="center" border="0" cellspacing="0" cellpadding="0">
    <tr><td>
    <table width="1022" height="610" bgcolor="#ffffff" align="center" border="0">
    <tr align="center"><td width="150" height="602">
   <table bgcolor="#8dd8f8" width="150" height="602" align="center">
   <tr><td height="63" ></td></tr>
   <tr><td height="55" align="center"><img src="image/top.gif"/></td></tr>
   <tr><td height="10" ></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="admin_cou_add.jsp" target="main">添加课程信息</a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="admin_cou_del.jsp" target="main">删除课程信息</a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="admin_cou_sel.jsp" target="main">查询课程信息</a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="admin_cou_upd.jsp" target="main">修改课程信息</a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="195" ></td></tr>
   </table>
   </td>
   <td width="845" height="602" align="center"><iframe src="index.jsp" width="845" height="602" name="main" scrolling="auto" frameborder="0"></iframe><br></td></tr>
   </table>
    </td></tr>
   </table>
  </body>
</html>
