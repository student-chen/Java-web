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
    		<td align="center">教师编号</td>
    		<td align="center">教师名</td>
    		<td align="center">联系电话</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="%{#request.teacherList}" var="teacher">
    	<tr>
    		<td align="center"><s:property value="#teacher.TId" /></td>
    		<td align="center"><s:property value="#teacher.TName" /></td>
    		<td align="center"><s:property value="#teacher.TPhone" /></td>
    		<td align="center"><a href="AdmindeleteTeacher.action?tid=<s:property value='#teacher.TId' />"onclick="return confirm('警告:删除该教师会同时删除该教师的选课信息和所有选该教师所选课程的学生选课记录!真的要删除吗?')" >删除</a></td>
    		<td align="center"><a href="AdminUpdateTeacher.action?tid=<s:property value='#teacher.TId' />" >编辑</a></td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
