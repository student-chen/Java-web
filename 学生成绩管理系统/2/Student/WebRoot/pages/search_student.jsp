<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>search page</title>
		<link href="../css/search.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="../js/search_student.js" type="text/javascript"></script>
		<script src="../js/search.js" type="text/javascript"></script>
	</head>

	<body>
		<center>
			<div class="window">
				<div class="searchbox tit">
					查找学生：
					<select id="search_type">
						<option value="stu_all">
							查找全部
						</option>
						<option value="stu_no">
							学生学号
						</option>
						<option value="stu_name">
							学生姓名
						</option>
						<option value="cla_name">
							班级名称
						</option>
						<option value="maj_name">
							专业名称
						</option>
					</select>
					<input id="value" type="text" style="width: 200px; height: 20px;" />
					<input id="search_student" type="button" value=" 查询   " />
				</div>
				<p style="font-size: 12px; color: #FF0000;">
					注意：删除学生时将会删除学生的登录账号以及成绩等信息，且不可恢复。
				</p>
				<br />
				<center id="center">
					<table id="table" width="670px" border="1px" cellspacing="0"
						cellpadding="5" bordercolor="#999999">
						<tr align="center">
							<td width="50px">编号</td>
							<td width="50px">学号</td>
							<td width="90px">姓名</td>
							<td width="50px">性别</td>
							<td width="110px">生日</td>
							<td width="130px">班级</td>
							<td width="60px">照片</td>
							<td width="130px">编辑</td>
						</tr>
					</table>
				</center>
			</div>
		</center>
	</body>
</html>