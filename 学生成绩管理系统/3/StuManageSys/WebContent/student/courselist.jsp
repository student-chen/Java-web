<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'courselist.jsp' starting page</title>
	</head>
    <style type="text/css">
    .style{text-align: center}
    </style>
	<body>
	<center>
		<table border="0.5px" width="800px" class="style" style="margin-top: 50px;">
		<tr><td colspan="7" background="../skin/images/frame/wbg.gif" style="height:25px; text-align:center"><strong>您可选的课程信息如下：</strong></td></tr>
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
					学时
				</td>
				<td>
					教师号
				</td>
				<td>
					教师名
				</td>
				<td>
					操作
				</td>
			</tr>
			<s:iterator value="%{#session.ct}" var="ct">
    	<tr>
    		<td align="center"><s:property value="#ct.CTId" /></td>
    		<td align="center"><s:property value="#ct.course.CId" /></td>
    		<td align="center"><s:property value="#ct.course.CName" /></td>
    		<td align="center"><s:property value="#ct.course.CHour" /></td>
    		<td align="center"><s:property value="#ct.teacher.TId" /></td>
    		<td align="center"><s:property value="#ct.teacher.TName" /></td>
    		<td align="center"><a href='select.action?ctid=<s:property value="#ct.CTId" />'>选定</a></td>
    	</tr>
    	</s:iterator>
		</table>
		</center>
	</body>
</html>
