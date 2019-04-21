<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formdelcou.cno.value == "")
  	{	
  		window.alert("课序号不能为空！"); 
 		document.formdelcou.elements(0).focus();
  		return  false;
  	}
  	formdelcou.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formdelcou" action="course_slt" method="post" onsubmit="return isValid(this);"><div align="center"> 
  <font color="#0000a0"><strong><font size="5" face="华文楷体">删除课程信息</font></strong></font></div>
  <br><br>
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25">请输入删除课程信息</th></tr>
    <tr><td height="25">课程序号：</td><td><input type="text" name="cno"/> </td></tr>
    <tr><th colspan="2" height="15"><input type="hidden" name="action" value="delete"></th></tr>
    <tr><td height="25"><font size="5"><input type="reset" value="重 置"></font></td><td><input type="submit" value="提 交"/></td></tr>
    </table>
    </form>
  </body>
</html>
