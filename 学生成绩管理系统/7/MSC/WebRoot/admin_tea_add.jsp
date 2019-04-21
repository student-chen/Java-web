<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <SCRIPT Language="javascript">
<!--
    function isValid(){
        if(formaddtea.tid.value==""){
           window.alert("教师工号为空！");
           document.formaddtea.elements(0).focus();
   		   return  false;
         }
         if(formaddtea.tname.value==""){
           window.alert("教师姓名为空！");
           document.formaddtea.elements(1).focus();
   		   return  false;
         }
         if(formaddtea.tcode.value==""){
           window.alert("教师密码为空！");
           document.formaddtea.elements(2).focus();
   		   return  false;
         }
        formaddtea.submit();
    }
-->
    </script>

  </head>
  
  <body bgcolor="#8dd8f8">
  <form name="formaddtea" action="teacher_slt" method="post" onsubmit="return isValid(this);"><div align="center">
    <font color="#0000a0"><strong><font size="5" face="华文楷体">添加教师信息<br><br><br></font></strong></font></div><table border="1" width="600" height="120" align="center" cellspacing="0" cellpadding="0">
    <tr><th colspan="2" height="25"><font size="4">请输入教师信息</font></th></tr>
    <tr><td height="20">教师工号：</td><td><input type="text" name="tid"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20">教师姓名：</td><td><input type="text" name="tname"/></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20">登录密码：</td><td><input type="text" name="tcode"/>
    <input type="hidden" name="action" value="new"></td></tr>
    <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20"><input type="reset" value="重  置"/></td><td><input type="submit" value="提  交"/></td></tr>
    </table>
    </form>
    <br/><br/><br/>
  </body>
</html>
