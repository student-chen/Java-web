<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>regist page</title>
		<link href="../css/regist.css" rel="stylesheet" type="text/css" />
		<script src="../js/jquery-1.8.3.min.js">
	
</script>
		<script src="../js/search.js">
	
</script>
	</head>

	<body>
		<center>
			<form action="/Student/AddSubjectServlet" method="post">
				<c:if test="${sessionScope.message!=null}">
					<input type="hidden" value="${sessionScope.message}" id="message" />
				</c:if>
				<c:remove var="message" scope="session" />
				<div class="window" align="left">
					<div class="tit">
						添加课程
					</div>
					<div class="main">
						<div align="left">
							课程名称：
							<input type="text" name="sub_name" />
						</div>
						<div align="left">
							课程类型：
							<input type="text" name="sub_type" />
						</div>
						<div align="left">
							课程时数：
							<input type="text" name="sub_times" />
						</div>
						<br />
						<div align="right">
							<input type="submit" value="添加"
								style="width: 65px; height: 35px; line-height: 35px; overflow: hidden; text-align: center; float: left; margin-left: 270px;" />
						</div>
					</div>
				</div>
			</form>
		</center>
	</body>
</html>