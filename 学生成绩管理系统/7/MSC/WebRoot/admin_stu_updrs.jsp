
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
    <jsp:useBean id="sdao" scope="page" class="msc.dao.StudentDAO"></jsp:useBean>
    <title></title>
    <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formupdate.sname.value == "")
  	{	
  		window.alert("学生姓名为空！"); 
 		document.formupdate.elements(0).focus();
  		return  false;
  	}
  	if(formupdate.smajor.value=="")
  	{
  	    window.alert("学生专业为空！");
  	    document.formupdate.elements(1).focus();
  	    return  false;
  	}
  	if(formupdate.sclass.value=="")
  	{
  	    window.alert("学生班级为空！");
  	    document.formupdate.elements(2).focus();
  	    return  false;
  	}
  	if(formupdate.scode.value=="")
  	{
  	    window.alert("学生密码为空！");
  	    document.formupdate.elements(3).focus();
  	    return  false;
  	}
  	formupdate.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
    <%
    String condition=request.getParameter("sid");
    Vector vector=sdao.Select(condition,"","");
    int i=vector.size();
    Student stu[]=new Student[i];
    	
     %>
     <div align="center"><font size="5" color="#000080" face="华文楷体"><b>修改学生信息<br><br><br></b></font></div>
     <form name="formupdate" action="student_slt" method="post" onsubmit="return isValid(this);">
     
     <table width="650" border="1" cellspacing="0" cellpadding="0" align="center">
     <tr><th height="25" colspan="2"><input type="hidden" name="action" value="update"/><font size="4">请在下表输入修改后学生信息</font></th></tr>
	<%
	for(int j=0;j<i;j++){
	stu[j]=(Student)vector.elementAt(j);
	String sid = stu[j].getSid() ;
	String sname = stu[j].getSname() ;
    String smajor = stu[j].getSmajor() ;
	String sclass = stu[j].getSclass() ;
    String scode=stu[j].getScode();
	%>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>学生学号：</td><td><input type="text" name="sid" value="<%=sid%>" readonly/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>学生姓名：</td><td><input type="text" name="sname" value="<%=sname %>"/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>学生专业：</td><td><input type="text" name="smajor" value="<%=smajor %>"/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>学生班级：</td><td><input type="text" name="sclass" value="<%=sclass %>"/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
	<tr><td>学生密码：</td><td><input type="text" name="scode" value="<%=scode %>"/></td></tr>
	<tr><th colspan="2" height="15"></th></tr>
     <tr><td><input type="reset" value="重  置"/></td><td><input type="submit" value="提  交"/></td></tr>
	<% 
	}
	if(i==0){	
	%>
	<tr><th colspan="5">无该学生信息！</th></tr>
	<%} %>

    
      </table>
     </form>
  </body>
</html>