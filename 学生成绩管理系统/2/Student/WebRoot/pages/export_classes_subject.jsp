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
		<script src="../js/export_classes_subject.js" type="text/javascript">
	
</script>
		<script src="../js/search.js" type="text/javascript">
	
</script>
	</head>

	<body>
		<center>
			<div class="window">
				<div id="sta" class="searchbox tit">
					请输入班级名称：
					<input type="hidden" id="search_type" name="search_type"
						value="cla_name" />
					<input id="value" type="text" style="width: 200px; height: 20px;" />
					<input id="search_classes_subject" type="button" value="查询   " />


				</div>
				<p style="font-size: 12px; color: #FF0000;">
					注意：只有查询出来才会显示右上角的导出课程表菜单哦！
				</p>
				<br/>
				<center id="center">
					<table id="table" width="810px" border="1px" cellspacing="0"
						cellpadding="5" bordercolor="#999999">
						<tr align="center">


							<td width="120px">
								班级名
								<td width="120px">
									课程名
								</td>

								<td width="120px">
									主讲教师名
								</td>
						</tr>
					</table>
				</center>
			</div>
		</center>
	</body>
</html>