<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left page</title>
<link href="../css/classmate.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<center>
		<div class="main">
			<div class="top">
				<div class="title">${sessionScope.classes.name}</div>
				<div class="detail">
					<p>班级人数：${sessionScope.studentNum}</p>
					<p>班主任：${sessionScope.teacher.name}</p>
				</div>
			</div>
			<div class="content">
				<c:forEach items="${sessionScope.list_student}" var="student">
					<div class="person">
						<img src="${student.pic}" border="0" width="100px"
							height="100px" />
						<p>${student.name}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</center>
</body>
</html>