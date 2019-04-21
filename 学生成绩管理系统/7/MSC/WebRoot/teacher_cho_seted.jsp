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
    <jsp:useBean id="tcdao" scope="page" class="msc.dao.TcDAO"></jsp:useBean>
    <title></title>
    <%
    request.setCharacterEncoding("utf-8");
    String tid=request.getParameter("tid");
    Vector all=tcdao.SelectSelf(tid,"");
    int i=all.size();
    Tc cou[]=new Tc[i];
     %>

  </head>
  
  <body bgcolor="#8dd8f8">
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>开设课程信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="100">课序号</td><td width="150">课程名</td><td width="80">课程学分</td><td width="80">教学班号</td><td>上课地点</td><td>上课时间</td><td width="100">课程容量</td><td width="100">已选人数</td></tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Tc)all.elementAt(j);
	String cno = cou[j].getCno() ;
	String cname = cou[j].getCname() ;
    double credit=cou[j].getCredit();
    int cteachno=cou[j].getCteachno();
    String clocation=cou[j].getClocation();
    String ctime=cou[j].getCtime();
    int cmax=cou[j].getCmax();
    int csel=cou[j].getCsel();
	%>
            	<tr align="center">
		    		<td><%=cno%></td>
		    		<td><%=cname%></td>
		       		<td><%=credit%></td>
					<td><%=cteachno%></td>
					<td><%=clocation%></td>
		    		<td><%=ctime%></td>
		       		<td><%=cmax%></td>
					<td><%=csel%></td>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="10">无课程信息！</th></tr>
	<%} %>
	</table>
  </body>
</html>
