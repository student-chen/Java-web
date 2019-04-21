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
    		<td align="center">授课号</td>
    		<td align="center">教师编号</td>
    		<td align="center">课程编号</td>
    		<td align="center">课程名</td>
    		<td align="center">学时</td>
    		<td align="center">教师名</td>
    		<td colspan="2" align="center">操作</td>
    	</tr>
    	<s:iterator value="%{#request.allCT}" var="all">
    	<tr>
    		<td align="center"><s:property value="#all.CTId" /></td>
    		<td align="center"><s:property value="#all.teacher.TId" /></td>
    		<td align="center"><s:property value="#all.course.CId" /></td>
    		<td align="center"><s:property value="#all.course.CName" /></td>
    		<td align="center">&nbsp;<s:property value="#all.course.CHour" /></td>
    		<td align="center">&nbsp;<s:property value="#all.teacher.TName" /></td>
    		<td align="center"><a href="adminDeleteCT.action?ctid=<s:property value='#all.CTId' />"onclick="return confirm('警告!删除该授课信息将同时删除选修了该课程的所有学生的选课信息,真的要删除吗?')" >删除</a></td>
    		
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
