<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
 <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formupdcou.cno.value == "")
  	{	
  		window.alert("课序号为空！"); 
 		document.formupdcou.elements(0).focus();
  		return  false;
  	}
  	formupdcou.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formupdcou" action="admin_cou_updrs.jsp" method="post" onsubmit="return isValid();"><div align="center">
    <font face="华文楷体" color="#0000a0"><strong><font size="5">修改课程信息<br><br><br></font></strong></font></div>
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25"><font size="4">请输入修改课程信息</font></th></tr>
    <tr><td height="20">程序号：</td><td><input type="text" name="cno"/></td></tr>
    <tr><td height="20"><input type="reset" value="重&nbsp&nbsp置"/></td><td><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    </form>
  </body>
</html>
