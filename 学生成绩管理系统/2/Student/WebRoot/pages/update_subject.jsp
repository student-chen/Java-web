<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>update page</title>
		<link href="../css/regist.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<center>
			<form action="/Student/UpdateSubjectServlet" method="post">
				<div class="window" align="left">
					<div class="tit">
						修改课程信息
					</div>
					<div class="main">
						<div align="left">
							ID：&nbsp;&nbsp;
							<input name="sub_id" type="text"
								value="${sessionScope.subject.id}" readonly="readonly" />
						</div>
						<div align="left">
							名称：
							<input name="sub_name" type="text"
								value="${sessionScope.subject.name}" />
						</div>
						<div align="left">
							类型：
							<input name="sub_type" type="text"
								value="${sessionScope.subject.type}" />
						</div>
						<div align="left">
							课时：
							<input name="sub_times" type="text"
								value="${sessionScope.subject.times}" />
						</div>
						<br />
						<div align="right">
							<input type="submit" value="修改"
								style="width: 65px; height: 35px; line-height: 35px; overflow: hidden; text-align: center; float: left; margin-left: 270px;" />
						</div>
					</div>
				</div>
			</form>
		</center>
	</body>
</html>