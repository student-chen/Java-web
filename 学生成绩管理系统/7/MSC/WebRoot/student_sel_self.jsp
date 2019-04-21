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
  </head>
  <jsp:useBean id="scdao" scope="page" class="msc.dao.ScDAO"></jsp:useBean>
  <jsp:useBean id="sdao" scope="page" class="msc.dao.StudentDAO"></jsp:useBean>
  <body bgcolor="#8dd8f8">
  <%
request.setCharacterEncoding("utf-8");
String name=(String)session.getAttribute("na");
String id=(String)session.getAttribute("id");
Vector vector=sdao.Select(id,"","");
int i=vector.size();
Student stu=new Student();
if(i!=0){
stu=(Student)vector.elementAt(0);
}
Vector all=scdao.SelectCourse(id);
int n=all.size();
Sc cou[]=new Sc[n];
 %>
 <div align="center"><font size="5" color="#0000a0" face="华文楷体"><strong>个人基本信息</strong></font></div>
 <table border="1" align="center" cellspacing="0" cellpadding="0">
    <tr align="center"><td width="80">学号</td><td width="80">姓名</td><td width="160">专业</td><td width="100" >班级</td><td>总学分</td><td>平均学分绩点</td><td>最终智育成绩</td><td>班级排名</td><td>专业排名</td></tr>
    <tr align="center"><td width="80"><%=stu.getSid() %></td><td><%=stu.getSname() %></td><td><%=stu.getSmajor() %></td><td><%=stu.getSclass() %></td><td><%=stu.getTcredit() %></td><td><%=Math.round(stu.getAcredit()*100)/100.0 %></td><td><%=Math.round(stu.getEgrade()*100)/100.0 %></td><td><%=stu.getClasspm() %></td><td><%=stu.getMajorpm() %></td></tr>
    </table>
    <br/>
    <div align="center"><font size="5" color="#000080" face="华文楷体"><b>课程信息</b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     <tr align="center"><td width="100">课序号</td><td width="150">课程名</td><td width="100">课程学分</td><td width="100">平时成绩</td><td width="100">期末成绩</td><td width="100">最终成绩</td></tr>
	<%
	for(int j=0;j<n;j++){
	cou[j]=(Sc)all.elementAt(j);
	String rcno = cou[j].getCno() ;
	String rcname = cou[j].getCname() ;
    double rcredit=cou[j].getCredit();
    double rpscore=cou[j].getPscore();
    double rlscore=cou[j].getLscore();
    double rescore=cou[j].getEscore();
	%>
            	<tr align="center">
		    		<td><%=rcno%></td>
		    		<td><%=rcname%></td>
		       		<td><%=rcredit%></td>
					<td><%=rpscore%></td>
					<td><%=rlscore%></td>
		    		<td><%=rescore%></td>
				</tr>
	<% 
	}
	if(n==0){
	%>
	<tr><th colspan="6">无课程信息！</th></tr>
	<%} %>
	</table>
  </body>
</html>
