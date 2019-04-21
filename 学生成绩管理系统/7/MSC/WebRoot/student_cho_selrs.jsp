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
    String scredit=request.getParameter("credit");
    String scteachno=request.getParameter("cteachno");
    String clocation=request.getParameter("clocation");
    String ctime=request.getParameter("ctime");
    String tname=request.getParameter("tname");
    double credit=0;
    int cteachno=0;
    if(scredit!="")
    {
        credit=Double.parseDouble(scredit);
    }
    if(scteachno!="")
    {
        cteachno=Integer.parseInt(scteachno);
    }
    Vector all=scdao.ScSelect(cno,cname,credit,cteachno,clocation,ctime,tname);
    int i=all.size();
    Tc cou[]=new Tc[i];
     %>

  </head>
  
  <body bgcolor="#8dd8f8">
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>课程信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center">
      <td width="90">课序号</td>
      <td>课程名</td>
      <td width="80">课程学分</td>
      <td width="80">教学班号</td>
      <td width="100">上课地点</td>
      <td>上课时间</td>
      <td width="70">课程容量</td>
      <td width="70">已选人数</td>
      <td width="80">任课教师</td>
      </tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Tc)all.elementAt(j);
	String rcno = cou[j].getCno() ;
	String rcname = cou[j].getCname() ;
    double rcredit=cou[j].getCredit();
    int rcteachno=cou[j].getCteachno();
    String rclocation=cou[j].getClocation();
    String rctime=cou[j].getCtime();
    int rcmax=cou[j].getCmax();
    int rcsel=cou[j].getCsel();
    String rtname=cou[j].getTname();
	%>
            	<tr align="center">
		    		<td><%=rcno%></td>
		    		<td><%=rcname%></td>
		       		<td><%=rcredit%></td>
					<td><%=rcteachno%></td>
					<td><%=rclocation%></td>
		    		<td><%=rctime%></td>
		       		<td><%=rcmax%></td>
		       		<td><%=rcsel %></td>
					<td><%=rtname%> </td>
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
