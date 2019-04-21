<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
 <SCRIPT Language="javascript">
 <!--
  function isValid()
  {	
  	if(formaddcou.cno.value == "")
  	{	
  		window.alert("课序号不能为空！"); 
 		document.formaddcou.elements(0).focus();
  		return  false;
  	}
  	if(formaddcou.cname.value == "")
  	{
  		window.alert("课程名不能为空！");
  		document.formaddcou.elements(1).focus();
  		return  false; 
  	}
  	if(formaddcou.credit.value == "")
  	{
  		window.alert("课程学分称不能为空！");
  		document.formaddcou.elements(2).focus();
  		return  false; 
  	}
  	formaddcou.submit();
 }
  -->
  </SCRIPT>	
  <SCRIPT Language="javascript">
  
   <script language="javascript">
   function   shuru(txt){   
     if(isNaN(txt)){   
          window.alert("学分只能输入数字"); 
          document.formaddcou.elements(2).focus(); 
          return  false;   
          }  
    }  
   </script>
  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formaddcou" action="course_slt" method="post" onsubmit="return isValid(this);"><div align="center">
  <font size="5" face="华文楷体" color="#0000a0"><strong>添加课程信息</strong></font></div>
  <br/><br/>
  <table border="1" width="600" height="120" align="center" cellspacing="0" cellpadding="0">
    <tr align="center"><th colspan="2" height="25"><font size="4" face="宋体"><strong>请</strong></font><font size="4" face="宋体">输入课程信息</font></th></tr>
    <tr><td height="25">课序号：</td><td><input type="text" name="cno"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="25">课程名称：</td><td><input type="text" name="cname"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="25">课程学分：</td><td><input type="text" name="credit" onchange="shuru(this.value )"/></td></tr>
    <tr><th colspan="2" height="15"><input type="hidden" name="action" value="new"></th></tr>
    <tr><td height="25"><input type="reset" value="重&nbsp&nbsp置"/></td><td><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    </form>
    <br/><br/><br/>
    </body>
</html>
