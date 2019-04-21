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
    <jsp:useBean id="tdao" scope="page" class="msc.dao.TeacherDAO"></jsp:useBean>
    <title></title>
    <%
    request.setCharacterEncoding("utf-8");
    String tid=request.getParameter("tid");
    Vector all=tcdao.SelectSelf(tid,"");
    Vector teacher=tdao.Select(tid,"");
    Teacher tea=new Teacher();
    if(teacher.size()!=0){
        tea=(Teacher)teacher.elementAt(0);
    }
    int i=all.size();
    Tc cou[]=new Tc[i];
     %>

  </head>
  
  <body bgcolor="#8dd8f8">
    
    <br/>
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b><%=tea.getTname() %>开设课程信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="100">课序号</td><td width="150">课程名</td><td width="80">课程学分</td><td width="80">平均分</td><td width="80">最高分</td><td width="80">最低分</td><td width="80">选课人数</td></tr>
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
