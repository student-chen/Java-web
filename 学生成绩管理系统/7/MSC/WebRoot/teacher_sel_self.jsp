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
    <jsp:useBean id="scdao" scope="page" class="msc.dao.ScDAO"></jsp:useBean>
    <title></title>
    <%
    request.setCharacterEncoding("utf-8");
    String tname=(String)session.getAttribute("na");
    String tcode=(String)session.getAttribute("pa");
    String tid=request.getParameter("tid");
    Vector all=tcdao.SelectSelf(tid,"");
    int i=all.size();
    Tc cou[]=new Tc[i];
     %>

  </head>
  
  <body bgcolor="#8dd8f8">
    <div align="center"><strong><font size="5" face="华文楷体" color="#0000a0">个人基本信息</font></strong></div><br/>
    <table border="1" align="center">
    <tr align="center"><td width="100">工号</td><td width="100">姓名</td><td width="100">密码</td></tr>
    <tr align="center"><td width="100"><%=tid %></td><td width="100"><%=tname %></td><td width="100"><%=tcode %></td></tr>
    </table>
    <br/>
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>开设课程信息如下：</b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="100">课序号</td><td width="150">课程名</td><td width="80">课程学分</td><td>平均分</td><td width="80">最高分</td><td width="80">最低分</td><td width="80">选课人数</td><td width="80">详细信息</td></tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Tc)all.elementAt(j);
	String cno = cou[j].getCno() ;
	String cname = cou[j].getCname() ;
    double credit=cou[j].getCredit();
    Score sco=scdao.GetMaxMinAvg(cno,tid);
    double avscore=sco.getAvscore();
    double maxscore=sco.getMaxscore();
    double minscore=sco.getMinscore();
    int csel=cou[j].getCsel();
	%>
            	<tr align="center">
		    		<td><%=cno%></td>
		    		<td><%=cname%></td>
		       		<td><%=credit%></td>
					<td><%=avscore%></td>
					<td><%=maxscore%></td>
		    		<td><%=minscore%></td>
					<td><%=csel%></td>
					<td><a href="teacher_sel_self_coul.jsp?cno=<%=cno %>" >查看</a></td>
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
