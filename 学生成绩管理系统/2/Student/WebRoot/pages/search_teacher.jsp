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
<script src="../js/search_teacher.js" type="text/javascript"></script>
<script src="../js/search.js" type="text/javascript"></script>
</head>

<body>
	<center>
		<div class="window">
			<div class="searchbox tit">
				查找教师： <select id="search_type">
					<option value="all">查找全部</option>
					<option value="tec_name">教师名字</option>
					<option value="tec_major">教师专业</option>
					<option value="cla_name">任课班级</option>
				</select> <input id="value" type="text" style="width: 200px; height: 20px;"
					name="value" /> <input id="search_teacher" type="button"
					value="  查询  " />
			</div>
			<center id="center">
				<table id="table" width="850px" border="1px" cellspacing="0"
					cellpadding="5" bordercolor="#999999">
					<tr align="center">
						<td width="50px">编号</td>
						<td width="100px">教师ID</td>
						<td width="100px">姓名</td>
						<td width="100px">生日</td>
						<td width="100px">性别</td>
						<td width="100px">专业</td>
						<td width="100px">联系电话</td>
						<td width="150px">编辑</td>
					</tr>
				</table>
			</center>
		</div>
	</center>
</body>
</html>