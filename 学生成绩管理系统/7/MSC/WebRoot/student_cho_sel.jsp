<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title></title>
	</head>

	<body bgcolor="#8dd8f8">
		<div align="center">
			<font color="#0000a0"> </font><font size="5" face="华文楷体"
				color="#0000a0">
				<strong>查询课程信息<br>
					<br>
					<br>
			   </strong>
			</font>
		</div>
		<form name="formselcou" action="student_cho_selrs.jsp" method="post">
			<table border="1" width="600" align="center" cellspacing="0"
				cellpadding="0">
				<tr>
					<th colspan="2" height="25">
						<font size="4">查询条件（可近似查询）</font>
					</th>
				</tr>
				<tr>
					<td height="25">
						课程号：
					</td>
					<td>
						<input type="text" name="cno" />
					</td>
				</tr>
				<tr>
					<th colspan="2" height="15"></th>
				</tr>
				<tr>
					<td height="25">
						课程名称：
					</td>
					<td>
						<input type="text" name="cname" />
					</td>
				</tr>
				<tr>
					<th colspan="25" height="15"></th>
				</tr>
				<tr>
					<td height="25">
						课程学分：
					</td>
					<td>
						<input type="text" name="credit" />
					</td>
				</tr>
				<tr>
					<th colspan="2" height="15"></th>
				</tr>
				<tr>
					<td height="25">
						任课教师：
					</td>
					<td>
						<input type="text" name="tname" />
					</td>
				</tr>
				<tr>
					<th colspan="2" height="15"></th>
				</tr>
				<tr>
					<td height="25">
						教学班号：
					</td>
					<td>
						<input type="text" name="cteachno" />
					</td>
				</tr>
				<tr>
					<th colspan="2" height="15"></th>
				</tr>
				<tr>
					<td height="25">
						上课时间：
					</td>
					<td>
						<input type="text" name="ctime" />
					</td>
				</tr>
				<tr>
					<th colspan="2" height="15"></th>
				</tr>
				<tr>
					<td height="25">
						上课地点：
					</td>
					<td>
						<input type="text" name="clocation" />
					</td>
				</tr>
				<tr>
					<th colspan="2" height="15"></th>
				</tr>
				<tr>
					<td height="20">
						<input type="reset" value="重  置" />
					</td>
					<td>
						<input type="submit" value="提  交" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
