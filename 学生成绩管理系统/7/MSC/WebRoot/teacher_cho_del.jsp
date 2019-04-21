<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="msc.vo.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <jsp:useBean id="tcdao" scope="page" class="msc.dao.TcDAO"></jsp:useBean>
    <title></title>
 <script language="JavaScript">
 <!-- Hide 
function delalert(value)
 { 
    if (value == true) 
       alert("打上勾表示删除,小心哟!");  
 }
// -->
</script>

  </head>
  
  <body bgcolor="#8dd8f8">
  <% 
  request.setCharacterEncoding("utf-8");
  String tid=(String)session.getAttribute("id");
  String canchoose=(String)session.getAttribute("canchoose");
  String message=null;
  if(canchoose.equals("选课")){
  Vector all=tcdao.SelectSelf(tid,"");
    int i=all.size();
    Tc cou[]=new Tc[i];
  %>
  <div align="center"><font size="5" color="#000080" face="华文楷体"><b>开设课程信息如下：<br><br></b></font></div>
     <form name="formdelcou" action="tc_slt?n=<%=i %>" method="post" onsubmit="return isValid(this);">
     <table border="1" cellspacing="0" cellpadding="0" align="center">
     
     <tr align="center"><td width="100">课序号</td><td width="150">课程名</td><td width="100">课程学分</td><td width="100">删除</td></tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Tc)all.elementAt(j);
	String cno = cou[j].getCno() ;
	String cname = cou[j].getCname() ;
    double credit=cou[j].getCredit();
	%>
            	<tr align="center">
		    		<td><%=cno%></td>
		    		<td><%=cname%></td>
		       		<td><%=credit%></td>
		       		<td><input type="checkbox" name="cno<%=j %>" value="<%=cno %>" onClick="return delalert(this.checked)"/> </td>
				</tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="10">无课程信息！</th></tr>
	<%}else{ %>
    <tr height="15" ><td colspan="4"><input type="hidden" name="action" value="delete"><input type="hidden" name="tid" value=<%=tid %>></td></tr>
    <tr><td height="25" colspan="2"><input type="reset" value="重&nbsp&nbsp置"/></td><td colspan="2"><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    <%} %>
    </form>
    <%}else{ %><div align="center">
<font size="5" color="#ff0000"><strong>非选课时期，不能删除课程！
  </strong></font></div>
  <%} %>
  </body>
</html>
