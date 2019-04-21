<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
 <SCRIPT Language="javascript">
 <!--
  function isValid()
  {	
  	if(formaddstu.sid.value == "")
  	{	
  		window.alert("学号不能为空！"); 
 		document.formaddstu.elements(0).focus();
  		return  false;
  	}
  	if(formaddstu.sname.value == "")
  	{
  		window.alert("姓名不能为空！");
  		document.formaddstu.elements(1).focus();
  		return  false; 
  	}
  	
  	if(formaddstu.sclass.value == "")
  	{
  		window.alert("班级不能为空！");
  		document.formaddstu.elements(3).focus();
  		return  false; 
  	}
  	if(formaddstu.scode.value == "")
  	{
  		window.alert("密码不能为空！");
  		document.formaddstu.elements(4).focus();
  		return  false; 
  	}
  	formaddstu.submit();
 }
  -->
  </SCRIPT>		
  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formaddstu" action="student_slt" method="post" onsubmit="return isValid(this);"><div align="center"> 
   <font color="#0000a0" size="5" face="华文楷体"> <strong>添加学生信息<br><br><br></strong></font> 
    </div><table border="1" width="600" height="120" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25"><font size="4">请输入学生信息</font></th></tr>
    <tr><td height="20">学生学号：</td><td><input type="text" name="sid"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20">学生姓名：</td><td><input type="text" name="sname"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20">学生专业：</td>
    <td><SELECT name="smajor">
     <OPTION>计算机科学与技术系</OPTION>
     <OPTION>软件工程系</OPTION>
     <OPTION>数学与信息科学系</OPTION>
     <OPTION>电子信息工程系</OPTION>
     <OPTION>自动化系</OPTION>
     <OPTION>生物工程</OPTION>
     </SELECT></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20">学生班级：</td><td><input type="text" name="sclass"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20">登录密码：</td><td><input type="text" name="scode"/>
    <input type="hidden" name="action" value="new"></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20"><input type="reset" value="重&nbsp&nbsp置"/></td><td><input type="submit" value="提&nbsp&nbsp交"/></td></tr>
    </table>
    
    </form>
    <br/><br/><br/>
    </body>
</html>
