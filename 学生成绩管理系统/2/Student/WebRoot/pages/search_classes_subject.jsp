<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>search page</title>
		<link href="../css/search.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.8.3.min.js" type="text/javascript">
</script>
		<script src="../js/search_classes_subject.js" type="text/javascript">
</script>
		<script src="../js/search.js" type="text/javascript">
</script>
	</head>

	<body>
		<center>
			<div class="window">
				<div class="searchbox tit">
					查找班级课程：
					<select id="search_type">
						<option value="all">
							查找全部
						</option>
						<option value="sub_name">
							课程名称
						</option>
						<option value="cla_name">
							班级名称
						</option>
					</select>
					<input id="value" type="text" style="width: 200px; height: 20px;" />
					<input id="search_classes_subject" type="button" value="查询   " />
				</div>
				<center id="center">
					<table id="table" width="810px" border="1px" cellspacing="0"
						cellpadding="5" bordercolor="#999999">
						<tr align="center">
							<td width="70px">
								编号
							</td>
							<td width="80px">
								班级ID
							</td>
							<td width="120px">
								班级名
							</td>
							<td width="80px">
								课程ID
							</td>
							<td width="120px">
								课程名
							</td>
							<td width="80px">
								主讲教师ID
							</td>
							<td width="120px">
								主讲教师名
							</td>						
							<td width="130px">
								编辑
							</td>
						</tr>
					</table>
				</center>
			</div>
		</center>
	</body>
</html>