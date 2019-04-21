<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
 <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formselstu.sid.value == "")
  	{	
  		window.alert("学号为空！"); 
 		document.formselstu.elements(0).focus();
  		return  false;
  	}
  	formselstu.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formselstu" action="admin_stu_updrs.jsp" method="post" onsubmit="return isValid();"><div align="center">
    <font color="#0000a0" face="华文楷体"><strong><font size="5">修改学生信息<br><br><br></font></strong></font></div>
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25">请输入修改学生信息</th></tr>
    <tr><td height="20">学生学号：</td><td><input type="text" name="sid"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20"><input type="reset" value="重&nbsp&nbsp置"/></td><td><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    </form>
  </body>
</html>
