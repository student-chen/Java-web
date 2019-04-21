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

  </head>
  
  <body>
  <%
      request.setCharacterEncoding("utf-8");
      String sid=(String)session.getAttribute("id");
   %>
    <table width="1024" height="661" bgcolor="#1fa0eb" align="center" border="0" cellspacing="0" cellpadding="0">
    <tr><td>
    <table width="1022" height="660" bgcolor="#ffffff" align="center" border="0">
    <tr align="center"><td width="150" height="650">
   <table bgcolor="#8dd8f8" width="150" height="650" align="center">
   <tr><td height="50" ></td></tr>
   <tr><td height="55" align="center"><img src="image/top.gif"/></td></tr>
   <tr><td height="10" ></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="student_sel_self.jsp" target="main">查看个人成绩</a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="" target="main"></a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="student_sel_other.jsp" target="main">查询他人成绩</a></strong></font></td></tr>
   <tr><td height="10" ><font color="#0000ff"><br></font></td></tr>
   <tr><td height="35" align="center" background="image/bgpicture.gif"><font color="#0000ff"><strong><a href="" target="main"></a></strong></font></td></tr>
   <tr><td height="310" ></td></tr>
   </table>
   </td>
   <td width="845" height="650"><iframe src="index.jsp" width="845" height="650" name="main" scrolling="auto" frameborder="0"></iframe><br></td></tr>
    </table>
    </td></tr>
    </table>
    
  </body>
</html>
