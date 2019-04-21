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
  	if(formdelcou.cteachno.value == "")
  	{	
  		window.alert("教学班号不能为空！"); 
 		document.formdelcou.elements(1).focus();
  		return  false;
  	}
  	if(formdelcou.clocation.value == "")
  	{	
  		window.alert("上课地点不能为空！"); 
 		document.formdelcou.elements(2).focus();
  		return  false;
  	}
  	if(formdelcou.ctime.value == "")
  	{	
  		window.alert("上课时间不能为空！"); 
 		document.formdelcou.elements(3).focus();
  		return  false;
  	}
  	if(formdelcou.cmax.value == "")
  	{	
  		window.alert("课程容量不能为空！"); 
 		document.formdelcou.elements(4).focus();
  		return  false;
  	}
  	formdelcou.submit();
 }
  -->
  </SCRIPT>		

  </head>
  
  <body bgcolor="#8dd8f8">
  <% 
  request.setCharacterEncoding("utf-8");
  String name=(String)session.getAttribute("na");
  String tid=(String)session.getAttribute("id");
  String message=null;
  %>
<div align="center"><font color="#0000a0"><strong><font size="5" face="华文楷体">
  开设课程</font></strong></font><br><br><br></div>
  <form name="formdelcou" action="tc_slt" method="post" onsubmit="return isValid(this);">
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th height="25" colspan="2">请输入开设课程信息:</th></tr>
    <tr><td height="15"></td></tr>
    <tr><td height="25">课程序号：</td><td><input type="text" name="cno"/> </td></tr>
    <tr><td height="15"></td></tr>
    <tr><td height="25">教学班号：</td><td><input type="text" name="cteachno"/> </td></tr>
    <tr><td height="15"></td></tr>
    <tr><td height="25">上课地点：</td><td><input type="text" name="clocation"/> </td></tr>
    <tr><td height="15"></td></tr>
    <tr><td height="25">上课时间：</td><td>星期
    <SELECT name="ctime1">
    <OPTION>一</OPTION>
    <OPTION>二</OPTION>
    <OPTION>三</OPTION>
    <OPTION>四</OPTION>
    <OPTION>五</OPTION>
    <OPTION>六</OPTION>
    <OPTION>天</OPTION>
    </SELECT>
    第<SELECT name="ctime2">
    <OPTION>一</OPTION>
    <OPTION>二</OPTION>
    <OPTION>三</OPTION>
    <OPTION>四</OPTION>
    <OPTION>五</OPTION>
    </SELECT>节
    </td></tr>
    <tr><td height="15"></td></tr>
    <tr><td height="25">课程容量：</td><td><input type="text" name="cmax"/> </td></tr>
    <tr height="15" >
    <td><input type="hidden" name="action" value="new"></td>
    <td><input type="hidden" name="tid" value=<%=tid %>></td>
    </tr>
    <tr><td height="25">
    <input type="reset" value="重&nbsp&nbsp置"/></td>
    <td><input type="submit" value="提&nbsp&nbsp交"/></td>
    </tr>
    </table>
    </form>
  </body>
</html>
