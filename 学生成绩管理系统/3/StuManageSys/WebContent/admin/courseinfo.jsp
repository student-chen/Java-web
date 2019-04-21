<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>课程信息页面</title>
    <style type="text/css">
        .style {
	      text-align: center
        }
        </style>
  </head>
  
  <body>
   <center>
			<table border="0.5px" width="900px" class="style"
				style="margin-top: 50px;">
				<tr>
					<td colspan="9" background="../skin/images/frame/wbg.gif"
						style="height: 25px; text-align: center">
						<strong>课程信息列表</strong>
					</td>
				</tr>
				<tr bgcolor="lightgreen">
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
					          操作 
					</td>
				</tr>
				<s:iterator value="%{#request.allcourse}" var="allcourse">
					<tr>
						<td align="center">
							<s:property value="#allcourse.CId" />
						</td>
						<td align="center">
							<s:property value="#allcourse.CName" />
						</td>
						<td align="center">
							<s:property value="#allcourse.CHour" />
						</td>		
						<td align="center">
							<a href='admindeletecourse.action?cid=<s:property value="#allcourse.CId"/>'onclick="return confirm('警告：删除该课程会同时删除选修该课程的教师选课信息以及所有选修了该课程的学生的选课信息！真的要删除吗？')" >删除</a>
							<a href='admingetSelectedCourseInfo.action?cid=<s:property value="#allcourse.CId"/>'>编辑</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</center>
  </body>
</html>
