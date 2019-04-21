<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <jsp:useBean id="mdao" scope="page" class="msc.dao.MscDAO"></jsp:useBean>
    <title></title>
    <link rel="stylesheet" type="text/css" href="image/mystyle1.css">
  </head>
  
  <body >
  <%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");
String name=(String)session.getAttribute("na");
String kind=(String)session.getAttribute("kind");
if(id!=null&&kind!="admin")
		{
int stunum=(int)mdao.CountStudent();
int teanum=(int)mdao.Countteacher();
int counum=(int)mdao.CountCourse();
 %>
    <table width="1024" height="610" bgcolor="#1fa0eb" align="center" cellspacing="0" cellpadding="0"><tr><td> 
    <table width="1024" height="610" bgcolor="#ffffff" align="center" cellspacing="0" cellpadding="0">
    <tr><td>
    <table width="1016" height="602" bgcolor="#8dd8f8" align="center">
    <tr><td>
    <table align="center">
    <tr><td width="724" height="80" style="FILTER: blur(direction=135,strength=8)" align="center"><i><font size="7" face="华文行楷" color="#2e0df7">欢迎使用学生成绩管理系统！</font></i></td></tr>
    </table>
    </td></tr>
    <tr><td><table background="image/tips.gif" align="center" width="598" height="169">
    <tr><td width="50"></td><td height="59"></td></tr>
    <tr ><td width="50"></td><td height="20" align="left"><font color="#48f9f9"><em><strong>欢迎你<%out.print(name); %></strong></em></font></td></tr>
    <tr><td width="50"></td><td height="8"></td></tr>
     <tr><td width="50"></td><td height="50"></td></tr>
    </table></td></tr>
     <tr><td height="50"></td></tr>
    <tr><td>
    <table  bgcolor="#8dd8f8" width="650" border="1" cellpadding="0" cellspacing="0" align="center"> 
    <tr><th colspan="2" height="25" align="center"><font  face="黑体" color="#044a85" size="5">系统基本信息</font></th></tr>
    <tr align="center"><td height="25"><font size="4" face="楷体">当前系统中共有学生数：<%=stunum %></font></td><td width="80" align="center"><a href="admin_stu.jsp"><img border="0" src="image/scan.gif"/></a></td></tr> 
    <tr align="center"><td height="25"><font size="4" face="楷体">当前系统中共有教师数：<%=teanum %></font></td><td><a href="admin_tea.jsp"><img border="0" src="image/scan.gif"/></a></td></tr> 

    <tr align="center"><td height="25"><font size="4" face="楷体">当前系统中共有课程数：<%=counum %></font></td><td><a href="admin_cou.jsp"><img border="0" src="image/scan.gif"/></a></td></tr> 

    </table>
    </td></tr>
    <tr><td height="80">&nbsp;</td></tr>
    </table></td></tr></table></td></tr></table>
    <%
		}
		else
		{
	%>
	<div align="center"> 
	<font size="5" color="#ff0000">非法登录！！！<br> 
	点<a target="_parent" href="login.jsp">这里</a>转到登陆页面！<br></font>
	</div><%
		}
	%>
  </body>
</html>
