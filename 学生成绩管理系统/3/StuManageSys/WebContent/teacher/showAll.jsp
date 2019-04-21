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
    		<td align="center">授课号</td>
    		<td align="center">教师编号</td>
    		<td align="center">教师名</td>
    		<td align="center">课程编号</td>
    		<td align="center">课程名</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="%{#request.hasSelect}" var="course_teacher">
    	<tr>
    		<td align="center"><s:property value="#course_teacher.CTId" /></td>
    		<td align="center"><s:property value="#course_teacher.getTeacher().TId" /></td>
    		<td align="center"><s:property value="#course_teacher.getTeacher().TName" /></td>
    		<td align="center">&nbsp;<s:property value="#course_teacher.getCourse().CId" /></td>
    		<td align="center">&nbsp;<s:property value="#course_teacher.getCourse().CName" /></td>
    		<td align="center"><a href="showAStudent.action?ctid=<s:property value='#course_teacher.CTId' />" >显示该课程的学生信息</a></td>
    		
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
