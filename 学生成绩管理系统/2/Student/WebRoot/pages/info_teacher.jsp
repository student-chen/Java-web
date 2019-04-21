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
			<form
				action="/Student/EditTeacherServlet?tec_id=${sessionScope.teacher_me.id}"
				method="post">
				<div class="window" align="left">
					<div class="tit">
						我的信息
					</div>
					<div class="main">
						<div align="left">
							I　　　D：&nbsp;&nbsp; ${sessionScope.teacher_me.id}
						</div>
						<div align="left">
							姓　　名： ${sessionScope.teacher_me.name}
						</div>
						<div align="left">
							专　　业： ${sessionScope.teacher_me.major}
						</div>
						<div align="left">
							性　　别： ${sessionScope.teacher_me.sex}
						</div>
						<div align="left">
							生　　日： ${sessionScope.teacher_me.birth}
						</div>
						<div align="left">
							账　　号： ${sessionScope.operator_me.name}
						</div>
						<div align="left">
							联系电话： ${sessionScope.teacher_me.phone}
						</div>
						<div align="right">
							<input type="submit" value="修改我的信息"
								style="width: 100px; height: 35px; line-height: 35px; overflow: hidden; text-align: center; float: left; margin-left: 270px;" />
						</div>
					</div>
				</div>
			</form>
		</center>
	</body>
</html>