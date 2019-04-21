<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  <body>
     <br /><br /><br /><br />
    <table border="1" width="80%" align="center">
    	<tr bgcolor="lightgreen">
    	    <td align="center">学号</td>
    		<td align="center">授课号</td>
    		<td align="center">任课老师</td>
    		<td align="center">课程编号</td>
    		<td align="center">课程名</td>
    		<td align="center">学生名</td>
    		<td align="center">成绩(-1代表未输入)</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="%{#request.allSC}" var="all">
    	<tr>
            <td align="center">&nbsp;<s:property value="#all.id.student.stuId" /></td>     	
    		<td align="center"><s:property value="#all.id.course_teacher.CTId" /></td>
    		<td align="center"><s:property value="#all.id.course_teacher.teacher.TName" /></td>
    		<td align="center"><s:property value="#all.id.course_teacher.course.CId" /></td>
    		<td align="center"><s:property value="#all.id.course_teacher.course.CName" /></td>
    		<td align="center">&nbsp;<s:property value="#all.id.student.stuName" /></td>
    		<td align="center">&nbsp;<s:property value="#all.grade" /></td>
    		<td align="center"><a href="adminDeleteSC.action?stuid=<s:property value='#all.id.student.stuId' />&ctid=<s:property value='#all.id.course_teacher.CTId' />"onclick="return confirm('真的要删除吗?')">删除</a></td>
    		<td align="center"><a href="adminEditGrade.action?stuid=<s:property value='#all.id.student.stuId' />&ctid=<s:property value='#all.id.course_teacher.CTId' />&grade=<s:property value='#all.grade' />" >编辑</a></td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
 
</html>
