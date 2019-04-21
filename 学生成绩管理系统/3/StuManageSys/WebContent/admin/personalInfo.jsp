<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员个人信息</title>

	</head>

	<body>
		<div style="padding-top: 150px;">
			<center>
			<form action="../adminupdateInfo.action" method="post">
				<table border="1px" width="280px">
					<tr><td>编号：</td><td><input type="text" value="${sessionScope.admin.id}" name="newadmin.id" readonly="readonly"/></td></tr>
					<tr><td>管理员号：</td><td><input type="text" value="${sessionScope.admin.adminId}" name="newadmin.adminId" readonly="readonly"/></td></tr>
					<tr><td>姓名：</td><td><input type="text" value="${sessionScope.admin.adminName}" name="newadmin.adminName"/></td></tr>
					<tr><td>备注：</td><td><input type="text" value="${sessionScope.admin.adminPs}" name="newadmin.adminPs"/></td></tr>
					<tr><td colspan="2" align="center"><input type="submit" value="提交"/></td></tr>
				</table>
				</form>
			</center>
		</div>

	</body>
</html>
