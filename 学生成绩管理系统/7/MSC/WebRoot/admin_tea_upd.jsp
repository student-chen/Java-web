<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    <SCRIPT Language=javascript>
 <!--
  function isValid()
  {	
  	if(formupdtea.tid.value == "")
  	{	
  		window.alert("工号为空！"); 
 		document.formupdtea.elements(0).focus();
  		return  false;
  	}
  	formupdtea.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8"><div align="center">
  <font color="#0000a0" face="华文楷体"><strong><font size="5">修改教师信息<br><br><br></font></strong></font></div>
  <form name="formupdtea" action="admin_tea_updrs.jsp" method="post" onsubmit="return isValid(this);">
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25">请输入修改信息</th></tr>
    <tr><td height="20">教师的工号：</td><td><input type="text" name="tid"/> 
    <input type="hidden" name="action" value="update"></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20"><input type="reset" value="重 置"/></td><td><input type="submit" value="提 交"/></td></tr>
    </table>
    </form>
  </body>
</html>
