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
    
    <title></title>  
	<jsp:useBean id="tdao" scope="page" class="msc.dao.TeacherDAO"></jsp:useBean>

  </head>
   <body bgcolor="#8dd8f8">
   <%
   request.setCharacterEncoding("utf-8");
   String tid=request.getParameter("tid");
   String tname=request.getParameter("tname");
   Vector all=tdao.Select(tid,tname);
   int i=all.size();
   Teacher tea[]=new Teacher[i];
    %>
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>教师信息如下：<br><br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="150">工号</td><td width="150">姓名</td><td width="150">密码</td><td width="150">查看开设课程</td></tr>
	<%
	for(int j=0;j<i;j++){
	tea[j]=(Teacher)all.elementAt(j);
	String rtid = tea[j].getTid() ;
	String rtname = tea[j].getTname() ;
    String rtcode=tea[j].getTcode();
	%>
            	<tr align="center">
		    		<td><%=rtid%></td>
		    		<td><%=rtname%></td>
		       		
					<td><%=rtcode%></td>
					<td><A href="teacher_sel_other_rsd.jsp?tid=<%=rtid %>">查看</A></td>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="10">无教师信息！</th></tr>
	<%} %>
	</table>
	</body>
</html>
