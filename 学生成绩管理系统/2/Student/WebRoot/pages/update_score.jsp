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
			<form
				action="/Student/UpdateScoreServlet?sco_id=${sessionScope.score.id}"
				method="post">
				<div class="window" align="left">
					<div class="tit">
						修改成绩
					</div>
					<div class="main">
						<div align="left">
							姓&nbsp;&nbsp;&nbsp;&nbsp;名：&nbsp;${sessionScope.student.name}
						</div>
						<div align="left">
							学&nbsp;&nbsp;&nbsp;&nbsp;科：&nbsp;${sessionScope.subject.name}
						</div>
						<div align="left">
							平 时 分：
							<input name="daily" type="text"
								value="${sessionScope.score.daily}" />
						</div>
						<div align="left">
							考 试 分：
							<input name="exam" type="text" value="${sessionScope.score.exam}" />
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