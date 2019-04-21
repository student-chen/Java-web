<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生信息</title>
<link href="../css/regist.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<center>
		<form action="/Student/EditStudentServlet?stu_id=${sessionScope.student_me.id}" method="post">
			<div class="window" align="left">
				<div class="tit">我的信息</div>
				<div class="main">
					<div align="left">
						学号： ${sessionScope.student_me.no}
					</div>
					<div align="left">
						姓名： ${sessionScope.student_me.name}
					</div>
					<div align="left">
						账号： ${sessionScope.student_me.operator.name}
					</div>
					<div align="left">
						性别： ${sessionScope.student_me.sex}
					</div>
					<div align="left">
						生日： ${sessionScope.student_me.birth}
					</div>
					<div align="left">
						班级： ${sessionScope.student_me.classes.name}
					</div>
					<div align="left">
						<a>头像：</a><br/>
						<img src=" ${sessionScope.student_me.pic}" width="150" height="150" style="margin-left: 100px;" />
					</div>
					<br />
					<div align="right">
						<input type="submit" value="修改我的信息"
							style="width: 100px; height: 35px; line-height: 35px; overflow:hidden;text-align:center;  float: left; margin-left: 270px;" />
					</div>
				</div>
			</div>
		</form>
	</center>
</body>
</html>