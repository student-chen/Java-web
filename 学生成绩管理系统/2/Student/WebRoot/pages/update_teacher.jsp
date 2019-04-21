<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>update page</title>
		<link href="../css/regist.css" rel="stylesheet" type="text/css" />
		<script language="javascript" type="text/javascript" src="../js/My97DatePicker/WdatePicker.js"></script>
		<script src="../js/jquery-1.8.3.min.js"></script>
		<script src="../js/search.js"></script>
	</head>
	<body>
		<center>
			<form action="/Student/UpdateTeacherServlet" method="post">
				<div class="window" align="left">
					<div class="tit">
						修改信息
					</div>
					<div class="main">
						<div align="left">
							I　　　D：&nbsp;&nbsp;
							<input name="tec_id" type="text"
								value="${sessionScope.teacher_me.id}" readonly="readonly" />
						</div>
						<div align="left">
							姓　　名：
							<input name="tec_name" type="text"
								value="${sessionScope.teacher_me.name}" />
						</div>
						<div align="left">
							性　　别：
							<c:choose>
								<c:when test="${sessionScope.teacher_me.sex == '男'}">
								男 <input style="width: 20px; height: 20px" name="tec_sex"
										type="radio" value="male" checked="checked" />
								&nbsp;&nbsp;&nbsp;女 <input style="width: 20px; height: 20px;"
										name="tec_sex" type="radio" value="female" />
								</c:when>
								<c:otherwise>
								男 <input style="width: 20px; height: 20px" name="tec_sex"
									type="radio" value="male" />
									&nbsp;&nbsp;&nbsp;女 <input style="width: 20px; height: 20px;"
										name="tec_sex" type="radio" value="female" checked="checked" />
									</c:otherwise>
							</c:choose>
						</div>
						<div align="left">
							生　　日： <input type="text" name="tec_birth"
							value="${sessionScope.teacher_me.birth}" onClick="WdatePicker()" />
						</div>
						
						<div align="left">
							专　　业：
							<input name="tec_major" type="text"
								value="${sessionScope.teacher_me.major}" />
						</div>
						<div align="left">
							联系电话：
							<input name="tec_phone" type="text"
								value="${sessionScope.teacher_me.phone}" />
						</div>
						
						<div align="left">
							账　　号：
							<input name="ope_name" type="text"
								value="${sessionScope.operator_me.name}" />
						</div>
						<div align="left">
							密　　码：
							<input type="text" name="ope_pwd"
								value="${sessionScope.operator_me.pwd}" />
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