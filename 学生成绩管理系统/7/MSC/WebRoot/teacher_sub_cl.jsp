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
    

  </head>
  
  <body bgcolor="#8dd8f8">
  <% 
  request.setCharacterEncoding("utf-8");
  String message=null;
  %>
    <%
    request.setCharacterEncoding("utf-8");
    String tid=request.getParameter("tid");
    String con=request.getParameter("con");
    Vector all=new Vector();
    if(con.equals("subing")){
        all=tcdao.SelectSelf(tid,"1");
    }else {
        all=tcdao.SelectSelf(tid,"2");
    }
    int i=all.size();
    Tc cou[]=new Tc[i];
     %>
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>开设课程信息如下：<br><br></b></font></div>
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="150">课序号</td><td width="150">课程名</td><td>导出成绩Excel表</td><%if(con.equals("subing")){ %><%} %><td>提交成绩</td></tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Tc)all.elementAt(j);
	String cno = cou[j].getCno() ;
	String cname = cou[j].getCname() ;
	%>
            	<tr align="center">
		    		<td><%=cno%></td>
		    		<td><%=cname%></td>
		    		<td><a href="teacher_sub_rs.jsp?cno=<%=cno %>&tid=<%=tid %>&con=subed&xls=yes"><img src="image/download1.png" /></a></td>
		    		<%if(con.equals("subing")){ %>
		    		<%} %>
		    		<td><a href="teacher_sub_rs.jsp?cno=<%=cno %>&tid=<%=tid %>&con=<%=con %>&xls=no">提交</a></td>
				    
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
