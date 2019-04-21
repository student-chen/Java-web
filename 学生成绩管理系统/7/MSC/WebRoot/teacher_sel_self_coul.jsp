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
    <jsp:useBean id="scdao" scope="page" class="msc.dao.ScDAO"></jsp:useBean>
    <title></title>
    <%
    request.setCharacterEncoding("utf-8");
    String cno=request.getParameter("cno");
    String cname=request.getParameter("cname");
    String tid=(String)session.getAttribute("id");
    Vector all=scdao.SelectStudent(cno,tid);
    int i=all.size();
    Sc stu[]=new Sc[i];
     %>

  </head>
  
  <body bgcolor="#8dd8f8">
  <div align="center"><font size="4" color="#000080" face="华文楷体"><b><font size="5">选课学生如下：<br><br></font></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="100">学号</td><td width="100">姓名</td><td width="100">课程学分</td><td width="100">平时成绩</td><td width="100">期末成绩</td><td width="100">最终成绩</td><td width="100">名次</td></tr>
	<%
	for(int j=0;j<i;j++){
	stu[j]=(Sc)all.elementAt(j);
	String sid = stu[j].getSid() ;
	String sname = stu[j].getSname() ;
    double credit=stu[j].getCredit();
    double pscore=stu[j].getPscore();
    double lscore=stu[j].getLscore();
    double escore=stu[j].getEscore();
	%>
            	<tr align="center">
		    		<td><%=sid%></td>
		    		<td><%=sname%></td>
		       		<td><%=credit%></td>
					<td><%=pscore%></td>
		    		<td><%=lscore%></td>
		    		<td><%=escore%></td>
		    		<td><%=j+1%></td>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="7">无选课学生信息！</th></tr>
	<%}
	 %>
	</table>
  </body>
</html>
