<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>update page</title>
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
		<form
			action="/Student/UpateStudentServlet?stu_id=${sessionScope.student.id}"
			enctype="multipart/form-data" method="post">
			<div class="window" align="left">
				<div class="tit">修改个人信息</div>
				<div class="main">
					<div align="left">
						学号：
						<c:choose>
							<c:when test="${sessionScope.log_operator.role.id == 1}">
								<input name="no" type="text" value="${sessionScope.student.no}" />
							</c:when>
							<c:otherwise>
								<input name="no" readonly="readonly" type="text"
									value="${sessionScope.student.no}" />
							</c:otherwise>
						</c:choose>
					</div>
					<div align="left">
						姓名：
						<c:choose>
							<c:when test="${sessionScope.log_operator.role.id == 1}">
								<input name="name" type="text"
									value="${sessionScope.student.name}" />
							</c:when>
							<c:otherwise>
								<input name="name" type="text" readonly="readonly"
									value="${sessionScope.student.name}" />
							</c:otherwise>
						</c:choose>
					</div>
					<div align="left">
						账号： <input name="log_name" type="text"
							value="${sessionScope.student.operator.name}" />
					</div>
					<div align="left">
						密码： <input type="text" name="log_pwd"
							value="${sessionScope.student.operator.pwd}" />
					</div>
					<div align="left">
						性别：
						<c:choose>
							<c:when test="${sessionScope.student.sex == '男'}">
							男 <input style="width: 20px; height: 20px" name="sex"
									type="radio" value="male" checked="checked" />
							&nbsp;&nbsp;&nbsp;女 <input style="width: 20px; height: 20px;"
									name="sex" type="radio" value="female" />
							</c:when>
							<c:otherwise>
							男 <input style="width: 20px; height: 20px" name="sex"
									type="radio" value="male" />
							&nbsp;&nbsp;&nbsp;女 <input style="width: 20px; height: 20px;"
									name="sex" type="radio" value="female" checked="checked" />
							</c:otherwise>
						</c:choose>
					</div>
					<div align="left">
						生日： <input type="text" name="birth"
							value="${sessionScope.student.birth}" onClick="WdatePicker()" />
					</div>
					<div align="left">
						班级：
						<c:choose>
							<c:when test="${sessionScope.log_operator.role.id == 1}">
								<select name="cla_id">
									<c:forEach items="${sessionScope.list_classes}" var="cla">
										<c:choose>
											<c:when test="${cla.id == sessionScope.student.classes.id}">
												<option value="${cla.id}" selected="selected">
													${cla.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${cla.id}">${cla.name}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</c:when>
							<c:otherwise>
								<select name="cla_id">
									<option value="${sessionScope.student.classes.id}">${sessionScope.student.classes.name}</option>
								</select>
							</c:otherwise>
						</c:choose>
					</div>
					<div align="left">
						<a>头像：</a> <input style="margin-top: 20px;" type="file" name="pic" />
						<br /> <br /> <img src="${sessionScope.student.pic}" width="150"
							height="150" style="margin-left: 100px;" />
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