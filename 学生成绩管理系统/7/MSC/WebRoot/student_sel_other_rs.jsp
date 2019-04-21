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
    <jsp:useBean id="sdao" scope="page" class="msc.dao.StudentDAO"></jsp:useBean>
    <title></title>
    </head>
  
  <body bgcolor="#8dd8f8">
    <%
    request.setCharacterEncoding("utf-8");
    String sid=request.getParameter("sid");
    String sclass=request.getParameter("sclass");
    String smajor=request.getParameter("smajor");
    
    Vector vector=sdao.Select(sid,sclass,smajor);
    int i=vector.size();
    Student stu[]=new Student[i];
    	
     %>
     <div align="center"><font size="5" color="#000080" face="华文楷体"><b>学生信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="80">学号</td><td width="60">姓名</td><td>专业</td><td width="80">班级</td><td width="50">总学分</td><td width="80">总学分绩点</td><td width="80">智育成绩</td><td width="70">班级排名</td><td width="70">专业排名</td><td width="70">课程信息</td></tr>
	<%
	for(int j=0;j<i;j++){
	stu[j]=(Student)vector.elementAt(j);
	String rsid = stu[j].getSid() ;
	String rsname = stu[j].getSname() ;
    String rsmajor = stu[j].getSmajor() ;
	String rsclass = stu[j].getSclass() ;
	double tcredit=stu[j].getTcredit();
	double acredit=stu[j].getAcredit();
	double egrade=stu[j].getEgrade();
	int classpm=stu[j].getClasspm();
	int majorpm=stu[j].getMajorpm();
	%>
            	<tr align="center">
		    		<td><%=rsid%></td>
		    		<td><%=rsname%></td>
		       		<td><%=rsmajor%></td>
		 	    	<td><%=rsclass%></td>
					<td><%=tcredit%></td>
					<td><%=Math.round(acredit*100)/100.0%></td>
					<td><%=Math.round(egrade*100)/100.0%></td>
					<td><%=classpm%></td>
					<td><%=majorpm%></td>
					<td><a href="student_sel_other_cours.jsp?sid=<%=rsid %>">查看</a></td>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="10">无该学生信息！</th></tr>
	<%} %>
	</table>
	</body>
</html>
	