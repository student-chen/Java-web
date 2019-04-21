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
    <jsp:useBean id="cdao" scope="page" class="msc.dao.CourseDAO"></jsp:useBean>
    <title></title>
    <%
    request.setCharacterEncoding("utf-8");
    String cno=request.getParameter("cno");
    String tid=request.getParameter("tid");
    String con=request.getParameter("con");
    String xls=request.getParameter("xls");
    Vector all=new Vector();
    Vector course=new Vector();
    course=cdao.Select(cno,"",0);
    Course cou=new Course();
    if(course.size()!=0){
       cou=(Course)course.elementAt(0);
    }
    all=scdao.SelectStudent(cno,tid);
    int i=all.size();
    Sc stu[]=new Sc[i];
     %>

  </head>
  <script language="javascript">
   function   shuru(txt){   
     if(isNaN(txt)){   
          alert("请输入数字");     
          }  
    }  
  </script>
  <body bgcolor="#8dd8f8">
  <%  
	if(xls.equals("yes")){
     String name = "download.xls";   
     name = new String(name.getBytes("utf-8"), "utf-8");   
     response.setHeader("Content-Disposition", "attachment; filename=" + name);   
     }
    %> 
  <div align="center"><font size="4" color="#000080" face="华文楷体"><b><font size="5"><%=cou.getCname() %>选课学生如下：</font></b></font></div>
     <form name="scoresub" action="sc_slt?sn=<%=i %>&tid=<%=tid %>&cno=<%=cno %>" method="post">
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="150">学号</td><td width="150">姓名</td><td width="150">课程学分</td><td width="150">平时成绩</td><td width="150">期末成绩</td></tr>
	<%
	for(int j=0;j<i;j++){
	stu[j]=(Sc)all.elementAt(j);
	String sid = stu[j].getSid() ;
	String sname = stu[j].getSname() ;
    double credit=stu[j].getCredit();
    double pscore=stu[j].getPscore();
    double lscore=stu[j].getLscore();
	%>
            	<tr align="center">
		    		<td><%=sid%></td>
		    		<td><%=sname%></td>
		       		<td><%=credit%></td>
		       		<%if(con.equals("subing")){ %>
					<td><input type="text" name="pscore<%=j %>" value="<%=pscore%>" onchange="shuru(this.value )"/></td>
		    		<td><input type="text" name="lscore<%=j %>" value="<%=lscore%>" onchange="shuru(this.value )"/>
		    		<input type="hidden" name="sid<%=j %>" value="<%=sid%>"/>
		    		</td>
		    		<%}else{ %>
		    		<td><%=pscore%></td>
		    		<td><%=lscore%></td>
		    		<%} %>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="5">无选课学生信息！</th></tr>
	<%}
	else if(con.equals("subing")){
	 %>
	 <tr><th colspan="2"><input type="reset" value="重置"/></th>
	 <th colspan="3"><input type="submit" name="submit" value="暂时提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 <input type="submit" name="submit" value="最终提交"/><input type="hidden" name="action" value="scoresub"/></th></tr>
	 <tr><td colspan="8"><div align="center">
    <strong><font size="4" color="#ff0000">	<font face="楷体">提示：暂时提交后成绩可修改，最终提交后不可修改！
    </font></font></strong></div></td></tr>
	 <%} %>
	</table>
	</form>
	 
	</body>
</html>
