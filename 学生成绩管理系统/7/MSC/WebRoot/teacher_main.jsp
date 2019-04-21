<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="msc.vo.*"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:useBean id="tdao" scope="page" class="msc.dao.TeacherDAO"></jsp:useBean>
    <title></title>
	<link rel="stylesheet" type="text/css" href="image/mystyle1.css">
  </head>
  <body>
  <%
request.setCharacterEncoding("utf-8");
String name=(String)session.getAttribute("na");
String id=(String)session.getAttribute("id");
 String kind=(String)session.getAttribute("kind");
if(id!=null&&kind!="teacher")
		{
String message=null;
message="你可以开设课程或信息查询。";
Vector vector=tdao.Select(id,name);
int i=vector.size();
Teacher tea=new Teacher();
if(i!=0){
tea=(Teacher)vector.elementAt(0);
}
 %>
    <table width="1024" height="661" bgcolor="#1fa0eb" align="center" border="0" cellspacing="0" cellpadding="0">
    <tr><td><table width="1022" height="660" bgcolor="#ffffff" align="center" border="0" cellspacing="0" cellpadding="0">
    <tr><td><table width="1014" height="652" bgcolor="#8dd8f8" align="center">
    <tr><td><table align="center">
    <tr><td width="724" height="80" style="FILTER: blur(direction=135,strength=8)" align="center"><i><font size="7" face="华文行楷" color="#2e0df7">欢迎使用学生成绩管理系统！</font></i></td></tr>
    </table></td></tr>
     <tr><td><table background="image/tips.gif" align="center" width="598" height="169">
    <tr><td width="30"></td><td height="50"></td></tr>
    <tr ><td width="30"></td><td height="20" align="left"><font color="#48f9f9"><font size="3"><strong>欢迎你<%out.print(name); %></strong></font></font></td></tr>
    <tr><td width="30"></td><td><font color="#8000ff"><strong>当前是<font color="red">选课</font>时期，</strong></font><font size="3" color="#8000ff"><strong><%=message %></strong></font></td></tr>
    <tr><td width="30"></td><td height="40"></td></tr>
    </table></td></tr>
    <tr><td><div align="center"><font size="6" color="#0000a0"><br>个人基本信息<br></font></div><br/>
    <table width="600" border="1" align="center">
    <tr ><td height="50" width="200"><strong><font size="5">工号:</font></strong></td><td width="400"><font size="5"><%=tea.getTid() %></font></td></tr>
    <tr ><td height="50" width="200"><strong><font size="5">姓名:</font></strong></td><td width="400"><font size="5"><%=tea.getTname() %></font></td></tr>
    </table></td></tr>
    <tr><td height="150"></td></tr>
    </table></td></tr>
    </table></td></tr>
    </table>
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
