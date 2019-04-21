<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'selectcourselist.jsp' starting page</title>
    <style type="text/css">
    .style{text-align: center}
    </style>
  </head>
  
  <body>
   <center>
		<table border="0.5px" width="800px" class="style" style="margin-top: 50px;">
		<tr><td colspan="5" background="../skin/images/frame/wbg.gif" style="height:25px; text-align:center"><strong>您可选的课程信息如下：</strong></td></tr>
			<tr bgcolor="lightgreen">
				<td>
					授课号
				</td>
				<td>
					课程号
				</td>
				<td>
					课程名
				</td>
				<td>
					教师名
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="%{#session.sc}" var="sc">
    	<tr>
    		<td align="center"><s:property value="#sc.id.course_teacher.CTId" /></td>
    		<td align="center"><s:property value="#sc.id.course_teacher.course.CId" /></td>
    		<td align="center"><s:property value="#sc.id.course_teacher.course.CName" /></td>
    		<td align="center"><s:property value="#sc.id.course_teacher.teacher.TName" /></td>
    		<td align="center"><a href='deletecourse.action?ctid=<s:property value="#sc.id.course_teacher.CTId" />' onclick="return confirm('真的要删除吗？')">删除</a></td>
    	</tr>
    	</s:iterator>
		</table>
		</center>
  </body>
</html>
