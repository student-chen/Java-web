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
		<form action="/Student/UpdateMajorServlet" method="post">
			<div class="window" align="left">
				<div class="tit">修改信息</div>
				<div class="main">
					<div align="left">
						专　业　I　 &nbsp;D&nbsp;： <input name="maj_id" type="text"
							value="${sessionScope.major.id}" readonly="readonly" />
					</div>
					<div align="left">
						专　业　名　称： <input name="maj_name" type="text"
							value="${sessionScope.major.name}" />
					</div>
					<div align="left">
						专 业 负 责 人： <input name="maj_prin" type="text"
							value="${sessionScope.major.prin}" />
					</div>
					<div align="left">
						专 业 联 系 人： <input name="maj_link" type="text"
							value="${sessionScope.major.link}" />
					</div>
					<div align="left">
						联 系 人 电 话： <input name="maj_phone" type="text"
							value="${sessionScope.major.phone}" />
					</div>
					<br />
					<div align="right">
						<input type="submit" value="修改"
							style="width: 65px; height: 35px; line-height: 35px; overflow:hidden;text-align:center;  float: left; margin-left: 270px;" />
					</div>
				</div>
			</div>
		</form>
	</center>
</body>
</html>