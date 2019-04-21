<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>regist page</title>
		<link href="../css/regist.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<center>
			<form action="/Student/UpdateClassesServlet"
				method="post">
				<div class="window" align="left">
					<div class="tit">
						编辑班级：
					</div>
					<div class="main">
						<div align="left">
							班 级 ID：
							<input type="text" name="cla_id"
								value="${sessionScope.classes.id}" readonly="readonly" />
						</div>
						<div align="left">
							班 级 名：
							<input type="text" name="cla_name"
								value="${sessionScope.classes.name}"/>
						</div>
						<div align="left">
							班 主 任：
							<!--<input type="text" name="cla_tec"
								value="${sessionScope.classes.tecName}"/>
								
								--><select name="cla_tec">
								<c:forEach items="${sessionScope.list_teacher}" var="teacher">
									<c:choose>
										<c:when test="${teacher.name == sessionScope.classes.tecName}">
											<option value="${teacher.name}" selected="selected">
												${teacher.name }
											</option>
										</c:when>
										<c:otherwise>
											<option value="${teacher.name }">
												${teacher.name }
											</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
			
						</div>
						<div align="left">
							主修专业：
							<select name="maj_id">
								<c:forEach items="${sessionScope.list_major}" var="major">
									<c:choose>
										<c:when test="${major.id == sessionScope.classes.major.id}">
											<option value="${major.id}" selected="selected">
												${major.name}
											</option>
										</c:when>
										<c:otherwise>
											<option value="${major.id}">
												${major.name}
											</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</div>
						<br />
						<div align="left">
							<input style="width: 60px; height: 30px" type="submit"
								value="更 新    " />
						</div>
					</div>
				</div>
			</form>
		</center>
	</body>
</html>