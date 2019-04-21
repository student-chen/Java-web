<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<form action="/Student/AddTeacherServlet" method="post">
				<c:if test="${sessionScope.message!=null}">
					<input type="hidden" value="${sessionScope.message}" id="message" />
				</c:if>
				<c:remove var="message" scope="session" />
				<div class="window" align="left">
					<div class="tit">
						添加教师
					</div>
					<div class="main">
						<div align="left">
							姓 名：
							<input type="text" name="tec_name" />
						</div>
						<div align="left">
							专 业：
							<input type="text" name="tec_major" />
						</div>
						<div align="left">
							生 日：
							<input type="text" name="tec_birth" onClick="WdatePicker()" />
						</div>
						<div align="left">
							性 别：
							<input style="width: 20px; height: 20px" name="tec_sex"
								type="radio" value="male" checked="checked" />
							男 &nbsp;&nbsp;&nbsp;&nbsp;
							<input style="width: 20px; height: 20px;" name="tec_sex"
								type="radio" value="female" />
							女
						</div>
						<div align="left">
							电 话：
							<input type="text" name="tec_phone" />
						</div>
						<div align="left">
							账 号：
							<input type="text" name="ope_name" />
						</div>
						<div align="left">
							密 码：
							<input type="text" name="ope_pwd" />
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