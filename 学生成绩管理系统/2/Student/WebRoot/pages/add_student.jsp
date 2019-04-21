<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>regist page</title>
		<link href="../css/regist.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript"
			src="../js/My97DatePicker/WdatePicker.js">
</script>
		<script src="../js/jquery-1.8.3.min.js">

</script>
		<script src="../js/search.js">
</script>
	</head>

	<body>
		<center>

			<form action="/Student/AddStudentServlet"
				enctype="multipart/form-data" method="post">
				<c:if test="${sessionScope.message!=null}">
					<input type="hidden" value="${sessionScope.message}" id="message" />
				</c:if>
				<c:remove var="message" scope="session" />
				<div class="window" align="left">

					<div class="tit">
						添加学生
					</div>
					<div class="main">
						<div align="left">
							学号：
							<input type="text" name="no" />
						</div>
						<div align="left">
							姓名：
							<input type="text" name="name" />
						</div>
						<div align="left">
							性别：
							<input style="width: 20px; height: 20px" name="sex" type="radio"
								value="male" checked="checked" />
							男 &nbsp;&nbsp;&nbsp;&nbsp;
							<input style="width: 20px; height: 20px;" name="sex" type="radio"
								value="female" />
							女
						</div>
						<div align="left">
							生日：
							<input type="text" name="birth" onClick="WdatePicker()" />
						</div>
						<div align="left">
							班级：
							<select name="cla_id">
								<c:forEach items="${sessionScope.list_classes}" var="cla">
									<option value="${cla.id}">
										${cla.name}
									</option>
								</c:forEach>
							</select>
						</div>
						<div align="left">
							账号：
							<input type="text" name="ope_name" />
						</div>
						<div align="left">
							密码：
							<input type="text" name="ope_pwd" />
						</div>
						<div align="left">
							<a>头像：</a>
							<input style="margin-top: 20px;" type="file" name="pic" />
							<br />
							<br />
							<img src="../images/person.png" width="150" height="150"
								style="margin-left: 100px;" />
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