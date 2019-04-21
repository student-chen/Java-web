<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,data.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	if (session.isNew()) {
		session.setAttribute("type", "0");
	}
	String type = session.getAttribute("type").toString();
	if (type == null) {
		type = "0";
	}
	if (!type.equals("3")) {
		request.getSession().setAttribute("type", "0");
		response.sendRedirect("test.jsp");
		return;
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增用户</title>
</head>
<body text="#000000">
	<div class="biaoti">
  		<table width="550" border="0" cellspacing="0" cellpadding="0" align="center">
  		<tr>
  		<td height="150" style="FILTER: mask(color=#E1E4EC)shadow(color=#0066cc,direction=135)chroma(color=#E1E4EC)" align="center"><font face="黑体" color="#0066cc" size="7">
			<b>学生信息管理系统――JSP</b></font>
   		</td>
   		</tr>
   		</table>
   	</div>
	<form method="POST" action="add">
		<table width="680" border="0" align="center" cellpadding="3" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px;margin-top:8px;"height="300">
			<tr>
				<td align="right" width="300" height="25">
					<div align="right"><font color="#336600">用户名称：</font></div>
				</td>
				<td width="365">
					<div align="left">
						<input name="username" style="width:160px;border-style:solid;border-width:1;padding-left:4;padding-right:4;padding-top:1;padding-bottom:1" />
					</div>
				</td>
			</tr>
			<tr>
				<td align="right" width="300" height="25">
					<div align="right"><font color="#336600">用户密码：</font></div>
				</td>
				<td width="365">
					<div align="left">
						<input name="password" type="password" style="width:160px;border-style:solid;border-width:1;padding-left:4;padding-right:4;padding-top:1;padding-bottom:1"/>
					</div>
				</td>
			</tr>
			<tr>
				<td align="right" width="300" height="25">
					<div align="right"><font color="#336600">学号/工号：</font></div>
				</td>
				<td width="365">
					<div align="left">
						<input name="id" type="text" style="width:160px;border-style:solid;border-width:1;padding-left:4;padding-right:4;padding-top:1;padding-bottom:1"/>
					</div>
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td align="right" width="300" height="25">
					<div align="right"><font color="#336600">用户类型：</font></div>
				</td>
				<td><input type="radio" name="type" value="1" checked />学生<input
					type="radio" name="type" value="2" />教师</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>