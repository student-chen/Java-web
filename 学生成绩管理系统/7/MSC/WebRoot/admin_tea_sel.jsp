<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>

  </head>
  
  <body bgcolor="#8dd8f8">
  <div align="center"><strong><font color="#000080" size="5" face="华文楷体">查询教师信息<br><br><br></font></strong></div>
  <form name="formdeltea" action="admin_tea_selrs.jsp" method="post" onsubmit="return isValid(this);"><div align="center"> 
    </div><table border="1" width="600" align="center" cellspacing="0" cellpadding="0">
     <tr><th colspan="2" height="25"><font size="4">查询条件（可近似查询）</font></th></tr>
    <tr><td height="20" align="center">教师的工号：</td><td align="center"><input type="text" name="tid"/></td></tr>
     <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20" align="center">教师的姓名：</td><td align="center"><input type="text" name="tname"/>  
    <input type="hidden" name="action" value="select"></td></tr>
     <tr><th colspan="2" height="15"></th></tr>
    <tr><td height="20" align="center"><input type="reset" value="重 置"/></td><td align="center"><input type="submit" value="提 交"/></td></tr>
    </table>
    </form>
  </body>
</html>
