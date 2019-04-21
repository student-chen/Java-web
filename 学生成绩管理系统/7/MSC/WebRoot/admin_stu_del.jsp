<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formdelstu.sid.value == "")
  	{	
  		window.alert("学号为空！"); 
 		document.formdelstu.elements(0).focus();
  		return  false;
  	}
  	formdelstu.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formdelstu" action="student_slt" method="post" onsubmit="return isValid();"><div align="center">
<strong>    <font color="#0000a0" size="5" face="华文楷体">删除学生信息<br><br><br></font></strong></div>
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25"><font size="4">请输入删除学生信息</font></th></tr>
    <tr><td height="20">学生学号：</td><td><input type="text" name="sid"/></td></tr>
    <tr><th colspan="2" height="15"><input type="hidden" name="action" value="delete"></th></tr>
    <tr><td height="20"><input type="reset" value="重&nbsp&nbsp置"/></td><td><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    </form>
  </body>
</html>
