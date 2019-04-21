<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="msc.vo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()

+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <jsp:useBean id="cdao" scope="page" class="msc.dao.CourseDAO"></jsp:useBean>
    <title></title>
    <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formupdate.cname.value == "")
  	{	
  		window.alert("课程名称为空！"); 
 		document.formupdate.elements(1).focus();
  		return  false;
  	}
  	if(formupdate.credit.value=="")
  	{
  	    window.alert("课程学分为空！");
  	    document.formupdate.elements(2).focus();
  	    return  false;
  	}
  	formupdate.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
    <%
    request.setCharacterEncoding("utf-8");
    String condition=request.getParameter("cno");
    Vector vector=cdao.Select(condition,"",0);
    int i=vector.size();
    Course cou[]=new Course[i];
    	
     %>
     <div align="center"><font size="5" color="#000080" face="华文楷体"><b>修改课程信息：<br><br></b></font></div>
     <form name="formupdate" action="course_slt" method="post" onsubmit="return isValid(this);">
     <table width="650" border="1" cellspacing="0" cellpadding="0" align="center">
     <tr><th height="25" colspan="2"><input type="hidden" name="action" value="update"/><font size="4">请在下表输入修改后课程信息</font></th></tr>
	<%
	for(int j=0;j<i;j++){
	cou[j]=(Course)vector.elementAt(j);
	String cno = cou[j].getCno() ;
	String cname = cou[j].getCname() ;
    double credit = cou[j].getCredit() ;
	
	%>
	<tr><td>课序号：</td><td><input type="text" name="cno" value="<%=cno%>" readonly/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>课程名称：</td><td><input type="text" name="cname" value="<%=cname %>"/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>课程学分：</td><td><input type="text" name="credit" value="<%=credit %>"/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
     <tr><td><input type="reset" value="重  置"/></td><td><input type="submit" value="提  交"/></td></tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="5">无该课程信息！</th></tr>
	<%} %>

    
      </table>
     </form>
  </body>
</html>