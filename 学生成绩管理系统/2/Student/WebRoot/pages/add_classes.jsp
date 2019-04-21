<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form action="/Student/AddClassesServlet" method="post">
				<c:if test="${sessionScope.message!=null}">
					<input type="hidden" value="${sessionScope.message}" id="message" />
				</c:if>
				<c:remove var="message" scope="session" />
				<div class="window" align="left">
					<div class="tit">
						添加班级
					</div>
					<div class="main">
						<div align="left">
							班级名称：
							<input type="text" name="cla_name" />
						</div>
						<div align="left">
							班 主 任：
							<select name="cla_tec">
								<c:forEach items="${sessionScope.list_teacher}" var="teacher">
									<option value="${teacher.name}">
										${teacher.name}
									</option>
								</c:forEach>
							</select>
						</div>
						<div align="left">
							主修专业：
							<select name="maj_id">
								<c:forEach items="${sessionScope.list_major}" var="major">
									<option value="${major.id}">
										${major.name}
									</option>
								</c:forEach>
							</select>
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