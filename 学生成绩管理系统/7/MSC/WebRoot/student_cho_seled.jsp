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
    String sid=request.getParameter("sid");
    Vector all=scdao.SelectSelf(sid);
    int n=all.size();
    Tc cou[]=new Tc[n];
    for(int j=0;j<n;j++){
    cou[j]=(Tc)all.elementAt(j);
    }
     %>

  </head>
  
  <body bgcolor="#8dd8f8">
  <%
  String time[]={"一","二","三","四","五","六","天"};
   %>
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>课表显示<br><br></b></font></div>
  <table border="1" cellspacing="0" cellpadding="0" align="center" width="750">
  <tr align="center"><td width="60">课表</td><td>星期一</td><td>星期二</td><td>星期三</td><td>星期四</td><td>星期五</td><td>星期六</td><td>星期天</td></tr>
  <%
  for(int j=0;j<5;j++)
  {
  %>
  <tr align="center"><td>第<%=time[j] %>节</td>
  <%for(int k=0;k<7;k++){ 
  String course="&nbsp;";
  for(int i=0;i<n;i++){
  if(cou[i].getCtime().equals("星期"+time[k]+"第"+time[j]+"节"))
  {
  course=cou[i].getCname();
  }
  
  }
  %>
 <td ><%=course %></td>
  <%}%>
  </tr>
  <%}%>
  </table>
  <br/><br/>
  
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>选定课程信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="100">课序号</td><td width="180">课程名</td><td width="80">课程学分</td><td width="80">教学班号</td><td width="100">上课地点</td><td>上课时间</td><td width="80">任课教师</td></tr>
	<%
	for(int j=0;j<n;j++){
	String rcno = cou[j].getCno() ;
	String rcname = cou[j].getCname() ;
    double rcredit=cou[j].getCredit();
    int rcteachno=cou[j].getCteachno();
    String rclocation=cou[j].getClocation();
    String rctime=cou[j].getCtime();
    String rtname=cou[j].getTname();
	%>
            	<tr align="center">
		    		<td><%=rcno%></td>
		    		<td><%=rcname%></td>
		       		<td><%=rcredit%></td>
					<td><%=rcteachno%></td>
					<td><%=rclocation%></td>
		    		<td><%=rctime%></td>
					<td><%=rtname%> </td>
				</tr>
	<% 
	}
	if(n==0){	
	%>
	<tr><th colspan="10">无课程信息！</th></tr>
	<%} %>
	</table>
  </body>
</html>
