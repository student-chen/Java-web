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
    <jsp:useBean id="cdao" scope="page" class="msc.dao.CourseDAO"></jsp:useBean>
    <title></title>
    </head>
  
  <body bgcolor="#8dd8f8">
    <%
    request.setCharacterEncoding("utf-8");
    String cno=request.getParameter("cno");
    String cname=request.getParameter("cname");
    String scredit=request.getParameter("credit");
    double credit=0;
    if(scredit!=""){
        credit=Double.parseDouble(scredit);
    }
    Vector vector=cdao.Select(cno,cname,credit);
   
    int i=vector.size();
    Course cou[]=new Course[i];
    	
     %>
     <div align="center"><font size="5" color="#000080" face="华文楷体"><b>课程信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="150">课序号</td><td width="200">课程名称</td><td width="150">课程学分</td><td width="150">序号</td></tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Course)vector.elementAt(j);
	String rcno = cou[j].getCno() ;
	String rcname = cou[j].getCname() ;
    double rcredit = cou[j].getCredit();
	%>
            	<tr align="center">
		    		<td><%=rcno%></td>
		    		<td><%=rcname%></td>
		       		<td><%=rcredit%></td>
		       		<td><%=j+1%></td>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="3">无该课程信息！</th></tr>
	<%} %>
	</table>
 
	</body>
</html>
	