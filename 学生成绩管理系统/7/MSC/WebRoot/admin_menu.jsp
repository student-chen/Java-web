<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    <link rel="stylesheet" type="text/css" href="image/mystyle1.css">
  </head>
  
  <body >
  <SCRIPT Language="javascript">
 <!--
  
 function isValid2()
  {	
  	if(changecode.oldpa.value == "")
  	{	
  		window.alert("原密码不能为空！"); 
 		document.changecode.elements(0).focus();
  		return  false;
  	}
  	if(changecode.newpa.value == "")
  	{
  		window.alert("新密码不能为空！");
  		document.changecode.elements(1).focus();
  		return  false; 
  	}
  	if(changecode.confpa.value == "")
  	{
  		window.alert("密码确认不能为空！");
  		document.changecode.elements(2).focus();
  		return  false; 
  	}
  	changecode.submit();
 }
 
  -->
  </SCRIPT>	
  <%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");
String kind=(String)session.getAttribute("kind");
 %>
    <table width="1024" height="610" bgcolor="#1fa0eb" align="center" cellspacing="0" cellpadding="0"><tr><td><div align="center">  
    </div><table width="1024" height="610" bgcolor="#ffffff" align="center" cellspacing="0" cellpadding="0">
    <tr><td><table width="1016" height="602" bgcolor="#8dd8f8" align="center">
    <tr><th colspan="2" align="center"><form name="changecode" action="menu_slt?id=<%=id %>&kind=<%=kind %>" method="post" onsubmit="return isValid2(this);">
    <table align="center"><tr><td><table border="1" align="center">
    <tr align="center"><th colspan="2"><font face="华文楷体" color="#0000a0"><strong><font size="5">修改登录密码</font></strong></font></th></tr>
    <tr><td>原 密 码：   </td><td>  <input type="password" name="oldpa" /></td></tr>
    <tr><td>新 密 码：   </td><td>  <input type="password" name="newpa" /></td></tr>
    <tr><td>密码确认：</td><td><input type="password" name="confpa" /><input type="hidden" name="action" value="changecode"/></td></tr>
      <tr><td><input type="reset" value="重 置"/>   </td><td>  <input type="submit" value="修 改"/></td></tr>
    </table></td></tr></table></form>
    </th></tr>
    </table></td></tr>
    </table></td></tr>
    </table>
  </body>
</html>
