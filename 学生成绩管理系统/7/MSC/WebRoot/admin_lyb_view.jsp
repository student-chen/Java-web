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
		<title>查看留言</title>
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
	<div align="center"><font size="5" color="#000080" face="华文楷体"><b>留言板：<br><br></b></font></div> 
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     <tr align="center"><td width="80">编号</td><td width="80">姓名</td><td width="110">留言时间</td><td width="450">留言内容</td></tr>
     <%
     for(int j=0;j<i;j++)
     {    
      msg[j]=(Massage)all.elementAt(j);
      int mid=msg[j].getMid();
      String rid=msg[j].getId();
      String rname=msg[j].getName();
      String rcontent = msg[j].getContent();
      String rtime = msg[j].getDate();
      if(rname.equals("admin")){
      %>
      <tr align="center" height="25">
      <td>管理员</td>
      <td><%=name %></td>
      <td><%=rtime %></td>
      <td align="left"><%=rcontent %></td>
      <td height="10" width="50" background="image/delete.gif " align="center"><strong><a href="msg_dealing.jsp?mid=<%=mid%>&action=delete">删除</a></strong></td>
       </tr>
       <%}else{ %>
      <tr align="center" height="25">
      <td><%=rid %></td>
      <td><%=rname %></td>
      <td><%=rtime %></td>
      <td align="left"><%=rcontent %></td>
      <td height="10" width="50" background="image/delete.gif " align="center"><strong><a href="admin_lyb_ly.jsp?rid=<%=rid %>">回复</a></strong></td>
      <td height="10" width="50" background="image/delete.gif " align="center"><strong><a href="admin_msg_dealing.jsp?mid=<%=mid%>&action=delete">删除</a></strong></td>
       </tr>
       <%} 
       }
	   if(i==0){	
	  %>
	<tr><th colspan="10">无留言信息！</th></tr>
	<%} %>
       </table>
	</body>
</html>
