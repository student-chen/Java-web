<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
  </head>
  
  <body bgcolor="#8dd8f8">
    <form name="formselstu" action="admin_stu_selrs.jsp?" method="post"><div align="center">
    <font color="#0000a0" face="华文楷体"><strong><font size="5">查询学生信息<br><br><br></font></strong></font></div>
    <table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="15"><font size="4">查询条件（可近似查询）</font></th></tr>
    <tr><td height="25">请输入查询学生学号：</td><td><input type="text" name="sid"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="25">请输入查询学生班级：</td><td><input type="text" name="sclass"/></td></tr>
    <tr><th colspan="25" height="15"></th></tr>
    <tr><td height="25">请输入查询学生专业：</td><td><input type="text" name="smajor"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20"><input type="reset" value="重  置"/></td><td><input type="submit" value="提  交"/></td></tr>
    </table>
    </form>
  </body>
</html>
