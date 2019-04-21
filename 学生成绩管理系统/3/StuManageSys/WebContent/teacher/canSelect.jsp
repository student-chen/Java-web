<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
   <br /><br /><br /><br />
    <table border="1" width="50%" align="center">
    	<tr bgcolor="lightgreen">
    		<td align="center">课程序号</td>
    		<td align="center">课程名</td>
    		<td align="center">课时</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="%{#request.canSelect}" var="course">
    	<tr>
    		<td align="center"><s:property value="#course.CId" /></td>
    		<td align="center"><s:property value="#course.CName" /></td>
    		<td align="center">&nbsp;<s:property value="#course.CHour" /></td>
    		<td align="center"><a href="choice.action?cid=<s:property value='#course.CId' />" >选定</a></td>
    		
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
