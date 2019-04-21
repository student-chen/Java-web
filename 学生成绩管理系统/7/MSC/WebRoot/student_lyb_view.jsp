<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="msc.vo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
		<title>留言查看</title>
		<link rel="stylesheet" type="text/css" href="image/mystyle1.css">
	</head>
	<jsp:useBean id="msgdao" class="msc.dao.MassageDAO" scope="page" />
	<body bgcolor="#8dd8f8">
	<%
	request.setCharacterEncoding("utf-8");
	String id=(String)session.getAttribute("id");
	String name=(String)session.getAttribute("na");
	Vector all=msgdao.SearchMassage();
	int i=all.size();
	Massage msg[]=new Massage[i];
    %>
	<div align="center"><font size="5" color="#000080" face="华文楷体"><b>学生留言如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     <tr align="center"><td width="80">姓名</td><td width="110">留言时间</td><td width="500">留言内容</td><td width="50"></td></tr>
     
     <%
     for(int j=0;j<i;j++)
     {
     
      msg[j]=(Massage)all.elementAt(j);
      int mid=msg[j].getMid();
      String rname=msg[j].getName();
      String rcontent = msg[j].getContent();
      String rtime = msg[j].getDate();
      %>
      <tr align="center" height="25">
      <td><%=rname %></td>
      <td><%=rtime %></td>
      <td align="left"><%=rcontent %></td>
      <td height="10" background="image/delete.gif " align="center"><strong><a href="msg_dealing.jsp?mid=<%=mid%>&action=delete">删除</a></strong>
      </td>
       </tr>
       <% 
       }
	   if(i==0){	
	  %>
	<tr><th colspan="10">无留言信息！</th></tr>
	<%} %>
       </table>
	</body>
</html>
