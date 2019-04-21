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
    <jsp:useBean id="sdao" scope="page" class="msc.dao.StudentDAO"></jsp:useBean>
    <title></title>
	<link rel="stylesheet" type="text/css" href="image/mystyle1.css">

  </head>
  
  <body>

  <%
request.setCharacterEncoding("utf-8");
String name=(String)session.getAttribute("na");
String id=(String)session.getAttribute("id");
String kind=(String)session.getAttribute("kind");
//String canchoose=(String)session.getAttribute("canchoose");
if(id!=null&&kind!="student")
		{
String message=null;
//if(canchoose.equals("选课")){
message="你可以进行课程选择或信息查询。";
//}else{
//message="你可以进行信息查询。";
//}
Vector vector=sdao.Select(id,"","");
int i=vector.size();
Student stu=new Student();
if(i!=0){
stu=(Student)vector.elementAt(0);
}
 %>
    <table width="1024" height="661" bgcolor="#1fa0eb" align="center" border="0" cellspacing="0" cellpadding="0">
    <tr><td><table width="1022" height="660" bgcolor="#ffffff" align="center" border="0" cellspacing="0" cellpadding="0">
    <tr><td><table width="1014" height="652" bgcolor="#8dd8f8" align="center">
    <tr><td><table align="center">
    <tr><td width="724" height="80" style="FILTER: blur(direction=135,strength=8)" align="center"><i><font size="7" face="华文行楷" color="#2e0df7">欢迎使用学生成绩管理系统！</font></i></td></tr>
    </table></td></tr>
    <tr><td><table background="image/tips.gif" align="center" width="598" height="169">
    <tr><td width="30"></td><td height="40"></td></tr>
    <tr ><td width="30"></td><td height="10" align="left"><em><font color="#48f9f9"><font size="4"><strong>欢迎你<%out.print(name); %></strong></font></font></em></td></tr>
    <tr><td width="30"><br></td><td><em><font color="#8000ff"><strong>当前是<font color="red">选课</font>时期，</strong></font><font size="3" color="#8000ff"><strong><%=message %></strong></font></em></td></tr>
    <tr><td width="30"></td><td height="20"></td></tr>
    </table></td></tr>
    
    <tr><td height="120"><div align="center"><strong><font size="5" color="#0000a0"><br><br><font size="6">个人基本信息</font><br></font></strong></div><br/>
    <table width="700" border="1" align="center">
    <tr align="center"><th colspan="5"><font size="5">学籍信息</font></th></tr>
    <tr align="center"><td width="150">学号</td><td width="150">姓名</td><td width="200">专业</td><th colspan="2">班级</th></tr>
    <tr align="center"><td width="150"><%=stu.getSid() %></td><td width="150"><%=stu.getSname() %></td><td width="200"><%=stu.getSmajor() %></td><td colspan="2"><%=stu.getSclass() %></td></tr>
    <tr><td colspan="5" height="25"></td></tr>
    <tr align="center"><th colspan="5"><font size="5">成绩信息</font></th></tr>
    <tr align="center" ><td width="100">总学分</td><td width="100">平均学分绩点</td><td width="150">智育成绩</td><td width="100">班级排名</td><td width="100">专业排名</td></tr>
    <tr align="center"><td width="100"><%=stu.getTcredit() %></td><td width="100"><%=Math.round(stu.getAcredit()*100)/100.0 %></td><td width="150"><%=Math.round(stu.getEgrade()*100)/100.0 %></td><td width="100"><%=stu.getClasspm() %></td><td width="100"><%=stu.getMajorpm() %></td></tr>
    </table></td></tr>
    <tr><td height="80"></td></tr>
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
